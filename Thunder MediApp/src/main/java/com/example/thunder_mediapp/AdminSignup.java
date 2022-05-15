package com.example.thunder_mediapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminSignup implements Initializable {

    @FXML
    private AnchorPane adminPane;
    @FXML
    private TextField nidLabel;

    @FXML
    private TextField emailLabel;

    @FXML
    private TextField licenseLabel;


    @FXML
    private TextField admin_fName;

    @FXML
    private TextField admin_lName;

    @FXML
    private TextField adminPass;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField adminAddress;

    @FXML
    private TextField username;
    @FXML
    private TextField medShop;

    @FXML
    void doneSignup(ActionEvent event) {

        System.out.println("DONE");
        try {
            if (Database_Management.checkAdminOnServer(username.getText())) {
                Database_Management.insertAdminIntoDB(new AdminInfo(admin_fName.getText(), admin_lName.getText(), adminPass.getText(), adminAddress.getText(), username.getText(), comboBox.getSelectionModel().getSelectedItem(), medShop.getText(), nidLabel.getText(), licenseLabel.getText(), emailLabel.getText()));
                ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("Banani", "Malibag", "Bashundhara", "Lalbagh", "Mirpur", "Dhanmondi", "Banasree") ;
        comboBox.setItems(list);
    }
}
