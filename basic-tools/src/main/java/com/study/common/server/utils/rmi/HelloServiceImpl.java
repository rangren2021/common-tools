package com.study.common.server.utils.rmi;

import com.xinbang.commonservice.common.component.CommonUtil;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    protected HelloServiceImpl() throws RemoteException{
        super();
    }
    @Override
    public void sayHello() throws RemoteException {
        System.out.println("你好啊，接收到调用");
    }
}