package com.ohgiraffers.practice04;

import com.ohgiraffers.practice03.ImageFXListRequest;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javax.swing.text.TableView;
import java.awt.event.ActionEvent;
import java.util.BitSet;

public class BillboardfxController {
//    @FXML
//    private TableView<Billboard> billbordTable;

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
//        getAllBillboard();
    }
}
