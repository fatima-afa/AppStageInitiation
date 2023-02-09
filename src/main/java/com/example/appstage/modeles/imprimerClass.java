package com.example.appstage.modeles;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Date;

import static java.lang.Math.abs;

public class imprimerClass {
    String NomS,PrenomS,Etab,Spec,Theme,NomEnc,Division,Fonction,Unite,Cin,Tele;

    long Duree;
    Date DateFin,DateDebut;

    public imprimerClass(String cin,String nomS, String prenomS, String etab, String spec, String theme, String nomEnc, String division, String unite, String tele,Date dateDebut,Date dateFin,String fonction) {
        Fonction=fonction;
        Cin=cin;
        NomS = nomS;
        PrenomS = prenomS;
        Etab = etab;
        Spec = spec;
        Theme = theme;
        NomEnc = nomEnc;
        Division = division;
        Unite = unite;
        Tele = tele;
        DateFin=dateFin;
        DateDebut=dateDebut;
        this.Duree = abs((dd() / (1000 * 60 * 60 * 24*28))) ;
    }

    public String getFonction() {
        return Fonction;
    }

    public void setFonction(String fonction) {
        Fonction = fonction;
    }

    public String getCin() {
        return Cin;
    }

    public void setCin(String cin) {
        Cin = cin;
    }

    private long dd(){return getDateFin().getTime() - getDateDebut().getTime();}

    public String getDuree() {
        return Duree+" mois";
    }

    public void setDuree(long duree) {
        Duree = duree;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateFin(Date dateFin) {
        DateFin = dateFin;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        DateDebut = dateDebut;
    }

    public String getNomS() {
        return NomS;
    }

    public void setNomS(String nomS) {
        NomS = nomS;
    }

    public String getPrenomS() {
        return PrenomS;
    }

    public void setPrenomS(String prenomS) {
        PrenomS = prenomS;
    }

    public String getEtab() {
        return Etab;
    }

    public void setEtab(String etab) {
        Etab = etab;
    }

    public String getSpec() {
        return Spec;
    }

    public void setSpec(String spec) {
        Spec = spec;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }

    public String getNomEnc() {
        return NomEnc;
    }

    public void setNomEnc(String nomEnc) {
        NomEnc = nomEnc;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getUnite() {
        return Unite;
    }

    public void setUnite(String unite) {
        Unite = unite;
    }

    public String getTele() {
        return Tele;
    }

    public void setTele(String tele) {
        Tele = tele;
    }

    public  String getPeriode(){
        return getDateDebut()+" à "+getDateFin();
    }
}
