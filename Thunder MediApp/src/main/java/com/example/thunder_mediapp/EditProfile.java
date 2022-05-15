package com.example.thunder_mediapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProfile implements Initializable {

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
    private TextField phNumber;

    public String name ;

    UserInfo info ;
    @FXML
    void savePressed(ActionEvent event) {
        String f_name, l_name, pass, add, ph_num ;
        try {
            if (firstName.getText().equals(""))
                f_name = firstName.getPromptText() ;
            else
                f_name = firstName.getText() ;

            if (lastName.getText().equals(""))
                l_name = lastName.getPromptText() ;
            else
                l_name = lastName.getText() ;

            if (password.getText().equals(""))
                pass = password.getPromptText() ;
            else
                pass = password.getText() ;

            if(address.getText().equals(""))
                add = address.getPromptText() ;
            else
                add = address.getText() ;

            if (phNumber.getText().equals(""))
                ph_num = phNumber.getPromptText() ;
            else
                ph_num = phNumber.getText() ;


            UserInfo info = new UserInfo(f_name, l_name, pass, add, ph_num) ;
            Database_Management.UpdateUserDB(name, info);
        }catch (Exception e) {}
    }

    void setAllLabels (String id ) {

        info = Database_Management.fletchDataFromDB(id) ;
        String name = info.getfName() + " " + info.getlName() ;
        nameLabel.setText(name);
        adressLabel.setText(info.getAddress());
        firstName.setPromptText(info.getfName());
        lastName.setPromptText(info.getlName());
        password.setPromptText(info.getPassword());
        address.setPromptText(info.getAddress());
        phNumber.setPromptText(info.getUsername());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
