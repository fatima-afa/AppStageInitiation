package com.example.appstage;

import com.example.appstage.dao.InterfaceImp;
import com.example.appstage.modeles.demandeur;
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

public class demandeurController implements Initializable {
    @FXML
    private TextField txtNom;

    @FXML
    private TableView<demandeur> tableDemandeurs;

    @FXML
    private TableColumn<demandeur, String> nom;

    private InterfaceImp interImp = new InterfaceImp();
    ObservableList<demandeur> liste= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));

        liste.addAll(interImp.getAllDemandeurs());
        tableDemandeurs.setItems(liste);
        tableDemandeurs.setOnMouseClicked(event -> {
            afficher();
        });
    }

    public void vider(){
        txtNom.setText("");
    }
    public void afficher(){
        demandeur d = tableDemandeurs.getSelectionModel().getSelectedItem() ;
        txtNom.setText(d.getNom());
    }
    public void ajouter(){
        demandeur d;
        d = new demandeur(txtNom.getText());
        interImp.addDemandeur(d);
        liste.clear();
        liste.addAll(interImp.getAllDemandeurs());
        tableDemandeurs.setItems(liste);
        vider();
    }
    public void modifier(){
        demandeur d;
        d = tableDemandeurs.getSelectionModel().getSelectedItem();
        d.setNom(txtNom.getText());
        interImp.updateDemandeur(d);
        liste.clear();
        liste.addAll(interImp.getAllDemandeurs());
        tableDemandeurs.setItems(liste);
        vider();
    }
    public void supprimer(){
        demandeur d;
        d = tableDemandeurs.getSelectionModel().getSelectedItem();
        interImp.deleteDemandeur(d);
        liste.clear();
        liste.addAll(interImp.getAllDemandeurs());
        tableDemandeurs.setItems(liste);
        vider();
    }
}
