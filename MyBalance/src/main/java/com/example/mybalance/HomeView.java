package com.example.mybalance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.security.spec.ECField;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class HomeView implements Initializable {

    @FXML
    private AnchorPane loginPane;

    @FXML
    private TextField addText;

    @FXML
    public Label balanceText;

    @FXML
    private Label setName;

    @FXML
    private AnchorPane showPane;

    @FXML
    private AnchorPane displayPane;

    @FXML
    public Label totalCostofDayText;

    @FXML
    public VBox vboxPane;
    @FXML
    private TextField totalCost;

    @FXML
    private TextField costName;


    public String f_name ;

    public String date ;
    public String day ;

    public String amount, name0 ;


    @FXML
    public BarChart<?,?> lineChart;

    public XYChart.Series series ;
    public XYChart.Data data ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SimpleDateFormat fore = new SimpleDateFormat("dd-MM-yyyy") ;
        Date d = new Date() ;
        date = fore.format(d) ;
        Calendar c = Calendar.getInstance() ;
        c.setTime(d);
        day = new SimpleDateFormat("EEEE").format(d) ;


        lineChart.horizontalGridLinesVisibleProperty().setValue(false);
        lineChart.verticalGridLinesVisibleProperty().setValue(false);

    }

    public void setNameLabel (String name) {
        setName.setText(name);
    }


    @FXML
    void addButton(ActionEvent event) {

        String balance = Integer.parseInt(balanceText.getText()) + Integer.parseInt(addText.getText()) + "" ;
        balanceText.setText(balance);
        FileIO.writeIntoFile(f_name, balance);
        addText.setText("");
    }

    @FXML
    void addCost(ActionEvent event) {
        try {
            FXMLLoader loadr = new FXMLLoader(getClass().getResource("cost-node.fxml")) ;
            Parent root = loadr.load() ;
            CostNode cn = loadr.getController() ;
            cn.setCostText(totalCost.getText());
            cn.setCostCause(costName.getText());

            vboxPane.getChildren().add(root) ;

            String newBalance = Integer.parseInt(balanceText.getText()) - Integer.parseInt(totalCost.getText()) + "";

            balanceText.setText(newBalance);

            FileIO.writeIntoFile(f_name, newBalance);
            FileIO.appendIntoFile(f_name, costName.getText(), totalCost.getText(), date);

            name0 = costName.getText() ;
            amount = totalCost.getText() ;

            String costt = FileIO.fletchCost(f_name, date)+ Integer.parseInt(totalCost.getText()) + "" ;

            FileIO.writeIntoFileC(f_name, costt, day);

            series.getData().add(new XYChart.Data(day, Integer.parseInt(costt))) ;

            //lineChart.getData().add(series) ;
            totalCostofDayText.setText(String.valueOf(FileIO.fletchCost(f_name, date)));

            totalCost.setText("");
            costName.setText("");

        }catch (Exception e) {}
    }

    @FXML
    void dailyHistory(ActionEvent event) {

        String main_f = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ f_name + "\\DailyCost" ;


        try {

            File f = new File(main_f) ;
            String con[]= f.list() ;
            System.out.println(con.length);
            int i = 0 ;
            FXMLLoader loa = new FXMLLoader(getClass().getResource("daily-cost-history.fxml")) ;
            Parent r = loa.load() ;
            while (i < con.length) {
                /*String number = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ f_name + "\\DailyCost\\" + con[i] ;
                System.out.println(number);
                BufferedReader br = new BufferedReader(new FileReader(number)) ;
                String line;*/

                //while ((line = br.readLine()) != null) {
                    //String del[] = line.split("_") ;
                    String s[] = con[i].split(".txt") ;
                System.out.println(s[0] );
                    FXMLLoader loar = new FXMLLoader(getClass().getResource("vbox-compo.fxml")) ;
                    Parent roo = loar.load() ;
                    VboxCompo vc = loar.getController() ;

                    String sk[] = s[0].split("-") ;
                LocalDate d = LocalDate.of(Integer.parseInt(sk[2]), Integer.parseInt(sk[1]), Integer.parseInt(sk[0])) ;


                    vc.setLabellBox( s[0] + " -- " + d.getDayOfWeek().toString() );
                    vc.f_namee = f_name ;
                    /*vc.name_ = name0 ;
                    vc.amount = amount ;*/

                    DailyCostHistory h = loa.getController() ;
                    h.setShowVBOX(roo);


                //}
                displayPane.getChildren().setAll(r) ;
                i++ ;
            }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void dashBoardPressed(ActionEvent event) {
        try {

            displayPane.getChildren().setAll(showPane) ;
        }catch (Exception e) {}
    }

}