/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utenteContatto;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author bvisc
 */
public class ElencoUtenti {
    private List<Utente> elencoUtenti;
    
    public ElencoUtenti(){
        this.elencoUtenti = new LinkedList<>();
    }

    public List<Utente> getListaUtenti() {
        return elencoUtenti;
    }
    
    public void aggiungiUtente(Utente u){
        elencoUtenti.add(u);
    }
    
    public void modificaUtente(Utente u){
        
    }
}
