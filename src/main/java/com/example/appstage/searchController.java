package com.example.appstage;

import com.example.appstage.dao.InterfaceImp;
import com.example.appstage.modeles.TreeClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class searchController implements Initializable {

    @FXML
    private TableView<TreeClass> tableStagiaires;

    @FXML
    private TableColumn<TreeClass, String> cni;

    @FXML
    private TableColumn<TreeClass, String> nom;

    @FXML
    private TableColumn<TreeClass, String> prenom;

    @FXML
    private TableColumn<TreeClass, String> etablissement;

    @FXML
    private TableColumn<TreeClass, String> specialite;

    @FXML
    private TableColumn<TreeClass, String> encadrant;

    @FXML
    private TableColumn<TreeClass, String> service;

    @FXML
    private TableColumn<TreeClass, String> demandeur;

    @FXML
    private TableColumn<TreeClass, String> type;

    @FXML
    private TableColumn<TreeClass, String> theme;

    @FXML
    private TableColumn<TreeClass, Date> dateDebut;

    @FXML
    private TableColumn<TreeClass, Date> dateFin;

    @FXML
    private TableColumn<TreeClass, Long> duree;

    @FXML
    private ComboBox<String> comboServ1;

    @FXML
    private ComboBox<String> comboEnc1;

    private InterfaceImp interImp = new InterfaceImp();

    ObservableList<TreeClass> liste= FXCollections.observableArrayList();

    ObservableList<String> listeCmbEncadrant= FXCollections.observableArrayList();
    ObservableList<String> listeCmbService= FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cni.setCellValueFactory(new PropertyValueFactory<>("cni"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        etablissement.setCellValueFactory(new PropertyValueFactory<>("etablissement"));
        specialite.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        encadrant.setCellValueFactory(new PropertyValueFactory<>("nomEncadrant"));
        service.setCellValueFactory(new PropertyValueFactory<>("intituleService"));
        demandeur.setCellValueFactory(new PropertyValueFactory<>("nomDemandeur"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
        dateDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        dateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        duree.setCellValueFactory(new PropertyValueFactory<>("duree"));


        liste.addAll(interImp.getAllStagiairesTable());
        tableStagiaires.setItems(liste);

        listeCmbEncadrant.addAll(interImp.getAllEncadrant()) ;
        comboEnc1.setItems(listeCmbEncadrant);
        listeCmbService.addAll(interImp.getAllServiceIntitule()) ;
        comboServ1.setItems(listeCmbService);
    }
    public void vider(){
        comboEnc1.getSelectionModel().select(-1);
        comboServ1.getSelectionModel().select(-1);
    }
    public void search(){
        if(((String) comboServ1.getSelectionModel().getSelectedItem() !=null)){
            liste.clear() ;
            liste.addAll(interImp.getAllStagiairesByService(((String) comboServ1.getSelectionModel().getSelectedItem() )));
            tableStagiaires.setItems(liste);
            vider();
        }
        if(((String) comboEnc1.getSelectionModel().getSelectedItem() !=null)){
            liste.clear() ;
            liste.addAll(interImp.getAllStagiairesByEncadrant(((String) comboEnc1.getSelectionModel().getSelectedItem() )));
            tableStagiaires.setItems(liste);
            vider();
        }
    }
}
