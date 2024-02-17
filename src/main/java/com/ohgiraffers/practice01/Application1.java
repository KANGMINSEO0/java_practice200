package com.ohgiraffers.practice01;

import java.util.Calendar;
import java.util.Date;

public class Application1 {

    public static void main(String[] args) {
        /* 자바 프로그래밍 실행하기*/
        System.out.println("===================================");
        System.out.println(" 이 프로그래밍은 Java200이 만들었습니다. ");
        System.out.println("===================================");

        /* 기본 타입 선언하기 */
        boolean isL = false;
        char suit = 'H';
        int year = 2016;
        double latitude = 37.52127220511242;
        double longitude = 127.0074462890625;
        System.out.println(latitude + "\t" + longitude);  // "\t" : 이스케이프 문자로 탭(7자 띄우기)을 의미함

        /* API에서 제공하는 참조 타입 사용하기 */
        // 기본 타입의 배열은 참조 타입
        int[] m = {1, 2, 3};            // 배열
        int[] n = new int[] {1, 2, 3};  // 배열
        // 참조 타입 - 객체타입
        String card = "HB";             // 문자열
        Date d = new Date();            // 오늘
        Calendar cal = Calendar.getInstance();  // 오늘
        // 자동으로 toString()이 붙음
        System.out.println(card);       // card.toString()
        System.out.println(d);          // d.toString()
        System.out.println(cal);        // cal.toString()

        /* 사용자 정의 참조 타입 사용하기 */
        // 두 개의 기본 타입
        double latitude1 = 37.52127220511242;
        double longitude1 = 127.0074462890628;
        // 사용자 정의 객체를 생성
        jLocation jloc = new jLocation();
        jloc.lat = latitude1;       // 값을 대입
        jloc.lng = longitude1;      // 값을 대입

        jLocation newLoc = jloc;        // 객체를 대입
        System.out.println(newLoc.lat); // 출력
        System.out.println(latitude1);

        /* 문자열을 실수로 변환하기 */
        // 타입변환의 필요성
        String slat = "37.52127220511242   ";
        // Strina slat = "hello";
        // 공백 제거 후 double로 타입 변환
        double latitude2 = Double.parseDouble(slat.trim());
        System.out.println(latitude2);

        /* 코멘트(주석) 달기 */
        // 코멘트 - 프로그래밍에 영향이 없으며 설명을 위한 표시
        /*
        * 0.0 <= 실수값 < 10.0을 (int)하면 정수만 반환한다.
        * 그래서 0~9 사이의 임의의 정수를 반환한다.
        * */
        int makeOne = (int)(Math.random()*10);
        // 0~9 사이의 임의의 정수
        System.out.println(makeOne);    // 실행할 때마다 변한다.

        /* 정수 연산하기 */
        // 정수 변수, 연산
        int kor = 90;
        int eng = 80;
        int math = 89;
        int tot = kor + eng + math;     // 259
        int average = tot/3;            // 정수 연산은 정수 86.3333 -> 86
        System.out.printf("국어%d점, 영어%d점, 수학%d점 =>\t", kor, eng, math);
        System.out.printf("총점%d점, 평균%d점\n", tot, average);

        /* 정수 타입의 배열 사용하기 */
        // 정수 배열
        int[] grad = {90, 80, 89};
        int tot1 = grad[0] + grad[1] + grad[2];
        int average1 = tot1/3;      // 정수 연산은 정수
        System.out.printf("국어%d점, 영어%d점, 수학%d점 =>\t", grad[0], grad[1], grad[2]);
        System.out.printf("총점%d점, 평균%d점\n", tot1, average1);

        /* 실수 타입의 변수 사용하기 */
        // 실수 변수, 연산
        double S = 6;       // 6 영국 신발 사이즈 -> 255mm
        double P = 0.75;    // 75% 히트할 확률
        double L = 200;     // 200파운드 -> 1.787원/1파운드
        double T = 0;       // 0년(올해 유행) 1년 전 유행
        double A = 1;       // 음주량 0잔 -> 8.83cm 1잔 -> 4.42cm
        double Y = 2;       // 착용년도
        double ups1 = P * L * (Y + 9);
        double downs = (T + 1) * (A + 1) * (L + 20);
        double ups2 = 12 + 3 * S / 8.0;
        double high = ups1 / downs * ups2;  // 밝혀낸 식
        System.out.printf("적당한 하이힐 높이는 %1$.2fcm입니다.", high);
        System.out.println();

        /* 문자와 문자열의 관계 살펴보기 */
        //char, escape
        char a = '닳';
        String letter = "동해 물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세";
        int loc = letter.indexOf(a);
        char b = letter.charAt(loc);
        System.out.printf("\"%s\"의 %d번째 문자는 '%c'이다.", letter, loc, b);
        System.out.println();

        /* 메서드 선언하고 호출하기 */
        // 메서드 호출
        showHelp();


    }
    // 메서드 선언
    public static void showHelp() {
        System.out.println("===================================");
        System.out.println(" 이 프로그래밍은 Java200이 만들었습니다. ");
        System.out.println("===================================");
    }
}


