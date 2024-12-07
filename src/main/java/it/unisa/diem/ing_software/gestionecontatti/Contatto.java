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
 */
public class Contatto {
    
    private String nome;
    private String cognome;
    List<String> Email;
    List<String> NumTel;

    public Contatto(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.Email = new LinkedList<>();
        this.NumTel = new LinkedList<>();
    }

    /** Permette di ottenere il nome di un Contatto
     
    */
    public String getNome() {
        return this.nome;
    }
    
    /** Permette di ottenere il cognome di un Contatto
     
    */
    public String getCognome() {
        return this.cognome;
    }

    /** Permette di settare il nome di un Contatto
      * @param[in] nome stringa del nome del contatto che andrà settato
    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Permette di settare il cognome di un Contatto
      * @param[in] cognome stringa del cognome del contatto che andrà settato
    */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    /** Permette di ottenere l'intera lista delle Email
     
    */
    public List<String> getEmail() {
        return this.Email;
    }

    /** Permette di ottenere l'intera lista dei numeri di telefono
     
    */
    public List<String> getNumTel() {
        return this.NumTel;
    }
    
}
