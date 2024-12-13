/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ingegneriasoftware;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    @FXML
    private Button BackButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * @throws java.io.IOException
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        for(Utente u : UtilityClass.elencoUtenti.getListaUtenti()){
            if(u.getUsername().equals(UtilityClass.username)){
                profileSurname.setText(u.getUsername());
                profileName.setText(u.getName());
                profileUsername.setText(u.getUsername());
                profilePassword.setText(u.getPassword());
                profileEmail.setText(u.getEmail());
                profilePhone.setText(u.getNumtel());
            }
        }
    }    
    
    
    @FXML
    private void modifyProfile(ActionEvent event) throws IOException {
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene(App.loadFXML("ModifyUserView")));
    }

    /**
     * @brief Questo metodo implementa l'eliminazione dell'utente dalla lista di utenti.
     * 
     * @param[in] event Il metodo prende in ingresso l'evento di pressione del tasto "Elimina Profilo". 
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito, Giuseppe Messalino, Poalo Vitale.
     * @throws IOException 
     */
    @FXML
    private void deleteProfile(ActionEvent event) throws IOException {
        ///< Riferimento all'utente da eliminare.
        Utente utenteDaEliminare = null;
        
        ///< Scorrimento di tutta la lista per trovare l'utente da eliminare;
        for (Utente u : UtilityClass.elencoUtenti.getListaUtenti()) {
            if (u.getName().equals(profileName.getText()) &&
                u.getSurname().equals(profileSurname.getText()) &&
                u.getUsername().equals(profileUsername.getText()) &&
                u.getPassword().equals(profilePassword.getText()) &&
                u.getEmail().equals(profileEmail.getText()) &&
                u.getNumtel().equals(profilePhone.getText())) {
                utenteDaEliminare = u;  ///< Assegnazione dell'utente da eliminare in una variabile d'appoggio.
                break; // Esci dal ciclo dopo aver trovato il contatto
            }
        }
        
        ///< Rimozione dalla lista di utenti dell'utente da eliminare.
        if (utenteDaEliminare != null) {
            UtilityClass.elencoUtenti.getListaUtenti().remove(utenteDaEliminare);
        }
        
        ///< Riscrittura del file esterno.
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(UtilityClass.username + ".csv")))) {
            for (Utente utente : UtilityClass.elencoUtenti.getListaUtenti()) {
                pw.append(utente.getName().isEmpty() ? "null" : utente.getName()).append(";");
                pw.append(utente.getSurname().isEmpty() ? "null" : utente.getSurname()).append(";");
                pw.append(utente.getUsername().isEmpty() ? "null" : utente.getUsername()).append(";");
                pw.append(utente.getPassword().isEmpty() ? "null" : utente.getPassword()).append(";");
                pw.append(utente.getEmail().isEmpty() ? "null" : utente.getEmail()).append(";");
                pw.append(utente.getNumtel().isEmpty() ? "null" : utente.getNumtel()).append(";");
                pw.append('\n');
            }
        }
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene(App.loadFXML("RubricaView")));
    }
}
