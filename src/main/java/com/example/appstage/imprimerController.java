package com.example.appstage;

import com.example.appstage.dao.InterfaceImp;
import com.example.appstage.modeles.imprimerClass;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.awt.Desktop;



//import org.w3c.dom.Document;
import com.itextpdf.text.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class imprimerController implements Initializable{
    @FXML
    TextField txtNom ;
    @FXML
    TextField txtPrenom ;
    @FXML
    TextField txtCin ;
    @FXML
    TextField txtEtab;
    @FXML
    TextField txtSpec;
    @FXML
    TextField txtDuree ;
    @FXML
    TextField txtPeriode ;
    @FXML
    TextField txtTheme ;
    @FXML
    TextField txtEncadrant ;
    @FXML
    TextField txtDivision ;
    @FXML
    TextField txtFonction ;
    @FXML
    TextField txtUnite ;
    @FXML
    TextField txtTele ;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    InterfaceImp inter=new InterfaceImp();
    imprimerClass imper ;
    public void search(){

        imper=inter.serchByCin(txtCin.getText());


        System.out.println(imper.getCin());
        txtNom.setText(imper.getNomS());
        txtPrenom.setText(imper.getPrenomS());
        txtEtab.setText(imper.getEtab());
        txtSpec.setText(imper.getSpec());
        txtDuree.setText(imper.getDuree());
        txtPeriode.setText((imper.getPeriode()));

        txtDivision.setText(imper.getDivision());
        txtEncadrant.setText(imper.getNomEnc());
        txtFonction.setText(imper.getFonction());
        txtUnite.setText(imper.getUnite());
        txtTele.setText(imper.getTele());
        txtTheme.setText(imper.getTheme());

    }
    public void imprimer(){
        Document docu=new Document();
        try{
            PdfWriter.getInstance(docu,new FileOutputStream("ficheDaccord.pdf"));
            docu.open();
            Image im = Image.getInstance("C:\\Users\\HP\\IdeaProjects\\AppStage\\src\\main\\java\\images\\onee.jpg");
            im.setAlignment(Image.ALIGN_CENTER);
            docu.add(im);
            docu.addTitle("FICHE D4ACCORD DE STAGE(A retourner à DR/DFC");
String title="\n                                                    FICHE D'ACCORD DE STAGE" +
             "\n                                                        (A retourner à DR/DFC)\n";
title.toUpperCase();

docu.add(new Paragraph(title));
           // docu.addHeader("header","FICHE D4ACCORD DE STAGE(A retourner à DR/DFC");
            docu.add(new Paragraph("STAGIAIRE\n\nNom : "+txtNom.getText()+"\n"+"Prénom : "+txtPrenom.getText()
                    +"\n"+"Etablissement : "+txtEtab.getText()
                    +"\n"+"Spécialité : "+txtSpec.getText()
                    +"\n\nREF.De La DEMANDE : \nSTAGE ACCORDE\n\n                         En Présentiel : X                    A Distance : X\n"+
                    "Durée(en mois) : "+txtDuree.getText()+
                    "\nPériode : "+txtPeriode.getText()+
                    "\nUnité d'acceul : CENTRALE THERMIQUE MOHAMMEDIA/ONEE-BE\n"+
                    "Lieu : MOHAMMEDIA\n"+
                    "Thème proposé : "+txtTheme.getText()+
                    "\n\nENCADRANT ONEE/BE : \n\n"+
                    "Nom et Prénom : "+txtEncadrant.getText()+
                    "\nFonction : "+txtFonction.getText()+
                    "\nDivision : "+txtDivision.getText()+
                    "\nUnité : "+txtUnite.getText()+
                    "\nTéléphone : "+txtTele.getText()+
                    "\n\nSTAGE NON ACCORDE\n"+
                    "\nMotif : ......................................................................................................."+
                    "\nDate :  .......................................................................................................\n"+
                    "\nCachet et signature du : \n\n"+
                    "      Responsable SRH\b\b             Chef de Division                  Directeur de l'Entité d'acceuil"


            ));
            docu.close();
            Desktop.getDesktop().open(new File("ficheDaccord.pdf"));

        } catch (FileNotFoundException  | DocumentException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

