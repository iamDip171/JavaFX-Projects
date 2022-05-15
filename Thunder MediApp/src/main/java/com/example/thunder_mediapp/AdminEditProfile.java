package com.example.thunder_mediapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AdminEditProfile {

    @FXML
    private AnchorPane showedPane;

    @FXML
    private Label nameLabel;

    @FXML
    private Label adressLabel;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField password;

    @FXML
    private TextField address;

    @FXML
    private TextField username;

    @FXML
    private TextField shopName;
    @FXML
    void savePressed(ActionEvent event) {
        String fname, lname, pass, add, uname, sh_name ;

        try {
             if (firstName.getText().equals("")) fname = firstName.getPromptText() ;
             else fname = firstName.getText() ;

             if (lastName.getText().equals("")) lname = lastName.getPromptText() ;
             else lname = lastName.getText() ;

             if (password.getText().equals("")) pass = password.getPromptText() ;
             else pass = password.getText() ;

             if (address.getText().equals("")) add = address.getPromptText() ;
             else add = address.getText() ;

             if (username.getText().equals("")) uname = username.getPromptText() ;
             else uname = username.getText() ;

             if (shopName.getText().equals("")) sh_name = shopName.getPromptText() ;
             else sh_name = shopName.getText() ;

            System.out.println(uname);
            Database_Management.UpdateAdminDB(uname, new AdminInfo(fname, lname, pass, add, uname, sh_name));

        }catch (Exception e) {}
    }

    @FXML
    void baktoDash (ActionEvent event) {
        try {
            AnchorPane pane = (AnchorPane) showedPane.getParent() ;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admin-dashboard.fxml")) ;
            Parent root = loader.load() ;

            AdminDashboard dash = loader.getController() ;
            dash.setAllLabels(username.getPromptText());

            pane.getChildren().setAll(root) ;
        }catch (Exception e) {}
    }

    public void setLabels (String name ) {
        try {
            AdminInfo info = Database_Management.fletchAdminDataFromDB(name) ;

            nameLabel.setText(info.getfName() + " " + info.getlName());
            adressLabel.setText(info.getAddress());
            firstName.setPromptText(info.getfName());
            lastName.setPromptText(info.getlName());
            password.setPromptText(info.getPassword());
            address.setPromptText(info.getAddress());
            username.setPromptText(info.getUsername());
            shopName.setPromptText(info.getShop_name());

        }catch (Exception e) {}
    }

}
