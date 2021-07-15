package com.hp.dayzuoye;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DayTest02 {
    public static void main(String[] args) {
        Date date = new Date();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String chinaDate = sdf.format(date);
        System.out.println("请输入当前的时间：chinaDate = " + chinaDate);


    }
}