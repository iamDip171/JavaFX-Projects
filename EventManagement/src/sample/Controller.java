package sample;

import javafx.animation.Animation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import javafx.scene.layout.Pane ;


import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller extends LoginPageController implements Initializable {

    @FXML
    AnchorPane mainPane ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void onSignupAction (ActionEvent event) throws Exception {
        Parent pane = FXMLLoader.load(getClass().getResource("SignUpPage.fxml")) ;
        Scene scene = new Scene(pane) ;

        Stage stage = new Stage() ;
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public void onLoginBtn (ActionEvent event) throws Exception {
        if (success == 0) {
            Parent pane = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
            Scene scene = new Scene(pane);

            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();

        }
        if (success == 1) {
            Parent root = FXMLLoader.load(getClass().getResource("EventPage.fxml")) ;
            mainPane.getChildren().setAll(root) ;
        }
    }

    public void onCloseBtn(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow() ;
        s.close();
    }

    public void onMinBtn(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow() ;
        s.setIconified(true);
    }
}
