package com.example.appstage.modeles;

public class service {
    private int idService;
    private String intitule;

    public service (int idService, String intitule){
        this.idService = idService;
        this.intitule = intitule;
    }
    public service (String intitule){
        this.intitule = intitule;
    }

    public int getIdService() {
        return idService;
    }

    public String getIntitule() {
        return intitule;
    }
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}
