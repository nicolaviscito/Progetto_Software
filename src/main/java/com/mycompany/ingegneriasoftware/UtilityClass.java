/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneriasoftware;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utenteContatto.Contatto;
import utenteContatto.ElencoContatti;
import utenteContatto.ElencoUtenti;
import utenteContatto.Utente;

/**
 * @file UtiilityClass.java
 * @brief Classe in cui sono riportati e implementati i metodi che vengono usati più spessso.
 * 
 * @author Nicola Viscito, Giuseppe Messalino, Poalo Vitale.
 * @date December 13, 2024.
 */
public class UtilityClass {
    public static Stage stage;
    public static String username;  ///< Attributo per risalire all'utente che ha effettuato l'accesso.
    public static ElencoUtenti elencoUtenti = new ElencoUtenti();   ///< Attributo per risalire alla lista di utenti.
    public static ElencoContatti elencoContatti = new ElencoContatti(); ///< Attributo per risalire alla lista di contatti dell'utente che ha effettuato l'accesso.
    
    public static void openNewStage(Scene scene){
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * @brief Metodo per leggere le informazioni degli utenti in un file esterno.
     * 
     * Questo metodo accede al file esterno "ElencoUtenti.csv" dove sono state salvate tutte le informazioni associate ad un utente
     * attraverso il metodo "salvaUserInfoCSV()".
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito, Giuseppe Messalino, Poalo Vitale.
     * @throws IOException 
     */
    public static void leggiUserInfoCSV() throws IOException{
        
        ///< Istanziamento di due oggetti "Bufferedreader" e "FileReader" per la lettura del file "ElencoUtenti.csv".
        try(BufferedReader br = new BufferedReader(new FileReader("ElencoUtenti.csv"))){
            
            ///< Controllo per vedere se il file è terminato.
            if(br.readLine() == null)
                elencoUtenti = null;
            
            ///< Codice per comporre la lista di utenti che sono stati aggiungi nel file esterno "ElencoUtenti.csv".
            String line;
            while((line = br.readLine()) != null){
                String campi[] = line.split(";");
                Utente u = new Utente(campi[0], campi[1], campi[2], campi[3], campi[4], campi[5]);
                elencoUtenti.aggiungiUtente(u);
            }
        }
    }   
    
        /**
     * @brief Metodo per la scrittura delle informazioni riguardanti gli utenti che si registrano.
     *
     * Questo metodo permette di scrivere le informazioni richieste, che l'utente inserisce nell'interfaccia dedicata alla registrazione utente,
     * in un file esterno "ElencoUtenti.csv".
     * 
     * @param[in] u Il metodo prende in ingresso l'utente da inserire.
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito, Giuseppe Messalino, Poalo Vitale.
     * @throws IOException 
     */
    public static void salvaUserInfoCSV(Utente u) throws IOException{
        UtilityClass.username = u.getUsername();
        ///< Istanziamento di due oggetti "PrintWriter", "BufferedWriter" e "FileWriter" per la scrittura sul file "ElencoUtenti.csv".
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ElencoUtenti.csv")))){
            ///< Scrittura delle informazioni nel file esterno.
                pw.append(u.getName());
                pw.append(";");
                pw.append(u.getSurname());
                pw.append(";");
                pw.append(u.getUsername());
                pw.append(";");
                pw.append(u.getPassword());
                pw.append(";");
                pw.append(u.getNumtel());
                pw.append(";");
                pw.append(u.getEmail());
                pw.append(";");
                pw.append("\n");
            }
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(u.getUsername() + ".csv")))){}
    }
    
    /**
     * @brief Metodo per la scrittura delle informazioni riguardanti i contatti salvati.
     *
     * Questo metodo permette di scrivere le informazioni richieste, che l'utente inserisce nell'interfaccia dedicata alla creazione contatto,
     * in un file esterno "username_utente.csv".
     * 
     * @param[in] c Il metodo prende in ingresso il contatto da inserire.
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito, Giuseppe Messalino, Poalo Vitale.
     * @throws IOException 
     */
    public static void salvaContattoInfoCSV(Contatto c) throws IOException{
        ///< Istanziamento di due oggetti "PrintWriter", "BufferedWriter" e "FileWriter" per la scrittura sul file "ElencoContatti.csv".
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(UtilityClass.username + ".csv", true)))){
            ///< Scrittura delle informazioni nel file esterno.
                    if(c.getNome().equals("")){
                        pw.append("null");
                        pw.append(";");
                    }
                    else{
                        pw.append(c.getNome());
                        pw.append(";");
                    }

                    if(c.getCognome().equals("")){
                        pw.append("null");
                        pw.append(";");
                    }
                    else{
                        pw.append(c.getCognome());
                        pw.append(";");
                    }
                    
                    if(c.getEmail1().equals("")){
                        pw.append("null");
                        pw.append(";");
                    }
                    else {
                        pw.append(c.getEmail1());
                        pw.append(";");
                    }
                    
                    if(c.getEmail2().equals("")){
                        pw.append("null");
                        pw.append(";");
                    }   
                    else {
                        pw.append(c.getEmail2());
                        pw.append(";");
                    }
                    
                    if(c.getEmail3().equals("")){
                        pw.append("null");
                        pw.append(";");
                    }   
                    else {
                        pw.append(c.getEmail3());
                        pw.append(";");
                    }                                                                                                                              
                    
                    if(c.getNumTel1().equals("")){
                        pw.append("null");
                        pw.append(";");
                    } 
                    else{
                        pw.append(c.getNumTel1());
                        pw.append(";");
                    }
                    
                    if(c.getNumTel2().equals("")){
                        pw.append("null");
                        pw.append(";");
                    }   
                    else {
                        pw.append(c.getNumTel2());
                        pw.append(";");
                    }
                    
                    if(c.getNumTel3().equals("")){
                        pw.append("null");
                        pw.append(";");
                    }   
                    else{
                        pw.append(c.getNumTel3());
                        pw.append(";");
                    } 
                    pw.append('\n');
        }
    }
    
    /**
     * @brief Metodo per leggere le informazioni dei contatti in un file esterno.
     * 
     * Questo metodo accede al file esterno "ElencoContatti.csv" dove sono state salvate tutte le informazioni associate ad un 
     * contatto attraverso il metodo "salvaContattiInfoCSV()".
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return L'elenco dei contatti.
     * 
     * @author Nicola Viscito, Giuseppe Messalino, Poalo Vitale.
     * @throws IOException 
     */
    public static ElencoContatti leggiContattiInfoCSV() throws IOException{
        ElencoContatti ec = new ElencoContatti();
        
        ///< Istanziamento di due oggetti "Bufferedreader" e "FileReader" per la lettura del file "ElencoUtenti.csv".
        try(BufferedReader br = new BufferedReader(new FileReader(UtilityClass.username + ".csv"))){
            
            ///< Controllo per vedere se il file è terminato.
            if(br.readLine() == null)
                return ec;
            
            ///< Codice per comporre la lista di utenti che sono stati aggiungi nel file esterno "ElencoUtenti.csv".
            String line;
            while((line = br.readLine()) != null){
                String campi[] = line.split(";");
                Contatto c = new Contatto(campi[0], campi[1], campi[2], campi[3], campi[4], campi[5], campi[6], campi[7]);
                ec.aggiungiContatto(c);
            }
        }
        return ec;
    }
}
