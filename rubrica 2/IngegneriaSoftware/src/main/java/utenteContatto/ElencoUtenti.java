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
    private List<Utente> listaUtenti;
    
    public ElencoUtenti(){
        this.listaUtenti = new LinkedList<>();
    }

    public List<Utente> getListaUtenti() {
        return listaUtenti;
    }
    
    public void aggiungiUtente(Utente u){
        listaUtenti.add(u);
    }
    
    public void modificaUtente(Utente u){
        
    }
}
