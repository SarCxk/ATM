package com.hp.threaddemo01;
/*
    多个线程同时操作一个资源诞生的安全问题
    比如：多个 账户抢票
    多线程的安全问题
    synchronized锁的机制可以解决多线程的安全问题
    解决的手段是将原本的多线程“各干各的”变为按顺序执行
    未知synchronized锁之前，线程是异步的，给方法加上synchronized锁就变成同步
    将有序的同步执行，就会解决安全问题，但是缺点是因为有序需要等待方法内的程序走完
    才进行下一个线程，效率上会慢一点
    synchronized锁，所在不同的位置
 */
public class ThreadSyncDemo01 {
    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                //模拟黄牛1 取票
                while (true){
                    int ticket = tickets.getTicket();
                    Thread.yield();//
                    System.out.println(getName()+"线程拿了" + ticket);
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                //模拟黄牛2 取票
                while (true){
                    int ticket = tickets.getTicket();
                    Thread.yield();//
                    System.out.println(getName()+"线程拿了" + ticket);
                    if(ticket<=0){
                        break;
                    }
                }
            }
        };
        t1.start();t2.start();
    }
}
class Tickets {
    private  int ticket = 20;
    public int getTicket() {
        if (ticket == 0) {
            System.out.println("没票了哦");
            throw new RuntimeException("票没了");
        }
        //Thread.yield();//线程的让一让
        return ticket--;
    }

}