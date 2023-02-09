package com.example.appstage.modeles;

import java.util.Date;

public class TreeClass {
    private String cni,nom,prenom, etablissement, specialite;
    private String nomEncadrant, intituleService, nomDemandeur;
    private String theme, type;
    private Date dateDebut;
    private Date dateFin;
    private long duree;

    public TreeClass(String cni, String nom, String prenom, String etablissement, String specialite, String nomEncadrant, String intituleService, String nomDemandeur, String theme, String type, Date dateDebut, Date dateFin) {
        this.cni = cni;
        this.nom = nom;
        this.prenom = prenom;
        this.etablissement = etablissement;
        this.specialite = specialite;
        this.nomEncadrant = nomEncadrant;
        this.intituleService = intituleService;
        this.nomDemandeur = nomDemandeur;
        this.theme = theme;
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        //this.duree = 1;
        this.duree =  (dd() / (1000 * 60 * 60 * 24)) % 365;
    }
    private long dd(){return getDateFin().getTime() - getDateDebut().getTime();}

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getNomEncadrant() {
        return nomEncadrant;
    }

    public void setNomEncadrant(String nomEncadrant) {
        this.nomEncadrant = nomEncadrant;
    }

    public String getIntituleService() {
        return intituleService;
    }

    public void setIntituleService(String intituleService) {
        this.intituleService = intituleService;
    }

    public String getNomDemandeur() {
        return nomDemandeur;
    }

    public void setNomDemandeur(String nomDemandeur) {
        this.nomDemandeur = nomDemandeur;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public long getDuree() {
        return duree;
    }
}
