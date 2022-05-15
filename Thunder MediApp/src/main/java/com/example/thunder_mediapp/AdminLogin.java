package com.example.thunder_mediapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminLogin implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private AnchorPane adminLogin;

    @FXML
    private TextField adminName;

    @FXML
    private TextField adminPass;

    @FXML
    void adminLogin(ActionEvent event) {
        try {
            String st[] = Database_Management.fletchAdminPassFromDB(adminName.getText()) ;

            if (st[1].equals(adminPass.getText()) && !adminPass.getText().equals("") && !adminName.getText().equals("")) {
                AnchorPane pane = (AnchorPane) adminLogin.getParent().getParent().getParent();
                FXMLLoader loader  = new FXMLLoader (getClass().getResource("admin-dashboard.fxml")) ;
                Parent root = loader.load() ;

                AdminDashboard dash = loader.getController() ;
                dash.setAllLabels(adminName.getText());

                pane.getChildren().setAll(root) ;
            }


        }catch (Exception e) {}
    }

    @FXML
    void adminSignUP(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("admin-signup.fxml")) ;
            Stage st = new Stage() ;
            st.setScene(new Scene(root));
            st.show();

        }catch (Exception e) {}
    }
    @FXML
    void backBtn(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("user-login.fxml")) ;
        adminLogin.getChildren().setAll(root) ;
    }
}
