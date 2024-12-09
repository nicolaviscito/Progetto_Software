/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneriasoftware;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import utenteContatto.ElencoUtenti;
import utenteContatto.Utente;

/**
 * @file LoginViewController.java
 * @brief Questa classe implementa l'interfaccia di accesso.
 * 
 * Questa classe si occupa di gestire tutte le interazioni possibili che l'utente può avere con l'interfaccia grafica
 * che gestisce l'accesso dell'utente.
 *
 * @author Nicola Viscito e Giuseppe Messalino.
 * @date December 07, 2024.
 */
public class LoginViewController implements Initializable {
    
    ///< Attributi per l'interfaccia grafica dell'accesso utente ideati e scritti da Giuseppe Messalino.
    @FXML
     PasswordField passwordField;
    @FXML
     TextField usernameField;
    @FXML
     Label errorLabel;

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
     * @brief Metodo che gestisce l'accesso alla rubrica dell'utente.
     * 
     * Questo metodo implementa la logica di accesso alla rubrica dell'utente che inserisce le proprie credenziali ("Username e "Password")
     * nelle apposite caselle facendo un controllo per verificare se queste ultime siano uguali a quelle che sono satte salvate
     * nel file esterno "ElencoUtenti.csv" al momento della registrazione.
     * 
     * @param[in] event Il metodo prende in ingresso l'evento di pressione del tasto "SignIn".  
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito.
     * @throws IOException 
     */
    @FXML
    private void openMailView(ActionEvent event) throws IOException {
        
        ///< Accesso all'elenco dove sono stati inseriti tutti gli utenti e le informazioni associate.
        ElencoUtenti elencoUtenti = SignUpViewController.leggiUserInfoCSV();
        
        ///< Iterazione per fare il controllo su ognuno degli utenti presenti nell'elenco.
        for(Utente u : elencoUtenti.getListaUtenti()){
            
            ///< Controllo per verificare se "Username" e "Password" sono corretti.
            if((u.getUsername().equals(usernameField.getText())) && (u.getPassword().equals(passwordField.getText()))){
                
                //visualizza l'interfaccia della rubrica
                System.out.println("credenziali corrette"); //log per vedere se funziona bene il check
            }
            else{
                
                ///< Label di errore che viene mostrata se le credenziali non sono corrette.
                errorLabel.setTextFill(Color.RED);
                errorLabel.setText("Le credenziali inserite non sono valide.");
            }
        }
        InitBindings.stage.close();
        InitBindings.openNewStage(new Scene(App.loadFXML("RubricaView")));
    }

    @FXML
    private void openSignUpView(ActionEvent event) throws IOException {
        InitBindings.stage.close();
        InitBindings.openNewStage(new Scene(App.loadFXML("SignUpView")));
    }
    
}
