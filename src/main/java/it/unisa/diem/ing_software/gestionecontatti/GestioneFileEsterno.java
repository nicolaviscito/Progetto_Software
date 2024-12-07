package it.unisa.diem.ing_software.gestionecontatti;


import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paolo
 * @brief Classe per la gestione del file esterno
 *      
 * Permette di gestire il salvataggio e il caricamente dell'intera rubrica da/su file esterno.
 */
public class GestioneFileEsterno {
    
    ElencoTelefonico elenco;
    
   
    public GestioneFileEsterno() {
        this.elenco = new ElencoTelefonico();
    }
    
    /** Permette di salvare le informazioni riguardanti i contatti su un file esterno 
      * @param[in] filename stringa del nome del file esterno su cui salvare le informazioni
      
      * non restituisce nulla
    */
    public void salvaFile(String filename) {
        
    }
    
    /** Permette di caricare le informazioni riguardanti i contatti da file 
      * @param[in] filename stringa del nome del file esterno da cui caricare le informazioni
      * 
      * restiuisce l'elenco telefonico
    */
    
    public static ElencoTelefonico leggiFile(String filename) {
        
        ElencoTelefonico e = new ElencoTelefonico();
        
        
        
        
        return e;
    }
}
