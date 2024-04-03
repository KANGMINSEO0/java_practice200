package com.ohgiraffers.practice07;

public class CardLaw {
    public boolean thirdCardPlayer(int x) {
        boolean isC = false;
        if (x < 6) {
            isC = true;
        }
        return isC;
    }
    public boolean thirdCardDealer(int x, int y) {
        boolean isC = false;
        if (x < 3) {
            isC = true;
        } else if (x == 3 && y != 8) {
            // 뱅커 카드 두 장의 합이 3이고 플레이어 세 번째 카드가 8이 아닐 때
            isC = true;
        } else if (x == 4 && (y > 1 && y < 8)) {
            // 뱅커 카드 두 장의 합이 4이고 플레이어 세 번째 카드가 2~7일 때
        } else if (x == 5 && (y > 3 && y < 8)) {
            // 뱅커 카드 두 장의 합이 5이고 플레이어 세 번째 카드가 4~7일 때
        } else if (x == 6 && y < 8) {
            // 뱅커 카드 두 장의 합이 6이고 플레이어 세 번째 카드가 6, 7일 때
            isC = true;
        }
        return isC;
    }
    public boolean stand(int x, int y) {
        boolean isC = false;

        if (x > 6 && x < 8) {
            if (x == y) {
                isC = true;
            }
            isC = true;
        } else if (y == 7) {
            isC = true;
        }
        return isC;
    }
    public boolean natural(int x, int y) {
        boolean isE = false;
        if (x > 7 && x < 10) {
            isE = true;
        } else if (y > 7 && y < 10) {
            isE = true;
        }
        return isE;
    }
}
