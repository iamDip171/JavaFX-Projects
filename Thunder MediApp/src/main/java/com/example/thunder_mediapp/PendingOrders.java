package com.example.thunder_mediapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PendingOrders implements Initializable {

    @FXML
    private AnchorPane showedPane;

    @FXML
    private Label nameLabel;

    @FXML
    private Label adressLabel;

    @FXML
    private VBox vboxPane;

    public static String Pen_name ;

    public ArrayList<Node> list = new ArrayList<>() ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ArrayList<String> l = Database_Management.getTablesFromOrders() ;

            for (int i=0; i<l.size(); i++) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("pending-stage.fxml"));
                Parent r = loader.load();
                PendingStage pg = loader.getController();
                int sum = Database_Management.getTotalAmount(l.get(i)) ;
                pg.setLabels(l.get(i),String.valueOf(sum) );
                if (sum !=0 )
                    list.add(r);
            }
            vboxPane.getChildren().setAll(list) ;
        }catch (Exception e) {}
    }

    @FXML
    void backToDash(ActionEvent event) {
        try {
            AnchorPane pane = (AnchorPane) showedPane.getParent() ;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admin-dashboard.fxml")) ;
            Parent p = loader.load() ;
            AdminDashboard d = loader.getController() ;
            d.setAllLabels(Pen_name);
            pane.getChildren().setAll(p) ;
        }catch (Exception e) {}
    }

    public void setLabels (String name, String add) throws Exception {
        nameLabel.setText(name);
        adressLabel.setText(add);
    }
}
