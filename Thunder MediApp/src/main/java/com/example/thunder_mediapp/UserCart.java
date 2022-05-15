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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserCart implements Initializable {

    @FXML
    private AnchorPane showedPane;

    @FXML
    private Label nameLabel;

    @FXML
    private Label adressLabel;

    @FXML
    public VBox vboxPane;

    @FXML
    public Label totalPrice;


    public static String cart_name ;

    public ArrayList<Node> list = new ArrayList<>() ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int sum = 0 ;
        System.out.println("Cart: " + cart_name);
        try {
            ArrayList<UserOrder> o_list = Database_Management.fletchDataFromOrders(cart_name) ;
            for (int i=0; i<o_list.size(); i++) {
                sum += o_list.get(i).getPrice() ;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("items-stage.fxml"));
                Parent root = loader.load();
                ItemsStage stage = loader.getController();
                stage.setLabels(o_list.get(i).getName(),o_list.get(i).getPrice());
                list.add(root) ;
            }

            vboxPane.getChildren().setAll(list) ;
        }catch (Exception e) {}

        totalPrice.setText(String.valueOf(sum));

    }


    public void setLabels (String id) {
        UserInfo info =  Database_Management.fletchDataFromDB(id) ;
        String name = info.getfName() + " " + info.getlName() ;
        nameLabel.setText(name);
        adressLabel.setText(info.getAddress());
    }
}
