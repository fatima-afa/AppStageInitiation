package com.example.appstage;

import com.example.appstage.dao.InterfaceImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

//import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class statisticsController implements Initializable {

    @FXML
    private DatePicker dateD;

    @FXML
    private DatePicker dateF;

    @FXML
    private ComboBox<String> comboServ;

    @FXML
    private Label labelStagiaire;

    @FXML
    private Label labelPerServ;
    private InterfaceImp interImp = new InterfaceImp();


    ObservableList<String> listeCmbService= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listeCmbService.addAll(interImp.getAllServiceIntitule()) ;
        comboServ.setItems(listeCmbService);
        //LocalDate localDateD = dateD.getValue();
        //LocalDate localDateF = dateF.getValue();
        //Instant instant = Instant.from(localDateD.atStartOfDay(ZoneId.systemDefault()));
        //Date dateD = Date.from(instant);
        //Instant instant1 = Instant.from(localDateF.atStartOfDay(ZoneId.systemDefault()));
        //Date dateF = Date.from(instant1);

        //comboServ.setOnAction(event -> {
            //if(((String) comboServ.getSelectionModel().getSelectedItem() !=null)){
                //int i = interImp.NbStagiaireYearService(dateD,dateF,comboServ.getSelectionModel().getSelectedItem());
                //int j = interImp.NbStagiaires(dateD,dateF);
                //labelStagiaire.setText(j+"stagiaires");
                //float per = i*100/j;
                //labelPerServ.setText(per+"%");
           // }
    //});
    }
    public void quitter(){
        Stage stage = (Stage) dateD.getScene().getWindow();
        stage.close();
    }
    public void chercher(){
        LocalDate localDateD = dateD.getValue();
        LocalDate localDateF = dateF.getValue();
        Instant instant = Instant.from(localDateD.atStartOfDay(ZoneId.systemDefault()));
        Date dateD = Date.from(instant);
        Instant instant1 = Instant.from(localDateF.atStartOfDay(ZoneId.systemDefault()));
        Date dateF = Date.from(instant1);
        if(((String) comboServ.getSelectionModel().getSelectedItem() !=null)){
            int i = interImp.NbStagiaireYearService(dateD,dateF,comboServ.getSelectionModel().getSelectedItem());
            int j = interImp.NbStagiaires(dateD,dateF);
            labelStagiaire.setText(j+" stagiaires");
            float per = i*100/j;
            labelPerServ.setText(per+" %");
        }
    }
}
