package com.hp.StringT;
/*
作业: 写一个 private 方法, 需要 传一个 string 的 网址参数, 返回 处理后的数据.
        // 假定 大数据获取了 很多网址, 我想要 www -----  com 之间的内容
        // 有一下  几类网址
        // www.oracle.com  ---->  oracle
        // www.oracle.com.cn  ---->  oracle
        // www.java.oracle.com.cn  ---->  java.oracle
        // www.lol.game.qq.com.cn  ---->  lol.game.qq
        // www.game.mycom.com.cn  ---->  game.mycom
        // www.girl.mycom.com.cn  ---->  girl.mycom
        // www.computer.mycom.com.cn  ---->  computer.mycom
*/
public class StringTest07 {
    public static void main(String[] args) {

        String str2="www.oracle.com";
        //(含头不含尾)www.oracle.com  ---->  oracle
        String substring=str2.substring(4,10);
        System.out.println("substring = " + substring);

        String str3="www.oracle.com.cn";
        String substring1=str3.substring(4,10);
        System.out.println("substring1 = " + substring1);

        //www.java.oracle.com.cn  ---->  java.oracle
        String str4="www.java.oracle.com.cn";
        String substring2=str4.substring(4,15);
        System.out.println("substring2 = " + substring2);

        //www.lol.game.qq.com.cn  ---->  lol.game.qq
        String str5="www.lol.game.qq.com.cn";
        String substring3=str5.substring(4,15);
        System.out.println("substring3 = " + substring3);

        // www.game.mycom.com.cn  ---->  game.mycom
        String str6="www.game.mycom.com.cn";
        String substring4=str6.substring(4,14);
        System.out.println("substring4 = " + substring4);

        // www.girl.mycom.com.cn  ---->  girl.mycom
        String str7="www.girl.mycom.com.cn";
        String substring5=str7.substring(4,14);
        System.out.println("substring5 = " + substring5);

        // www.computer.mycom.com.cn  ---->  computer.mycom
        String str8="www.computer.mycom.com.cn";
        String substring6=str8.substring(4,18);
        System.out.println("substring6 = " + substring6);

    }
}
