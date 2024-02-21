package com.ohgiraffers.practice02;

import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

public class SystemTest {

    public static void main(String[] args) {

        /* System으로 연산 요소 시간 구하기 */
        long ltime = System.currentTimeMillis();
        System.out.println(ltime);           // 1970.1.1 부터 현재까지 걸린 시간을 밀리세컨드 단위로 반환
        for (int i = 0; i < 100000; i++) {
            System.out.printf("");
        }
        long ltime2 = System.currentTimeMillis();   // milli 1/1000초
        System.out.println((ltime2-ltime2));
        System.out.println(ltime2/1000/60/60/24/365 + "년");
        Properties prop = System.getProperties();
        // 원하는 System property
        System.out.println(prop.getProperty("java.vm.version"));
        System.out.println(prop.getProperty("file.separator"));

        System.out.println(new Date(System.currentTimeMillis()));   // 오늘
        //----------------java.util.*에서----------------//
        // 모든 System property
        Enumeration<Object> en = prop.keys();
        int i = 0;
        while (en.hasMoreElements()) {
            String keys = (String) en.nextElement();
            System.out.println((++i + " ") + keys + " : " + prop.getProperty(keys));
        }
    }
}
