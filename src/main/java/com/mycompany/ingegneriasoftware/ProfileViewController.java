/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ingegneriasoftware;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifyProfile(ActionEvent event) {
    }

    @FXML
    private void deleteProfile(ActionEvent event) {
    }
}
