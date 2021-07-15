package com.hp.collectiondemo;

import java.util.ArrayList;
import java.util.Collection;

/*
*集合存的是对象的什么?
* 存的对象的引用，当对象通过外力改变了,那么集合中的内容也会变.
*
 */
public class CollectionDemo02 {
    public static void main(String[] args) {
        Person zhaolusi = new Person();
        zhaolusi.setName("赵露思");
        zhaolusi.setAge(18);
        zhaolusi.setHeight(166);
        ArrayList c = new ArrayList();
        c.add(zhaolusi);
        for (Object o : c) {
            System.out.println("o = " + o);
        }
        zhaolusi.setHeight(166);
        zhaolusi.setAge(28);
        zhaolusi.setName("贾玲");
        for (Object o : c) {
            System.out.println("o = " + o);

        }
    }
}
