package com.example.appstage.modeles;

public class stagiaire {
    private String cni,nom,prenom, etablissement, specialite;
    private String nomEncadrant, intituleService, nomDemandeur;


    public stagiaire( String cni, String nom, String prenom, String etablissement, String specialite, String nomEncadrant, String intituleService, String nomDemandeur) {
        this.cni = cni;
        this.nom = nom;
        this.prenom = prenom;
        this.etablissement = etablissement;
        this.specialite = specialite;
        this.nomEncadrant = nomEncadrant;
        this.intituleService = intituleService;
        this.nomDemandeur = nomDemandeur;

    }

    public String getCni() {
        return cni;
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

    public void setIntituleService(String nomService) {
        this.intituleService = nomService;
    }

    public String getNomDemandeur() {
        return nomDemandeur;
    }

    public void setNomDemandeur(String nomDemandeur) {
        this.nomDemandeur = nomDemandeur;
    }



    @Override
    public String toString() {
        return nom  +" " +prenom ;
    }
}
