package com.ohgiraffers.practice06;

import com.ohgiraffers.practice05.CardUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 리스트에 서로 다른 카드 20개 저장하기
public class CardCase {
    // aggregation : CardCase는 Card로 구성된다.
    private List<Card> cards = new ArrayList<Card>();
    public CardCase() {
        cards.clear();  // 내용 지우기
    }
    // List 반환
    public List<Card> getCards() {
        return cards;
    }
    // List에 저장된 Card의 개수
    public int count() {
        return cards.size();    // 저장된 Card 개수
    }
    // List의 index번째 Card
    public Card getCard(int index) {
        return cards.get(index);    // index번째 Card
    }
    // 서로 다른 카드 20장 만들기
    public void make() {
        cards.clear();                      // 내용 지우기
        int suit = CardUtil.SUIT.length;    // 2
        int valu = CardUtil.VALU.length;    // 10
        int count = 0;
        // 서로 다른 20개의 카드를 만든다.
        while (count != valu*suit) {    // 20장이 될 때까지
            Card c = new Card();        // 임의의 카드를 만든다.
            if (!cards.contains(c)) {   // contains -> equals()를 이용해 비교
                cards.add(c);           // 같은 객체가 아니라면 저장
                count++;
            }
        }
    }
    public void shuffle() {
        Collections.shuffle(cards); // 카드 섞기
    }
    public void print() {
        int valu = CardUtil.VALU.length;
        for (int i = 0; i < cards.size(); i++) {
            Card c = cards.get(i);
            System.out.printf("%s", c.toString());
            if ((i + 1) % valu == 0) {
                System.out.println();
            }
        }
    }
    // 107번 객체 비교를 이용하여 카드 정렬하기
    public void sort() {
        Comparator<Card> cmp = new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return c1.getCardVal().compareTo(c1.getCardVal());
            }
        };
        cards.sort(cmp);
//        cards.sort(new CardComp());
        // Collections.sort(cards, new CardComp());
    }
    public void rsort() {
        // 익명 -anonymous
        cards.sort(new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return -c1.getCardVal().compareTo(c2.getCardVal());
            }
        });
//        cards.sort(new CardRomp());
        // Collections.sort(cards, new CardRomp());
    }
    // sort를 Lambda로 구현
    public void lambdasort() {
        cards.sort((c1, c2) -> {return c1.getCardVal().compareTo(c2.getCardVal());});
    }
    public void lambdasort2() {
        cards.sort(Comparator.comparing(Card::getCardVal));     // comparing
    }
    public void lambdasort3() {
        cards.sort(Card::compareCard);     // static
    }

    // rsort를 Lambda로 구현
    public void lambdarsort() {
        cards.sort(
                (c1, c2) -> {return -c1.getCardVal().compareTo(c2.getCardVal());});
    }
    public void lambdarsort2() {
        Comparator<Card> mycard = (c1, c2) -> {return c1.getCardVal().compareTo(c2.getCardVal());};
        cards.sort(mycard.reversed());
    }
    public void lambdarsort3() {
        cards.sort(Card::compareRCard);     // static
    }
}
