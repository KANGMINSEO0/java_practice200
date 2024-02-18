package com.ohgiraffers.practice02;

public class Application2 {
    public static void main(String[] args) {
        // 50번 문제까지 있음
        /* switch~case로 환율 구하기 */
        String money = "USD";
        double result = toMoney(money);
        System.out.printf("%s => %f\n", money, result);

        /* 논리 연산자(&&, ||)로 윤년 판별하기 */
        Application2 hc = new Application2();
        System.out.println(hc.isLeapYear(2017));

        /* 정수-실수 변환으로 섭씨를 화씨로 바꾸기 */
        // 반복문
        for (int i = 0; i < 101; i++) {
            double fahrenheit = 9.0 / 5 * i + 32;   // for 블록 변수
            System.out.printf("섭씨%d도 = 화씨%.2f도\n", i, fahrenheit);
        }

        /* while을 이용하여 1이 될 때까지 나누고 곱하기 */
        showOddEvenw(122);
        System.out.println();

        /* do~while을 이용하여 1이 될 때까지 나누고 곱하기 */
        showOddEvenDW(122);
        System.out.println();

        /* for를 이용하여 1이 될 때까지 나누고 곱하기 */
        showOddEvenFor(122);
        System.out.println();

        /* while을 이용하여 서로 다른 세 정수 만들기 */
        int range = 10;
        int start = 1;
        int a = 0, b = 0, c = 0;
//        while (true) {
//            a = (int) (range * Math.random() + start);
//            b = (int) (range * Math.random() + start);
//            c = (int) (range * Math.random() + start);
//            if (a != b && b != c && c != a) break;
//        }
        System.out.printf("%d\t%d\t%d", a, b, c);
        System.out.println();

        /* while과 조건을 이용하여 서로 다른 세 정수 만들기 */
        while (a == b || b == c || c == a) {
            a = (int) (range * Math.random() + start);
            b = (int) (range * Math.random() + start);
            c = (int) (range * Math.random() + start);
        }
        System.out.printf("%d\t%d\t%d", a, b, c);
        System.out.println();

        /* while과 단축 연산자를 이용하여 각 자릿수의 합 구하기 */
        int number = 1234567;
        int value = sumEach(number);
        System.out.printf("%d에 대한 각 자리의 숫자 합 : %d", number, value);
        System.out.println();
        /* 제곱근을 이용하여 소수 판별하기 */
        boolean ifPrime = isPrime(number);  // 소수인가를 확인한다.
        if (ifPrime) {
            System.out.printf("%는 1과 자신으로만 나눠떨어지는 소수다.", number);
        } else {
            System.out.printf("%d은 소수가 아니다.", number);
        }
        System.out.println();

        /* shift 연산자를 이용하여 2진수 문자열로 바꾸기 */
        int intNums1 = 123;
        int intNums2 = -123;
        System.out.printf("%d : %s%n", intNums1, shift(intNums1));
        System.out.printf("%d : %s%n", intNums2, shift(intNums2));

    }

    public static double toMoney(String c) {
        double tot = 0.0;
        switch (c) {
            case "USD" : tot = 1126.5; break;
            case "JPY" : tot = 110.6; break;
            case "CNY" : tot = 10.5; break;
            default : tot = 1; break;
        }
        return tot;
    }

    // if && ||
    public boolean isLeapYear(int year) {
        boolean isS = false;
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            // 입력된 연도가 4의 배수이지만 100의 배수는 아니며 400의 배수이다
            // 윤년이면 isS에 true를 대입한다.
            isS = true;
        }
        return isS;
    }

    public static void showOddEvenw(int n) {
        int temp = n;
        while (temp != 1) {
            if (temp % 2 == 1) {
                // 홀수
                temp = temp * 3 + 1;
            } else {
                // 짝수
                temp /= 2;
            }
            System.out.printf("[" + temp + "]");
        }
        System.out.printf("\n--------------------");
    }

    public static void showOddEvenDW(int n) {
        int temp = n;
        do {
            if (temp % 2 == 1) {
                temp = temp * 3 + 1;
            } else {
                temp /= 2;
            }
            System.out.printf("[" + temp + "]");
        } while (temp != 1);
        System.out.printf("\n--------------------");
    }

    public static void showOddEvenFor(int n) {
        int temp = n;
        for (; temp != 1; ) {
            if (temp % 2 == 1) {
                temp = temp * 3 + 1;
            } else {
                temp /= 2;
            }
            System.out.printf("[" + temp + "]");
        }
        System.out.printf("\n--------------------");
    }

    // 축약 연산자
    public static int sumEach(int n) {
        int tot = 0;
        while (n != 0) {
            // n의 일의 자릿수를 구하여 tot에 더함
            tot += n % 10; // 3 -> 2 -> 1
            n /= 10;
        }
        return tot;
    }

    // Math 클래스 메서드
    public static boolean isPrime(int n) {
        // 소수(Prime)이란 1과 자신으로만 나누어 떨어지는 수
        // 1과 자신을 제외한 다른 수로는 나누어 떨어지지 않음
        boolean isS = true;
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                isS = false;
                break;
            }
        }
        return isS;
    }

    // >> shift ? 삼항연산자
    // 10진수 정수를 2진수 문자열(String)로 변환
    public static String shift(int a) {
        String s = "";
        for (int i = 0; i <= 31; i++) {
            int aa = a % 2;
            s = (aa >= 0)? aa + s : (-aa) + s;
            a >>= 1;    // a /= 2;
        }
        return s;
    }
}
