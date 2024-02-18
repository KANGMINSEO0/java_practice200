package com.ohgiraffers.practice02;

public class Application1 {
    // 중급 39번 문제까지 있음
    // 상수, 상수값은 변경할 수 없다.
    public static final int PHYSICAL = 23;    // 상수(개발자 정의)
    public static final int EMOTIONAL = 28;
    public static final int INTELLECTUAL = 33;

    // static 메서드 선언
    public static double getBioRythm(long days, int index, int max) {
        return max * Math.sin((days % index) * 2 * Math.PI / index);
    }
    // 멤버 메서드( non static) 선언
    public double getBioRythmNon(long days, int index, int max) {
        return max * Math.sin((days % index) * 2 * Math.PI / index);
    }
    public static void main(String[] args) {

        /* Math 클래스를 사용하여 신체 지수 구하기 */
        int index = PHYSICAL;                   // 상수값을 변수에 대입
        int days = 1200;
        double phyval = 100 * Math.sin((days % index) * 2 * Math.PI / index);
        System.out.printf("나의 신체 지수 %1$.2f입니다.\n", phyval);

        /* static 메서드로 신체 지수 구하기 */
        //메서드 호출
        double phyval1 = getBioRythm(days, PHYSICAL, 100);
        System.out.printf("나의 신체 지수 %1$.2f입니다.\n", phyval1);

        /* 멤버 메서드를 이용하여 신체 지수 구하기 */
        Application1 bio = new Application1();
        double phyval2 = bio.getBioRythmNon(days, PHYSICAL, 100);
        System.out.printf("나의 신체 지수 %1$.2f입니다.\n", phyval2);

        /* 상수의 묶음 클래스 enum 사용하기 */
        // 상수의 묶음
        FRUIT pear = FRUIT.APPLE;
        FRUIT pear2 = FRUIT.MANGO;
        System.out.println(pear);
        System.out.println(pear.name());
        System.out.println(pear.ordinal());     // 선언될 때 순서0
        System.out.println(pear2.ordinal());    // 선언될 때 순서2
        FRUIT[] fruits = FRUIT.values();
        System.out.println(fruits[0]);
        /* enum을 int로 변환하거나 대입할 수 없다. int a = FRUIT.APPLE; 형식은 예외가 발생한다.
        *  꼭 변환해서 사용하고 싶다면 순서를 나타내는 ordinal()을 이용한다.
        * 메서드가 없는 기본 enum은 연산에 적합하지 않으며 if, switch와 같은 분기문에 사용한다.
        * */

        /* 1, 2차원 배열로 위도, 경도 표현하기 */
        // 실수 변수
        double latitude1 = 37.52127220511242;
        double longitude1 = 127.0074462890625;  // 서울
        double latitude2 = 35.137879119634185;
        double longitude2 = 129.04541015625;    // 부산
        System.out.println(latitude1 + "\t" + longitude1);
        // 실수 1차원 배열
        double[] latlng1 = {latitude1, longitude1};
        double[] latlng2 = {latitude2, longitude2};
        System.out.println(latlng1[0] + "\t" + latlng1[1]);
        // 실수 2차원 배열
        double[][] latlng = { {latitude1, longitude1},
                              {latitude2, longitude2}};
        System.out.println(latlng[0][0] + "\t" + latlng[0][1]);

        /* 객체를 이용하여 위도, 경도 표현하기 */
        // 위도, 경도를 한 묶음으로 객체에 저장
        // (위도, 경도) 객체
        Geo geo1 = new Geo();
        geo1.latitude = latitude1;
        geo1.longitude = longitude1;
        System.out.println(geo1.latitude + "\t" + geo1.longitude);

        /* if 조건문을 이용하여 짝수 홀수 판별하기 */
        // if condition
        int temp = 99;
        if (temp % 2 == 1) {
            // 홀수
            temp = temp * 3 + 1;
        } else {
            temp = temp / 2;
        }
        System.out.printf("계산 후 = %d\n", temp);

        /* 입력받은 정수값에 따라 신체, 감정, 지성값 출력하기 */
        int idx = 23;       // 신체지수
        double value = 0.86;
        String st = textInfor(index, value);
        System.out.println(st);

        String stInfor = textInformation(index, value);
        System.out.println(stInfor);

        /* enum 값에 따라 신체, 감정, 지성값 출력하기 */
        PEI idxPEI = PEI.PHYSICAL;
        double valuePEI = 0.86;
        System.out.println("신체 지수 주기값 : " + idxPEI.getPei());   //enum을 int로 반환
        String stPEI = textInforPEI(idxPEI, valuePEI);
        System.out.println(stPEI);
        System.out.println(idxPEI.ordinal());
        System.out.println(idxPEI.name());
        System.out.println(idxPEI);
        System.out.println(idxPEI.getPei());

        /* switch~case로 카드값 구하기 */
        char c = 'J';
        int result = toNum(c);
        System.out.printf("%c => %d\n", c, result);



    }
    // case
    // 조건에 따라 신체, 감정, 지성값을 출력
    public static String textInfor(int index, double value) {
        String result = "";
        switch (index) {
            case 23 : result = "신체지수 : "; break;
            case 28 : result = "감성지수 : "; break;
            case 33 : result = "지성지수 : "; break;
        }
        return result + (value * 100);
    }

    public static String textInformation(int index, double value) {
        String result = "";
        switch (index) {
            case PHYSICAL : result = "신체지수 : "; break;
            case EMOTIONAL: result = "감성지수 : "; break;
            case INTELLECTUAL : result = "지성지수 : "; break;
            default : result = "미결정 : "; break;
        }
        return result + (value * 100);
    }

    public static String textInforPEI(PEI index, double value) {
        String result = "";
        switch (index) {
            case PHYSICAL : result = "신체지수 : "; break;
            case EMOTIONAL: result = "감성지수 : "; break;
            case INTELLECTUAL : result = "지성지수 : "; break;
            default : result = "미결정 : "; break;
        }
        return result + (value * 100);
    }
    public static int toNum(char c) {
        int tot = 0;
        switch (c) {
            case 'A' : tot = 1; break;
            case 'T' : tot = 10; break;
            case 'J' : tot = 11; break;
            case 'Q' : tot = 12; break;
            case 'K' : tot = 13; break;
            default : tot = c - '0'; break;
        }
        return tot;
    }

}
