package com.ohgiraffers.practice07;

import java.util.Scanner;

public class BakaraMain {
    public static void main(String[] args) {
        System.out.println("자산을 입력하시오");
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int i = 0;
        Bakara bakara = new Bakara();
        while(true) {
            bakara.start();
            i++;
            System.out.println(i + "번째 대결입니다.");
            System.out.println("당신의 현재 자산은 총" + sum + "원입니다.");
            System.out.println("당신이 배팅할 금액을 설정하세요.");

            int n = in.nextInt();
            if (n > sum) {
                System.out.println("자신을 넘어설 수 없습니다. 다시 입력하세요.");
                i--;
            } else {
                sum = sum - n;
                System.out.println("당신은" + n + "만큼의 금액을 배팅했습니다.");
                System.out.println("당신의 자산은 " + sum + "원 입니다.");
                System.out.println("이 금액을 어디에 거시겠습니까");
            }
        }
    }
}
