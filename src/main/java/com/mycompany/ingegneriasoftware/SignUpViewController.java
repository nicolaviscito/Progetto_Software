/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utenteContatto.ElencoUtenti;
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
    
    ///< Attributi per l'interfaccia grafica della registrazione utente ideati e scritti da Giuseppe Messalino.
    private ElencoUtenti elencoUtenti = new ElencoUtenti();

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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        salvaUserInfoCSV();

        ///< Chiusura dell'interfaccia "SignUpView" e apertura dell'interfaccia "RubricaView".
        InitBindings.stage.close();
        InitBindings.openNewStage(new Scene(App.loadFXML("RubricaView")));
    }
    
    /**
     * @brief Metodo per la scrittura delle informazioni riguardanti gli utenti che si registrano.
     *
     * Questo metodo permette di scrivere le informazioni richieste, che l'utente inserisce nell'interfaccia dedicata alla registrazione utente,
     * in un file esterno "ElencoUtenti.csv".
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito.
     * @throws IOException 
     */
    public void salvaUserInfoCSV() throws IOException{

        ///< Istanziamento di due oggetti "PrintWriter", "BufferedWriter" e "FileWriter" per la scrittura sul file "ElencoUtenti.csv".
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ElencoUtenti.csv" , true)))){
            ///< Scrittura delle informazioni nel file esterno.
            pw.append(nameField.getText());
            pw.append(";");
            pw.append(surnameField.getText());
            pw.append(";");
            pw.append(usernameField.getText());
            pw.append(";");
            pw.append(passwordField.getText());
            pw.append(";");
            pw.append(phoneField.getText());
            pw.append(";");
            pw.append(mailField.getText());
            pw.append('\n');
        }
    }
    
    /**
     * @brief Metodo per leggere le informazioni degli utenti in un file esterno.
     * 
     * Questo metodo accede al file esterno "ElencoUtenti.csv" dove sono state salvate tutte le informazioni associate ad un utente
     * attraverso il metodo "salvaUserInfoCSV()".
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return L'elenco degli utenti registrati.
     * 
     * @author Nicola Viscito.
     * @throws IOException 
     */
    
    public static ElencoUtenti leggiUserInfoCSV() throws IOException{
        
        ElencoUtenti eu = new ElencoUtenti();
        
        ///< Istanziamento di due oggetti "Bufferedreader" e "FileReader" per la lettura del file "ElencoUtenti.csv".
        try(BufferedReader br = new BufferedReader(new FileReader("ElencoUtenti.csv"))){
            
            ///< Controllo per vedere se il file è terminato.
            if(br.readLine() == null)
                return eu;
            
            ///< Codice per comporre la lista di utenti che sono stati aggiungi nel file esterno "ElencoUtenti.csv".
            String line;
            while((line = br.readLine()) != null){
                String campi[] = line.split(";");
                Utente u = new Utente(campi[0], campi[1], campi[2], campi[3], campi[4], campi[5]);
                eu.aggiungiUtente(u);
            }
        }
        return eu;
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
    
    public void RegistraUtente() throws IOException{
        
        ///< Creazione del nuovo utente, a cui passiamo i parametri presi dai TextFields dell'interfaccia di registrazione utente "SignUpView".
        Utente u = new  Utente(nameField.getText(), surnameField.getText(), usernameField.getText(), passwordField.getText(), mailField.getText(), phoneField.getText());
        
        ///< Aggiunta dell'utente appena creato alla lista degli utenti.
        elencoUtenti.aggiungiUtente(u);
        
        ///< Modifica del file esterno: aggiuta delle informazioni del nuovo utente.
        salvaUserInfoCSV();
    }
}
