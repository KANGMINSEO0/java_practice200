package com.ohgiraffers.practice04;

import javafx.scene.image.Image;

import java.util.*;

public class ImageFXListRequest {
    private Map<String, Image> images;
    public ImageFXListRequest() {
        images = Collections.synchronizedMap(new LinkedHashMap<String, Image>(10, 1.53f, true));
    }
    public synchronized Image loadImage(String imagesrc) {
        Image mimage = null;
        if (images.containsKey(imagesrc)) {
            mimage =images.get(imagesrc);
        } else {
            if (imagesrc != null && !imagesrc.contains("q_____")) {
                try {
                    mimage = new Image(imagesrc, 100, 100, true, true);
                } catch (Exception e) {
                    mimage = null;
                }
            }
        }
        return mimage == null ? new Image(getClass().getResourceAsStream("billboard.jpg")):mimage;
    }
    public synchronized void getAllImages(ArrayList<Billboard> bills) {
        images.clear();
        List<Billboard> newbills = Collections.synchronizedList(bills);
        for (Billboard bb : newbills) {
            new Thread(() -> {
                if (!images.containsKey(bb.getImagesrc())) {
                    images.put(bb.getImagesrc(), loadImage(bb.getImagesrc()));
                    System.out.println(bb.getImagesrc() + "\t\t\t---Map에 Image 저장---->>>>>>");
                }
            }).start();
        }
    }
    public synchronized void printImage() {
        System.out.println(images.size());
        Iterator<String> imagekeys = images.keySet().iterator();
        while (imagekeys.hasNext()) {
            String key = imagekeys.next();
            // Image val = images.get(key);
            System.out.printf("key=%s\n", key);    // 키만 출력
        }
    }

    public static void main(String[] args) {
        ImageFXListRequest request = new ImageFXListRequest();
        RequestFromBillboardHot rfw = new RequestFromBillboardHot();
        String a = "https://www.billboard.com/charts/hot-100/";
        String rs = rfw.getTimeDate(a);
        // rs = rfw.toWantedDay(rs, 1); // 1주 전
        System.out.println(rs + "--------------Billboard Chart !!!");
        rfw.getAllHtml(a);
        String str = "<article class =\"chart-row";
        rfw.getBillboardData(str);
        ArrayList<Billboard> bills = rfw.getBillboards();
        request.getAllImages(bills);    // image를 맵에 저장
        request.printImage();
    }
}