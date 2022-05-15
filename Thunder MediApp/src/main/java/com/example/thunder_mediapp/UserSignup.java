package com.example.thunder_mediapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserSignup implements Initializable {
    @FXML
    private AnchorPane userPane;

    @FXML
    private TextField user_fName;

    @FXML
    private TextField user_lName;


    @FXML
    private TextField userPass;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField userAddress;

    @FXML
    public TextField username ;

    @FXML
    void signUPpressed(ActionEvent event) {
        String fname = user_fName.getText() ;
        String lName = user_lName.getText() ;
        String userpass = userPass.getText() ;
        String address = userAddress.getText() ;
        String uname = username.getText() ;
        String area = comboBox.getSelectionModel().getSelectedItem() ;

        try {
            if (Database_Management.checkOnServer(uname)) {
                Database_Management.insertIntoDB(new UserInfo(fname, lName, userpass, address, uname, area));
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.NONE, "Duplicate username found", ButtonType.OK) ;
                //alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("WARNING!");

                alert.show() ;

            }

            Database_Management.createTable(uname);

        } catch (Exception e) {
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("Banani", "Banasree", "Rampura", "Uttara") ;
        comboBox.setItems(list);
    }
}
