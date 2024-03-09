package com.ohgiraffers.practice03;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.event.ActionEvent;

public class BillboardfxController {
    @FXML
    private TableView<Billboard> billboardTableView;
    @FXML
    private TableColumn<Billboard, String> song;
    @FXML
    private TableColumn<Billboard, String> artist;
    @FXML
    private TableColumn<Billboard, String> lastweek;
    @FXML
    private TableColumn<Billboard, String> rank;
    @FXML
    private  TableColumn<Billboard, String> imagesrc;
//    @FXML
//    private WebView billwebview;
    @FXML
    private Button binAf;
    @FXML
    private Button btnBf;
    @FXML
    private Label lbbill;
    @FXML
    void onClikBrnBf(ActionEvent event) {}
    @FXML
    void onClikBtnAf(ActionEvent event) {}
    @FXML
    void initialize() {}

}
