package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class TodayFxml extends LoginPageController implements Initializable {

    @FXML
    public ListView<String> classesLV;

    @FXML
    public TableView<ExamRoutine> tvExams;

    @FXML
    public TableColumn<ExamRoutine, String> examCol;

    @FXML
    public TableColumn<ExamRoutine, String> examTimeCol;

    @FXML
    public TableView<OthersClassController> tvOthers;

    @FXML
    public TableColumn<OthersClassController, String> othersCol;

    @FXML
    public TableColumn<OthersClassController, String> othersTimeCol;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Date date = new Date() ;

        String classFile = "Database//" + name + "//Class.txt" ;
        String examFile = "Database//" + name + "//Exam.txt" ;
        String otherFile = "Database//" + name + "//Others.txt" ;

        try {
            BufferedReader classReader = new BufferedReader(new FileReader(classFile)) ;
            BufferedReader examReader = new BufferedReader(new FileReader(examFile)) ;
            BufferedReader othersReader = new BufferedReader(new FileReader(otherFile)) ;

            SimpleDateFormat dFormate = new SimpleDateFormat("EEEE");
            String lineClass, lineExam, lineOthers ;
            while ((lineClass = classReader.readLine()) != null) {
                String classData[] = lineClass.split("_");
                String days[] = classData[2].split(", ");
                for (int i = 0; i < days.length; i++) {
                    if (days[i].equalsIgnoreCase(dFormate.format(date))) {
                        classesLV.getItems().add(classData[0]);
                        break;
                    }
                }
            }

            ObservableList<ExamRoutine> list = FXCollections.observableArrayList() ;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy") ;
            while ((lineExam = examReader.readLine()) != null) {
                String examData[] = lineExam.split("_") ;
                if (examData[2].equals(dateFormat.format(date))) {
                    list.add(new ExamRoutine(examData[0], examData[1], examData[2])) ;
                }
            }
            examCol.setCellValueFactory(new PropertyValueFactory<ExamRoutine, String>("subject"));
            examTimeCol.setCellValueFactory(new PropertyValueFactory<ExamRoutine, String>("time"));
            tvExams.setItems(list);
        }catch (Exception e) {}
    }


}
