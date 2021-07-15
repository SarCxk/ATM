package com.hp.collectiondemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListDemo {
    public static void main(String[] args) {
        Person luban = new Person();
        luban.setAge(12);
        luban.setHeight(500);
        luban.setName("鲁班");

        Person daji = new Person();
        daji.setAge(12);
        daji.setHeight(500);
        daji.setName("妲己");

        Person xuance = new Person();
        xuance.setAge(12);
        xuance.setHeight(500);
        xuance.setName("玄策");
        //需求:给定一个list person对象的集合，需要一个String集合,该集合中的值是提取与上面3000个list中的name值.把美女的名字都存进去.
        List<Person> list = new ArrayList();
        list.add(luban);
        list.add(daji);
        list.add(xuance);

        System.out.println("list = " + list);
        List<String> names = new ArrayList<>();
        names.add(luban.getName());
        names.add(daji.getName());
        names.add(xuance.getName());
        System.out.println("names = " + names);

        //1，遍历 list集合，拿出对象的names付给新的names集合中
        /* for (Person s : list) {
            String name = s.getName();
            //赋值给新的集合
            names.add(name);
        }*/
        System.out.println("names = " + names);
        //以上是传统的，新的？JDK8    Stream(), 作业：自我学习JDK8的新特性，如何新的遍历
        List<String> nameLists = list.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("nameLists = " + nameLists);

    }


}
