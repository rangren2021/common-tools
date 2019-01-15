package com.study.common.server.exec;

import com.alibaba.fastjson.JSON;
import com.alicloud.openservices.tablestore.TableStoreException;
import com.jcabi.manifests.Manifests;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import sun.security.action.GetPropertyAction;

import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

import static com.auth0.jwt.internal.org.bouncycastle.crypto.tls.CipherType.stream;

/**
 * @ClassName _Test3
 * @Description TODO
 * @Author xinbang
 * @Date 2018/12/5 10:36
 * @Version 1.0
 **/

public class _Test3 {


    public static void main(String[] args) throws IOException {
//        String specification = JSON.class.getPackage().getSpecificationVersion();
//        System.out.println("specification:"+specification);
//        String implementation = JSON.class.getPackage().getImplementationVersion();
//        System.out.println("implementation:"+implementation);
//        TableStoreException.class.getPackage().getImplementationTitle();

//        Manifests.class;

//        JarInputStream jarStream = null;
//        try {
//            jarStream = new JarInputStream(stream);
//            Manifest mf = jarStream.getManifest();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Enumeration resources = Thread.currentThread().getContextClassLoader().getResources("META-INF/MANIFEST.MF");
//        String path = System.getProperty("java.class.path");
//        System.out.println("path-->"+path);

        String path = StdSchedulerFactory.class.getProtectionDomain().getCodeSource().getLocation().getPath();
//        System.out.println("path-->"+path);


        JarFile jar = new JarFile(path);
        Manifest manifest = jar.getManifest();
        System.out.println("1-->"+manifest.getMainAttributes());
        System.out.println("2-->"+manifest.getMainAttributes().getValue("Bundle-Description"));

//        String created = Manifests.read("Manifest-Version");
//        System.out.println("1-->"+created);

    }
}
