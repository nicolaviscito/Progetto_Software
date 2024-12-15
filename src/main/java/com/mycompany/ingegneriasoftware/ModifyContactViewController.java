/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ingegneriasoftware;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import utenteContatto.Contatto;
import utenteContatto.ElencoContatti;
import utenteContatto.Utente;

/**
 * @file ModifyContactViewController.java
 * @brief Questa classe implementa l'interfaccia di modifica del contatto.
 * 
 * Questa classe si occupa di gestire tutte le interazioni possibili che l'utente può avere con l'interfaccia grafica
 * che gestisce la modifica del contatto.
 * 
 * @author Nicola Viscito e Giuseppe Messalino, Paolo Vitale.
 * @date December 11, 2024.
 */
public class ModifyContactViewController implements Initializable {
    
    private RubricaViewController controllerRubrica = new RubricaViewController();
    
    /**
     * Attributi per l'interfaccia grafica della modifica del contatto e del contatto selezionato dalla rubrica,
     * nell'interfaccia "RubricaView", ideati e scritti da Giuseppe Messalino e Paolo Vitale.
     */
    private String selectionedContactName;
    
    @FXML
    private TextField newSurnameField;
    @FXML
    private TextField newNameField;
    @FXML
    private TextField newTelephone1Field;
    @FXML
    private TextField newTelephone2Field;
    @FXML
    private TextField newTelephone3Field;
    @FXML
    private TextField newEmail1Field;
    @FXML
    private TextField newEmail2Field;
    @FXML
    private TextField newEmail3Field;
    @FXML
    private Button modifyButton;
    @FXML
    private Label errorLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        selectionedContactName = RubricaViewController.selectionedName;
    }   

    /**
     * @brief Il metodo implementa la modifica di un contatto.
     * 
     * Questo metodo cerca nella lista di contatti corrispodente all'utente che ha fatto l'accesso, il contatto selezionato e, 
     * se è stata apportata qualche modifica, modifica il contatto, sia nel file esterno sia nella lista osservabile, per poi 
     * ritornare all'interfaccia "Rubrica View" per poter visualizzare le modifiche.
     * 
     * @param[in] event Il metodo prende in ingresso l'evento di pressione del tasto "Modifica".  
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito.
     * @throws IOException 
     */
    @FXML
    private void modifyContact(ActionEvent event) throws IOException {
        
        ///< Variabile booleana che serve per verificare se è stata effettuata una modfica a uno degli attributi del contatto selezionato.
        boolean modificaEffettuata = false;
        
        ///< Ricerca del contatto selezionato nella lista di contatti, con le conseguenti modifiche.
        for(Contatto c : UtilityClass.elencoContatti.getElencoContatti()){
            if((selectionedContactName.equals(c.getNome()))){
                if(!newNameField.getText().isEmpty()){
                    c.setNome(newNameField.getText());
                    modificaEffettuata = true;
                }
                if(!newSurnameField.getText().isEmpty()){
                    c.setCognome(newSurnameField.getText());
                    modificaEffettuata = true;
                }
                if(!newTelephone1Field.getText().isEmpty()){
                    c.setNumTel1(newTelephone1Field.getText());
                    modificaEffettuata = true;
                }
                if(!newTelephone2Field.getText().isEmpty()){
                    c.setNumTel2(newTelephone2Field.getText());
                    modificaEffettuata = true;
                }
                if(!newTelephone3Field.getText().isEmpty()){
                    c.setNumTel3(newTelephone3Field.getText());
                    modificaEffettuata = true;
                }
                if(!newEmail1Field.getText().isEmpty()){
                    c.setEmail1(newEmail1Field.getText());
                    modificaEffettuata = true;
                }
                if(!newEmail2Field.getText().isEmpty()){
                    c.setEmail2(newEmail2Field.getText());
                    modificaEffettuata = true;
                }
                if(!newEmail3Field.getText().isEmpty()){
                    c.setEmail3(newEmail3Field.getText());
                    modificaEffettuata = true;
                }
                break;
            }
        }
        
        ///< Prima di riscrivere tutto il file esterno si controlla se ci sono state delle modifiche.
        if(modificaEffettuata){
            ///< Riscrittura del file CSV con tutti i contatti aggiornati
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(UtilityClass.username + ".csv")))) {
                for (Contatto contatto : UtilityClass.elencoContatti.getElencoContatti()) {
                    pw.append(contatto.getNome().isEmpty() ? "null" : contatto.getNome()).append(";");
                    pw.append(contatto.getCognome().isEmpty() ? "null" : contatto.getCognome()).append(";");
                    pw.append(contatto.getEmail1().isEmpty() ? "null" : contatto.getEmail1()).append(";");
                    pw.append(contatto.getEmail2().isEmpty() ? "null" : contatto.getEmail2()).append(";");
                    pw.append(contatto.getEmail3().isEmpty() ? "null" : contatto.getEmail3()).append(";");
                    pw.append(contatto.getNumTel1().isEmpty() ? "null" : contatto.getNumTel1()).append(";");
                    pw.append(contatto.getNumTel2().isEmpty() ? "null" : contatto.getNumTel2()).append(";");
                    pw.append(contatto.getNumTel3().isEmpty() ? "null" : contatto.getNumTel3()).append(";");
                    pw.append('\n');
                }
            }
        }
        
        ///< Ritorno all'interfaccia "RubricaView".
        UtilityClass.elencoContatti = UtilityClass.leggiContattiInfoCSV();
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene(App.loadFXML("RubricaView")));
    }
}
