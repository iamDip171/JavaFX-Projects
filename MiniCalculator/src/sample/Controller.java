package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Label screen1, screen2 ;

    static double result = 0.0;
    static int count = 0 ;
    static boolean pressed = false, pressedEqual = true ;

    public void numberAction (javafx.event.ActionEvent e) {
        String newN, oldN;

        if (pressedEqual) {
            screen2.setText("");
            screen1.setText("");
            pressedEqual = false;
            count = 0 ;
        }

        newN = ((Button) e.getSource()).getText();
        oldN = screen2.getText();
        if ((newN.equals("0") || newN.equals("00")) && screen2.getText() == "")
            screen2.setText("");
        else
            screen2.setText(oldN + newN);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void operationAction(ActionEvent event) {
        pressed = false ;
        pressedEqual = false ;
        String op = ((Button)event.getSource()).getText() ;
        if (count == 0) {
            double firstNum = Double.parseDouble(screen2.getText()) ;
            count = 1 ;
            result = firstNum ;
        } else {
            if (screen1.getText().startsWith(" +", screen1.getText().length()-2)) result = result + Double.parseDouble(screen2.getText()) ;
            if (screen1.getText().startsWith(" -", screen1.getText().length()-2)) result = result - Double.parseDouble(screen2.getText()) ;
            if (screen1.getText().startsWith(" /", screen1.getText().length()-2)) result = result / Double.parseDouble(screen2.getText()) ;
            if (screen1.getText().startsWith(" X", screen1.getText().length()-2)) result = result * Double.parseDouble(screen2.getText()) ;

            //count = 0 ;
        }
        DecimalFormat dc = new DecimalFormat("#0.000") ;
        String formatted = dc.format(result) ;
        screen1.setText((formatted.startsWith(".000", formatted.length()-4) ? (formatted.substring(0, formatted.length() - 4)) : formatted) + " " + op);
        screen2.setText("");
    }

    public void allClearAction(ActionEvent event) {
        screen2.setText("");
        screen1.setText("");
        result = 0.0 ;
        count = 0 ;
        pressed = false ;
    }

    public void clearAction (ActionEvent event) {
        if (!pressedEqual) {
            int length = screen2.getText().length();
            screen2.setText(screen2.getText().substring(0, length - 1));
        }
    }

    public void pointAction (ActionEvent event) {

        if (!pressed) {
            screen2.setText(screen2.getText() + ".");
            pressed = true ;
        }
    }

    public void equalAction (ActionEvent event) {
        Double temp ;
        if (screen1.getText().startsWith(" +", screen1.getText().length()-2)) {
            temp = result ;
            result = result + Double.parseDouble(screen2.getText());
            screen1.setText((String.valueOf(temp).startsWith(".0", String.valueOf(temp).length()-2) ? (String.valueOf(temp).substring(0, String.valueOf(temp).length() - 2)) : String.valueOf(temp)) + " + " + screen2.getText());

        }
        if (screen1.getText().startsWith(" -", screen1.getText().length()-2)) {
            temp = result ;
            result = result - Double.parseDouble(screen2.getText());
            screen1.setText((String.valueOf(temp).startsWith(".0", String.valueOf(temp).length()-2) ? (String.valueOf(temp).substring(0, String.valueOf(temp).length() - 2)) : String.valueOf(temp)) + " - " + screen2.getText());

        }
        if (screen1.getText().startsWith(" /", screen1.getText().length()-2)) {
            temp = result ;
            result = result / Double.parseDouble(screen2.getText());
            screen1.setText((String.valueOf(temp).startsWith(".0", String.valueOf(temp).length()-2) ? (String.valueOf(temp).substring(0, String.valueOf(temp).length() - 2)) : String.valueOf(temp)) + " / " + screen2.getText());

        }
        if (screen1.getText().startsWith(" X", screen1.getText().length()-2)) {
            temp = result ;
            result = result * Double.parseDouble(screen2.getText());
            screen1.setText((String.valueOf(temp).startsWith(".0", String.valueOf(temp).length()-2) ? (String.valueOf(temp).substring(0, String.valueOf(temp).length() - 2)) : String.valueOf(temp)) + " x " + screen2.getText());

        }

        DecimalFormat dc = new DecimalFormat("#0.000") ;
        String formatted = dc.format(result) ;
        screen2.setText((formatted.startsWith(".000", formatted.length()-4) ? (formatted.substring(0, formatted.length() - 4)) : formatted));

        pressedEqual = true ;
        pressed = false ;
    }

    public void offOnAction(ActionEvent event) {

    }
}
