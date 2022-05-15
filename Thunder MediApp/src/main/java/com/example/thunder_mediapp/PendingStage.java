package com.example.thunder_mediapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PendingStage implements Initializable {

    @FXML
    private AnchorPane peen;
    @FXML
    private Label medicineName;

    @FXML
    private Label totalAmount;

    @FXML
    void deliver(ActionEvent event) {
        peen.setVisible(false);
        Database_Management.deleteOrdersFromDB(medicineName.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setLabels (String name, String total) throws Exception {
        medicineName.setText(name);
        totalAmount.setText(total);
    }
}
