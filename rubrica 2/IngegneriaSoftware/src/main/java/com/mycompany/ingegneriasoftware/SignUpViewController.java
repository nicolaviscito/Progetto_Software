/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneriasoftware;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utenteContatto.ElencoUtenti;
import utenteContatto.Utente;

/**
 * FXML Controller class
 *
 * @author 39334
 */
public class SignUpViewController implements Initializable {
    
    ElencoUtenti elencoUtenti = new ElencoUtenti();

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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openMailView(ActionEvent event) throws IOException {
        salvaUserInfoCSV();
    }
    
    private void salvaUserInfoCSV() throws IOException{
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ElencoUtenti.csv")))){
            pw.println("USERNAME;PASSWORD");
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
        catch(EOFException ex){
            System.out.println("Fine file");
        }
        /**
         * dopo aver scritto le informaizoni dell'utente nel file "ElencoUtenti.csv", l'interfaccia "SignUpView" si chiude 
         * e si apre l'interfaccia della rubrica.
         */
    }
    
    private ElencoUtenti leggiUserInfoCSV() throws IOException{
        ElencoUtenti eu = new ElencoUtenti();
        
        try(BufferedReader br = new BufferedReader(new FileReader("ElencoUtenti.csv"))){
            if(br.readLine() == null)
                return eu;
            
            String line;
            while((line = br.readLine()) != null){
                String campi[] = line.split(";");
                Utente u = new Utente(campi[0], campi[1], campi[2], campi[3], campi[4], campi[5]);
                eu.aggiungiUtente(u);
            }
        }
        return eu;
    }
    
}
