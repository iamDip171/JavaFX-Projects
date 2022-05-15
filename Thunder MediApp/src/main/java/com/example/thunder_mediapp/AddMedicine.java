package com.example.thunder_mediapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddMedicine implements Initializable {

    @FXML
    private AnchorPane explorePane;

    @FXML
    private Label nameLabel;

    @FXML
    private Label adressLabel;

    public String uname ;

    @FXML
    void addCaps(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("medicine-add.fxml")) ;
            Parent root = loader.load() ;
            MedicineAdd md = loader.getController() ;
            md.cats = "capsules" ;
            Stage st = new Stage() ;
            st.setScene(new Scene(root));
            st.show();
        }catch (Exception e) {}
    }

    @FXML
    void addDrops(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("medicine-add.fxml")) ;
            Parent root = loader.load() ;
            MedicineAdd md = loader.getController() ;
            md.cats = "drops" ;
            Stage st = new Stage() ;
            st.setScene(new Scene(root));
            st.show();
        }catch (Exception e) {}
    }

    @FXML
    void addInhalers(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("medicine-add.fxml")) ;
            Parent root = loader.load() ;
            MedicineAdd md = loader.getController() ;
            md.cats = "inhalers" ;
            Stage st = new Stage() ;
            st.setScene(new Scene(root));
            st.show();
        }catch (Exception e) {}
    }

    @FXML
    void addInjection(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("medicine-add.fxml")) ;
            Parent root = loader.load() ;
            MedicineAdd md = loader.getController() ;
            md.cats = "injections" ;
            Stage st = new Stage() ;
            st.setScene(new Scene(root));
            st.show();
        }catch (Exception e) {}
    }

    @FXML
    void addLiquids(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("medicine-add.fxml")) ;
            Parent root = loader.load() ;
            MedicineAdd md = loader.getController() ;
            md.cats = "liquids" ;
            Stage st = new Stage() ;
            st.setScene(new Scene(root));
            st.show();
        }catch (Exception e) {}
    }

    @FXML
    void addTablets(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("medicine-add.fxml")) ;
            Parent root = loader.load() ;
            MedicineAdd md = loader.getController() ;
            md.cats = "tablets" ;
            Stage st = new Stage() ;
            st.setScene(new Scene(root));
            st.show();
        }catch (Exception e) {}
    }

    @FXML
    void back_dashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admin-dashboard.fxml")) ;
            Parent root = loader.load() ;

            AdminDashboard dash = loader.getController() ;
            dash.setAllLabels(uname);
            explorePane.getChildren().setAll(root) ;
        }catch (Exception e) {}
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(uname);
    }
}
