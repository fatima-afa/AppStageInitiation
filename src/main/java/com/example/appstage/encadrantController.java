package com.example.appstage;

import com.example.appstage.dao.InterfaceImp;
import com.example.appstage.modeles.encadrant;
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

public class encadrantController implements Initializable{
    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtTel;
    @FXML
    private TextField txtDiv;

    @FXML
    private TextField txtFonct;

    @FXML
    private TextField txtUnit;

    @FXML
    private TableView<encadrant> tableEncadrants;

    @FXML
    private TableColumn<encadrant, String> nom;

    @FXML
    private TableColumn<encadrant, String> fonction;

    @FXML
    private TableColumn<encadrant, String> division;

    @FXML
    private TableColumn<encadrant, String> unite;

    @FXML
    private TableColumn<encadrant, String> tel;

    private InterfaceImp interImp = new InterfaceImp();

    ObservableList<encadrant> liste= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        fonction.setCellValueFactory(new PropertyValueFactory<>("fonction"));
        division.setCellValueFactory(new PropertyValueFactory<>("division"));
        unite.setCellValueFactory(new PropertyValueFactory<>("unite"));
        tel.setCellValueFactory(new PropertyValueFactory<>("tel"));

        liste.addAll(interImp.getAllEncadrantsTable());
        tableEncadrants.setItems(liste);
        tableEncadrants.setOnMouseClicked(event -> {
            afficher();
        });
    }

    public void vider(){
        txtNom.setText("");
        txtFonct.setText("");
        txtDiv.setText("");
        txtUnit.setText("");
        txtTel.setText("");
    }
    public void afficher(){
        encadrant e = tableEncadrants.getSelectionModel().getSelectedItem() ;
        txtNom.setText(e.getNom());
        txtFonct.setText(e.getFonction());
        txtDiv.setText(e.getDivision());
        txtUnit.setText(e.getUnite());
        txtTel.setText(e.getTel());
    }
    public void ajouter(){
        encadrant e;
        e= new encadrant(txtNom.getText(),txtFonct.getText(),txtDiv.getText(),  txtUnit.getText(), txtTel.getText());
        interImp.addEncadrant(e);
        liste.clear();
        liste.addAll(interImp.getAllEncadrantsTable());
        tableEncadrants.setItems(liste);
        vider();
    }
    public void modifier(){
        encadrant e;
        e = tableEncadrants.getSelectionModel().getSelectedItem();
        e.setNom(txtNom.getText());
        e.setFonction(txtFonct.getText());
        e.setDivision(txtDiv.getText());
        e.setUnite(txtUnit.getText());
        e.setTel(txtTel.getText());
        interImp.updateEncadrant(e);
        liste.clear();
        liste.addAll(interImp.getAllEncadrantsTable());
        tableEncadrants.setItems(liste);
        vider();
    }
    public void supprimer(){
        encadrant e ;
        e = tableEncadrants.getSelectionModel().getSelectedItem();
        interImp.deleteEncadrant(e);
        liste.clear();
        liste.addAll(interImp.getAllEncadrantsTable());
        tableEncadrants.setItems(liste);
        vider();
    }
}
