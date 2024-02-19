package com.ohgiraffers.practice02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {
        // 60번 문제까지 있음
        /* &(비트) 연산자를 이용하여 2진수 문자열로 바꾸기 */
        // & 연산자 : 1 & 1 일 때만 1
        // | 연산자 : 0 | 0 일 때만 0
        // ^ 연산자 : 1과 0 또는 0과 1일 때만 1
        int intNum1 = 123;
        int intNum2 = -123;
        System.out.printf("%d : %s%n", intNum1, shifts(intNum1));
        System.out.printf("%d : %s%n", intNum2, shifts(intNum2));

        /* 문자열 자르기를 이용하여 2진수 문자열로 바꾸기 */
        // String method
        System.out.printf("%d : %s%n", intNum1, shifts(intNum1));
        System.out.printf("%d : %s%n", intNum2, shifts(intNum2));

        /* for와 if를 이용하여 홀수의 합 구하기 */
        // s = s + a
        int s = 0;
        for (int i = 1; i <= 100; i++) {
            s += i;
        }
        System.out.println("1~100의 합 : " + s);
        s = 0;      // 0으로 초기화
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1) {
                s += i;
            }
        }
        System.out.println("1~100 사이의 홀수의 합 : " + s);

        /* 향상된 for(foreach)로 배열 출력하기 */
        // 향상된 for와 배열
        int[] mm = {1,6,16,22,23,33};
        for (int m : mm) {
            System.out.printf(m + "\t");
        }
        System.out.println();

        /* varargs(variable arguments)를 이용하여 배열 출력하기 */
        print(mm);      // 배열도 되고
        int a = 1, b = 6, c = 16;
        print(a);       // 1개짜리도 되고
        print(a,b);     // 2개짜리도 되고
        print(a,b,c);   // 3개짜리도 되고

        /* 배열보다 편리한 List 사용하기 */
        List<Integer> list = new ArrayList<>();
        // 넣기
        for (int i = 1; i <= 10; i++) {
            list.add(i);            // 저장할때는 add를 사용
        }
        // 가져오기
        for (int i = 0; i < list.size(); i++) {
            int m = list.get(i);    // 가져올때는 get을 사용
            System.out.printf("%d\t", m);
        }
        System.out.println();

        /* foreach와 Lambda 형식을 이용하여 List 출력하기 */
        /* 인덱스 없이 순서대로 수를 가져온 다음
        * -> {} (람다) 형식을 이용해서 그 수를 처리한다.
        * forEach(m -> {m 출력}) 형식
        * 향상된 for에서 순서대로 수를 가져와 출력함
        * List<Integer>로 선언했다면 m은 int(Integer) 이다.*/
        List<Integer> mmlists = Arrays.asList(1,6,16,22,23,33);
        mmlists.forEach(
                m -> {
                    System.out.printf(m + "\t");
                }
        );
        System.out.println();
        Consumer<Integer> consume = (Integer m) -> {
            System.out.printf(m + "\t");
        };
        mmlists.forEach(consume);
        System.out.println();

        /* for와 if를 이용하여 홀수에 대한 제곱의 합 구하기 */
        // List
        List<Integer> list1 = new ArrayList<>();
        int s1 = 0;
        for (int i = 1; i <= 10; i++) {
            list1.add(i);
        }
        for (int m : list1) {
            if (m % 2 == 1) {
                s1 += m*m;
                System.out.printf("%d\t", m*m);
            }
        }
        System.out.println();
        System.out.println("1~10 사이의 홀수에 대한 제곱합 : " + s1);

        /* Stream을 이용하여 홀수의 합 구하기 */
        List<Integer> list2 = new ArrayList<>();
        int s2 = 0;
        for (int i = 1; i <= 100; i++) {
            list2.add(i);       // 리스트에 저장
        }
        // 초기값 0
        s2 = list2.stream().reduce(0, Integer::sum);
        System.out.println("1~100의 합 : " + s2);
        // 1~100 사이 홀수의 합
        s2 = list2.stream().filter(i -> i % 2 == 1).reduce(0, (x, y) -> x + y);
        System.out.println("1~100 사이 홀수의 합 : " + s2);
        // 1~100 사이 홀수의 합
        s2 = list2.stream().filter(i -> i % 2 == 1).reduce(0,
                new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer t, Integer u) {
                        return t + u;
                    }
                });
        System.out.println("1~100 사이 홀수의 합 : " + s2);

        /* Stream과 map을 이용하여 홀수에 대한 제곱의 합 구하기 */
        // stream list filter map reduce
        List<Integer> list3 = new ArrayList<>();
        int s3 = 0;
        for (int i = 1; i <= 10; i++) { // 1과 10 사이의 정수를 List에 저장
            list3.add(i);
        }
        // stream filter map collect
        /* 리스트에 저장된 데이터에 대해 조건에 맞는 수를 찾을 때는 filter를 이용한다.
        * filter에서 찾은 수에 대하여 "제곱을 하라"처럼 "이렇게 처리하라"는 map을 이용한다.
        * collect는 해당 수의 값을 새로운 리스트에 저장한다.
        * filter(수 -> 홀수).map(수 -> 수*수).collect()는 홀수에 대하여 제곱한 수를
        * 새로운 리스트에 저장한다는 의미이다.*/
        list3 = list3.stream()
                .filter(i -> i % 2 == 1)        // 홀수를 구함
                .map(i -> i * i)                // 홀수에 대하여 제곱
                .collect(Collectors.toList());  // 제곱한 수를 모두 list3에 저장
        list3.forEach(i -> {
            System.out.printf(i + "\t");        // 홀수에 대한 제곱수 출력
        });
        System.out.println();
        // stream reduce
        s3 = list3.stream().reduce(0, Integer::sum);    // 홀수 제곱수의 합 구함
        System.out.println("1~10 사이의 홀수에 대한 제곱합 : " + s3);


    }

    public static int BITMASK = 1;
    // 10진수를 2진수 문자열(스트링)로 변환
    public static String shifts(int a) {
//        int BITMASK = 1;
        String s = "";
        for (int i = 0; i <= 31; i++) {
            s = (a & BITMASK) + s;
            a >>= 1;        // a /= 2;
        }
//        return s;
        // 10진수를 2진수 스트림으로 변환
        return s.substring(s.indexOf("1"));
        /* 왼쪽에서 오른쪽 첫 번째 1을 찾고
        * 그 앞에 있는 0을 모두 제거
        * a가 123인 경우 indexOf("1") = 25
        * substring(25)은 0부터 24번째까지의 0을 제거 후 반환
        * */
    }
    // var args variable arguments
    public static void print(int ... mm) {
        for (int m : mm) {
            System.out.printf(m + "\t");
        }
        System.out.println();
    }
}
