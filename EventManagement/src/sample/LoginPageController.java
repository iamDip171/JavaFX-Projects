package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {

    @FXML
    public TextField loginTxt ;

    @FXML
    public Label errorLabel ;


    public static int success = 0 ;
    public static String name = null ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);
    }

    public void onGetMeinAction(ActionEvent event) throws Exception {
        name = loginTxt.getText() ;
        String str = "Database//" +loginTxt.getText() ;
        File file = new File(str) ;
        if (file.isDirectory() && !name.isEmpty())
        {
            errorLabel.setVisible(false);
            success = 1 ;
            ((Stage)(((Button) event.getSource()).getScene().getWindow())).close();
        }else{
            errorLabel.setVisible(true);
            success = 0 ;
        }

        loginTxt.setText(null);
    }

    public void onCloseBtn(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow() ;
        s.close();
    }
}
