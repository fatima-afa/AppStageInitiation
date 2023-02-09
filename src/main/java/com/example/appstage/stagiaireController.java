package com.example.appstage;

//import com.sun.javaws.IconUtil;
import com.example.appstage.dao.InterfaceImp;
import com.example.appstage.modeles.TreeClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

//import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class stagiaireController implements Initializable{
    @FXML
    TextField txtNom ;
    @FXML
    TextField txtCNI ;
    @FXML
    TextField txtEtab;
    @FXML TextField txtPrenom ;
    @FXML TextField txtSpec;
    @FXML DatePicker dateD;
    @FXML DatePicker dateF;

    @FXML TextField txtTheme ;
    @FXML
    private ComboBox<String> comboType;

    @FXML
    private ComboBox<String> comboEnc;

    @FXML
    private ComboBox<String> comboDem;

    @FXML
    private ComboBox<String> comboServ;

    @FXML
    TableView<TreeClass> tableStagiaires ;

    @FXML
    TableColumn<TreeClass,String> cni ;
    @FXML
    TableColumn<TreeClass,String> nom ;
    @FXML
    TableColumn<TreeClass,String> prenom ;
    @FXML
    TableColumn<TreeClass,String> etablissement ;
    @FXML
    TableColumn<TreeClass,String> specialite ;
    @FXML
    TableColumn<TreeClass,String> encadrant ;
    @FXML
    TableColumn<TreeClass,String> service ;
    @FXML
    TableColumn<TreeClass,String> demandeur ;
    @FXML
    TableColumn<TreeClass,String> type ;
    @FXML
    TableColumn<TreeClass,String> theme ;
    @FXML
    TableColumn<TreeClass, Date> dateDebut ;
    @FXML
    TableColumn<TreeClass, Date> dateFin ;
    @FXML
    TableColumn<TreeClass, Long> duree ;


    //private interface inter;
    private InterfaceImp interImp = new InterfaceImp();

    ObservableList<TreeClass> liste= FXCollections.observableArrayList();

    ObservableList<String> listeCmbEncadrant= FXCollections.observableArrayList();
    ObservableList<String> listeCmbService= FXCollections.observableArrayList();
    ObservableList<String> listeCmbDemandeur= FXCollections.observableArrayList();



    //@Override
    //public void initialize extends Application {
       // comboType.setItems(FXCollections.observableArrayList("Stage de fin d'études", "Stache technique", "Stage ouvrier"));
    //comboType.getItems().setAll("Stage de fin d'études", "Stache technique", "Stage ouvrier");
    //}


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboType.setItems(FXCollections.observableArrayList("Stage de fin d'études", "Stage technique", "Stage ouvrier"));
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
        comboEnc.setItems(listeCmbEncadrant);
        listeCmbService.addAll(interImp.getAllServiceIntitule()) ;
        comboServ.setItems(listeCmbService);
        listeCmbDemandeur.addAll(interImp.getAllNomDemandeurs()) ;
        comboDem.setItems(listeCmbDemandeur);


        tableStagiaires.setOnMouseClicked(event -> {
            afficher();
        });

    }

    public void vider(){
        txtNom.setText("");
        txtPrenom.setText("");
        txtCNI.setText("");
        txtEtab.setText("");
        txtSpec.setText("");
        //txtEnca.setText("");
        comboEnc.getSelectionModel().select(-1);
        comboServ.getSelectionModel().select(-1);
        //txtServ.setText("");
        //txtDemn.setText("");
        comboDem.getSelectionModel().select(-1);
        txtTheme.setText("");
        dateD.setValue(null);
        dateF.setValue(null);
        comboType.getSelectionModel().select(-1);
    }
    public void ajouter(){
        TreeClass t;

        LocalDate localDateD = dateD.getValue();
        LocalDate localDateF = dateF.getValue();

        Instant instant = Instant.from(localDateD.atStartOfDay(ZoneId.systemDefault()));
        Date dateD = Date.from(instant);
        Instant instant1 = Instant.from(localDateF.atStartOfDay(ZoneId.systemDefault()));
        Date dateF = Date.from(instant1);

        t= new TreeClass(txtCNI.getText(),txtNom.getText(),txtPrenom.getText(),txtEtab.getText(),txtSpec.getText(),comboEnc.getSelectionModel().getSelectedItem(),comboServ.getSelectionModel().getSelectedItem(),comboDem.getSelectionModel().getSelectedItem(),txtTheme.getText(),comboType.getSelectionModel().getSelectedItem(),dateD,dateF);

        boolean obs;
         if(comboType.getSelectionModel().getSelectedItem().equals("stage ouvrier"))
            obs = true;
        else obs = false;
        interImp.addStagiaire(t);
        liste.clear();
        liste.addAll(interImp.getAllStagiairesTable());
        tableStagiaires.setItems(liste);
        vider();
    }

    public void dossier() throws IOException {
        Stage stage = new Stage() ;
        Parent root =  load(Objects.requireNonNull(getClass().getResource("dossier.fxml")));
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("AppStage ") ;
        stage.show() ;
    }
    void afficher(){

        TreeClass t = tableStagiaires.getSelectionModel().getSelectedItem() ;
        txtCNI.setText(t.getCni());
        txtNom.setText(t.getNom());
        txtPrenom.setText(t.getPrenom());
        txtEtab.setText(t.getEtablissement());
        txtSpec.setText(t.getSpecialite());

        //txtDemn.setText(t.getNomDemandeur()); ;
        txtTheme.setText(t.getTheme());



        SimpleDateFormat sd =new SimpleDateFormat("dd/MMM/YYYY") ;
        String dtD = sd.format(t.getDateDebut()) ;
        DateTimeFormatter dfD = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        LocalDate ldD= LocalDate.parse(dtD, dfD);
        dateD.setValue(ldD);


        String dtF = sd.format(t.getDateFin()) ;
        DateTimeFormatter dfF = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        LocalDate ldF= LocalDate.parse(dtF, dfF);
        dateF.setValue(ldF);

        int i = 0 ;
        for(String d:listeCmbEncadrant){
            if(d.equals(t.getNomEncadrant()))

                break;
            i++ ;
        }
        comboEnc.getSelectionModel().select(i);

        int j=0;
        for(String d:listeCmbService){
            if(d.equals(t.getIntituleService()))
                break;
            j++ ;
        }
        comboServ.getSelectionModel().select(j);

        int k=0;
        for(String d:listeCmbDemandeur){
            if(d.equals(t.getNomDemandeur()))
                break;
            k++ ;
        }
        comboDem.getSelectionModel().select(k);

        if(t.getType().equalsIgnoreCase("Stage de fin d'études"))
            comboType.getSelectionModel().select(0);
        else{
            if(t.getType().equalsIgnoreCase("Stage technique"))
                comboType.getSelectionModel().select(1);
            else
                comboType.getSelectionModel().select(2);
        }



    }

    public void modifier(){
       // TreeClass t =new TreeClass("", "", "", "", "", "", "", "", "", "", new Date(2021-10-1), new Date(2021-10-29)) ;
        TreeClass t;

        t = tableStagiaires.getSelectionModel().getSelectedItem();
        t.setCni(txtCNI.getText());
        //System.out.println(t.getCni());

        t.setNom(txtNom.getText());
        //System.out.println(t.getNom());

        t.setPrenom(txtPrenom.getText());
        //System.out.println(t.getPrenom());

        t.setEtablissement(txtEtab.getText());
        //System.out.println(t.getEtablissement());

        t.setSpecialite(txtSpec.getText());
        //System.out.println(t.getSpecialite());
        //t.setNomDemandeur(txtDemn.getText());
        t.setTheme(txtTheme.getText());
        //System.out.println(t.getTheme());


        t.setType((String) comboType.getSelectionModel().getSelectedItem());
        //System.out.println(t.getType());

        t.setNomEncadrant((String) comboEnc.getSelectionModel().getSelectedItem());
        //System.out.println(t.getNomEncadrant());
        t.setIntituleService((String) comboServ.getSelectionModel().getSelectedItem());
        t.setNomDemandeur((String) comboDem.getSelectionModel().getSelectedItem());
        LocalDate localDateD = dateD.getValue();
        Instant instant = Instant.from(localDateD.atStartOfDay(ZoneId.systemDefault()));
        Date dateD = Date.from(instant);
        t.setDateDebut(dateD);

        LocalDate localDateF = dateF.getValue();
        Instant instant1 = Instant.from(localDateF.atStartOfDay(ZoneId.systemDefault()));
        Date dateF = Date.from(instant1);
        t.setDateFin(dateF);
        interImp.updateStagiaire(t);
        liste.clear();
        liste.addAll(interImp.getAllStagiairesTable());
        tableStagiaires.setItems(liste);
        vider();
    }

    public void supprimer(){
        TreeClass t ;
        t = tableStagiaires.getSelectionModel().getSelectedItem();
        interImp.deleteStagiaire(t);

        liste.clear();
        liste.addAll(interImp.getAllStagiairesTable());
        tableStagiaires.setItems(liste);
        vider();
    }

    public void search (){

    }

}
