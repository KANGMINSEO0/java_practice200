package com.ohgiraffers.practice05;
// 객체 - 중요한 데이터를 저장
public class Card {
    // 데이터 보호 - 은닉화 - 접근 제한자 private
    private String cardVal; // H8, H6, ...
    // 멤버 접근 메서드
    public String getCardVal() {
        return cardVal;
    }
    // 기본 생성자 - 멤버 초기화
    public Card() {
//        this("H2"); // 아래와 동일
        this.cardVal = "H2";
        // 0~3
        int suit = (int) (Math.random() * CardUtil.SUIT.length);
        // 0~12
        int valu = (int) (Math.random() * CardUtil.VALU.length);
        // 임의의 카드값을 갖는다. H8, H6, ...
        cardVal = CardUtil.SUIT[suit] + CardUtil.VALU[valu];
    }
    // 테스트용
    public Card(String s) {
        this.cardVal = s;   // 문자열은 값 복사
    }
    // 복사 생성자
    public Card(Card c) {       // 다른 카드의 카드값만 가져온다.
        this.cardVal = c.getCardVal();  // 문자열 값 복사
    }
    @Override
    public String toString() {
        return "[" + cardVal + "]";
    }
}
