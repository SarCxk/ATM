package com.hp.collectiondemo;

import java.util.*;

/*
*斗地主 模拟 洗牌
* 牌数：54张，大王，小王，2-10  A ,J，Q，k,四个桃
* ♥，♠，♣，♦
* 1-10
* ♥7
 */
public class DouDiZhuTest {
    public static void main(String[] args) {
        //1.先造出4个花色
        List<String> colors = new ArrayList<>();
        colors.add("♥");
        colors.add("♠");
        colors.add("♣");
        colors.add("♦");
        List<String> numbers = new ArrayList<>();
        for (int i = 2; i<=10; i++) {
            numbers.add(i+"");
        }
        numbers.add("A");
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        System.out.println("numbers = " + numbers);


        //3. 上边的colors 和number进行一个整合
        //放入到一个 新的集合中  如何做到呢？
        //嵌套循环
        List<String> piker = new ArrayList<>();
        //Set<String> piker = new HashSet<>();
        for (String color : colors) {
            for (String number : numbers) {
                piker.add(color+number);
            }
        }
        piker.add("BigKing");
        piker.add("LittleKing");
        System.out.println("piker = " + piker);
        System.out.println("piker = " + piker.size());

        //如果使用set 也无法分开排序，改为list，有个方法可以.打乱他的排序，只能打断list
        //因set无序
        Collections.shuffle(piker);
        System.out.println("piker = " + piker);
        //给player1 player2 player3 发牌
        List<String> player1 = new ArrayList<>();//玩家1
        List<String> player2 = new ArrayList<>();//玩家2
        List<String> player3 = new ArrayList<>();//玩家3
        List<String> dipai = new ArrayList<>();
        for (int i = 0 ; i<piker.size();i++) {
            String pName = piker.get(i);
            if (i >= 51) {
                dipai.add(pName);
            }else {
                //给玩家发前面51张牌
                if (i%3 == 0) {
                    player1.add(pName);
                }else if(i%3 == 1){
                    player2.add(pName);
                }else {
                    player3.add(pName);
                }
            }
        }
        System.out.println("dipai = " + dipai);
        System.out.println("player1 = " + player1);
        System.out.println("player1 = " + player1.size());
        System.out.println("player2 = " + player2);
        System.out.println("player2 = " + player2.size());
        System.out.println("player3 = " + player3);
        System.out.println("player3 = " + player3.size());

        Collections.sort(piker);
        System.out.println("piker = " + piker);
    }
}
