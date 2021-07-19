package com.hp.threaddemo01;
/*
    刚刚的1-2是锁在普通方法上面
    现在要锁在 静态方法上,synchronized可以锁在带static方法上的
 */
public class ThreadSyncDemo03 {
    public static void main(String[] args) {
    Thread t1 = new Thread(){
        @Override
        public void run() {
            Shop01.buy();
        }
    };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                Shop01.buy();
            }
        };
        t1.start();t2.start();

    }
}
class Shop01{
    public synchronized static void buy(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+" xuan..... ");
        try{
            thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(thread.getName()+" shi...." );
        try{
            thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(thread.getName()+" chu..." );
    }
}