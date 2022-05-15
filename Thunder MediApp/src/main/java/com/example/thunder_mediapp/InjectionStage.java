package com.example.thunder_mediapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class InjectionStage implements Initializable {

    @FXML
    private TableView<Medicine> injectionTable;

    @FXML
    private TableColumn<Medicine, String> name;

    @FXML
    private TableColumn<Medicine, String> strength;

    @FXML
    private TableColumn<Medicine, String> ingredents;

    @FXML
    private TableColumn<Medicine, String> com_name;

    @FXML
    private TableColumn<Medicine, Integer> price;

    ObservableList<Medicine> list = FXCollections.observableArrayList() ;
    ObservableList<Medicine> select ;

    public static String l_name ;
    @FXML
    void addtoCart(ActionEvent event) throws Exception {
        Database_Management.insertIntoOrders( l_name,select.get(0).getName() , select.get(0).getPrice());



        FXMLLoader loader = new FXMLLoader(getClass().getResource("items-stage.fxml")) ;
        Parent root = loader.load() ;
        ItemsStage stage = loader.getController() ;
        stage.setLabels(select.get(0).getName(), select.get(0).getPrice());

        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("user-cart.fxml")) ;
        Parent root1 = loader1.load() ;
        UserCart cart = loader1.getController() ;

        cart.list.add(root) ;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        select = injectionTable.getSelectionModel().getSelectedItems() ;
        try {
            list = Database_Management.fletchDataFromMedicine("injections") ;
        } catch (Exception e) {
            e.printStackTrace();
        }

        name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("name"));
        strength.setCellValueFactory(new PropertyValueFactory<Medicine, String>("strength"));
        ingredents.setCellValueFactory(new PropertyValueFactory<Medicine, String>("indegrants"));
        com_name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("com_name"));
        price.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("price"));
        injectionTable.setItems(list);
    }
}
