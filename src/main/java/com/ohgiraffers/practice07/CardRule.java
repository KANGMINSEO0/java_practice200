package com.ohgiraffers.practice07;

import com.ohgiraffers.practice06.Card;

public class CardRule {
    public int toV(Card c) {
        int count = 0;
        switch (c.getCardVal().charAt(1)) {
            case 'A': count = 1; break;
            case 'T': count = 10; break;
            default: count = c.getCardVal().charAt(1) - '0'; break; // '7'-'0'
        }
        return count;
    } //
    // 광 SUIT C
    public boolean isLight(Card c) {
        boolean isL = false;
        if (c.getCardVal().charAt(0) == 'C') {
            isL = true;
        }
        return isL;
    } //
    // 광(C)이면서 밸류가 1, 3, 8 -> C1, C3, C8
    private boolean is138(Card c) {
        boolean isC = false;
        if (isLight(c)) {
            if (c.getCardVal().charAt(1) == '1' ||
                    c.getCardVal().charAt(1) == '3' ||
                    c.getCardVal().charAt(1) == '8') {
                isC = true;
            }
        }
        return isC;
    }
    // 이차원 방정식을 이용 : 더해서 11, 곱해서 24 -> 3, 8
    public int rule(Card c1, Card c2) {
        int count = 0;
        if (is138(c1) && is138(c2)) {
            if ((toV(c1) * toV(c2) == 24) && (toV(c1) + toV(c2) == 11)) {
                count = 3000;
            } else if ((toV(c1) * toV(c2) == 3) && (toV(c1) + toV(c2) == 4)) {
                count = 2000;
            } else if ((toV(c1) * toV(c2) == 8) && (toV(c1) + toV(c2) == 9)) {
                count = 2000;
            }
        } else {
            // 땡 처리
            if (toV(c1) == toV(c2)) {
                count = toV(c1) * 100;
            } else {
                // 낫땡
                if ((toV(c1) * toV(c2) == 3) && (toV(c1) + toV(c2) == 3)) {
                    count = 99;
                } else if ((toV(c1) * toV(c2) == 4) && (toV(c1) + toV(c2) == 5)) {
                    count = 98;
                } else if ((toV(c1) * toV(c2) == 9) && (toV(c1) + toV(c2) == 10)) {
                    count = 97;
                } else if ((toV(c1) * toV(c2) == 10) && (toV(c1) + toV(c2) == 11)) {
                    count = 96;
                } else if ((toV(c1) * toV(c2) == 40) && (toV(c1) + toV(c2) == 14)) {
                    count = 95;
                } else if ((toV(c1) * toV(c2) == 24) && (toV(c1) + toV(c2) == 10)) {
                    count = 94;
                } else {
                    count = ((toV(c1) + toV(c2)) % 10) * 10;
                }
            }
        }
        return count;
    }
}
