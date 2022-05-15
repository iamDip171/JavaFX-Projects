package com.example.mybalance;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class DailyCostHistory {

    @FXML
    private VBox showVBOX;
    public static int count = 0 ;
    public void setShowVBOX (Node n) {
        System.out.println(count++);
        showVBOX.getChildren().add(n) ;

    }


}
