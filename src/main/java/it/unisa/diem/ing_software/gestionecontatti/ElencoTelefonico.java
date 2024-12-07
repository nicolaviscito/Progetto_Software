package it.unisa.diem.ing_software.gestionecontatti;


import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paolo
 * 
 * 
 */

public class ElencoTelefonico {
    
    List<Contatto> rubrica;
    
    public ElencoTelefonico() {
        this.rubrica = new LinkedList<>();
    }
    
    
    /** Crea un contatto all'interno della rubrica telefonica
     * @param[in] c in ingresso l'oggetto di tipo Contatto che sarà creato  
    
     * non restituisce nulla
    */
    public void creaContatto() {
        
    }
    
    
    /** Elimina un contatto all'interno della rubrica telefonica
     * @param[in] c in ingresso l'oggetto di tipo Contatto che sarà eliminato  
    
     * non restituisce nulla
    */
    public void eliminaContatto(Contatto c) {
        
    }
    
    /** Modifica un contatto all'interno della rubrica telefonica
     * @param[in] c in ingresso l'oggetto di tipo Contatto che sarà modificato  
    
     * non restituisce nulla
    */
    public void modificaContatto(Contatto c) {
        
    }
    
    /** Cerca un contatto all'interno della rubrica telefonica, inserendo la sottostringa nella barra di ricerca
     * @param[in] c l'oggetto di tipo Contatto che sarà cercato nella rubrica  
    
     * @param[out] c l'oggetto di tipo Contatto che è stato trovato
     * 
     * restutuisce un'oggetto di tipo Contatto che rappresenta l'oggetto cercato.
    */
    public Contatto cercaContatto(String stringa) {
        
        Contatto c = new Contatto("Paolo", "Vitale");
        
        
        
        return c;
    }
}
