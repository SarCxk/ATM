package com.hp.threaddemo01;
/*
    线程的打断
    背景：1.cy: 爱吃  大肘子，，，100块
          2.yyh:打断 cy
 */
public class ThreadDemo05 {
    public static void main(String[] args) {
        Thread cy = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true){
                    try {
                        System.out.println("吃大肘子"+i);
                        i++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            if (e.getMessage().equals("sleep interrupted")){
                                System.out.println("yyh阻止了cy");
                                break;
                            }
                            e.printStackTrace();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        }
        });
        cy.start();
        Thread yyhThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    cy.interrupt();//打断cy
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
