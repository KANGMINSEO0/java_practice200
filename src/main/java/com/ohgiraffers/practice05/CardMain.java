package com.ohgiraffers.practice05;

public class CardMain {
    public static void main(String[] args) {
        String csuit1 = "H", cvalu1 = "6";  // suit+value
        String csuit2 = "H", cvalu2 = "3";  // suit+value
        // 객체 생성
        Card c1 = new Card("H6");       // 생성자 (String 아규먼트)H6
        Card c2 = new Card(csuit1 + cvalu1); // 생성자 (String 아규먼트)H6
        Card c3 = new Card();               // 기본 생성자 H2를 가짐
        Card c4 = new Card(csuit2 + cvalu2); // 생성자 (String 아규먼트)H3

        System.out.printf("%s, %s, %s, %s\n", c1, c2, c3, c4);
        System.out.println(c1.equals(c2));  // 해시코드는 다름
        System.out.println(c1.getCardVal().equals(c2.getCardVal())); // 값 동일
        // 참조 타입은 equals()로 비교

        System.out.println("=================================================");
        Card card1 = new Card("H4");         // 생성자 (String 아규먼트)
        Card card2 = new Card("H4");         // 생성자 (String 아규먼트)
        Card card3 = new Card(c1);              // 복사 생성자 - 값 동일
        System.out.println(card1.hashCode());   // 값은 동일, 다른 해시코드
        System.out.println(card2.hashCode());   // 값은 동일, 다른 해시코드
        System.out.println(card1.getCardVal()); // 값은 동일
        System.out.println(card2.getCardVal()); // 값은 동일
        System.out.println(card1.equals(card2));// hashCode 비교 - 중요 - false
        System.out.println(card1.equals(card3));// hashCode 비교 - 중요 - false
        for (int i = 0; i < CardUtil.SUIT.length; i++) {     // SUIT 2
            for (int j = 0; j < CardUtil.VALU.length; j++) { // VALU 10
                // 값은 같을 수 있지만, 해시코드는 고유하다 (같을 수 없다).
                Card c =new Card();             // 임의로 카드 생성 - 기본 생성자()
                System.out.printf("%s\t", c);   // c.toString()
            }
            System.out.println();               // 10개 출력 후 한 칸 아래
        }
    }
}
