/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ingegneriasoftware;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import utenteContatto.Contatto;

/**
 * @file NewContactViewController.java
 * @brief Questa classe implementa l'interfaccia di creazione contatto.
 * 
 * Questa classe si occupa di gestire tutte le interazioni possibili che l'utente può avere con l'interfaccia grafica
 * che gestisce la creazione del contatto.
 *
 * @author Nicola Viscito e Giuseppe Messalino, Paolo Vitale.
 * @date December 09, 2024.
 */
public class NewContactViewController implements Initializable {
    
    ///< Attributi per l'interfaccia grafica della creazione contatto ideati e scritti da Nicola Viscito.
    @FXML
    private TextField newNameField;
    @FXML
    private TextField newTelephone1Field;
    @FXML
    private TextField newTelephone2Field;
    @FXML
    private TextField newTelephone3Field;
    @FXML
    private TextField newEmail3Field;
    @FXML
    private TextField newEmail2Field;
    @FXML
    private TextField newEmail1Field;
    @FXML
    private TextField newSurnameField;
    @FXML
    private Button createContactButton;
    @FXML
    private Label errorLabel;
    @FXML
    private Button BackButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    /**
     * @brief Metodo che crea un nuovo contatto.
     * 
     * Questo metodo implementa l'aggiunta di nuovi contatti all'interno del file esterno che gestisce una lista di contatti, in questo modo:
     * crea l'oggetto Contatto "c", lo aggiunge alla lista di contatti e aggiorna il file esterno con l'inserimento del nuovo contatto. 
     * 
     * @param[in] event Il metodo prende in ingresso l'evento di pressione del tasto "Crea".  
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito.
     * @throws IOException 
     */
    @FXML
    private void newCreateContact(ActionEvent event) throws IOException {
        if(newNameField.getText().isEmpty() && newSurnameField.getText().isEmpty()){
     
            ///< Label di errore che viene mostrata se almeno uno dei due campi non è stato riempito.
            errorLabel.setTextFill(Color.RED);
            errorLabel.setText("Inserire almeno un nome o un cognome.");
        }
        else{
            
            ///< Creazione del nuovo contatto, a cui passiamo i parametri presi dai TextFields dell'interfaccia di creazione contatto "NewContactView".
            Contatto c = new Contatto(
                                    newNameField.getText().isEmpty() ? "" : newNameField.getText(),
                                    newSurnameField.getText().isEmpty() ? "" : newSurnameField.getText(),
                                    newTelephone1Field.getText().isEmpty() ? "" : newTelephone1Field.getText(),
                                    newTelephone2Field.getText().isEmpty() ? "" : newTelephone2Field.getText(),
                                    newTelephone3Field.getText().isEmpty() ? "" : newTelephone3Field.getText(),
                                    newEmail1Field.getText().isEmpty() ? "" : newEmail1Field.getText(),
                                    newEmail2Field.getText().isEmpty() ? "" : newEmail2Field.getText(),
                                    newEmail3Field.getText().isEmpty() ? "" : newEmail3Field.getText()
                                    
            );
            
            ///< Aggiunta del contatto appena creato alla lista dei contatti.
            UtilityClass.elencoContatti.aggiungiContatto(c);
            
            ///< Modifica del file esterno: aggiuta delle informazioni del nuovo contatto.
            UtilityClass.salvaContattoInfoCSV(c);
            UtilityClass.elencoContatti = UtilityClass.leggiContattiInfoCSV();
            
            ///< Chiusura dell'interfaccia corrente "NewContactView" e apertura dell'interfaccia "RubricaView".
            UtilityClass.stage.close();
            UtilityClass.openNewStage(new Scene(App.loadFXML("RubricaView")));
            
        }
    } 
    
    /**
     * @brief Metodo per tornare all'interfaccia precedente: "RubricaView".
     *  
     * @param[in] event Il metodo prende in ingresso l'evento di pressione del bottone che indica una freccia che torna indietro.  
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito.
     * @throws IOException 
     */
    @FXML
    private void goBack(ActionEvent event) throws IOException {
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene(App.loadFXML("RubricaView")));
    }
}

