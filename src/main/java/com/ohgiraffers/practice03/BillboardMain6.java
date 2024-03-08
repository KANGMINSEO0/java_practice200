package com.ohgiraffers.practice03;

import com.ohgiraffers.practice02.RestDay;

public class BillboardMain6 {
    public static void main(String[] args) {
        Application2 rfw = new Application2();
        String a = "https://www.billboard.com/charts/hot-100/";
        String rs = rfw.getTimeDate(a);
        // rs = RestDay.toWantedDay(rs, 1);    // 하루전
        System.out.println(rs);
        rfw.getAllHtml(a+rs);
        String str = "<article class = \"chart-row";
        rfw.getBillboardData(str);

        BillboardPrint.printToCSV(rfw.getBillboards(), "billboard\\" + rs + ".CSV");
//        BillboardPrint.printToJSON(rfw.getBillboards(), "billboard\\2015-06-02.json");
        BillboardPrint.printToXML(rfw.getBillboards(), "billboard\\" + rs + ".xml");

    }
}
