/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utenteContatto;

import java.util.LinkedList;
import java.util.List;

/**
 * @file ElencoUtenti.java
 * @brief Classe per la gestione dell'elenco degli utenti.
 * 
 * Questa classe si occupa di gestire l'elenco degli utenti e di implementare tutti i suoi metodi derivanti.
 * 
 * @author Nicola Viscito, Poalo Vitale, Giuseppe Messalino.
 * @date December 10, 2024. 
 */
public class ElencoUtenti {
    
    ///< Attributi: una lista che contiene elementi di tipo "Utente", ideata da: Nicola Viscito, Poalo Vitale, Giuseppe Messalino.
    private List<Utente> elencoUtenti;
    
     /**
     * @brief Costruttore: inizializza la lista di utenti come una lista di tipo "LinkedList".
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @retutn Nessun valore di ritorno.
     */ 
    public ElencoUtenti(){
        this.elencoUtenti = new LinkedList<>();
    }

    /**
     * @brief Questo metodo "getListaUtenti()" restituisce la lista di contatti.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna la lista degli uenti.
     */
    public List<Utente> getListaUtenti() {
        return elencoUtenti;
    }
    
    /**
     * @brief Questo metoto "aggiungiUtente(Utente u)" aggiunge un utente alla lista degli.
     * 
     * @param[in] Il metodo prende in ingresso l'utente da inserire nella lista.
     * @return Nessun valore di ritorno.
     */
    public void aggiungiUtente(Utente u){
        elencoUtenti.add(u);
    }
}
