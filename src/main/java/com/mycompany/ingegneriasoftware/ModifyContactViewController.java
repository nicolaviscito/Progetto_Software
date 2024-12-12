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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utenteContatto.Utente;

/**
 * FXML Controller class
 *
 * @author bvisc
 */
public class ModifyContactViewController implements Initializable {

    private NewContactViewController controller = new NewContactViewController();;
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
        // TODO
    }   

    @FXML
    private void modifyContact(ActionEvent event) throws IOException {
        for(Utente u : UtilityClass.leggiUserInfoCSV().getListaUtenti()){
            if(u.getUsername().equals(UtilityClass.username)){
                if(!newNameField.getText().isEmpty()){
                    u.setName(newNameField.getText());
                }
                if(!newSurnameField.getText().isEmpty()){
                    u.setSurname(newSurnameField.getText());
                }
                if(!newTelephone1Field.getText().isEmpty()){
                    u.setNumtel(newTelephone1Field.getText());
                }
                if(!newTelephone2Field.getText().isEmpty()){
                    u.setNumtel(newTelephone2Field.getText());
                }
                if(!newTelephone3Field.getText().isEmpty()){
                    u.setNumtel(newTelephone3Field.getText());
                }
                if(!newEmail1Field.getText().isEmpty()){
                    u.setEmail(newEmail1Field.getText());
                }
                if(!newEmail2Field.getText().isEmpty()){
                    u.setEmail(newEmail2Field.getText());
                }
                if(!newEmail3Field.getText().isEmpty()){
                    u.setEmail(newEmail3Field.getText());
                }
            }
        }
       controller.salvaContattiInfoCSV();
       UtilityClass.stage.close();
       UtilityClass.openNewStage(new Scene(App.loadFXML("ProfileView")));
    }
}