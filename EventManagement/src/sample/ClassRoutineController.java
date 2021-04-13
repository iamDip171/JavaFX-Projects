package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClassRoutineController extends LoginPageController implements Initializable {

    @FXML
    public TableView<ClassRoutine> mainTable;

    @FXML
    public TableColumn<ClassRoutine, String> colSub;

    @FXML
    public TableColumn<ClassRoutine, String> colDay;

    @FXML
    public TableColumn<ClassRoutine, String> colTime;

    @FXML public TextField subject, time, day ;

    ObservableList<ClassRoutine> list = FXCollections.observableArrayList() ;

    FileClass fClass = new FileClass("Database//" + name + "//Class.txt") ;

    ArrayList<ClassRoutine> listClass = new ArrayList<>() ;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        try {
            BufferedReader read = new BufferedReader(new FileReader("Database//" + name+ "//Class.txt")) ;
            String line ;
            while ((line = read.readLine()) != null) {
                String[] sp = line.split("_");
                listClass.add(new ClassRoutine(sp[0], sp[2], sp[1])) ;
                list.add(new ClassRoutine(sp[0], sp[1], sp[2]));
            }
            read.close();
        }catch (Exception e) {
            System.out.println("Unable to find file");
        }

        colSub.setCellValueFactory(new PropertyValueFactory<ClassRoutine, String>("subject"));
        colDay.setCellValueFactory(new PropertyValueFactory<ClassRoutine, String>("day"));
        colTime.setCellValueFactory(new PropertyValueFactory<ClassRoutine, String>("time"));

        mainTable.setItems(list);
    }


    public void onAddroutine(ActionEvent event) throws Exception{

        if (subject.getText().equals("") && time.getText().equals("") && day.getText().equals("")) {
            System.out.println("NOT");
        } else {

            /*try {
                BufferedReader bReader = new BufferedReader(new FileReader("Database//" + name + "//Class.txt")) ;
                String line ;
                while ((line = bReader.readLine()) != null) {
                    String data[] = line.split("_") ;
                    listClass.add(new ClassRoutine(data[0], data[2], data[1])) ;
                }
                bReader.close();

            }catch (Exception e) {}*/

            list.add(new ClassRoutine(subject.getText(), time.getText(), day.getText())) ;
            listClass.add (new ClassRoutine(subject.getText(), day.getText(), time.getText())) ;

            fClass.writeToFileClass(listClass);
        }

        subject.setText(null); time.setText(null); day.setText(null);
    }

    public void OnDeleteBtn(ActionEvent actionEvent) {
        try {
            fClass.DeleteFileClass(mainTable.getSelectionModel().getSelectedItem().getSubject());
            list.remove(mainTable.getSelectionModel().getSelectedItem());
        }catch (Exception e) {}
    }

}
