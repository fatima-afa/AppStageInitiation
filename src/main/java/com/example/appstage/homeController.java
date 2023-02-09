package com.example.appstage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static javafx.fxml.FXMLLoader.load;
public class homeController {
    public void stagiaireSpace(){
        Stage stage = new Stage() ;
        Parent root = null;
        try {
            root = load(Objects.requireNonNull(getClass().getResource("stagiaire.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("AppStage ") ;
        stage.show() ;
    }

    public void encadrantSpace(){
        Stage stage = new Stage() ;
        Parent root = null;
        try {
            root = load(Objects.requireNonNull(getClass().getResource("encadrant.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("AppStage ") ;
        stage.show() ;
    }
    public void serviceSpace(){
        Stage stage = new Stage() ;
        Parent root = null;
        try {
            root = load(Objects.requireNonNull(getClass().getResource("service.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("AppStage ") ;
        stage.show() ;
    }

    public void DemandeurSpace(){
        Stage stage = new Stage() ;
        Parent root = null;
        try {
            root = load(Objects.requireNonNull(getClass().getResource("demandeur.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("AppStage ") ;
        stage.show() ;
    }
    public void PrintSpace(){
        Stage stage = new Stage() ;
        Parent root = null;
        try {
            root = load(Objects.requireNonNull(getClass().getResource("imprimer.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("AppStage ") ;
        stage.show() ;
    }
    public void StatisticSpace(){
        Stage stage = new Stage() ;
        Parent root = null;
        try {
            root = load(Objects.requireNonNull(getClass().getResource("statistics.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("AppStage ") ;
        stage.show() ;
    }
    public void BDSpace(){
        Stage stage = new Stage() ;
        Parent root = null;
        try {
            root = load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root) ;
        stage.setScene(scene);
        stage.setTitle("AppStage ") ;
        stage.show() ;
    }
}
