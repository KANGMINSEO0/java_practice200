package com.ohgiraffers.practice06;

public class CardCaseMain {
    public static void main(String[] args) {
        CardCase cc = new CardCase();
        cc.make();      // 서로 다른 카드 20장 만들기
        cc.print();
        System.out.println("-------------------------");
        cc.shuffle();   // 카드 섞기
        cc.print();
        System.out.println("-------------------------");
        cc.shuffle();   // 카드 섞기
        cc.print();
        System.out.println("-------------------------");
        cc.sort();
        cc.print();
        System.out.println("-------------------------");
        cc.rsort();
        cc.print();
        System.out.println("-------------------------");
        cc.lambdasort();
        cc.print();
        System.out.println("-------------------------");
        cc.lambdarsort();
        cc.print();
        System.out.println("-------------------------");
        cc.lambdasort2();
        cc.print();
        System.out.println("-------------------------");
        cc.lambdarsort3();
        cc.print();
    }
}
