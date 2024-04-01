package com.ohgiraffers.practice07;

import com.ohgiraffers.practice06.CardCase;

public class CardRuleMain {
    public static void main(String[] args) {
        CardCase cc = new CardCase();
        cc.make();
        CardRule rule = new CardRule();

        for (int i = 0; i < 5; i++) {
            System.out.println("--------------------");
            cc.shuffle();
            cc.print();
            int a = rule.rule(cc.getCard(0), cc.getCard(2));
            int b = rule.rule(cc.getCard(1), cc.getCard(3));
            System.out.println(cc.getCard(0) + " " + cc.getCard(2) + " " + a);
            System.out.println(cc.getCard(1) + " " + cc.getCard(3) + " " + b);
        }
        System.out.println("----------------------");
    }
}
