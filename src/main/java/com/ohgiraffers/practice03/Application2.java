package com.ohgiraffers.practice03;

import com.ohgiraffers.practice02.RestDay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Application2 {

    public static void main(String[] args) {

        /* 이번 주 빌보드 차트 기준 날짜 찾기 */
        System.out.println("=====이번 주 빌보드 차트 기준 날짜 찾기=====");
        String newUrls = "https://www.billboard.com/charts/hot-100/";
        String s = "";
        URL url = null;
        try {
            url = new URL(newUrls);     // 주소 찾기
            // 주소지에 빨대 꽂기
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream(), "euc-kr"), 8);
            String line = "";
            while ((line = reader.readLine()) != null) {    // 한 줄씩 읽어들인다.
                if (!line.trim().equals("")) {   // 문자열이 있다면
                    // <time datetime = "2018-08-13"> August 13, 2018 </time>
                    if (line.trim().contains("<time datetime=")) {  // 찾기
                        s = line.trim();
                        s = s.substring(0, s.indexOf(">") - 1);     // <time datetime = "2018-08-13
                        s = s.substring(s.indexOf("\"") + 1).trim();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Billboard Passing error !!!");
        }
        System.out.println("이번 빌보드 차트 날짜 : " + s);

        /* 찾으려는 날짜의 빌보드 차트를 리스트에 저장하기 */
        System.out.println("=====찾으려는 날짜의 빌보드 차트를 리스트에 저장하기=====");
        Application2 rfw = new Application2();
        String a = "https://www.billboard.com/charts/hot-100/";
        String rs = rfw.getTimeDate(a);
        System.out.println("이번 주" + rs);
//        rs = RestDay.toWantedDay(rs, 1);     // 1주 전  : s062 RestDay
        rfw.getAllHtml(a + rs);
        rfw.printHtml();

        /* 이번 주 빌보드 차트를 파싱하여 객체로 저장하기*/
//        rs = RestDay.toWantedDay(rs, 1); // 1주 전
        System.out.println(rs);
        rfw.getAllHtml(a + rs);
        String str = "<article class = \"chart-row";
        rfw.getBillboardData(str);
        rfw.printBillboard();

    }

    ArrayList<String> htmls = new ArrayList<String>();
    boolean isConnection = false;

    public Application2() {
        htmls.clear();
        billboards.clear();
    }

    public void getAllHtml(String newUrls) {
        htmls.clear();
        URL url = null;
        try {
            url = new URL(newUrls);     // 주소 찾기
            // 주소지에 빨대 꽂기
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream(), "euc-kr"), 8);
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (!line.trim().equals("")) {
                    htmls.add(line.trim());
                }
            }
            isConnection = true;
        } catch (IOException e) {
            isConnection = false;
            System.out.println("Billboard Passing error !!!");
        }
    }

    public void printHtml() {
        for (String ss : htmls) {
            System.out.println(ss);
        }
    }

    public String getTimeDate(String newUrls) {
        String s = "";
        URL url = null;
        try {
            url = new URL(newUrls);         //  주소 찾기
            // 주소지에 빨대 꽂기
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream(), "euc-kr"), 8);
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (!line.trim().equals("")) {
                    if (line.trim().contains("<time datetime=")) {
                        // <time datetime="2016-08-13">August 13, 2016</time>
                        s = line.trim();
                        s = s.substring(0, s.indexOf(">") - 1); // <time datetime = "2016-08-13
                        s = s.substring(s.indexOf("\"") + 1);   // 2016-08-13
                        break;
                    }
                }
            }
            isConnection = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    ArrayList<Billboard> billboards = new ArrayList<Billboard>();

    public ArrayList<Billboard> getBillboards() {
        return billboards;
    }

    public synchronized void getBillboardData(String msg) {
        billboards.clear();
        for (int i = 0; i < htmls.size(); i++) {
            String ss = htmls.get(i);
            if (ss.contains(msg)) {
                String rank = ss.substring(ss.indexOf("chart-row--") + "chart-row--".length());
                rank = rank.substring(0, rank.indexOf("js") - 1).trim();
                String song = ss.substring(ss.indexOf("Song Hover-") + "Song Hover-".length());
                song = song.substring(0, song.indexOf("\"")).trim();
                int j = 1;
                String imageurl = htmls.get(i + j);
                while (true) {
                    if (imageurl.contains("images/pref_images")) {
                        break;
                    } else {
                        j++;
                        imageurl = htmls.get(i + j);
                    }
                }

                imageurl = imageurl.substring(imageurl.indexOf("https://"));
                imageurl = imageurl.substring(0, imageurl.indexOf(".jpg") + ".jpg".length());
                int k = 1;
                String artisturl = htmls.get(i + j + k);
                while (true) {
                    if (artisturl.contains("chart-row__artist")) {
                        break;
                    } else {
                        j++;
                        artisturl = htmls.get(i + j + k);
                    }
                }
                artisturl = artisturl.substring(artisturl.indexOf("https://"));
                artisturl = artisturl.substring(0, artisturl.lastIndexOf("/") + 1);
                String artist = artisturl.substring(0, artisturl.indexOf(".jpg") + ".jpg".length());
                artist = toArtis(artist);
                int m = 1;
                String lastweek = htmls.get(i + j + k + m);
                while (true) {
                    if (lastweek.contains("chart-row__last-week")) {
                        break;
                    } else {
                        j++;
                        lastweek = htmls.get(i + j + k + m);
                    }
                }
                int n = 1;
                lastweek = htmls.get(i + j + k + m + n);
                while (true) {
                    if (lastweek.contains("chart-row__value")) {
                        break;
                    } else {
                        j++;
                        lastweek = htmls.get(i + j + k + m + n);
                    }
                }
                lastweek = lastweek.substring(lastweek.indexOf(">") + 1);
                lastweek = lastweek.substring(0, lastweek.indexOf("<")).trim();
                // 빌보드 객체에 정보를 저장한다.
                    Billboard board = new Billboard(
                            toInt(rank), replace(song),
                            toInt(__toStr(lastweek)),
                            imageurl, artisturl, artist);
                    billboards.add(board);
            }
        }
    }

    public void printBillboard() {
        for (Billboard dto : billboards) {
            System.out.println(dto);
        }
    }
    public String replace(String msg) {
        String ss = msg;
        ss = ss.replaceAll("&#039;", "");
        ss = ss.replaceAll("&amp;", "&");
        ss = ss.replaceAll("&quot;", "\"");
        return ss.trim();
    }
    public String __toStr(String lastweek) {
        return lastweek.contains("--")? 101 + "":lastweek;
    }
    private int toInt(String msg) {
        return Integer.parseInt(msg == null ? "-1":msg.trim());
    }
    public String toArtis(String msg) {
        return msg.replaceAll("-", " ");
    }
}
