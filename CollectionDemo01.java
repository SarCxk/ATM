package com.hp.collectiondemo;

import java.util.ArrayList;
import java.util.Collection;

/*
*集合：非常重要！！有一个借口
* (接口可以继承接口)
*
 */
public class CollectionDemo01 {
    public static void main(String[] args) {
        //Collection c1 = new ArrayList();
        ArrayList c1 = new ArrayList();
        //add增加
        c1.add("唐僧--老顽童");
        c1.add("毛毛--吉吉国王");
        c1.add("猪八戒--老色批");
        c1.add("沙和尚--稳重");
        c1.add("白龙马--小白龙");
        System.out.println("c1 = " + c1);
        //尺寸
        int size = c1.size();
        System.out.println("size = " + size);

        boolean empty = c1.isEmpty();
        System.out.println("empty = " + empty);
        //集合的清空
        c1.clear();
        System.out.println("c1 = " + c1);
        boolean empty1 = c1.isEmpty();
        System.out.println("empty1 = " + empty1);
        //集合的遍历   3种
        //one
        for (int i=0;i<c1.size();i++) {
            System.out.println("c1 = " + c1.get(i));
        }
        //思考题：为什么collection不能使用for循环呢？
        //因为set集合么有索引，所以for循环不能使用到collection中
        for (Object o : c1) {
            System.out.println("o = " + o);
        }
        //迭代器 和 for循环的区别
        //迭代器工作：有游标，问下一个，有没有下一个元素，如果有,就拿出，没有就结束
        // for循环的工作:把集合从0---N排序，从0开取，拿下标。

    }
}
