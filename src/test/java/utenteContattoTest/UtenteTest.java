/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package utenteContattoTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utenteContatto.Utente;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bvisc
 */
public class UtenteTest {

    /**
     * Test of getName method, of class Utente.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Utente instance = new Utente("Nicola", "Viscito", "Nicola03", "123456", "nv@gmail.com", "3451648603");
        String expResult = "Nicola";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSurname method, of class Utente.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getSurname");
        Utente instance = new Utente("Nicola", "Viscito", "Nicola03", "123456", "nv@gmail.com", "3451648603");
        String expResult = "Viscito";
        String result = instance.getSurname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class Utente.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Utente instance = new Utente("Nicola", "Viscito", "Nicola03", "123456", "nv@gmail.com", "3451648603");
        String expResult = "Nicola03";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class Utente.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Utente instance = new Utente("Nicola", "Viscito", "Nicola03", "123456", "nv@gmail.com", "3451648603");
        String expResult = "123456";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Utente.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Utente instance = new Utente("Nicola", "Viscito", "Nicola03", "123456", "nv@gmail.com", "3451648603");
        String expResult = "nv@gmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumtel method, of class Utente.
     */
    @Test
    public void testGetNumtel() {
        System.out.println("getNumtel");
        Utente instance = new Utente("Nicola", "Viscito", "Nicola03", "123456", "nv@gmail.com", "3451648603");
        String expResult = "3451648603";
        String result = instance.getNumtel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Utente.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Giampiero";
        Utente instance = new Utente();
        instance.setName(name);
        String result = instance.getName();
        assertEquals(name, result);
    }

    /**
     * Test of setSurname method, of class Utente.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setSurname");
        String surname = "Lambiase";
        Utente instance = new Utente();
        instance.setSurname(surname);
        String result = instance.getSurname();
        assertEquals(surname, result);
    }

    /**
     * Test of setUsername method, of class Utente.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "GMPLamb";
        Utente instance = new Utente();
        instance.setUsername(username);
        String result = instance.getUsername();
        assertEquals(username, result);
    }

    /**
     * Test of setPassword method, of class Utente.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "123456789";
        Utente instance = new Utente();
        instance.setPassword(password);
        String result = instance.getPassword();
        assertEquals(password, result);
    }

    /**
     * Test of setEmail method, of class Utente.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "gmp@gmail.com";
        Utente instance = new Utente();
        instance.setEmail(email);
        String result = instance.getEmail();
        assertEquals(email, result);
    }

    /**
     * Test of setNumtel method, of class Utente.
     */
    @Test
    public void testSetNumtel() {
        System.out.println("setNumtel");
        String numtel = "3317524698";
        Utente instance = new Utente();
        instance.setNumtel(numtel);
        String result = instance.getNumtel();
        assertEquals(numtel, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
