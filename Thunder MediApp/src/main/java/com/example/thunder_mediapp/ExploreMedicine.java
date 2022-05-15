package com.example.thunder_mediapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ExploreMedicine {

    @FXML
    private AnchorPane explorePane;

    @FXML
    private Label nameLabel;

    @FXML
    private Label adressLabel;

    @FXML
    void BrowseCaps(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("capsule-stage.fxml")) ;
        Stage st = new Stage() ;
        Scene sc = new Scene(root) ;
        st.setScene(sc);
        st.showAndWait();
    }

    @FXML
    void BrowseDrops(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Drops-stage.fxml")) ;
        Stage st = new Stage() ;
        Scene sc = new Scene(root) ;
        st.setScene(sc);
        st.showAndWait();
    }

    @FXML
    void BrowseInj(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("injection-stage.fxml")) ;
        Stage st = new Stage() ;
        Scene sc = new Scene(root) ;
        st.setScene(sc);
        st.showAndWait();
    }

    @FXML
    void BrowseLiqs(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("liquids-stage.fxml")) ;
        Stage st = new Stage() ;
        Scene sc = new Scene(root) ;
        st.setScene(sc);
        st.showAndWait();
    }

    @FXML
    void BrowseTabs(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("tablet-stage.fxml")) ;
        Stage st = new Stage() ;
        Scene sc = new Scene(root) ;
        st.setScene(sc);
        st.showAndWait();
    }

    @FXML
    void browseInhalers(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("inhalers-stage.fxml")) ;
        Stage st = new Stage() ;
        Scene sc = new Scene(root) ;
        st.setScene(sc);
        st.showAndWait();

    }

    public void setLabels (String id) {
        UserInfo info =  Database_Management.fletchDataFromDB(id) ;
        String name = info.getfName() + " " + info.getlName() ;
        nameLabel.setText(name);
        adressLabel.setText(info.getAddress());
    }

}
