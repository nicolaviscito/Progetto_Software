/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.ingegneriasoftwareTest;

import com.mycompany.ingegneriasoftware.SignUpViewController;
import com.mycompany.ingegneriasoftware.UtilityClass;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import utenteContatto.ElencoUtenti;
import utenteContatto.Utente;

class SignUpControllerTest {

    private TextField nameField;
    private TextField surnameField;
    private TextField phoneField;
    private TextField mailField;
    private TextField usernameField;
    private TextField passwordField;
    private Label errorLabel;

    private UtilityClass utilityClass;

    @BeforeEach
    void setUp() {
        nameField = new TextField();
        surnameField = new TextField();
        phoneField = new TextField();
        mailField = new TextField();
        usernameField = new TextField();
        passwordField = new TextField();
        errorLabel = new Label();

        utilityClass = new UtilityClass();
        UtilityClass.elencoUtenti = new ElencoUtenti();
    }

    @Test
    void testRegistraUtente_UsernameUnico() throws IOException {
        nameField.setText("Nicola");
        surnameField.setText("Viscito");
        phoneField.setText("3451648603");
        mailField.setText("n.viscito@gmail.com");
        usernameField.setText("Nicola03");
        passwordField.setText("464372");

        // Chiamata al metodo da testare
        new SignUpViewController().RegistraUtente();

        // Verifica che l'utente sia stato aggiunto
        assertEquals(1, UtilityClass.elencoUtenti.getListaUtenti().size());
        Utente utente = UtilityClass.elencoUtenti.getListaUtenti().get(0);
        assertEquals("Nicola", utente.getName());
        assertEquals("Nicola03", utente.getUsername());
    }

    @Test
    void testRegistraUtente_UsernameDuplicato() throws IOException {
        Utente existingUser = new Utente("Nicola", "Viscito", "Nicola03", "464372", "n.viscito@gmail.com", "3451648603");
        UtilityClass.elencoUtenti.aggiungiUtente(existingUser);

        nameField.setText("Giuseppe");
        surnameField.setText("Messalino");
        phoneField.setText("3341589034");
        mailField.setText("g.messalino@gmail.com");
        usernameField.setText("Giuseppe03");
        passwordField.setText("838167");

        // Chiamata al metodo da testare
        new SignUpViewController().RegistraUtente();

        // Verifica che non sia stato aggiunto un nuovo utente
        assertEquals(1, UtilityClass.elencoUtenti.getListaUtenti().size());
        assertEquals(Color.RED, errorLabel.getTextFill());
        assertEquals("L'username inserito è già in uso.", errorLabel.getText());
    }

    @Test
    void testRegistraUtente_CampiVuoti() throws IOException {
        nameField.setText("");
        surnameField.setText("");
        phoneField.setText("");
        mailField.setText("");
        usernameField.setText("utente123");
        passwordField.setText("password123");

        // Chiamata al metodo da testare
        new SignUpViewController().RegistraUtente();

        // Verifica che l'utente sia stato aggiunto con campi null
        assertEquals(1, UtilityClass.elencoUtenti.getListaUtenti().size());
        Utente utente = UtilityClass.elencoUtenti.getListaUtenti().get(0);
        assertEquals("null", utente.getName());
        assertEquals("null", utente.getSurname());
        assertEquals("null", utente.getNumtel());
        assertEquals("null", utente.getEmail());
    }
}
