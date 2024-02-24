package com.ohgiraffers.practice03;

import java.util.ArrayList;

public class Application1 {

    public static void main(String[] args) {

        /* 빌보드 차트 정보에서 사용하는 정수와 문자열 */
        int rank = 1;       // 정수 저장
        String song = "Despacito";          // 문자열 저장
        // Data를 그릇에 담는다.
        int lastweek = 1;
        String imagesrc = "https://www.billboard.com/omages/pref_images/q61808osztw.jpg";
        String artist = "luis fonsi";
        String sf = String.format("%d, %s, %d, %s, %s", rank, song, lastweek,imagesrc,artist);
        System.out.println(sf);

        /* 빌보드 차트 정보를 빌보드 저장 객체(DTO)에 저장하기 */
        // Data를 객체로 저장
        Billboard b1 = new Billboard(1, "Despacito", 1, "https://www.billboard.com/images/pref_images/q61808osztw.jpg", "luis fonsi");
        // 객체 출력
        showAbout(b1);

        /* 빌보드 차트를 객체에 저장하고 출력하기 */
        Billboard b2 = new Billboard(2, "That's What I Like", 2, "https://www.billboard.com/images/pref_images/q89725qvpol.jpg", "bruno mars");
        Billboard b3 = new Billboard(3, "I'm The One", 3, "https://www.billboard.com/images/pref_images/q64532pl64x.jpg", "dj khaled");
        showAbout(b1);              // 1개 객체
        showAbout(b2);              // 1개 객체
        showAbout(b1, b2);          // 2개 객체
        showAbout(b1, b2, b3);      // 3개 객체
        Billboard[] b = new Billboard[3];
        b[0] = new Billboard(1, "Despacito", 1, "https://www.billboard.com/images/pref_images/q61808osztw.jpg", "luis fonsi");
        b[1] = b2;
        b[2] = b3;
        showAbout(b[0], b[1]);      // 2개 객체
        showAbout(b);               // 배열 -> 3개 객체

        /* 빌보드 차트를 리스트에 저장하고 출력하기 */
        System.out.println("=================빌보드 차트를 리스트에 저장하고 출력하기=================");
        ArrayList<Billboard> bills = new ArrayList<>();
        bills.add(new Billboard(1, "Despacito", 1, "https://www.billboard.com/images/pref_images/q61808osztw.jpg", "luis fonsi"));
        bills.add(new Billboard(2, "That's What I Like", 2, "https://www.billboard.com/images/pref_images/q89725qvpol.jpg", "bruno mars"));
        bills.add(new Billboard(3, "I'm The One", 3, "https://www.billboard.com/images/pref_images/q64532pl64x.jpg", "dj khaled"));
        System.out.println("size : " + bills.size());       // 3
        showAbout(bills.get(0));                // 0번째 Billboard 객체
        bills.remove(1);                  // 1번째 삭제
        System.out.println("size : " + bills.size());       // 2
        System.out.println("---------------------");
        for (Billboard bb : bills) {
            showAbout(bb);
        }
    }

    private static void showAbout(Billboard bb) {   // 객체를 전달하여 출력
        String sf = String.format("%d, %s, %d, %s, %s",
                bb.getRank(), bb.getSong(), bb.getLastweek(), bb.getImagesrc(), bb.getArtist());
        System.out.println(sf);
    }

    private static void showAbout(Billboard ... b) {    // 객체를 전달하여 출력
        System.out.println("2===============================>");
        for (Billboard bill : b) {
            showAbout(bill);    // 1
        }
        System.out.println("<===============================2");
    }
}
