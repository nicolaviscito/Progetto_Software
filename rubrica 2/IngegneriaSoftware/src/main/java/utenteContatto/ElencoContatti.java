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
public class ElencoContatti {
    private List<Contatto> elencoTelefonico;
    
    public ElencoContatti(){
        this.elencoTelefonico = new LinkedList<>();
    }

    public List<Contatto> getElencoTelefonico() {
        return elencoTelefonico;
    }
    
    
}
