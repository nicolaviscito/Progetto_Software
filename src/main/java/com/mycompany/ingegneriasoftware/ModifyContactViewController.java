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
import javafx.scene.image.ImageView;
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
    private String selectionedContactSurname;
    
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
    @FXML
    private Button goBackButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        for(Contatto c : UtilityClass.elencoContatti.getElencoContatti()){
            newNameField.setText(c.getNome());
            newSurnameField.setText(c.getCognome());
            newTelephone1Field.setText(c.getNumTel1());
            newTelephone2Field.setText(c.getNumTel2());
            newTelephone3Field.setText(c.getNumTel3());
            newEmail1Field.setText(c.getEmail1());
            newEmail2Field.setText(c.getEmail2());
            newEmail3Field.setText(c.getEmail3());
            
            
        }
        selectionedContactName = RubricaViewController.selectionedName;
        selectionedContactSurname = RubricaViewController.selectionedSurname;
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
        if(newNameField.getText().isEmpty() && newSurnameField.getText().isEmpty()){
        
            ///< Label di errore che viene mostrata se almeno uno dei due campi non è stato riempito.
            errorLabel.setTextFill(Color.RED);
            errorLabel.setText("Inserire almeno un nome o un cognome.");
        }else{ 
            for(Contatto c : UtilityClass.elencoContatti.getElencoContatti()){
                if((selectionedContactName.equals(c.getNome())) &&
                        selectionedContactSurname.equals(c.getCognome())){
                    if(!newNameField.getText().isEmpty()){
                        c.setNome(newNameField.getText());
                        modificaEffettuata = true;
                    }else{
                        c.setNome("");
                        modificaEffettuata = true;
                    }
                
                    if(!newSurnameField.getText().isEmpty()){
                        c.setCognome(newSurnameField.getText());
                        modificaEffettuata = true;
                    }else{
                        c.setCognome("");
                        modificaEffettuata = true;
                    }
                
                    if(!newTelephone1Field.getText().isEmpty()){
                        c.setNumTel1(newTelephone1Field.getText());
                        modificaEffettuata = true;
                    }else{
                        c.setNumTel1("");
                        modificaEffettuata = true;
                    }
                
                    if(!newTelephone2Field.getText().isEmpty()){
                        c.setNumTel2(newTelephone2Field.getText());
                        modificaEffettuata = true;
                    }else{
                        c.setNumTel2("");
                        modificaEffettuata = true;
                    }
                
                    if(!newTelephone3Field.getText().isEmpty()){
                        c.setNumTel3(newTelephone3Field.getText());
                        modificaEffettuata = true;
                    }else{
                        c.setNumTel3("");
                        modificaEffettuata = true;
                    }
                
                    if(!newEmail1Field.getText().isEmpty()){
                        c.setEmail1(newEmail1Field.getText());
                        modificaEffettuata = true;
                    }else{
                        c.setEmail1("");
                        modificaEffettuata = true;
                    }
                
                    if(!newEmail2Field.getText().isEmpty()){
                        c.setEmail2(newEmail2Field.getText());
                        modificaEffettuata = true;
                    }else{
                        c.setEmail2("");
                        modificaEffettuata = true;
                    }
                
                    if(!newEmail3Field.getText().isEmpty()){
                        c.setEmail3(newEmail3Field.getText());
                        modificaEffettuata = true;
                    }else{
                        c.setEmail3("");
                        modificaEffettuata = true;
                    }
                    break;
                }
            }
        }
        
        ///< Prima di riscrivere tutto il file esterno si controlla se ci sono state delle modifiche.
        if(modificaEffettuata){
            ///< Riscrittura del file CSV con tutti i contatti aggiornati
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(UtilityClass.username + ".csv")))) {
                for (Contatto contatto : UtilityClass.elencoContatti.getElencoContatti()) {
                    pw.append(contatto.getNome().isEmpty() ? "" : contatto.getNome()).append(";");
                    pw.append(contatto.getCognome().isEmpty() ? "" : contatto.getCognome()).append(";");
                    pw.append(contatto.getNumTel1().isEmpty() ? "" : contatto.getNumTel1()).append(";");
                    pw.append(contatto.getNumTel2().isEmpty() ? "" : contatto.getNumTel2()).append(";");
                    pw.append(contatto.getNumTel3().isEmpty() ? "" : contatto.getNumTel3()).append(";");
                    pw.append(contatto.getEmail1().isEmpty() ? "" : contatto.getEmail1()).append(";");
                    pw.append(contatto.getEmail2().isEmpty() ? "" : contatto.getEmail2()).append(";");
                    pw.append(contatto.getEmail3().isEmpty() ? "" : contatto.getEmail3()).append(";");
                    pw.append('\n');
                }
            }
        }
        
        ///< Ritorno all'interfaccia "RubricaView".
        UtilityClass.elencoContatti = UtilityClass.leggiContattiInfoCSV();
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene(App.loadFXML("RubricaView")));
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
