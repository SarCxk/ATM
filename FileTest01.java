package com.hp.filezuoye;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * 通过File输出当前项目目录下的文件"myfile.txt"的名字，大小，最后修改时间。
 * 最后修改时间格式如:2016-03-23 14:22:16
 *
 */
public class FileTest01 {
    public static void main(String[] args) {
        //通过File输出当前项目目录下的文件"myfile.txt"的名字，大小，最后修改时间。
        File s = new File("myfile.txt");
        System.out.println(s.length());
        System.out.println(s.getName());
        System.out.println(s.lastModified());
        //new Date -> 输出最后修改时间格式如:2017-06-30 14:22:16
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(s.lastModified()));



    }

}
