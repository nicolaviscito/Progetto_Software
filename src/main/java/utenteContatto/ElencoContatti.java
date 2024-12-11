/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utenteContatto;

import java.util.LinkedList;
import java.util.List;

/**
 * @file ElencoContatti.java
 * @brief Classe per la gestione dell'elenco dei contatti.
 * 
 * Questa classe si occupa di gestire l'elenco dei contatti e di implementare tutti i suoi metodi derivanti.
 * 
 * @author Nicola Viscito, Poalo Vitale, Giuseppe Messalino.
 * @date December 10, 2024. 
 */
public class ElencoContatti {
    
    ///< Attributi: una lista che contiene elementi di tipo "Contatto", ideata da: Nicola Viscito, Poalo Vitale, Giuseppe Messalino.
    private List<Contatto> elencoContatti;
    
    /**
     * @brief Costruttore: inizializza la lista di contatti come una lista di tipo "LinkedList".
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @retutn Nessun valore di ritorno.
     */ 
    public ElencoContatti(){
        this.elencoContatti = new LinkedList<>();
    }
    /**
     * @brief Questo metodo "getElencoContatti()" restituisce la lista di contatti.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna la lista di contatti.
     */
    public List<Contatto> getElencoContatti() {
        return this.elencoContatti;
    }
    
    /**
     * @brief Questo metoto "aggiungiContatto(Contatto c)" aggiunge un contatto alla lista di contatti.
     * 
     * @param[in] Il metodo prende in ingresso il contatto da inserire nella lista.
     * @return Nessun valore di ritorno.
     */
    public void aggiungiContatto(Contatto c){
        this.elencoContatti.add(c);
    }
}
