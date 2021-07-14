package com.hp.datazuoye;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest03 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的生日, 输入格式为:yyyy-MM-dd");
        String birthday = sc.nextLine();

        if (birthday.matches("[\\d]{4}-[\\d]{2}-[\\d]{2}")) {
            Date birDate = sdf.parse(birthday);
            Date now = new Date();
            long time = now.getTime() - birDate.getTime();
            long day = time / 1000 / 60 / 60 / 24;
            long week = day / 7;
            System.out.println("到今天经历了:" + week + "周");
        } else {
            System.out.println("输入格式错误");
        }
    }

}