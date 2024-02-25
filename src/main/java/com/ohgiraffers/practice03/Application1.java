package com.ohgiraffers.practice03;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

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

        /* 빌보드 차트 정보를 파일로 저장하기 */
        System.out.println("=====빌보드 차트 정보를 파일로 저장하기=====");
        ArrayList<Billboard> bblist = new ArrayList<>();
        bblist.add(b1);
        bblist.add(b2);
        bblist.add(b3);
        File f = new File("billboard");
        if (!f.exists()) {f.mkdirs();}

        try(PrintWriter pw = new PrintWriter(new FileWriter("billboard\\bill.txt", false), true)) {
            for (Billboard bb : bblist) {
                    pw.println(bb);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        /* 저장한 빌보드 차트 파일 정보를 읽어들이기 */
        System.out.println("=====저장한 빌보드 차트 파일 정보를 읽어들이기=====");
        try (BufferedReader br = new BufferedReader(new FileReader("billboard\\bill.txt"))){
            String msg = "";
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        /* 빌보드 차트 파일을 저장한 디렉토리 찾기 */
        System.out.println("=====빌보드 차트 파일을 저장한 디렉토리 찾기=====");
        File[] fd = f.listFiles();      // 바로 아래 파일들(자식 파일)
        for (File ff : fd) {
            String fname = ff.getName();    // 파일명
            String post = fname.substring(fname.lastIndexOf(".") + 1);
            System.out.println(fname + " " + post);     // 이름, 확장자
            System.out.println(ff.getAbsolutePath());   // 전체 경로
            System.out.println(new Date(ff.lastModified()));    // 수정일
            try (BufferedReader br = new BufferedReader(new FileReader(ff.getAbsolutePath()))){
                String msg = "";
                while ((msg = br.readLine()) != null) {
                    System.out.println(msg);
                }
            }  catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("-----------------------------------");

            /* 빌보드 차트 웹사이트에서 정보 읽어오기 */
            System.out.println("=====빌보드 차트 웹사이트에서 정보 읽어오기=====");
            String newUrls = "https://www.billboard.com/charts/hot-100/";
            URL url = null;
            try {
                url = new URL(newUrls);     // 주소 찾기
                // 주소지에 빨대 꽂기
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(url.openStream(), "euc-kr"), 8);
                String line = null;
                while ((line = reader.readLine()) != null) {    // 한 줄씩 읽어서
                    if (!line.trim().equals("")) {      // 공백이 아니면 출력한다.
                        System.out.println(line.trim());
                    }
                }
            } catch (Exception e) {
                System.out.println("Billboard Parsing error !!!");
            }

        }
        /* 빌보드 차트 웹사이트에서 정보를 읽어 리스트에 저장하기 */
        System.out.println("=====빌보드 차트 웹사이트에서 정보를 읽어 리스트에 저장하기=====");
        ArrayList<String> htmls = new ArrayList<String>();
        String newUrls = "https://www.billboard.com/charts/hot-100/";
        URL url = null;
        try {
            url = new URL(newUrls);     // 주소 찾기
            // 주소지에 빨대 꽂기
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream(), "euc-kr"),8);
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().equals("")) {
                    htmls.add(line.trim());
                }
            }
        }  catch (Exception e) {
            System.out.println("Billboard Passing error !!!");
        }
        // ArrayList에 저장된 문자열 출력
        for (String str : htmls) {
            System.out.println(str);
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
