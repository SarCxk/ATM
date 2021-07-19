package com.hp.threaddemo01;

import java.util.Random;

/*
    线程的打断
    打断针对线程的sleep来讲

 */
public class ThreadDemo04 {
    public static int time=4;//砸蛋的倒计时
    public static int password = new Random().nextInt(10000000);//砸蛋的密码
    public static boolean boom=true;
    public static void main(String[] args) {
        System.out.println("炸弹的密码是： " + password);
        //第一个线程：炸弹的倒计时，如果完成倒计时，就bengbeng
        Thread boomThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //炸弹的倒计时
                System.out.println("定时炸弹已安装炸弹");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (time >= 0) {

                    try {
                        if (time == 0) {
                            System.out.println("C4 beng beng.....匪徒胜利");
                            boom = false;
                            break;
                        }
                        time--;
                        System.out.println("time = " + time);

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        if (e.getMessage().equals("sleep interrupted")){
                            System.out.println("success");
                            break;
                        }
                        e.printStackTrace();
                    }
                }
            }
        });

        boomThread.start();
        //第二个线程：是打断线程的倒计时，如果打断了，就不蹦蹦...
        Thread policeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //警察负责拆炸弹，所以用打断的方式，打断boomThread就可以了
                System.out.println("警察开始拆炸弹！！！");
                while (boom){
                    if (password==new Random().nextInt(100)){
                        boomThread.interrupt();//这个是线程打断.
                        break;
                    }
                }
            }
        });
        boomThread.start();
        try{
            Thread.sleep(800);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        policeThread.start();
    }
}
