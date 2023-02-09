package com.example.appstage.modeles;

import java.util.Date;

public class effectuer {
    private int idStagiaire;
    private int idStage ;
    private Date dateDebut;
    private Date dateFin;

    public effectuer(int idStagiaire, int idStage, Date dateDebut, Date dateFin)
    {
        this.idStagiaire=idStagiaire;
        this.idStage=idStage;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
    }

    public int getIdStage() {
        return idStage;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public int getIdStagiaire() {
        return idStagiaire;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

}
