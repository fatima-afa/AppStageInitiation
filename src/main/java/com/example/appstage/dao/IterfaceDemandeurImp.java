package com.example.appstage.dao;

import com.example.appstage.modeles.TreeClass;
import com.example.appstage.modeles.service;
import com.example.appstage.modeles.stagiaire;

import java.util.ArrayList;

public class IterfaceDemandeurImp implements InterfaceDemandeur{
    @Override
    public ArrayList<stagiaire> getAllStagiaires() {
        return null;
    }

    @Override
    public ArrayList<TreeClass> getAllStagiairesByService(String serv) {
        return null;
    }

    @Override
    public ArrayList<TreeClass> getAllStagiairesByEncadrant(String enc) {
        return null;
    }

    @Override
    public ArrayList<service> getAllServices() {
        return null;
    }

    @Override
    public boolean connecter(String user, String password) {
        return false;
    }

    @Override
    public stagiaire getStagiaireByCNI(String cni) {
        return null;
    }

    @Override
    public void addStagiaire(TreeClass t) {

    }

    @Override
    public void deleteStagiaire(TreeClass t) {

    }

    @Override
    public void updateStagiaire(TreeClass s) {

    }
}
