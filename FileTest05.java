package com.hp.filezuoye;
import java.io.File;
import java.util.Scanner;

/**
 * 要求用户输入一个文件或目录名，并删除当前目录下的该文件或目录。
 * 可自行手动先在当前项目目录中创建一个要删除的文件或目录，若是目录，还可以
 * 在该目录中继续创建若干级目录和文件。
 *
 */
public class FileTest05 {
    public static void main(String[] args) {
        //要求用户输入一个文件或目录名，并删除当前目录下的该文件或目录。
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入文件或目录名字:");
        //可自行手动先在当前项目目录中创建一个要删除的文件或目录，若是目录，还可以
        //在该目录中继续创建若干级目录和文件。
        String input = scan.nextLine().trim();//接收名字
        File file = new File(input);
        if (!file.exists()) {//要删除的文件或目录是否存在
            System.out.println("目录或文件不存在");
            return;
        }
        deleteFile(file);
    }

    //遍历过程中,元素为文件则删除,元素为有内容目录则继续遍历,
    //元素为空目录则执行if后,不会执行for循环,但要执行删除语句,将空目录删除,递归删除以上所有
    public static void deleteFile(File file) {
        //如果是目录，需要先删除当前目录下的所有子项
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {//遍历子目录
                deleteFile(f);
            }
        }
        file.delete();//必定执行的语句
    }
}
