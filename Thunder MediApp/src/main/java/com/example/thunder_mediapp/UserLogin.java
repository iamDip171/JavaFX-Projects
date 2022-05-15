package com.example.thunder_mediapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserLogin extends MainApp {

    @FXML
    public Label label ;

    @FXML
    public AnchorPane userPane;

    @FXML
    public TextField userID;

    @FXML
    public TextField userPass;

    @FXML
    void adminLoginPressed(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("admin-login.fxml")) ;
            userPane.getChildren().setAll(root) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goPressed(ActionEvent event) {

        try {
            String[] st = Database_Management.fletchPassFromDB(userID.getText()) ;


            UserInfo info = Database_Management.fletchDataFromDB(userID.getText()) ;

            if (st[0].equals(userID.getText()) && st[1].equals(userPass.getText()) && !userID.getText().equals("") && !userPass.getText().equals("")) {
                System.out.println(st[0]);
                System.out.println(st[1]);

                FXMLLoader loadr = new FXMLLoader(getClass().getResource("user-dashboard.fxml")) ;
                Parent t = loadr.load() ;

                UserDashboard das = loadr.getController() ;
                das.setAll(info.getUsername());
                das.passID = userID.getText() ;
                //das.lis = Database_Management.getShopNearMe(Database_Management.fletchDataFromDB(userID.getText()).getUser_area()) ;
                FXMLLoader loader = new FXMLLoader (getClass().getResource("user-insider.fxml")) ;
                Parent p = loader.load() ;

                UserInsider dashboard = loader.getController() ;
                dashboard.id = userID.getText() ;
                dashboard.showPane.getChildren().setAll(t) ;
                AnchorPane pane = (AnchorPane) userPane.getParent().getParent();
                pane.getChildren().setAll(p) ;

                FXMLLoader m1 = new FXMLLoader(getClass().getResource("capsule-stage.fxml")) ;
                Parent me1 = m1.load() ;
                CapsuleStage c = m1.getController() ;
                c.l_name = userID.getText() ;


                FXMLLoader m2 = new FXMLLoader(getClass().getResource("liquids-stage.fxml")) ;
                Parent me2 = m2.load() ;
                LiquidStage l = m2.getController() ;
                l.l_name = userID.getText()  ;

                FXMLLoader m3 = new FXMLLoader(getClass().getResource("injection-stage.fxml")) ;
                Parent me3 = m3.load() ;
                InjectionStage i = m3.getController() ;
                i.l_name = userID.getText()  ;


                FXMLLoader m4 = new FXMLLoader(getClass().getResource("tablet-stage.fxml")) ;
                Parent me4 = m4.load() ;
                TabletStage ta = m4.getController() ;
                ta.l_name = userID.getText() ;

                FXMLLoader m5 = new FXMLLoader(getClass().getResource("Drops-stage.fxml")) ;
                Parent me5 = m5.load() ;
                DropsStage d = m5.getController() ;
                d.l_name = userID.getText() ;

                FXMLLoader m6 = new FXMLLoader(getClass().getResource("inhalers-stage.fxml")) ;
                Parent me6 = m6.load() ;
                InhalersStage in = m6.getController() ;
                in.l_name = userID.getText() ;

                FXMLLoader lk = new FXMLLoader(getClass().getResource("user-cart.fxml")) ;
                Parent f = lk.load() ;
                UserCart k = lk.getController() ;
                k.cart_name = userID.getText() ;
            }


        } catch (Exception e) {
            System.out.println("HELLO");
            e.printStackTrace();
        }
        userID.setText(null);
        userPass.setText(null);

    }

    @FXML
    void userSignUP(ActionEvent event) throws IOException {
        Stage stage = new Stage() ;
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("user-signup.fxml"))));
        stage.show();
    }
}
