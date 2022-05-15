package com.example.mybalance;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CostNode {

    @FXML
    private Label costCause;

    @FXML
    private Label costText;

    public void setCostCause (String cause) {
        costCause.setText(cause);
    }

    public void setCostText (String cost) {
        costText.setText(cost);
    }

}
