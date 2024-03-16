package com.ohgiraffers.practice04;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class BillboardfxController {
    @FXML
    private TableView<BillboardProperty> billbordTable;

    @FXML
    private TableColumn<BillboardProperty, String> song;

    @FXML
    private TableColumn<BillboardProperty, String> artist;

    @FXML
    private TableColumn<BillboardProperty, Integer> lastweek;

    @FXML
    private TableColumn<BillboardProperty, Integer> rank;

    @FXML
    private TableColumn<BillboardProperty, String> imagesrc;

//    @FXML
//    private WebVuew billwebwiew;

    @FXML
    private Button btnAf;

    @FXML
    private Button btnBf;

    @FXML
    private Label lbbill;
    ImageFXListRequest request = new ImageFXListRequest();
    int count = 0;

    @FXML
    void onClickBtnBf(ActionEvent event) {
        count++;
        getAllBillboard();
    }
    @FXML
    void onClickBtnAf(ActionEvent event) {
        count = 0;
        getAllBillboard();
    }
    @FXML
    void initialize() {
        rank.setCellValueFactory(cellData -> cellData.getValue().rankProperty().asObject());
        artist.setCellValueFactory(cellData -> cellData.getValue().artistProperty());
        song.setCellValueFactory(cellData -> cellData.getValue().songProperty());
        imagesrc.setCellValueFactory(cellData -> cellData.getValue().imagesrcProperty());
        lastweek.setCellValueFactory(cellData -> cellData.getValue().lastweekProperty().asObject());
        rank.setStyle("-fx-alignment: CENTER");
        lastweek.setStyle("-fx-alignment: CENTER");
        imagesrc.setCellFactory(new Callback<TableColumn<BillboardProperty, String>, TableCell<BillboardProperty, String>>() {
            @Override
            public TableCell<BillboardProperty, String> call(TableColumn<BillboardProperty, String> param) {
                TableCell<BillboardProperty, String> cell = new TableCell<BillboardProperty, String>() {
                    final javafx.scene.image.ImageView imageview = new ImageView();
                    @Override
                    public void updateItem(String item, boolean empty) {
                        if (item != null) {
                            imageview.setFitHeight(100);
                            imageview.setImage(request.loadImage(item));
                            setGraphic(imageview);
                        }
                    }
                };
                return cell;
            }
        });
//        final WebEngin webEngine = billwebview.getEngine();
//        billboardTable.setOnMouseClicked(e -> {
//            if (billboardTable.getSelectionModel().getSelectedItem() != null) {
//                BillboardProperty billboard = (BillboardProperty)billboardTable.getSelectionModel().getSelectedItem();
//                webEngine.load(
//                        "https://www.youtube.com/results?search_query" + toP(billboard.getSong()));
//
//            }
//        }
//        );
        getAllBillboard();
    }
    public String toP(String msg) {
        String ss = msg;
        ss = ss.replaceAll(" ", "+");
        return ss.trim();
    }
    public void getAllBillboard() {
        RequestFromBillboardHot rfw = new RequestFromBillboardHot();
        String a = "https://www.billboard.com/charts/hot-100/";
        String rs = rfw.getTimeDate(a);
//        rs = rfw.toWantedDay(rs, count);
        System.out.println(rs + "------------Billboard Chart !!!");
        rfw.getAllHtml(a + rs);
        String str = "<article class = \"chart-row";
        rfw.getBillboardData(str);
        ArrayList<Billboard> bills = rfw.getBillboards();

        request.getAllImages(bills);
        ObservableList<BillboardProperty> obsBills = BillboardConvert.toObservBill(bills);
        populateEmployees(obsBills);
        lbbill.setText("Billboard Chat GOT 100" + rs);
    }
    public void populateEmployees(ObservableList<BillboardProperty> bills) {
        billbordTable.setItems(bills);
    }
}
