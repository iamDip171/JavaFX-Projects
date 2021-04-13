package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class EventPageController extends LoginPageController implements Initializable {

    @FXML
    Label label ;

    @FXML
    AnchorPane viewPane ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText("Hello "+ name);
        try {
        Parent root = FXMLLoader.load(getClass().getResource("TodayFxml.fxml")) ;
        viewPane.getChildren().setAll(root) ;
        } catch (Exception e) {}
    }

    public void onCRAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ClassRoutinefxml.fxml")) ;
        viewPane.getChildren().setAll(root) ;
    }

    public void onERAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ExamRoutinefxml.fxml")) ;
        viewPane.getChildren().setAll(root) ;
    }

    public void onOthersAction(ActionEvent event) throws Exception {
        Parent rooti = FXMLLoader.load(getClass().getResource("OtherClassFxml.fxml")) ;
        viewPane.getChildren().setAll(rooti) ;
    }

    public void onTodayAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TodayFxml.fxml")) ;
        viewPane.getChildren().setAll(root) ;
    }

    public void eventPageMin(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow() ;
        s.setIconified(true);
    }

    public void eventPageClose(ActionEvent actionEvent) {
        Stage s =(Stage) ((Node)actionEvent.getSource()).getScene().getWindow() ;
        s.close();
    }
}
