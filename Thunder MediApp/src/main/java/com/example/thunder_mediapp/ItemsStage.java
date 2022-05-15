package com.example.thunder_mediapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ItemsStage {
    @FXML
    private Label medicineName;

    @FXML
    private Label totalAmount;

    @FXML
    private TextField amountText;

    @FXML
    void minus(ActionEvent event) {

        int num = Integer.parseInt(amountText.getText())  ;
        totalAmount.setText(String.valueOf(Integer.parseInt(totalAmount.getText())/num));
        if (num == 1) num =  1 ;
        else num-- ;
        amountText.setText(String.valueOf(num));


    }

    @FXML
    void plus(ActionEvent event) {
        int num = Integer.parseInt(amountText.getText()) +1 ;
        amountText.setText(String.valueOf(num));

        totalAmount.setText(String.valueOf(Integer.parseInt(totalAmount.getText()) * num));
    }

    public void setLabels (String name, int price) {
        medicineName.setText(name);
        totalAmount.setText(String.valueOf(price));
    }
}
