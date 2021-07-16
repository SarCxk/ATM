package com.hp.jihezuoye;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个List集合，并添加元素0-9
 * 将集合转换为一个Integer数组并输出数组每一个元素
 * @author Xiloer
 *
 */
public class JiheTest05 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        Integer[] d = list.toArray(new Integer[list.size()]);
        for(int num : d){
            System.out.println(num);
        }
    }
}
