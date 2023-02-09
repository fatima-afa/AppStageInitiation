package com.example.appstage;

import com.example.appstage.dao.Interface;

import com.example.appstage.dao.InterfaceImp;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static javafx.fxml.FXMLLoader.load;

public class authentificationController {
    @FXML
    TextField txtUser;
    @FXML TextField txtPassword;
    private Interface inter;

    public void connecter() throws IOException {
        inter=new InterfaceImp();
        if(inter.connecter(txtUser.getText(),txtPassword.getText())){
            Stage stage = new Stage() ;
            Parent root =  load(Objects.requireNonNull(getClass().getResource("home.fxml")));
            Scene scene = new Scene(root) ;
            //scene.getStylesheets().add(getClass().getResource("style.css").toString()) ;
            //stage.getIcons().add(new Image("Presentation\\images\\300px.png"));

            stage.setScene(scene);
            stage.setTitle("AppStage ") ;
            stage.show() ;
            quitter();
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("User ou Password est incorrect !!");
            alert.show();
        }






    }

    public void quitter(){
        Stage stage = (Stage) txtPassword.getScene().getWindow();
        stage.close();
    }
}
