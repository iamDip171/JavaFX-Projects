package com.example.mybalance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;

public class VboxCompo {

    @FXML
    private Label labellBox;

    public Node node ;
    public String amount, name_, f_namee ;

    @FXML
    void showDetails(ActionEvent event) {

        System.out.println(amount + " " + name_);
        try {
            String slt[] = labellBox.getText().split(" -- ") ;
            String name = "D:\\WorkPlace\\IdeaProjects\\MyBalance\\Database\\"+ f_namee + "\\DailyCost\\" + slt[0] + ".txt" ;

            BufferedReader br = new BufferedReader(new FileReader(name)) ;
            String line ;

            FXMLLoader fg = new FXMLLoader(getClass().getResource("cost-details.fxml")) ;
            Parent r = fg.load() ;

            while ((line = br.readLine()) != null) {
                String l[] = line.split("_") ;
                CostDetails df = fg.getController() ;
                df.amountLabel = l[1] ;
                df.nameLabel = l[0] ;
                df.setVBOXpane(node);
            }


            Stage s = new Stage() ;
            Scene scene = new Scene(r) ;
            s.setScene(scene);
            s.show();
        }catch (Exception e) {
            System.out.println("In VBOX");
            e.printStackTrace();
        }
    }

    public void setLabellBox (String date) {
        labellBox.setText(date);
    }

}
