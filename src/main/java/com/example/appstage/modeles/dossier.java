package com.example.appstage.modeles;

public class dossier {
    private int idDossier ;
    private String cin;
    private String photo;
    private String conventionStage;
    private String lettreRecommandation;
    private String assurance;
    private String demandeStage;
    private String engagement;
    private String cv;

    public dossier( int idDossier, String cin, String photo, String conventionStage, String lettreRecommandation, String assurance, String demandeStage,String engagement, String cv)
    {
        this.idDossier=idDossier;
        this.cin=cin;
        this.photo=photo;
        this.conventionStage=conventionStage;
        this.lettreRecommandation=lettreRecommandation;
        this.assurance=assurance;
        this.demandeStage=demandeStage;
        this.engagement=engagement;
        this.cv=cv;

    }

    public dossier(int idDossier, String photo)
    {
        this.idDossier=idDossier;
        this.photo=photo;

    }

    public int getIdDossier() {
        return idDossier;
    }

    public String getCin() {
        return cin;
    }

    public String getAssurance() {
        return assurance;
    }

    public String getPhoto() {
        return photo;
    }

    public String getConventionStage() {
        return conventionStage;
    }

    public String getDemandeStage() {
        return demandeStage;
    }

    public String getEngagement() {
        return engagement;
    }

    public String getLettreRecommandation() {
        return lettreRecommandation;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCv() {
        return cv;
    }

    public void setConventionStage(String conventionStage) {
        this.conventionStage = conventionStage;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public void setDemandeStage(String demandeStage) {
        this.demandeStage = demandeStage;
    }

    public void setIdDossier(int idDossier) {
        this.idDossier = idDossier;
    }

    public void setEngagement(String engagement) {
        this.engagement = engagement;
    }

    public void setLettreRecommandation(String lettreRecommandation) {
        this.lettreRecommandation = lettreRecommandation;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


}
