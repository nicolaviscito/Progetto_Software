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
import utenteContatto.Contatto;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bvisc
 */
public class ContattoTest {
    
    /**
     * Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "Nicola";
        Contatto instance = new Contatto();
        instance.setNome(nome);
        String result = instance.getNome();
        assertEquals(nome, result);
    }

    /**
     * Test of setCognome method, of class Contatto.
     */
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        String cognome = "Viscito";
        Contatto instance = new Contatto();
        instance.setCognome(cognome);
        String result = instance.getNome();
        assertEquals(cognome, result);
    }

    /**
     * Test of getNome method, of class Contatto.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Contatto instance = new Contatto("Piero", "Rossi", "pr1@gmail.com", "pr2@gmail.com", "pr3@gmail.com", "3451648603", "3341589034", "3398777704");
        String expResult = "Piero";
        String result = instance.getNome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCognome method, of class Contatto.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        Contatto instance = new Contatto("Piero", "Rossi", "pr1@gmail.com", "pr2@gmail.com", "pr3@gmail.com", "3451648603", "3341589034", "3398777704");
        String expResult = "Rossi";
        String result = instance.getCognome();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail1 method, of class Contatto.
     */
    @Test
    public void testGetEmail1() {
        System.out.println("getEmail1");
        Contatto instance = new Contatto("Piero", "Rossi", "pr1@gmail.com", "pr2@gmail.com", "pr3@gmail.com", "3451648603", "3341589034", "3398777704");
        String expResult = "pr1@gmail.com";
        String result = instance.getEmail1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail2 method, of class Contatto.
     */
    @Test
    public void testGetEmail2() {
        System.out.println("getEmail2");
        Contatto instance = new Contatto("Piero", "Rossi", "pr1@gmail.com", "pr2@gmail.com", "pr3@gmail.com", "3451648603", "3341589034", "3398777704");
        String expResult = "pr2@gmail.com";
        String result = instance.getEmail2();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail3 method, of class Contatto.
     */
    @Test
    public void testGetEmail3() {
        System.out.println("getEmail3");
        Contatto instance = new Contatto("Piero", "Rossi", "pr1@gmail.com", "pr2@gmail.com", "pr3@gmail.com", "3451648603", "3341589034", "3398777704");
        String expResult = "pr3@gmail.com";
        String result = instance.getEmail3();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumTel1 method, of class Contatto.
     */
    @Test
    public void testGetNumTel1() {
        System.out.println("getNumTel1");
        Contatto instance = new Contatto("Piero", "Rossi", "pr1@gmail.com", "pr2@gmail.com", "pr3@gmail.com", "3451648603", "3341589034", "3398777704");
        String expResult = "3451648603";
        String result = instance.getNumTel1();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumTel2 method, of class Contatto.
     */
    @Test
    public void testGetNumTel2() {
        System.out.println("getNumTel2");
        Contatto instance = new Contatto("Piero", "Rossi", "pr1@gmail.com", "pr2@gmail.com", "pr3@gmail.com", "3451648603", "3341589034", "3398777704");
        String expResult = "3341589034";
        String result = instance.getNumTel2();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumTel3 method, of class Contatto.
     */
    @Test
    public void testGetNumTel3() {
        System.out.println("getNumTel3");
        Contatto instance = new Contatto("Piero", "Rossi", "pr1@gmail.com", "pr2@gmail.com", "pr3@gmail.com", "3451648603", "3341589034", "3398777704");
        String expResult = "3398777704";
        String result = instance.getNumTel3();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail1 method, of class Contatto.
     */
    @Test
    public void testSetEmail1() {
        System.out.println("setEmail1");
        String email1 = "gr1@gmail.com";
        Contatto instance = new Contatto();
        instance.setEmail1(email1);
        String result = instance.getEmail1();
        assertEquals(email1, result);
    }

    /**
     * Test of setEmail2 method, of class Contatto.
     */
    @Test
    public void testSetEmail2() {
        System.out.println("setEmail2");
        String email2 = "gr2@gmail.com";
        Contatto instance = new Contatto();
        instance.setEmail1(email2);
        String result = instance.getEmail2();
        assertEquals(email2, result);
    }

    /**
     * Test of setEmail3 method, of class Contatto.
     */
    @Test
    public void testSetEmail3() {
        System.out.println("setEmail3");
        String email3 = "gr3@gmail.com";
        Contatto instance = new Contatto();
        instance.setEmail1(email3);
        String result = instance.getEmail3();
        assertEquals(email3, result);
    }

    /**
     * Test of setNumTel1 method, of class Contatto.
     */
    @Test
    public void testSetNumTel1() {
        System.out.println("setNumTel1");
        String numTel1 = "3876475489";
        Contatto instance = new Contatto();
        instance.setNumTel1(numTel1);
        String result = instance.getNumTel1();
        assertEquals(numTel1, result);
    }

    /**
     * Test of setNumTel2 method, of class Contatto.
     */
    @Test
    public void testSetNumTel2() {
        System.out.println("setNumTel2");
        String numTel2 = "3198498129";
        Contatto instance = new Contatto();
        instance.setNumTel1(numTel2);
        String result = instance.getNumTel2();
        assertEquals(numTel2, result);
    }

    /**
     * Test of setNumTel3 method, of class Contatto.
     */
    @Test
    public void testSetNumTel3() {
        System.out.println("setNumTel3");
        String numTel3 = "3850251438";
        Contatto instance = new Contatto();
        instance.setNumTel3(numTel3);
        String result = instance.getNumTel3();
        assertEquals(numTel3, result);
    }
}
