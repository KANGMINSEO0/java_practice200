package com.ohgiraffers.practice02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Locale;

public class Application4 {

    public static void main(String[] args) {
        // 중급 70번 까지 있음
        /* String과 char를 이용하여 10진수를 2진수로 변환하기 */
        int ival = 2345;
        int eval = -2345;
        Application4 bitsh = new Application4();
        String vals = bitsh.makeBit(ival);
        System.out.println(vals);
        vals = bitsh.makeBit(eval);
        System.out.println(vals);
        char[] vs = vals.toCharArray();
        System.out.println(vs[0]);

        /* 정수를 입력받을 때 발생할 수 있는 예외 처리하기 */
        String sNum = "123";
        String nNum = "h";
        try {
            int a = Integer.parseInt(sNum);
            System.out.println(a);
        } catch (NumberFormatException ee) {
            System.out.println("int인지 확인해 봐!!!");
            System.out.println(ee.getMessage());
        } catch (Exception ee) {
            System.out.println("야 잘 좀 넣어");
        } finally {
            System.out.println("난 수행되어야만 해!!!");
        }

        /* 수학 연산에서 발생하는 예외 처리하기 */
        try {
            // Divide by zero.
            int x = 5;
            int y = 20 / (5 - x);   // 여기에서 예외를 던짐
            System.out.println(y);
        } catch (ArithmeticException e) {
            System.out.println("==> 0으로 나눴나 확인해 봐!!!");
            // e.printStackTrace();
        } finally {
            System.out.println("난 수행 되어야만 해!!!");
        }

        /* Object 이해하고 사용하기 */
        Object obj1 = new Object();
        Object obj2 = new Object();

        System.out.println(obj1.hashCode());    // native 10진수
        System.out.println(Integer.toHexString(obj1.hashCode()));   // 16진수
        System.out.println(obj1 == obj2);       // 객체는 고유하다.
        System.out.println(obj1.equals(obj2));  // 객체는 고유하다.
        System.out.println(obj1);
        System.out.println(obj2.toString());    // Class@hashCode()

        System.out.println(obj1.getClass().getName());  // 클래스 이름
        String str = obj1.getClass().getName() + "@"
                + Integer.toHexString(obj1.hashCode()); //16진수
        System.out.println(str);    // 클래스 이름@16진수 해시코드

        Object objstr = new String("Good");     // 다형성
        System.out.println(objstr.toString());
        System.out.println(objstr instanceof Object);
        System.out.println(objstr instanceof Object);
        System.out.println(objstr instanceof String);

        String hello = "hello";
        System.out.println(hello.getClass());   // 클래스 이름

        /* Class를 이용하여 메서드와 생성자 살펴보기 */
        Object obj3 = new Object();
        Class classes = obj3.getClass();
        System.out.println(classes.getName());  // 클래스 이름
        System.out.println("--------constructor--------");
        Constructor[] constructor = classes.getDeclaredConstructors();
        for (Constructor con : constructor) {
            System.out.println(con.getName());
        }
        System.out.println("-------Method------");
        Method[] method = classes.getMethods();
        for (Method me : method) {
            System.out.println(me.getName());
        }

        /* String(문자열)을 이용해 도시 이름 비교하기 */
        String city1 = "Asia";
        String city2 = "Europe";
        String city3 = new String("Asia");
        String city7 = "Asia";
        System.out.println(city1);
        System.out.println(city1.length());
        System.out.println(city1 == city2);
        System.out.println(city1.equals(city2));
        System.out.println(city1 == city3);
        System.out.println(city1 == city7);
        System.out.println(city1.equals(city3));
        System.out.println(city1.equals(city7));

        String city4 = String.format("%s-%s", city1, city2);
        System.out.println(city4);
        String city5 = city1 + "-" + city2 + 1 + 2;
        System.out.println(city5);
        String city6 = 1 + 2 + city1 + "-" + city2;
        System.out.println(city6);

        /* String(문자열) 가공하기 */
        String text = " Hello Java4Android";
        String com = " HEllo Java4Android";

        System.out.println(text.charAt(2));
        System.out.println(text.concat("s"));
        System.out.println(text.contains("And"));
        System.out.println(text.equals(com));
        System.out.println(text.equalsIgnoreCase(com)); // 대소문자 구별 없이 두 문자열이 같은지 판별
        System.out.println(text.indexOf("a"));
        System.out.println(text.lastIndexOf("a"));
        System.out.println(text.trim());    // 양쪽의 공백을 제거
        System.out.println(text.length());  // 공백 포함된 문자열의 길이 반환
        System.out.println(text.substring(7));
        System.out.println(text.substring(7, 11));
        System.out.println(text.replace(" ", "-"));      // replaceAll
        System.out.println(text.replaceAll(" ", "-"));
        System.out.println(text.toUpperCase());
        System.out.println(text.toLowerCase());

        String[] sp = text.split(" ");
        for (int i = 0; i < sp.length; i++) {
            System.out.println(i +"\t\t" + sp[i] + "\t\t" + sp[i].length());
        }

        /* 리플렉션(Reflection)을 이용하여 클래스 정보 출력하기 */
        Object obj4 = new Object();
        try {
            // Class classes = obj4.getCalss();
            Class classes1 = Class.forName("java.lang.String");
            // ClassNotFoundException
            System.out.println("--------Method 찾기--------");
            Method[]  mes = classes1.getMethods();
            for (Method me : mes) {
                if (me.getModifiers() > 4000) {continue;}   // 4000초과면 다음 스텝
                System.out.printf("%s\t\t", toModi(me.getModifiers())); // 제한자 종류
                System.out.printf("%-30s\t\t", toRe(me.getReturnType().toString()));
                System.out.printf("%s", me.getName());      // 클래스 이름
                System.out.printf("(", "");     // 두개 이상일 때 ,로 표시
                Class[] aa = me.getParameterTypes();        // 아규먼트(인자, 파라미터)
                for (int j = 0; j < aa.length; j++) {
                    System.out.printf("%s", toRe(aa[j].getName())); // 아규먼트 이름
                    if (j != aa.length -1) {    // 2개 이상이면
                        System.out.printf(",");
                    }
                }
                System.out.printf(")", "");
                System.out.println();
            }
            System.out.println("-----------생성자 찾기-------------");
            Constructor[] constructor1 = classes1.getDeclaredConstructors();
            for (Constructor con : constructor1) {
                System.out.printf(con.getName());
                System.out.printf("(", "");
                Class[] aa = con.getParameterTypes();
                for (int j = 0; j < aa.length; j++) {
                    if (j != aa.length - 1) {
                        System.out.printf(",");
                    }
                }
                System.out.printf(")", "");
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        /* StringBuffer로 문자열 수정, 변경, 추가하기 */
        // StringBuffer 생성
        StringBuffer sb1 = new StringBuffer();
        // 1 계속 붙이는 함수 mutable
        sb1.append("안녕하세요.")
           .append("또 만나요.")
           .append("모두를 사랑해요. 기다려봐.");
        System.out.println(sb1.toString() + sb1.hashCode());
        // 2 replace
        sb1.replace(0, 2, "나 보기가 역겨워");
        System.out.println(sb1.toString() + sb1.hashCode());
        // 3 reverse
        sb1.reverse();
        System.out.println(sb1.toString());
        // 4 delete
        sb1.delete(10, 15);
        System.out.println(sb1.toString());
        // 5 cal by reference, shallow copy
        replaces(sb1);
        System.out.println(sb1.toString());

        /* StringBuilder로 문자열 수정, 변경, 추가하기 */
        // synchronized 안한 StringBuffer
        StringBuilder sbu = new StringBuilder();
        sbu.append("I")
                .append(" go")
                .append(" to school.");
        System.out.println(sbu);
        sbu.replace(7, 11, "");
        System.out.println(sbu);
        sbu.reverse();
        System.out.println(sbu);
        sbu.deleteCharAt(3);
        System.out.println(sbu);
        sbu.delete(1,3);
        System.out.println(sbu);
        String ss = sbu.substring(0);
        System.out.println(ss);
        System.out.println(sbu);
        String st = sbu.substring(0,4);
        System.out.println(st);
        System.out.println(sbu);






    }

    public static final int BITMASK = 1;
    public String makeBit(int value) {
        // char 배열을 String으로 만들기 위해
        char[] val = new char[32];
        for (int i = 31; i >= 0; i--) {
            if ((value & BITMASK) == 1) {
                val[i] = '1';    // 1&1일때만 1 그 외 0
            } else {
                val[i] = '0';    // 1&1일때만 1 그 외 0
            }
            value >>>= 1;        // value = value>>>1; 부호 무시하고 오른쪽 이동
            /* >> : 부호를 유지하면서 쉬프트 연산을 함
            *  >>> : >>와 마찬가지로 오른쪽으로 쉬프트(이동)
            * */
        }
        return new String(val);
    }
    public static String toModi(int n) {
        String s = "";
        switch (n) {
            case 0 : s = " "; break;
            case 1 : s = "public"; break;
            case 2 : s = "private"; break;
            case 4 : s = "protected"; break;
            case 8 : s = "static"; break;
            case 10 : s = "private static"; break;
            case 9 :
            case 137 : s = "public static"; break;
            case 17 : s = "public final"; break;
            case 257 : s = "public native"; break;
            case 260 : s = "protected native"; break;
            case 273 : s = "public final native"; break;
            default: s = "xxxx"; break;
        }
        return s;
    }

    public static String toRe(String msg) {
        String s = "";
        if (msg.indexOf("[") != -1) {
            if (msg.contains("[C")) {
                s = msg.substring(msg.indexOf(" ") + 1).trim();
                s = s.replace("[C", "char[]");
            } else if (msg.contains("[L")) {
                s = msg.substring(msg.indexOf(" ") + 1).trim();
                s = s.replace("[L", "").replace(";", "");
                s = s.concat("[]");
            } else if (msg.contains("[B")) {
                s = msg.substring(msg.indexOf(" ") + 1).trim();
                s = s.replace("[B", "byte[]");
            }
        } else if (msg.indexOf(" ") != -1) {
            s = msg.substring(msg.indexOf(" ") + 1).trim();
        } else {
            s = msg.trim();
        }
        return s;
    }

    public static void replaces(StringBuffer sb) {
        sb.reverse();
        sb.replace(0, 3, "GoGo");       // 0부터 2까지를 GoGo로
    }
}
