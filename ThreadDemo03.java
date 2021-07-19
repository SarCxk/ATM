package com.hp.threaddemo01;
/*
    线程创建的做好用的，
 */
public class ThreadDemo03 {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i =0;i<1000;i++) {
                    System.out.println("洗了菜" + i);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i =0;i<1000;i++) {
                    System.out.println("烧水" + i);
                }
            }
        }.start();
    }
    //联系任务：测试 自己的电脑看能否开多少个线程
}
