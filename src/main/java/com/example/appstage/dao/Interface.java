package com.example.appstage.dao;

import com.example.appstage.modeles.TreeClass;
import com.example.appstage.modeles.service;
import com.example.appstage.modeles.stagiaire;

import java.util.ArrayList;

public interface Interface {
    ArrayList<stagiaire> getAllStagiaires() ;

    ArrayList<TreeClass> getAllStagiairesByService(String serv) ;

    ArrayList<TreeClass> getAllStagiairesByEncadrant(String enc) ;

    ArrayList<service> getAllServices() ;


    boolean connecter(String user , String password);


    stagiaire getStagiaireByCNI(String cni) ;


    void addStagiaire(TreeClass t );



    void deleteStagiaire(TreeClass t );


    void updateStagiaire (TreeClass s );
}
