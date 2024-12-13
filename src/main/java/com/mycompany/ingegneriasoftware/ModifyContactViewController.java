/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ingegneriasoftware;

import java.io.IOException;
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

    private ElencoContatti elencoContatti = new ElencoContatti();
    
    private RubricaViewController controllerRubrica = new RubricaViewController();
    
    private NewContactViewController controllerNuovoContatto = new NewContactViewController();
    
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
        try {
            // TODO
            elencoContatti = controllerNuovoContatto.leggiContattiInfoCSV();
        } catch (IOException ex) {}
        
        selectionedContact = controllerRubrica.getSelectionedContact();
    }   

    @FXML
    private void modifyContact(ActionEvent event) throws IOException {
        for(Contatto c : controllerNuovoContatto.leggiContattiInfoCSV().getElencoContatti()){
            if(selectionedContact.getNome().equals(c.getNome())){
                if(!newNameField.getText().isEmpty()){
                    selectionedContact.setNome(newNameField.getText());
                }
                if(!newSurnameField.getText().isEmpty()){
                    selectionedContact.setCognome(newSurnameField.getText());
                }
                if(!newTelephone1Field.getText().isEmpty()){
                    selectionedContact.setNumTel1(newTelephone1Field.getText());
                }
                if(!newTelephone2Field.getText().isEmpty()){
                    selectionedContact.setNumTel2(newTelephone2Field.getText());
                }
                if(!newTelephone3Field.getText().isEmpty()){
                    selectionedContact.setNumTel3(newTelephone3Field.getText());
                }
                if(!newEmail1Field.getText().isEmpty()){
                    selectionedContact.setEmail1(newEmail1Field.getText());
                }
                if(!newEmail2Field.getText().isEmpty()){
                    selectionedContact.setEmail2(newEmail2Field.getText());
                }
                if(!newEmail3Field.getText().isEmpty()){
                    selectionedContact.setEmail3(newEmail3Field.getText());
                }
            }
        }
       controllerNuovoContatto.salvaContattoInfoCSV(selectionedContact);
       UtilityClass.stage.close();
       UtilityClass.openNewStage(new Scene(App.loadFXML("ProfileView")));
    }
}
