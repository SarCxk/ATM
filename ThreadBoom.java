package com.hp.threaddemo01;
import java.util.Random;

public class ThreadBoom {
    static int time=4;
    static int Password=new Random().nextInt(100000000);
    static   boolean boob=true;
    public static void main(String[] args) {

        final Thread  h1=new Thread(new Runnable() {
            public void run() {
                System.out.println("find boom");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                while (time >=0) {
                    try {
                        if(time==0){
                            System.out.println("boom beng beng");
                            boob=false;
                            break;
                        }
                        time--;
                        System.out.println(time);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //方法二使用interrupted 也可以使用Stop()
                        // 但是Stop方法会中止当前线程所有操作
                        // 判断是否为睡眠打断操作 是则输出拆弹成功 否则输出错误
                        if(e.getMessage().equals("sleep interrupted")){
                            System.out.println("success ");
                            break;
                        }
                        e.printStackTrace();
                    }
                }
            }
        });
        final Thread h2=new Thread(new Runnable() {
            public void run() {
                System.out.println("start chai boom ing");

                while(boob){
                    if (new Random().nextInt(100000000) ==Password) {
                        //方法二 interrupt()打断
                        h1.interrupt();

                        //方法一 重置时间为负数
                        // time=-1;
                        //System.out.println("拆弹成功");
                        break;
                    }
                }

            }
        });
        h1.start();
        try {
            Thread.sleep(800);
        }catch (InterruptedException e){
        }
        h2.start();
    }

}

