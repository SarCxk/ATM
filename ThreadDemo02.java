package com.hp.threaddemo01;
/*
    创建线程的第二种方式，不用继承，用实现
 */
public class ThreadDemo02 {
    public static void main(String[] args) {
        Runnable xiCai = new XiCai();
        Runnable shaoShui = new ShaoShui();

        Thread xicaiThread = new Thread(xiCai);
        Thread shaoShuiThread = new Thread(shaoShui);

        xicaiThread.start();
        shaoShuiThread.start();
    }
}
class XiCai implements Runnable{

    @Override
    public void run(){
        for (int i =0;i<1000;i++) {
            System.out.println("洗了菜" + i);
        }
    }
}
class ShaoShui implements Runnable{

    @Override
    public void run(){
        for (int i =0;i<1000;i++) {
            System.out.println("烧水" + i);
        }
    }
}