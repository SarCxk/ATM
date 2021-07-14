package com.hp.datazuoye;
import java.util.Date;
public class DateTest01 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("现在的时间date = " + date);//date
        long time = date.getTime();//获得 真实的时间，long
        time += 1000 * 60 * 60 * 24 * 3L;
        date.setTime(time);
        System.out.println("三天后的时间：date = " + date);
    }
}
