package com.hp.threaddemo01;
/*
    synchronized锁,尽量所在范围小的位置上
    越小，效率越高

    优衣库，synchronized锁在方法上，那么如果方法中有可以多个线程共同使用的，那么会造成锁的浪费
    哪呢效率，怎么办?锁应该锁在关键位置
 */
public class ThreadSyncDemo02 {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    shop.buy();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    shop.buy();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t1.start();t2.start();
    }
}

class Shop{
    //如果，不加上synchronized锁，完了，回火....
    public void buy() throws InterruptedException {//锁在优衣库门上
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"shiyifu");
        Thread.sleep(5000);

        synchronized (this) {//使用synchronized 块，锁在关键位置,锁在试衣间门上
            System.out.println(thread.getName()+"xuanyifu");
            Thread.sleep(5000);
            System.out.println("test over");
        }

    }
}