package com.study.common.server.exec;

import com.study.common.server.utils.DistributeLock;
import org.apache.zookeeper.*;

public class ZookeeperTest {
    static int n = 500;

    public static void secskill() {
        System.out.println("secskill-->" + --n);
    }

    public static void threadTest() {

        Runnable runnable = new Runnable() {
            public void run() {
                DistributeLock lock = null;
                try {
                    lock = new DistributeLock("192.168.75.129:2181", "distributeLock");
                    lock.lock();
                    secskill();
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }


    public static void main(String[] args) {
        threadTest();

//        InnerTest innerTest = new ZookeeperTest().new InnerTest();
//        ZooKeeper zk = null;
//        try {
//            zk = new ZooKeeper("192.168.75.129:2181", 30000, innerTest);
////            String path = zk.create("/locks1", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//            String path0 = zk.create("/locks0", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
//            String path2 = zk.create("/locks2", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//            String path3 = zk.create("/locks3", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
//            System.out.println("path0:" + path0);
//            System.out.println("path2:" + path2);
//            System.out.println("path3:" + path3);

//            zk.
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    class InnerTest implements Watcher {

        @Override
        public void process(WatchedEvent watchedEvent) {

        }
    }

}