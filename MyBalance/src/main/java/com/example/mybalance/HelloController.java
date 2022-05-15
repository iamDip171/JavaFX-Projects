package com.example.mybalance;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label greetingsLabel;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button mainBtn;

    @FXML
    private Label msgLabel1;

    @FXML
    private Label msgLabel2;

    @FXML
    private TextField nameText;

    @FXML
    private AnchorPane masterPane;

    @FXML
    private TextField pin1;

    @FXML
    private Label label;

    @FXML
    private TextField pin2;

    @FXML
    private TextField pin3;

    @FXML
    private TextField pin4;

    @FXML
    private AnchorPane signupPane;

    @FXML
    private VBox vBox;

    @FXML
    private AnchorPane signup;

    @FXML
    private AnchorPane login;

    private int pressed = 0 ;
    @FXML
    void loginBtn(ActionEvent event) {
        TranslateTransition t = new TranslateTransition() ;
        TranslateTransition t1 = new TranslateTransition() ;
        FadeTransition f = new FadeTransition() ;
        FadeTransition f1 = new FadeTransition() ;


        //TranslateTransition t1 = new TranslateTransition() ;
        Button b = (Button) event.getSource() ;
        if (pressed == 0) {
            t.setByX(661);
            t1.setByX(-415);

            //f.setFromValue(0);
            f.setToValue(0);
            f.setDuration(Duration.millis(500));
            f.setNode(b);
            f.setAutoReverse(true);
            f.setCycleCount(2);
            f.play();
            b.setText("Sign Up");
            mainBtn.setText("log in");
            pressed = 1 ;
        } else {
            t.setByX(-661);
            t1.setByX(416);
            f1.setFromValue(10);
            f1.setToValue(0);
            f1.setDuration(Duration.millis(500));
            f1.setNode(b);
            f1.setAutoReverse(true);
            f1.setCycleCount(2);
            f1.play();
            b.setText("Log In");
            mainBtn.setText("Sign Up");
            pressed = 0;
        }

        t.setDuration(Duration.millis(1000));
        t1.setDuration(Duration.millis(1000));

        t.setNode(vBox);
        t1.setNode(signupPane);
        t.play();
        t1.play();
        label.setVisible(false);


        nameText.requestFocus();

    }
    @FXML
    void minimizeBtn(ActionEvent event) {
        Stage st = (Stage) masterPane.getScene().getWindow() ;
        st.setIconified(true);
    }

    @FXML
    void closeBtn(ActionEvent event) {
        Stage st = (Stage) masterPane.getScene().getWindow() ;
        st.close();
    }

    @FXML
    void signUpPressed(ActionEvent event) {

        Button btn = (Button) event.getSource() ;

        if (btn.getText().equals("Sign Up")) {
            String name = nameText.getText() ;
            String pass = pin4.getText()+pin3.getText()+pin2.getText()+pin1.getText() ;

            FileIO i = new FileIO() ;
            i.createFolder(name, pass);
            nameText.setText("");
            pin1.setText("");
            pin2.setText("");
            pin3.setText("");
            pin4.setText("");

            label.setText("Signup succeed");

        }
        else if (btn.getText().equals("log in")) {
            String str = nameText.getText()+"_"+ pin4.getText()+pin3.getText()+pin2.getText()+pin1.getText() ;
            //System.out.println(str);
            if (FileIO.searchUser(str)) {
                gotoResource("home-view.fxml", nameText.getText(), str);
            }
            else System.out.println("Not found");
        }



       //System.out.println(btn.getText());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void gotoPin1(KeyEvent event) {
        if (event.getCode() == KeyCode.RIGHT) {
            pin1.requestFocus();
        }
        if (event.getCode() == KeyCode.UP) {
            nameText.requestFocus();
        }
        if (event.getCode() == KeyCode.LEFT) {
            pin2.requestFocus();
        }
    }

    @FXML
    void gotoPin2(KeyEvent event) {
        if (event.getCode() == KeyCode.RIGHT) {
            pin2.requestFocus();
        }
        if (event.getCode() == KeyCode.UP) {
            nameText.requestFocus();
        }
        if (event.getCode() == KeyCode.LEFT) {
            pin3.requestFocus();
        }
    }

    @FXML
    void gotoDown(KeyEvent event) {
        if (event.getCode() == KeyCode.DOWN) {
            pin4.requestFocus();
        }
        if (event.getCode() == KeyCode.UP) {
            nameText.requestFocus();
        }

    }

    @FXML
    void gotoPin3(KeyEvent event) {
        if (event.getCode() == KeyCode.RIGHT) {
            pin3.requestFocus();
        }
        if (event.getCode() == KeyCode.UP) {
            nameText.requestFocus();
        }
        if (event.getCode() == KeyCode.LEFT) {
            pin2.requestFocus();
        }
    }

    @FXML
    void gotoUp(KeyEvent event) {
        if (event.getCode() == KeyCode.UP) {
            nameText.requestFocus();
        }
    }

    void gotoResource (String res, String name, String folder) {
       /* SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy") ;
        Date ef = new Date() ;
        String dsa = d.format(ef) ;*/

        SimpleDateFormat fore = new SimpleDateFormat("dd-MM-yyyy") ;
        Date d = new Date() ;
        String date = fore.format(d) ;
        Calendar c = Calendar.getInstance() ;
        c.setTime(d);
        String day = new SimpleDateFormat("EEEE").format(d) ;


        try {
            String n = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ folder+ "\\DailyCost\\" + date + ".txt" ;

            new File(n).createNewFile() ;

        }catch (Exception e) {e.printStackTrace();}

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(res)) ;
            Parent rt = loader.load() ;
            HomeView v = loader.getController() ;

            String name_e = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ folder + "\\DailyCost\\" + date + ".txt" ;

            BufferedReader b = new BufferedReader(new FileReader(name_e)) ;
            String line ;

            while ((line = b.readLine()) != null) {
                FXMLLoader loadr = new FXMLLoader(getClass().getResource("cost-node.fxml")) ;
                Parent root = loadr.load() ;
                CostNode cn = loadr.getController() ;
                String[] spl = line.split("_") ;
                //System.out.println(spl[0] + " " + spl[1]);
                cn.setCostText(spl[1]);
                cn.setCostCause(spl[0]) ;
                v.vboxPane.getChildren().add(root);
            }

            v.totalCostofDayText.setText(FileIO.fletchCost(folder, date)+"");
            //System.out.println(folder);
            String balance = FileIO.fletchBalance(folder) ;
            v.balanceText.setText(balance);
            v.setNameLabel(name) ;
            v.f_name = folder ;
            mainPane.getChildren().setAll(rt) ;

            /*if (day.equals("Saturday")) {
                FileIO.writeIntoFileC(folder, "0", "Saturday");
                FileIO.writeIntoFileC(folder, "0", "Sunday");
                FileIO.writeIntoFileC(folder, "0", "Monday");
                FileIO.writeIntoFileC(folder, "0", "Tuesday");
                FileIO.writeIntoFileC(folder, "0", "Thursday");
                FileIO.writeIntoFileC(folder, "0", "Friday");
                FileIO.writeIntoFileC(folder, "0", "Wednesday");
            }*/

            v.series = new XYChart.Series() ;
            //String st[] = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"} ;

            String nam= "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ folder + "\\DailyCost" ;

            File f = new File(nam) ;
            String st[] = f.list() ;


            for (int i=0; i<st.length; i++) {
                String a[] = st[i].split(".txt") ;
                v.series.getData().add(new XYChart.Data(a[0], FileIO.fletchCost(folder, a[0]))) ;
            }

            v.lineChart.getData().add(v.series) ;

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
