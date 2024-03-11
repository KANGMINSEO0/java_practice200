package com.ohgiraffers.practice03;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BillboardImageTest2 extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    ImageFXListRequest request = new ImageFXListRequest();
    Application2 rfw = new Application2();
    @Override
    public void start(Stage stage) throws Exception {
        String a = "https://www.billboard.com/charts/hot-100/";
        String rs = rfw.getTimeDate(a);
        // rs = rfw.toWantedDay(rs, 1);     // 1주 전
        System.out.println(rs + "------------------Billboard Chart !!!");
        rfw.getAllHtml(a);
        String str = "<article class=\"chart-row";
        rfw.getBillboardData(str);
        ArrayList<Billboard> bills = rfw.getBillboards();
        // 계속 읽는 것을 방지
        request.getAllImages(bills);    // image를 맵에 저장
        VBox root = new VBox(10);   // HBox 10개 저장을 위해
        // 인터넷
        int col = 10;
        int row = bills.size()/col;
        for (int i = 0; i < row; i++) {
            HBox hbox = new HBox(10);
            hbox.setPadding(new Insets(5));
            hbox.setAlignment(Pos.CENTER);
            for (int j = 0; j < col; j++) {
                Billboard b = bills.get(i * col + j);
                ImageView imageView = new ImageView(request.loadImage(b.getImagesrc()));
                imageView.setFitWidth(50);
                imageView.setFitHeight(50);
                imageView.setOnMouseClicked(ee->{
                    System.out.println(b.getImagesrc());
                });
                hbox.getChildren().add(imageView);
            }
            root.getChildren().add(hbox);       // 아래로 HBox를 붙인다.
        }
        Stage primaryStage = null;
        primaryStage.setScene(new Scene(root, 60-col, 70-row));
        primaryStage.setTitle("Billboard Image");
        primaryStage.show();
    }
}
