package com.hp.jihezuoye;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 创建一个List集合，并存放10个随机数，然后排序该集合
 * 后输出
 * @author Xiloer
 *
 */
public class JiheTest07 {
    public static void main(String[] args) {
        Random ss = new Random();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            list.add(ss.nextInt(100));
        }
        System.out.println("list:"+list);
        Collections.sort(list);
        System.out.println("list:"+list);
    }
}
