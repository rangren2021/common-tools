package com.study.common.server.utils.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {

    void sayHello() throws RemoteException;
}