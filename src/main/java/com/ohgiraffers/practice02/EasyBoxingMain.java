package com.ohgiraffers.practice02;

import java.util.ArrayList;

// Boxing/Unboxing
public class EasyBoxingMain {
    public static void main(String[] args) {

        /* 박싱, 언박싱으로 기본 타입을 참조 타입으로 변환하기 */
        int intNm1 = 123;
        long longNum1 = 345L;
        double doubleNum = 123.123;
        Integer intWrap1 = intNm1;          // new Integer(intNm1);
        Long longWrap1 = longNum1;          // new Long(longNum1);
        Double doubleWrap1 = doubleNum;     // new Double(longNum1);
        double dd = doubleWrap1;
        // 기본타입 <-> Wrapper 캐스팅 없이 사용
        Integer intWrap2 = intNm1;          // Boxing
        intNm1 = intWrap2;                  // UnBoxing
        System.out.println(intNm1);

        ArrayList<Integer> lists = new ArrayList<>();
        lists.add(new Integer(3));
        lists.add(5);
        int a = lists.get(0);               // <Integer>
        System.out.println(a);

        int b = Integer.parseInt("123");
        System.out.println(b);
    }
}
