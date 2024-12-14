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
import utenteContatto.Contatto;
import utenteContatto.ElencoContatti;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bvisc
 */
public class ElencoContattiTest {

    /**
     * Test of getElencoContatti method, of class ElencoContatti.
     */
    @Test
    public void testGetElencoContatti() {
        System.out.println("getElencoContatti");
        ElencoContatti instance = new ElencoContatti();
        List<Contatto> expResult = new LinkedList<>();
        List<Contatto> result = instance.getElencoContatti();
        assertEquals(expResult, result);
    }

    /**
     * Test of aggiungiContatto method, of class ElencoContatti.
     */
    @Test
    public void testAggiungiContatto() {
        System.out.println("aggiungiContatto");
        Contatto expC = new Contatto("Piero", "Rossi", "pr1@gmail.com", "pr2@gmail.com", "pr3@gmail.com", "3451648603", "3341589034", "3398777704");
        ElencoContatti instance = new ElencoContatti();
        instance.aggiungiContatto(expC);
        assertTrue(instance.getElencoContatti().contains(expC));
    }

    /**
     * Test of removeContact method, of class ElencoContatti.
     */
    @Test
    public void testRemoveContact() {
        System.out.println("removeContact");
        Contatto expC = new Contatto("Piero", "Rossi", "pr1@gmail.com", "pr2@gmail.com", "pr3@gmail.com", "3451648603", "3341589034", "3398777704");
        ElencoContatti instance = new ElencoContatti();
        instance.aggiungiContatto(expC);
        instance.removeContact(expC);
        assertFalse(instance.getElencoContatti().contains(expC));
    }
    
}
