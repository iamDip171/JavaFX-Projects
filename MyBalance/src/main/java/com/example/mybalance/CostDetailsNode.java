package com.example.mybalance;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CostDetailsNode {

    @FXML
    private Label amountLabel;

    @FXML
    private Label nameLabel;


    public void setAmountLabel(String msg) {
        System.out.println("Baal: " +msg);
        amountLabel.setText(msg);
    }

    public void setNameLabel(String msg) {
        System.out.println("Saal: "+msg);
        nameLabel.setText(msg);
    }
}
