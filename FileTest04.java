package com.hp.filezuoye;
import java.io.File;

/**
 * 获取并输出当前目录下的所有文件和目录的名字
 *
 */
public class FileTest04 {
    public static void main(String[] args) {
        File dir = new File("src");//获取当前目录下的文件以及文件夹的名称
        printDir(dir);
    }

    public static void printDir(File dir) {
        //获取子文件和目录
        File[] files = dir.listFiles();
        //循环打印
        /**
         * 判断：
         * 当是文件时，打印绝对路径。
         * 当是目录时，继续调用打印目录当方法，形成递归调用。
         * */
        for (File file : files) {
            //判断
            if (file.isFile()) {
                //是文件，输出文件绝对路径
                System.out.println("文件名：" + file.getAbsolutePath());
            } else {
                //是目录，输出目录绝对路径
                System.out.println("目录：" + file.getAbsolutePath());
                //继续遍历，调用printDir，形成递归
                printDir(file);
            }
        }
    }
}
