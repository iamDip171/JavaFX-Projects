package com.example.thunder_mediapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MedicineAdd implements Initializable {

    @FXML
    private TextField medNAme;

    @FXML
    private TextField strength;

    @FXML
    private TextField ingredients;

    @FXML
    private TextField comName;

    @FXML
    private TextField price;

    public String cats ;

    @FXML
    void addToData(ActionEvent event) throws Exception{
        String m_Name = medNAme.getText() ;
        String stregth = strength.getText() ;
        String ingredi = ingredients.getText() ;
        String comN = comName.getText() ;
        int pr = Integer.parseInt(price.getText()) ;
        Database_Management.insertMedicinetoDB(new Medicine(m_Name, stregth, ingredi, comN, pr),cats);

        medNAme.setText(""); strength.setText(""); ingredients.setText(""); comName.setText(""); price.setText("");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
