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
public class ModifyUserViewController implements Initializable {

    private SignUpViewController controller = new SignUpViewController();;
    @FXML
    private TextField newSurnameField;
    @FXML
    private TextField newNameField;
    @FXML
    private Button modifyProfileButton;
    @FXML
    private TextField newEmailField;
    @FXML
    private TextField newPasswordField;
    @FXML
    private TextField newUsernameField;
    @FXML
    private TextField newTelephoneField;
    @FXML
    private Button BackButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifyProfile(ActionEvent event) throws IOException {
        for(Utente u : UtilityClass.leggiUserInfoCSV().getListaUtenti()){
            if(u.getUsername().equals(UtilityClass.username)){
                if(!newNameField.getText().isEmpty()){
                    u.setName(newNameField.getText());
                }
                if(!newSurnameField.getText().isEmpty()){
                    u.setSurname(newSurnameField.getText());
                }
                if(!newTelephoneField.getText().isEmpty()){
                    u.setNumtel(newTelephoneField.getText());
                }
                if(!newEmailField.getText().isEmpty()){
                    u.setEmail(newEmailField.getText());
                }
                if(!newUsernameField.getText().isEmpty()){
                    u.setUsername(newUsernameField.getText());
                }
                if(!newPasswordField.getText().isEmpty()){
                    u.setPassword(newPasswordField.getText());
                }
            }
        }
       controller.salvaUserInfoCSV();
       UtilityClass.stage.close();
       UtilityClass.openNewStage(new Scene(App.loadFXML("ProfileView")));
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene(App.loadFXML("ProfileView")));
    }
}