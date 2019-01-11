package com.study.common.server.utils;

import sun.security.krb5.Config;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceFactory {
     private static DataSourceFactory instance;
     private static InitialContext context;
     /** 默认的数据源的jndi名称属性的key */
     private static final String DEFAULT_DATASOURCE_PROP_KEY = "DB.DATASOURCE";
      
     private DataSourceFactory() {
         super();
     }
      
     /**
      * 单例模式获取工厂实例.<br>
      * @return
      */
     public static final synchronized DataSourceFactory newInstance() {
         if (instance == null)
             instance = new DataSourceFactory();
         return instance;
     }
      
     /**
      * 获取默认的DataSource.<br>
      * 根据config/config.properties中DB.DATASOURCE属性值查找.<br>
      * @return
      */
     public DataSource getDefaultDataSource() {
//         String jndiName = Config.getInstance().getValue(DEFAULT_DATASOURCE_PROP_KEY);
         String jndiName = DEFAULT_DATASOURCE_PROP_KEY;
         DataSource ds = getDataSource(jndiName);
         return ds;
     }
      
     /**
      * 根据JNDI名称，获取上下文中的DataSource.<br>
      * @param jndiName
      * @return
      */
     public synchronized DataSource getDataSource(String jndiName) {
         DataSource ds = null;
         try {
             if (context == null)
                 context = new InitialContext();
             ds = (DataSource)context.lookup(jndiName);
         } catch (NamingException e) {
             e.printStackTrace();
         }
         return ds;
     }
 }