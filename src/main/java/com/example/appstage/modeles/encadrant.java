package com.example.appstage.modeles;

public class encadrant {
    private int idEncadrant;
    private String nom, fonction, division, tel, unite;

    public encadrant(int idEncadrant, String nom, String fonction, String division, String unite, String tel){
        this.idEncadrant = idEncadrant;
        this.nom = nom;
        this.fonction = fonction;
        this.division = division;
        this.unite=unite;
        this.tel = tel;
    }
    public encadrant(int idEncadrant, String nom, String fonction, String division){
        this.idEncadrant = idEncadrant;
        this.nom = nom;
        this.fonction = fonction;
        this.division = division;
        this.unite="";
        this.tel="";
    }
    public encadrant(String nom, String fonction, String division, String unite, String tel){
        this.nom = nom;
        this.fonction = fonction;
        this.division = division;
        this.unite=unite;
        this.tel = tel;
    }

    public int getIdEncadrant() {
        return idEncadrant;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFonction() {
        return fonction;
    }
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getDivision() {
        return division;
    }
    public void setDivision(String division) {
        this.division = division;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
}
