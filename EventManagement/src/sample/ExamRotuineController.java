package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ExamRotuineController extends LoginPageController implements Initializable {

    @FXML
    public TableView<ExamRoutine> mainTable ;

    @FXML
    public TableColumn<ExamRoutine, String> subjectCol ;

    @FXML
    public TableColumn<ExamRoutine, String> timeCol ;

    @FXML
    public TableColumn <ExamRoutine, String> dayCol ;

    @FXML
    public TableColumn<ExamRoutine, Integer> serialCol ;
    @FXML
    public TextField subjectTxt, dayTxt, timeTxt ;

    ObservableList<ExamRoutine> listi = FXCollections.observableArrayList() ;

    ArrayList<ExamRoutine> arrList = new ArrayList<ExamRoutine>() ;

    FileClass fClass = new FileClass("Database//" + name + "//Exam.txt") ;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Database//" + name + "//Exam.txt")) ;
            String line ;
            while ((line = reader.readLine()) != null){
                String spl[] = line.split("_") ;
                arrList.add(new ExamRoutine(spl[0], spl[1], spl[2])) ;
                listi.add(new ExamRoutine(spl[0], spl[1], spl[2])) ;
            }
            reader.close();
        }catch (Exception e) {}

        //System.out.println(count);
        subjectCol.setCellValueFactory(new PropertyValueFactory<ExamRoutine, String>("subject"));
        timeCol.setCellValueFactory(new PropertyValueFactory<ExamRoutine, String>("time"));
        dayCol.setCellValueFactory(new PropertyValueFactory<ExamRoutine, String>("day"));

        mainTable.setItems(listi);
    }


    public void onAddbtn(ActionEvent actionEvent) throws Exception {
        if (subjectTxt.getText().equals("") && timeTxt.getText().equals("") && dayTxt.getText().equals("")) {
            System.out.println("NOT");
        } else {
            listi.add(new ExamRoutine(subjectTxt.getText(), timeTxt.getText(), dayTxt.getText()));
            arrList.add(new ExamRoutine(subjectTxt.getText(), timeTxt.getText(), dayTxt.getText())) ;
            fClass.writeToFileExam(arrList);
        }

        subjectTxt.setText(null); dayTxt.setText(null); timeTxt.setText(null);
    }

    public void onDeletebtn(ActionEvent actionEvent) {
        try {
            fClass.DeleteFileExam(mainTable.getSelectionModel().getSelectedItem().getSubject());
            listi.remove(mainTable.getSelectionModel().getSelectedItem());
        }catch (Exception e) {}
    }


}
