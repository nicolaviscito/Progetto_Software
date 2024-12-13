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
import utenteContatto.Contatto;
import utenteContatto.ElencoContatti;
import utenteContatto.Utente;

/**
 * FXML Controller class
 *
 * @author bvisc
 */
public class ModifyContactViewController implements Initializable {
    
    private RubricaViewController controllerRubrica = new RubricaViewController();
    
    private Contatto selectionedContact;
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
        
        selectionedContact = controllerRubrica.getSelectionedContact();
    }   

    @FXML
    private void modifyContact(ActionEvent event) throws IOException {
        boolean modificaEffettuata = false;
        for(Contatto c : UtilityClass.leggiContattiInfoCSV().getElencoContatti()){
            if(selectionedContact.getNome().equals(c.getNome())){
                if(!newNameField.getText().isEmpty()){
                    selectionedContact.setNome(newNameField.getText());
                    modificaEffettuata = true;
                }
                if(!newSurnameField.getText().isEmpty()){
                    selectionedContact.setCognome(newSurnameField.getText());
                    modificaEffettuata = true;
                }
                if(!newTelephone1Field.getText().isEmpty()){
                    selectionedContact.setNumTel1(newTelephone1Field.getText());
                    modificaEffettuata = true;
                }
                if(!newTelephone2Field.getText().isEmpty()){
                    selectionedContact.setNumTel2(newTelephone2Field.getText());
                    modificaEffettuata = true;
                }
                if(!newTelephone3Field.getText().isEmpty()){
                    selectionedContact.setNumTel3(newTelephone3Field.getText());
                    modificaEffettuata = true;
                }
                if(!newEmail1Field.getText().isEmpty()){
                    selectionedContact.setEmail1(newEmail1Field.getText());
                    modificaEffettuata = true;
                }
                if(!newEmail2Field.getText().isEmpty()){
                    selectionedContact.setEmail2(newEmail2Field.getText());
                    modificaEffettuata = true;
                }
                if(!newEmail3Field.getText().isEmpty()){
                    selectionedContact.setEmail3(newEmail3Field.getText());
                    modificaEffettuata = true;
                }
                break;
            }
        }
        
        if(modificaEffettuata){
            ///< Riscrivi il file CSV con tutti i contatti aggiornati
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
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene(App.loadFXML("ProfileView")));
    }
}
