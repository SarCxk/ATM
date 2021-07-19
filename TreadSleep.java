package com.hp.threaddemo01;

public class TreadSleep {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <30 ; i++) {
            Thread.sleep(2);//线程的阻塞
            System.out.println("访问中国电信"+i +"次");
        }
        //其实main 方法 就是一个线程，是一个主线程
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.println("name = " + name);
        long id = thread.getId();
        System.out.println("id = " + id);


    }
}
