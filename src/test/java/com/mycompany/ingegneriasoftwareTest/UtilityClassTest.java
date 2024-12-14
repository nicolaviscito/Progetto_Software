/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.ingegneriasoftware;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utenteContatto.Contatto;
import utenteContatto.ElencoContatti;
import utenteContatto.ElencoUtenti;
import utenteContatto.Utente;

import java.io.*;

/**
 * Test class for UtilityClass.
 */
public class UtilityClassTest {

    private static final String USER_FILE = "ElencoUtenti.csv";
    private static final String CONTACT_FILE = "testUser.csv";

    @BeforeEach
    void setUp() throws IOException {
        // Create test files
        try (PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE))) {
            writer.println("Nicola;Viscito;testUser;password;1234567890;test@example.com");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(CONTACT_FILE))) {
            writer.println("Poalo;Viatle;p.vitale1@gmail.com;;p.vitale3@gmail.com;;3398777704;;");
        }

        UtilityClass.username = "testUser";
    }

    @AfterEach
    void tearDown() {
        // Delete test files
        new File(USER_FILE).delete();
        new File(CONTACT_FILE).delete();
    }

    @Test
    void testLeggiUserInfoCSV() throws IOException {
        UtilityClass.leggiUserInfoCSV();

        ElencoUtenti elenco = UtilityClass.elencoUtenti;
        assertNotNull(elenco, "ElencoUtenti non dovrebbe essere uguale a null");
        assertEquals(1, elenco.getListaUtenti().size(), "ElencoUtenti dovrebbe contenere un utente");

        Utente user = elenco.getListaUtenti().get(0);
        assertEquals("testUser", user.getUsername(), "Gli Username dovrebbero essere uguali");
        assertEquals("Nicola", user.getName(), "I Name dovrebbero essere uguali");
        assertEquals("Viscito", user.getSurname(), "I Surname dovrebbero essere uguali");
    }

    @Test
    void testSalvaUserInfoCSV() throws IOException {
        Utente newUser = new Utente("Mario", "Rossi", "newUser", "newPassword", "0987654321", "mario.rossi@gmail.com");

        UtilityClass.salvaUserInfoCSV(newUser);

        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line = reader.readLine(); // Existing user
            assertNotNull(line);
            line = reader.readLine(); // New user
            assertNotNull(line);

            String[] fields = line.split(";");
            assertEquals("Mario", fields[0], "I Name dovrebbero essere uguali");
            assertEquals("Rossi", fields[1], "I Surname dovrebbero essere uguali");
            assertEquals("newUser", fields[2], "Gli Username dovrebbero essere uguali");
        }
    }

    @Test
    void testSalvaContattoInfoCSV() throws IOException {
        Contatto contact = new Contatto("Giuseppe", "Messalino", "g.messalino@gmail.com", "", "", "3341589034", "", "");

        UtilityClass.salvaContattoInfoCSV(contact);

        try (BufferedReader reader = new BufferedReader(new FileReader(CONTACT_FILE))) {
            String line = reader.readLine(); // Existing contact
            assertNotNull(line);
            line = reader.readLine(); // New contact
            assertNotNull(line);

            String[] fields = line.split(";");
            assertEquals("Giuseppe", fields[0], "I Name dovrebbero essere uguali");
            assertEquals("Messalino", fields[1], "I Surname dovrebbero essere uguali");
            assertEquals("g.messalino@gmail.com", fields[2], "Le Email dovrebbero essere uguali");
        }
    }

    @Test
    void testLeggiContattiInfoCSV() throws IOException {
        ElencoContatti elenco = UtilityClass.leggiContattiInfoCSV();

        assertNotNull(elenco, "ElencoContatti non dovrebbe essere uguale a null");
        assertEquals(1, elenco.getElencoContatti().size(), "ElencoContatti dovrebbe contenere un contatto");

        Contatto contact = elenco.getElencoContatti().get(0);
        assertEquals("Paolo", contact.getNome(), "I Nomi dei contatti dovrebbero essere uguali");
        assertEquals("Vitale", contact.getCognome(), "I Cognomi dei contatti dovrebbero essere uguali");
        assertEquals("p.vitale1@gmail.com", contact.getEmail1(), "Le Email dei contatti dovrebbero essere uguali");
    }
}