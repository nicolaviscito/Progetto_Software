/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ingegneriasoftware;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import utenteContatto.Contatto;
import utenteContatto.ElencoContatti;

/**
 * @file NewContactViewController.java
 * @brief Questa classe implementa l'interfaccia di creazione contatto.
 * 
 * Questa classe si occupa di gestire tutte le interazioni possibili che l'utente può avere con l'interfaccia grafica
 * che gestisce la creazione del contatto.
 *
 * @author Nicola Viscito.
 * @date December 09, 2024.
 */
public class NewContactViewController implements Initializable {
    
    ///< Attributi per l'interfaccia grafica della creazione contatto ideati e scritti da Nicola Viscito.
    private ElencoContatti elencoContatti;
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
        try {
            elencoContatti = leggiContattiInfoCSV();
        } catch (IOException ex) {}
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
     
            ///< Label di errore che viene mostrata se tutti e due i campi non sono stati riempiti.
            errorLabel.setTextFill(Color.RED);
            errorLabel.setText("Inserire almeno un nome o un cognome.");
        }
        else{
            
            ///< Creazione del nuovo contatto, a cui passiamo i parametri presi dai TextFields dell'interfaccia di creazione contatto "NewContactView".
            Contatto c = new Contatto(
                                    newNameField.getText().isEmpty() ? "" : newNameField.getText(),
                                    newSurnameField.getText().isEmpty() ? "" : newSurnameField.getText(),
                                    newEmail1Field.getText().isEmpty() ? "" : newEmail1Field.getText(),
                                    newEmail2Field.getText().isEmpty() ? "" : newEmail2Field.getText(),
                                    newEmail3Field.getText().isEmpty() ? "" : newEmail3Field.getText(),
                                    newTelephone1Field.getText().isEmpty() ? "" : newTelephone1Field.getText(),
                                    newTelephone2Field.getText().isEmpty() ? "" : newTelephone2Field.getText(),
                                    newTelephone3Field.getText().isEmpty() ? "" : newTelephone3Field.getText()
            );
            
            ///< Aggiunta del contatto appena creato alla lista dei contatti.
            elencoContatti.aggiungiContatto(c);
        
            ///< Modifica del file esterno: aggiuta delle informazioni del nuovo contatto.
            salvaContattoInfoCSV(c);
        
            ///< chiusura dell'interfaccia corrente "NewContactView" e apertura dell'interfaccia "RubricaView".
            UtilityClass.stage.close();
            UtilityClass.openNewStage(new Scene(App.loadFXML("RubricaView")));
            
        }
    } 
    
    /**
     * @brief Metodo per la scrittura delle informazioni riguardanti i contatti salvati.
     *
     * Questo metodo permette di scrivere le informazioni richieste, che l'utente inserisce nell'interfaccia dedicata alla creazione contatto,
     * in un file esterno "ElencoContatti.csv".
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito.
     * @throws IOException 
     */
    public void salvaContattiInfoCSV() throws IOException{
        
        ///< Istanziamento di due oggetti "PrintWriter", "BufferedWriter" e "FileWriter" per la scrittura sul file "ElencoContatti.csv".
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(UtilityClass.username + ".csv")))){
            
            ///< Scrittura delle informazioni nel file esterno.
            for(Contatto c : elencoContatti.getElencoContatti()){
                    if(c.getNome().equals("null"))
                        pw.append("null");
                    else pw.append(newNameField.getText());
                    
                    if(c.getCognome().equals("null"))
                        pw.append("null");
                    else pw.append(newSurnameField.getText());
                    
                    if(c.getEmail1().equals("null"))
                        pw.append("null");
                    else pw.append(newEmail1Field.getText());
                    
                    if(c.getEmail2().equals("null"))
                        pw.append("null");
                    else pw.append(newEmail2Field.getText());
                    
                    if(c.getEmail3().equals("null"))
                        pw.append("null");
                    else pw.append(newEmail3Field.getText());                                                                                                                              
                    
                    if(c.getNumTel1().equals("null"))
                        pw.append("null");
                    else pw.append(newTelephone1Field.getText());
                    
                    if(c.getNumTel2().equals("null"))
                        pw.append("null");
                    else pw.append(newTelephone2Field.getText());
                    
                    if(c.getNumTel3().equals("null"))
                        pw.append("null");
                    else pw.append(newTelephone3Field.getText());                    
            }
        }
    }
    
    public void salvaContattoInfoCSV(Contatto c) throws IOException{
        ///< Istanziamento di due oggetti "PrintWriter", "BufferedWriter" e "FileWriter" per la scrittura sul file "ElencoContatti.csv".
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(UtilityClass.username + ".csv")))){
            
            pw.println("NOME;COGNOME;EMAIL1;EMAIL2;EMAIL3;NUMERO DI TELEFONO1; NUMERO DI TELEFONO2; NUMERO DI TELEFONO3");
            ///< Scrittura delle informazioni nel file esterno.
                    if(c.getNome().equals("null"))
                        pw.append("null");
                    else pw.append(newNameField.getText());
                    
                    if(c.getCognome().equals("null"))
                        pw.append("null");
                    else pw.append(newSurnameField.getText());
                    
                    if(c.getEmail1().equals("null"))
                        pw.append("null");
                    else pw.append(newEmail1Field.getText());
                    
                    if(c.getEmail2().equals("null"))
                        pw.append("null");
                    else pw.append(newEmail2Field.getText());
                    
                    if(c.getEmail3().equals("null"))
                        pw.append("null");
                    else pw.append(newEmail3Field.getText());                                                                                                                              
                    
                    if(c.getNumTel1().equals("null"))
                        pw.append("null");
                    else pw.append(newTelephone1Field.getText());
                    
                    if(c.getNumTel2().equals("null"))
                        pw.append("null");
                    else pw.append(newTelephone2Field.getText());
                    
                    if(c.getNumTel3().equals("null"))
                        pw.append("null");
                    else pw.append(newTelephone3Field.getText());                    
        }
    }
    
    /**
     * @brief Metodo per leggere le informazioni dei contatti in un file esterno.
     * 
     * Questo metodo accede al file esterno "ElencoContatti.csv" dove sono state salvate tutte le informazioni associate ad un 
     * contatto attraverso il metodo "salvaContattiInfoCSV()".
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return L'elenco dei contatti.
     * 
     * @author Nicola Viscito.
     * @throws IOException 
     */
    public static ElencoContatti leggiContattiInfoCSV() throws IOException{
        ElencoContatti ec = new ElencoContatti();
        
        ///< Istanziamento di due oggetti "Bufferedreader" e "FileReader" per la lettura del file "ElencoUtenti.csv".
        try(BufferedReader br = new BufferedReader(new FileReader(UtilityClass.username + ".csv"))){
            
            ///< Controllo per vedere se il file è terminato.
            if(br.readLine() == null)
                return ec;
            
            ///< Codice per comporre la lista di utenti che sono stati aggiungi nel file esterno "ElencoUtenti.csv".
            String line;
            while((line = br.readLine()) != null){
                String campi[] = line.split(";");
                Contatto c = new Contatto(campi[0], campi[1], campi[2], campi[3], campi[4], campi[5], campi[6], campi[7]);
                ec.aggiungiContatto(c);
            }
        }
        return ec;
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene(App.loadFXML("RubricaView")));
    }
}

