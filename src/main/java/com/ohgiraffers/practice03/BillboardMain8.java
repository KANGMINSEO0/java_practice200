package com.ohgiraffers.practice03;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class BillboardMain8 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("billboard\\2024-03-08.json"));
            StringBuffer sb = new StringBuffer();
            String msg = "";
            while ((msg = br.readLine()) != null) {
                sb.append(msg);
            }
            JSONObject billboards = new JSONObject(sb.toString());
            JSONArray bills = billboards.getJSONArray("billboard");
            for (int i = 0; i < bills.length(); i++) {
                System.out.println("--------------------");
                JSONObject bill = bills.getJSONObject(i);
                String rank = bill.getString("rank");
                String song = bill.getString("song");
                String lastweek = bill.getString("lastweek");
                String imagesrc = bill.getString("imagesrc");
                String artist = bill.getString("artist");
                String sf = String.format("%s, %s, %s, %s, %s",
                        rank, song, lastweek, imagesrc, artist);
                System.out.println(sf);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
