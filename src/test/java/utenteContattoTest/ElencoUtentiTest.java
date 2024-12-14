/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package utenteContattoTest;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utenteContatto.ElencoUtenti;
import utenteContatto.Utente;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bvisc
 */
public class ElencoUtentiTest {

    /**
     * Test of getListaUtenti method, of class ElencoUtenti.
     */
    @Test
    public void testGetListaUtenti() {
        System.out.println("getListaUtenti");
        ElencoUtenti instance = new ElencoUtenti();
        List<Utente> expResult = new LinkedList<>();
        List<Utente> result = instance.getListaUtenti();
        assertEquals(expResult, result);
    }

    /**
     * Test of aggiungiUtente method, of class ElencoUtenti.
     */
    @Test
    public void testAggiungiUtente() {
        System.out.println("aggiungiUtente");
        Utente expU = new Utente("Nicola", "Viscito", "Nicola03", "123456", "nv@gmail.com", "3451648603");
        ElencoUtenti instance = new ElencoUtenti();
        instance.aggiungiUtente(expU);
        assertTrue(instance.getListaUtenti().contains(expU));
    }

    /**
     * Test of removeUtente method, of class ElencoUtenti.
     */
    @Test
    public void testRemoveUtente() {
        System.out.println("removeUtente");
        Utente expU = new Utente("Nicola", "Viscito", "Nicola03", "123456", "nv@gmail.com", "3451648603");
        ElencoUtenti instance = new ElencoUtenti();
        instance.aggiungiUtente(expU);
        instance.removeUtente(expU);
        assertFalse(instance.getListaUtenti().contains(expU));
    }
    
}
