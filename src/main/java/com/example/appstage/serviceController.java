package com.example.appstage;

import com.example.appstage.dao.InterfaceImp;
import com.example.appstage.modeles.service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

//import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class serviceController implements Initializable{

    @FXML
    private TextField txtServ;

    @FXML
    private TableView<com.example.appstage.modeles.service> tableServices;

    //@FXML
    //private TableColumn<service, Integer> id;

    @FXML
    private TableColumn<service, String> service;
    private InterfaceImp interImp = new InterfaceImp();

    ObservableList<service> liste= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //id.setCellValueFactory(new PropertyValueFactory<>("idService"));
        service.setCellValueFactory(new PropertyValueFactory<>("intitule"));

        liste.addAll(interImp.getAllServices());
        tableServices.setItems(liste);
        tableServices.setOnMouseClicked(event -> {
            afficher();
        });
    }

    public void vider(){
        txtServ.setText("");
    }
    public void afficher(){
        service s = tableServices.getSelectionModel().getSelectedItem() ;
        txtServ.setText(s.getIntitule());
    }
    public void ajouter(){
        service s;
        s= new service(txtServ.getText());
        interImp.addService(s);
        liste.clear();
        liste.addAll(interImp.getAllServices());
        tableServices.setItems(liste);
        vider();
    }
    public void modifier(){
        service s;
        s = tableServices.getSelectionModel().getSelectedItem();
        s.setIntitule(txtServ.getText());
        interImp.updateService(s);
        liste.clear();
        liste.addAll(interImp.getAllServices());
        tableServices.setItems(liste);
        vider();
    }
    public void supprimer(){
        service s;
        s = tableServices.getSelectionModel().getSelectedItem();
        interImp.deleteService(s);
        liste.clear();
        liste.addAll(interImp.getAllServices());
        tableServices.setItems(liste);
        vider();
    }
}
