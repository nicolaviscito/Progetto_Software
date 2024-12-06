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

/**
 * FXML Controller class
 *
 * @author 39334
 */
public class LoginViewController implements Initializable {

    @FXML
     PasswordField passwordField;
    @FXML
     TextField usernameField;
    @FXML
     Label errorLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openMailView(ActionEvent event) throws IOException {
        
    }

    @FXML
    private void openSignUpView(ActionEvent event) throws IOException {
        InitBindings.stage.close();
        InitBindings.initBindings(new Scene(App.loadFXML("SignUpView")));
    }
    
}
