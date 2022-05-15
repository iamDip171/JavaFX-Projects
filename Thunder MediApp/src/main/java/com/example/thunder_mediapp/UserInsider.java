package com.example.thunder_mediapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserInsider implements Initializable {

    @FXML
    public AnchorPane userInsider;

    @FXML
    public AnchorPane showPane;

    public String id ;
    @FXML
    void cartPressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("user-cart.fxml")) ;
            Parent root =loader.load();

            UserCart cart = loader.getController() ;
            cart.setLabels(id);
            showPane.getChildren().setAll(root) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void dashBoardPressed(ActionEvent event) throws Exception {
        System.out.println(id);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("user-dashboard.fxml")) ;
        Parent root = loader.load() ;
        UserDashboard da = loader.getController() ;
        da.setAll(id);
        da.passID = id ;
        showPane.getChildren().setAll(root) ;
    }

    @FXML
    void editProfilePressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("edit-profile.fxml")) ;
            Parent root = loader.load() ;

            EditProfile ed = loader.getController() ;
            ed.name = id ;
            ed.setAllLabels(id);
            showPane.getChildren().setAll(root) ;
        }catch (Exception e) {}
    }

    @FXML
    void logoutPressed(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) showPane.getParent() ;
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml")) ;
        pane.getChildren().setAll(root) ;
    }

    @FXML
    void xplorePressed(ActionEvent event) throws Exception {
        FXMLLoader fx = new FXMLLoader(getClass().getResource("explore-medicine.fxml")) ;
        Parent t = fx.load() ;

        ExploreMedicine ex = fx.getController() ;
        ex.setLabels(id);
        showPane.getChildren().setAll(t) ;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {

    }


}
