package com.ohgiraffers.practice03;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class BillboardConvert {
    public static BillboardProperty toBill(Billboard b) {
        BillboardProperty bp = new BillboardProperty();
        bp.setRank(b.getRank());
        bp.setSong(b.getSong());
        bp.setArtist(b.getArtist());
        bp.setImagesrc(b.getImagesrc());
        bp.setLastweek(b.getLastweek());
        return bp;
    }
    public static ArrayList<BillboardProperty> toBill(ArrayList<Billboard> blist) {
        ArrayList<BillboardProperty> bplist = new ArrayList<>();
        for (Billboard b : blist) {
            bplist.add(toBill(b));
        }
        return bplist;
    }
    public static ObservableList<BillboardProperty> toBillboard(ArrayList<BillboardProperty> alists) {
        ObservableList<BillboardProperty> bList = FXCollections.observableArrayList(alists);
        return bList;
    }
    public static ObservableList<BillboardProperty> toObservBill(ArrayList<Billboard> alists) {
        return toBillboard(toBill(alists));
    }

    public static void main(String[] args) {
        Application2 rfw = new Application2();
        ImageFXListRequest request = new ImageFXListRequest();
        String a = "https://www.billboard.com/charts/hot-100/";
        String rs = rfw.getTimeDate(a);
//        rs = rfw.toWantedDay(rs, 1);
        System.out.println(rs + "---------Billboard Chart !!!");
        rfw.getAllHtml((a + rs));
        String str = "<article class=\"chart-row";
        rfw.getBillboardData(str);
        ArrayList<Billboard> bills = rfw.getBillboards();

        request.getAllImages(bills);    // image를 맵에 저장
        ObservableList<BillboardProperty> obsbills = BillboardConvert.toObservBill(bills);
        for (BillboardProperty bp : obsbills) {
            System.out.println(bp);
        }
    }
}
