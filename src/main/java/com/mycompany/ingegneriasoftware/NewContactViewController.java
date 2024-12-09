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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private ElencoContatti elencoContatti = new ElencoContatti(); 
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        
        ///< Creazione del nuovo contatto, a cui passiamo i parametri presi dai TextFields dell'interfaccia di creazione contatto "NewContactView".
        Contatto c = new Contatto(newNameField.getText(), newSurnameField.getText(), 
                                  newEmail1Field.getText(), newEmail2Field.getText(),
                                  newEmail3Field.getText(), newTelephone1Field.getText(),
                                  newTelephone2Field.getText(), newTelephone3Field.getText());
        
        ///< Aggiunta del contatto appena creato alla lista dei contatti.
        elencoContatti.aggiungiContatto(c);
        
        ///< Modifica del file esterno: aggiuta delle informazioni del nuovo contatto.
        salvaContattiInfoCSV();
        
        
        InitBindings.stage.close();
        InitBindings.openNewStage(new Scene(App.loadFXML("RubricaView")));
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
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ElencoContatti.csv")))){
            
            ///< Scrittura delle informazioni nel file esterno.
            pw.println("NOME;COGNOME;E-MAIL1;E-MAIL2;E-MAIL3;NUMERO DI TELEFONO1;NUMERO DI TELEFONO2;NUMERO DI TELEFONO3");
            for(Contatto c : elencoContatti.getElencoTelefonico()){
                pw.append(c.getNome());
                pw.append(";");
                pw.append(c.getCognome());
                pw.append(";");
                pw.append(c.getEmail1());
                pw.append(";");
                pw.append(c.getEmail2());
                pw.append(";");
                pw.append(c.getEmail3());
                pw.append(";");
                pw.append(c.getNumTel1());
                pw.append(";");
                pw.append(c.getNumTel2());
                pw.append(";");
                pw.append(c.getNumTel3());
                pw.append('\n');
            }
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
        try(BufferedReader br = new BufferedReader(new FileReader("ElencoContatti.csv"))){
            
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
}

