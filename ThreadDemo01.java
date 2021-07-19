package com.hp.threaddemo01;
/*
 * 线程....
 *   以前代码都是 自上到下的执行
 *
 *   创建线程的第一种方式,缺点:直接extends Thread,那么,浪费一次 继承机会
 *
 * */
public class ThreadDemo01 {
    public static void main(String[] args) {
        Thread t1 = new HotWaterThread();//烧水的线程
        Thread t2 = new XiCaiThread();//洗菜的线程
        t1.start();
        t2.start();
        //像这样的 做一会洗菜,做一会烧水,那么这就叫做异步,没有顺序 ajkx 异步的
        //如果把烧水全部完成,再做洗菜,那么这叫同步,同步是有先后顺序的
    }
}
//如果只单单的new Thread,它只是一个线程,线程中没有方法(任务),无意义
//需要自己创建一个线程,继承它的任务(方法)
//线程中最具有意义的就是run 方法
class HotWaterThread extends Thread{
    //重要的  线程的方法!
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("烧了" + i + "瓶水");
        }
    }
}
class XiCaiThread extends Thread{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("洗了" + i + "颗大白菜");
        }
    }
}