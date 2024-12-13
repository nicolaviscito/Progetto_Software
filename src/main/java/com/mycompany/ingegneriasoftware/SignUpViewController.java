/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneriasoftware;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import utenteContatto.Utente;

/**
 * @file SingUpViewController.java
 * @brief Questa classe implementa l'interfaccia di registrazione utente.
 * 
 * Questa classe si occupa di gestire tutte le interazioni possibili che l'utente può avere con l'interfaccia grafica
 * che gestisce la registrazione dell'utente.
 *
 * @author Nicola Viscito e Giuseppe Messalino.
 * @date December 07, 2024.
 */
public class SignUpViewController implements Initializable {
    @FXML
    private Button confirmButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField surnameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField mailField;
    @FXML
    private Label errorLabel;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * 
     * @author Giuseppe Messalino.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       confirmButton.disableProperty().bind(
            Bindings.or(
                Bindings.and(Bindings.isEmpty(nameField.textProperty()), 
                            Bindings.isEmpty(surnameField.textProperty())),
                Bindings.or(Bindings.isEmpty(usernameField.textProperty()), 
                             Bindings.isEmpty(passwordField.textProperty()))
            )
        );
    }    

    /**
     * @brief Metodo per la gestione dell'interfaccia di registrazione utente
     * 
     * Questo metodo gestisce la scrittura del file esterno "ElencoUtenti.csv" e la chiusura dell'interfaccia di registrazione utente "SignUpView".
     * 
     * @param[in] event Il metodo prende in ingresso l'evento di pressione del tasto "Conferma".
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito.
     * @throws IOException 
     */
    @FXML
    private void openMailView(ActionEvent event) throws IOException {
        ///< Salva le informazioni prese dai TextField nell'interfaccia "SignUpView".
        if(RegistraUtente()){
            ///< Chiusura dell'interfaccia "SignUpView" e apertura dell'interfaccia "RubricaView".
            UtilityClass.stage.close();
            UtilityClass.openNewStage(new Scene(App.loadFXML("RubricaView")));            
        }


    }
       
    /**
     * @brief Metodo che effettua la registrazione di un nuovo utente.
     * 
     * Questo metodo implementa l'aggiunta di nuovi utenti all'interno del file esterno che gestisce una lista di utenti, in questo modo:
     * crea l'oggetto Utente "u", lo aggiunge alla lista di utenti e aggiorna il file esterno con l'inserimento del nuovo utente. 
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito.
     * @throws IOException 
     */
    
    public boolean RegistraUtente() throws IOException{
        /*for(Utente ut : UtilityClass.elencoUtenti.getListaUtenti()){
            if(ut.getUsername().equals(usernameField.getText())){
                errorLabel.setTextFill(Color.RED);
                errorLabel.setText("L'username inserito è già in uso.");
                return false;
            }
             else{*/
                ///< Creazione del nuovo utente, a cui passiamo i parametri presi dai TextFields dell'interfaccia di registrazione utente "SignUpView".
                Utente u = new  Utente(nameField.getText(), 
                                surnameField.getText(), 
                                usernameField.getText(), 
                                passwordField.getText(), 
                                mailField.getText(), 
                                phoneField.getText());
                ///< Aggiunta dell'utente appena creato alla lista degli utenti.
                UtilityClass.elencoUtenti.aggiungiUtente(u);
                ///< Modifica del file esterno: aggiuta delle informazioni del nuovo utente.
                UtilityClass.salvaUserInfoCSV(u);
                return true;
        //    }
       // }
        


    }
}
