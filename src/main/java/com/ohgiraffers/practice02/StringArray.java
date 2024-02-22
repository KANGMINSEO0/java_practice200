package com.ohgiraffers.practice02;

public class StringArray {
    public static void main(String[] args) {
        /* 문자열 1차원 배열 이해하기 */
        String[] myNum = new String[] {"2016-08-17", "2016-09-17", "2016-03-17"};
        String[] myNum2 = {"2016-08-17", "2016-09-17", "2016-03-17"};
        System.out.println(myNum2[0]);
        print(myNum);
        // myNum2 = {"2016-08-17", "2016-03-17", "2016-04-17"]; // 다시 초기화 불가
        myNum = new String[] {"2016-08-17", "2016-09-17", "2016-03-17", "2016-04-17"};
        String[] tos = new String[myNum.length];
        System.arraycopy(myNum, 0, tos, 0, myNum.length);
        print(tos);
    }

    public static void print(String[] tos) {
        for (String ss : tos) {
            System.out.printf(ss + "\t");
        }
        System.out.println();
    }
}
