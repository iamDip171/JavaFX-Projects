package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.* ;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpPageController implements Initializable {

    @FXML
    TextField nameTxt ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onSignupAction(ActionEvent event){
        String str = "Database//" + nameTxt.getText();
        //System.out.println(str);
        BufferedWriter classRoutine, examRoutine, others ;
        try {
            File file = new File(str) ;
            file.mkdir() ;
            classRoutine = new BufferedWriter(new FileWriter("Database//"+nameTxt.getText()+"//Class.txt")) ;
            examRoutine = new BufferedWriter(new FileWriter("Database//"+nameTxt.getText()+"//Exam.txt")) ;
            others = new BufferedWriter(new FileWriter("Database//"+nameTxt.getText()+"//Others.txt")) ;
            classRoutine.close(); examRoutine.close(); others.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }

    public void onExitBtn(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow() ;
        s.close();
    }
}
