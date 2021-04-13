package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OthersClassController extends LoginPageController implements Initializable {

    @FXML
    private TableView<OthersClass> othersTabelView;

    @FXML
    private TableColumn<OthersClass, String > othersEN;

    @FXML
    private TableColumn<OthersClass, String> othersED;

    @FXML
    private TableColumn<OthersClass, String> othersET;

    @FXML
    private TextField eventName;

    @FXML
    private TextField eventDate;

    @FXML
    private TextField eventTime;

    ObservableList<OthersClass> list = FXCollections.observableArrayList() ;

    ArrayList<OthersClass> listArr = new ArrayList<>() ;

    FileClass fc = new FileClass("Database//" + name + "//Others.txt") ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            BufferedReader bReader = new BufferedReader(new FileReader("Database//"+ name + "//Others.txt")) ;
            String line, data[] ;

            while ((line = bReader.readLine()) != null) {
                data = line.split("_") ;
                listArr.add(new OthersClass(data[0], data[1], data[2])) ;
                list.add(new OthersClass(data[0], data[1], data[2])) ;
            }

            bReader.close();
        }catch (Exception e) {}

        othersEN.setCellValueFactory(new PropertyValueFactory<OthersClass, String>("eventName"));
        othersED.setCellValueFactory(new PropertyValueFactory<OthersClass, String>("eventDate"));
        othersET.setCellValueFactory(new PropertyValueFactory<OthersClass, String>("eventTime"));

        othersTabelView.setItems(list);
    }

    public void onAddOthers(ActionEvent actionEvent) {
        if (!eventName.getText().equals("") &&
            !eventDate.getText().equals("") &&
            !eventTime.getText().equals("")) {
            list.add (new OthersClass(eventName.getText(), eventDate.getText(), eventTime.getText())) ;
            listArr.add(new OthersClass(eventName.getText(), eventDate.getText(), eventTime.getText())) ;
        }

        fc.writeToFileOthers(listArr);

        eventTime.setText(""); eventDate.setText(""); eventName.setText("");
    }

    public void onRemoveOthers(ActionEvent actionEvent) {
        fc.DeleteFileOthers(othersTabelView.getSelectionModel().getSelectedItem().getEventName());
        list.remove(othersTabelView.getSelectionModel().getSelectedItem());
    }
}
