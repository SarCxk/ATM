package com.hp.datazuoye;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateTest02 {
    public static void main(String[] args) {
        Date date = new Date();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String chinaDate = sdf.format(date);
        System.out.println("当前时间：chinaDate = " + chinaDate);


    }
}