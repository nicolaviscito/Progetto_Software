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
public class Contatto {
    private String nome;
    private String cognome;
    private List<String> email;
    private List<String> numTel;
    
    public Contatto(String nome, String cognome, List<String> email, List<String> numTel){
        this.nome = nome;
        this.cognome = cognome;
        this.email = new LinkedList<>();
        this.numTel = new LinkedList<>();
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCognome(){
        return this.cognome;
    }

    public List<String> getEmail() {
        return email;
    }

    public List<String> getNumTel() {
        return numTel;
    }
    
    
                    
}
