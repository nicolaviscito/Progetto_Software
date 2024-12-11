/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ingegneriasoftware;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import utenteContatto.Utente;

/**
 * @file ProfileViewController.java
 * @brief Questa classe implementa l'interfaccia di visualizzazione del profilo.
 * 
 * Questa classe si occupa di gestire tutte le interazioni possibili che l'utente può avere con l'interfaccia grafica
 * che gestisce la la visualizzazione del profilo.
 *
 * @author Nicola Viscito e Giuseppe Messalino.
 * @date December 10, 2024.
 */
public class ProfileViewController implements Initializable {

    ///< Attributi per l'interfaccia grafica della visualizzazione del profilo ideati e scritti da Nicola Viscito e Giuseppe Messalino.
    @FXML
    private Label profileSurname;
    @FXML
    private Label profilePhone;
    @FXML
    private Label profileEmail;
    @FXML
    private Label profileUsername;
    @FXML
    private Label profilePassword;
    @FXML
    private Label profileName;
    @FXML
    private Button modifyProfileButton;
    @FXML
    private Button deleteProfileButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * @throws java.io.IOException
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            for(Utente u : UtilityClass.leggiUserInfoCSV().getListaUtenti()){
                if(u.getUsername().equals(UtilityClass.username)){
                    profileSurname.setText(u.getUsername());
                    profileName.setText(u.getName());
                    profileUsername.setText(u.getUsername());
                    profilePassword.setText(u.getPassword());
                    profileEmail.setText(u.getEmail());
                    profilePhone.setText(u.getNumtel());
                }
            }
        } catch (IOException ex) {
        }
    }    
    
    
    @FXML
    private void modifyProfile(ActionEvent event) throws IOException {
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene(App.loadFXML("ModifyUserView")));
    }

    @FXML
    private void deleteProfile(ActionEvent event) {
        
    }
}
