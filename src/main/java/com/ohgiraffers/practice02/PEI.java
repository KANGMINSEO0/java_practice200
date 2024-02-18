package com.ohgiraffers.practice02;
// 상수 묶음 클래스 - enum
public enum PEI {
    // 생성자를 통해 enum 값을 초기화한다. 더 이상 값을 변경 할 수 없다.
    // PEI에 있는 모든 상수값을 enum 변수를 통해 저장 할 수 있다.
    // enum 값을 초기ㅣ화 할 수 있는 생성자 이다.
    // enum이 정수로 변환될 수 없다. 대신 해당 값을 반환하는 메서드를 선언해서 사용한다.
    // 생성자와 사용자 정의 메서드가 없는 enum의 예이다.

    PHYSICAL(23), EMOTIONAL(28), INTELLECTUAL(33);
    private final int peiValue;
    PEI(int pie) {
        this.peiValue = pie;
    }
    public int getPei() {
        return peiValue;
    }
}
