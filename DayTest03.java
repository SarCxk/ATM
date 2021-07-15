package com.hp.dayzuoye;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/*
 * 输入某人生日，格式为"yyyy-MM-dd"，输出到现在为止经过了多少周。
 *
 */
public class DayTest03 {
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
            System.out.println("到今天经过了:" + week + "周");
        } else {
            System.out.println("输入格式错误");
        }
    }

}