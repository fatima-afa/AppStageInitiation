package com.example.appstage.modeles;

public class stage {
    static int idStage=0;
    private String theme, type;
    private boolean observation, rapport, attestatoin ;

    public  stage (String theme, String type, boolean observation, boolean rapport, boolean attestation){
        this.idStage ++;
        this.theme = theme;
        this.type = type;
        this.observation = observation;
        this.rapport = rapport;
        this.attestatoin = attestation;
    }

    public int getIdStage() { return idStage; }

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

    public boolean isObservation() {
        return observation;
    }
    public void setObservation(boolean observation) {
        this.observation = observation;
    }

    public boolean isRapport() {
        return rapport;
    }
    public void setRapport(boolean rapport) {
        this.rapport = rapport;
    }

    public boolean isAttestatoin() {
        return attestatoin;
    }
    public void setAttestatoin(boolean attestatoin) {
        this.attestatoin = attestatoin;
    }
}
