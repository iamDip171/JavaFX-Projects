package com.example.thunder_mediapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends UserLogin implements Initializable {
    @FXML
    public AnchorPane mainPane;

    @FXML
    public AnchorPane paneMain = null ;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("user-login.fxml")) ;
            mainPane.getChildren().setAll(root) ;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}