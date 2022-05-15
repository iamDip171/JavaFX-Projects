package com.example.mybalance;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CostDetails {

    @FXML
    private VBox costVbox;

    @FXML
    private Label dateLabel;

    public String amountLabel, nameLabel ;

    public void setVBOXpane (Node n) {

        try {
            FXMLLoader l = new FXMLLoader(getClass().getResource("cost-details-node.fxml")) ;
            Parent p = l.load() ;
            CostDetailsNode cn = l.getController() ;
            cn.setAmountLabel(amountLabel);
            cn.setNameLabel(nameLabel);
            costVbox.getChildren().add(p) ;
        }catch (Exception e) {}

    }

}
