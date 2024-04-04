package com.ohgiraffers.practice07;

// 113 카드 게입(바카라) 만들기
public class Bakara {
    CardPrint cp = new CardPrint();
    int whoWin = -1;
    public void start() {
        cp.make();      // 카드 만들기
        cp.shuffle();   // 카드 초기화
    }

    public void result() {
        whoWin = -1;
        cp.print();
        System.out.println("결과 : ");
        System.out.println("-------------");
        System.out.println("플레이어 : " + cp.returnPlayer());
        System.out.println("뱅커 : " + cp.returnDealer());
        if (cp.returnPlayer() < cp.returnDealer()) {
            System.out.println("뱅커 승!");
            whoWin = 2;
        }
    }
}
