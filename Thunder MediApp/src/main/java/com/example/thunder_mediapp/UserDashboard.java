package com.example.thunder_mediapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserDashboard implements Initializable {

    @FXML
    public AnchorPane showedPane;

    @FXML
    public Label nameLabel;

    @FXML
    public Label adressLabel;

    @FXML
    public ListView<String> tableView;


    @FXML
    public Label unameLabel;

    @FXML
    public Label passLabel;

    @FXML
    public Label areaLabel;

    private boolean pressed = false ;

    public static String passID ;

    public ObservableList<String> lis = FXCollections.observableArrayList() ;
    @FXML
    void orderPressed(ActionEvent event) throws Exception {
        FXMLLoader fx = new FXMLLoader(getClass().getResource("explore-medicine.fxml"))  ;
        Parent pa = fx.load() ;

        ExploreMedicine ex = fx.getController() ;
        ex.setLabels(passID);
        showedPane.getChildren().setAll(pa) ;
    }

    @FXML
    void showPasss(ActionEvent event) {
        try {
            String[] ar = Database_Management.fletchPassFromDB(passID) ;
            if (!pressed) {
                pressed = true ;
                passLabel.setText(ar[1]);
                ((Button)event.getSource()).setText("HIDE");
            } else {
                pressed = false ;
                passLabel.setText("*********");
                ((Button)event.getSource()).setText("SHOW");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {



    }
    public void setAll (String id) throws Exception {
        UserInfo in = Database_Management.fletchDataFromDB(id) ;
        String name = in.getfName() + " " + in.getlName();
        nameLabel.setText(name);
        adressLabel.setText(in.getAddress());
        passLabel.setText("***********");
        areaLabel.setText(in.getUser_area());
        unameLabel.setText(in.getUsername());
        //lis = Database_Management.getShopNearMe(areaLabel.getText()) ;
        tableView.setItems(lis);
    }
}
