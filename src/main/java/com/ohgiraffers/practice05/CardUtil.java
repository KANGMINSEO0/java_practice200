package com.ohgiraffers.practice05;
// static 변수, 메서드 - 객체 생성 없이 사용 가능하다.
public class CardUtil {
    public static final int SUTDA = 2;
    public static final String[] SUIT = {"H", "C"};
    public static final String[] VALU = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T"};

    public static int toVal(Card c) {
        return toVal(c.getCardVal().charAt(1)); // "H6"에서 '6'
    }
    public static int toVal(Card c, int index) {
        return toVal(c.getCardVal().charAt(index));
    }
    public static int toVal(char cc) {
        int tot = 0;
        switch (cc) {
            case 'A' : tot = 1; break;
            case 'T' : tot = 10; break;
            case 'J' : tot = 11; break;
            case 'Q' : tot = 12; break;
            case 'K' : tot = 13; break;
            default: tot = cc - '0'; break;
        }
        return tot;
    }
}
