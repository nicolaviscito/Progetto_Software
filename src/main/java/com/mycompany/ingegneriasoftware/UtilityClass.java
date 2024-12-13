/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneriasoftware;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utenteContatto.ElencoUtenti;
import utenteContatto.Utente;

/**
 *
 * @author 39334
 */
public class UtilityClass {
    public static Stage stage;
    public static String username;
    public static ElencoUtenti elencoUtenti = new ElencoUtenti();
    
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
     * @return L'elenco degli utenti registrati.
     * 
     * @author Nicola Viscito.
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
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito , Giuseppe Messalino.
     * @throws IOException 
     */
    public static void salvaUserInfoCSV(Utente u) throws IOException{
        UtilityClass.username = u.getUsername();
        ///< Istanziamento di due oggetti "PrintWriter", "BufferedWriter" e "FileWriter" per la scrittura sul file "ElencoUtenti.csv".
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ElencoUtenti.csv" , true)))){
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
}
