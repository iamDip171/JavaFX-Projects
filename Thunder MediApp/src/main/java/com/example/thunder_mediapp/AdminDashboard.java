package com.example.thunder_mediapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboard {

    @FXML
    private AnchorPane showedPane;

    @FXML
    private Label nameLabel;

    @FXML
    private Label adressLabel;

    @FXML
    private Label unameLabel;

    @FXML
    private Label fullName;

    @FXML
    private Label areaLabel ;
    @FXML
    private Label emailLabel;

    @FXML
    private Label nidLabel;

    @FXML
    private Label licenseLabel;

    @FXML
    private Label passLabel;

    boolean pressed = false ;

    @FXML
    void addMedicine(ActionEvent event) {
        try {
            AnchorPane pane = (AnchorPane) showedPane.getParent() ;
            FXMLLoader lok = new FXMLLoader(getClass().getResource("add-medicine.fxml")) ;
            Parent root = lok.load() ;

            AddMedicine med = lok.getController() ;
            med.uname = unameLabel.getText() ;

            pane.getChildren().setAll(root) ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @FXML
    void editProfile(ActionEvent event) throws Exception{
        AnchorPane pane = (AnchorPane) showedPane.getParent() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin-edit-profile.fxml")) ;
        Parent root = loader.load() ;
        AdminEditProfile prf = loader.getController() ;
        prf.setLabels(unameLabel.getText());
        pane.getChildren().setAll(root) ;
    }

    @FXML
    void pendingOrders(ActionEvent event) {
        try {
            AnchorPane pane = (AnchorPane) showedPane.getParent() ;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pending-orders.fxml")) ;
            Parent p = loader.load() ;
            PendingOrders o = loader.getController() ;
            o.setLabels(nameLabel.getText(), adressLabel.getText());
            o.Pen_name = unameLabel.getText() ;
            pane.getChildren().setAll(p) ;
        }catch (Exception e) {}
    }

    @FXML
    void signOut(ActionEvent event) throws Exception{
        AnchorPane pane = (AnchorPane) showedPane.getParent() ;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml")) ;
        Parent root = loader.load() ;
        pane.getChildren().setAll(root) ;
    }

    public void setAllLabels (String uname) {
        try {
            AdminInfo info = Database_Management.fletchAdminDataFromDB(uname) ;
            nameLabel.setText(info.getShop_name());
            unameLabel.setText(info.getUsername());
            fullName.setText(info.getfName() + " " + info.getlName());
            areaLabel.setText(info.getShop_area());
            passLabel.setText("*********");
            adressLabel.setText(info.getAddress());
            nidLabel.setText(info.getNid_number());
            emailLabel.setText(info.getEmail());
            licenseLabel.setText(info.getLicense());

        }catch (Exception e) {}
    }

    @FXML
    public void showBtn (ActionEvent event) throws Exception{
        String ar[] = Database_Management.fletchAdminPassFromDB(unameLabel.getText()) ;
        if (!pressed) {
            pressed = true ;
            passLabel.setText(ar[1]);
            ((Button)event.getSource()).setText("HIDE");
        } else {
            pressed = false ;
            passLabel.setText("*********");
            ((Button)event.getSource()).setText("SHOW");
        }
    }
}
