package com.example.appstage.modeles;

public class demandeur {
    private int idDemandeur;
    private String nom;

    public demandeur(int idDemandeur, String nom){
        this.idDemandeur=idDemandeur;
        this.nom=nom;
    }

    public demandeur(String nom){
        this.idDemandeur=idDemandeur;
        this.nom=nom;
    }

    public int getIdDemandeur() {
        return idDemandeur;
    }
    public String getNom(){
        return nom;
    }
    public void setIdDemandeur(int idDemandeur)
    {
        this.idDemandeur=idDemandeur;
    }
    public void setNom(String nom)
    {
        this.nom=nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
