package com.hp.datazuoye;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 输入一个生产日期格式"yyyy-MM-dd",再输入一个数字(保质期的天数)。
 * 然后经过计算输出促销日期，促销日期为:该商品过期日前2周的周三
 *
 */
public class DateTest04 {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入生产日期(格式为yyyy-MM-dd)：");
        String production = input.nextLine();

        System.out.println("请输入保质期的天数：");
        int ExpirationDays = input.nextInt();

        long times = 24 * 60 * 60 * 1000;//一天的毫秒值

        if (production.matches("[\\d]{4}-[\\d]{1,2}-[\\d]{1,2}")) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date productionDate = simpleDateFormat.parse(production);//把输入的日期字符串转换为日期格式
            Date nowDate = new Date();//获取当前的时间

            System.out.println("当前日期为：" + simpleDateFormat.format(nowDate));

            long pastTime = nowDate.getTime() - productionDate.getTime();//获得输入日期到现在的毫秒值
            long pastDays = pastTime / (1000 * 60 * 60 * 24);//获取天数

            //算出过期日期的毫秒值
            long pastDueTime = productionDate.getTime() + times * ExpirationDays;
            //把过期日期的毫秒值转化为日期格式
            Date pastDueDate = new Date(pastDueTime);

            System.out.println("你所购买的商品过期日期为：" + simpleDateFormat.format(pastDueDate));

            if (pastDays == ExpirationDays) { //看过去的天数是否等于保质期天数
                System.out.println("你所购买的商品已过期！");

            }else {//计算输出促销日期，促销日期为:该商品过期日前2周的周三

                //计算促销日期的毫秒值
                long promoteSaleDateTime = pastDueTime - (times * 11);
                Date promoteSaleDate = new Date(promoteSaleDateTime);

                System.out.println("该产品促销日期为" + simpleDateFormat.format(promoteSaleDate));

            }
        }else {
            System.out.println("格式不正确！");
        }

    }
}
