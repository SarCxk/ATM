package com.hp.threaddemo01;
/*
    互斥锁
 */
public class ThreadSyncDemo04 {
    public static void main(String[] args) {
        Shop02 shop = new Shop02();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    shop.buy();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    shop.buy2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();t2.start();
    }
}
class Shop02{
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
    //买冰淇淋，在优衣库对面
    public synchronized void buy2() throws InterruptedException {//锁在冰淇淋门上
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"shiyifu");

        }
}