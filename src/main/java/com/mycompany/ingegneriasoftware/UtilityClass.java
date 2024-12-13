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
        try(BufferedReader reader = new BufferedReader(new FileReader("ElencoUtenti.csv"))){
            String line = reader.readLine();
            ///< Controllo per vedere se il file è vuoto.
            if(line == null){
                UtilityClass.elencoUtenti.aggiungiUtente(null);
                return;
            }
            
            do{
                String[] row = line.split(";");
                String name = (row.length > 0 && !row[0].isEmpty()) ? row[0] : "";
                String surname = (row.length > 1 && !row[1].isEmpty()) ? row[1] : "";
                String username = (row.length > 2 && !row[2].isEmpty()) ? row[2] : "";
                String password = (row.length > 3 && !row[3].isEmpty()) ? row[3] : "";
                String phone = (row.length > 4 && !row[4].isEmpty()) ? row[4] : "";
                String mail = (row.length > 5 && !row[5].isEmpty()) ? row[5] : "";
                Utente u = new Utente(name , surname , username , password , mail , phone);
                UtilityClass.elencoUtenti.aggiungiUtente(u);
            }while((line = reader.readLine()) != null);   
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
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("ElencoUtenti.csv" , true))){
            writer.write(u.getName());
            writer.write(";");
            writer.write(u.getSurname());
            writer.write(";");
            writer.write(u.getUsername());
            writer.write(";");
            writer.write(u.getPassword());
            writer.write(";");
            writer.write(u.getNumtel());
            writer.write(";");
            writer.write(u.getEmail());
            writer.write(";");
            writer.newLine();
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
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(UtilityClass.username + ".csv" , true))){
            writer.write(c.getNome());
            writer.write(";");
            writer.write(c.getCognome());
            writer.write(";");
            writer.write(c.getNumTel1());
            writer.write(";");
            writer.write(c.getNumTel2());
            writer.write(";");
            writer.write(c.getNumTel3());
            writer.write(";");
            writer.write(c.getEmail1());
            writer.write(";");
            writer.write(c.getEmail2());
            writer.write(";");
            writer.write(c.getEmail3());
            writer.write(";");
            writer.newLine();
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
        ElencoContatti e = new ElencoContatti();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(UtilityClass.username + ".csv"))){
            String line = reader.readLine();
            if(line == null)
                return e;
            
            do{
                String[] row = line.split(";");
                String name = (row.length > 0 && !row[0].isEmpty()) ? row[0] : "";
                String surname = (row.length > 1 && !row[1].isEmpty()) ? row[1] : "";
                String phone1 = (row.length > 2 && !row[2].isEmpty()) ? row[2] : "";
                String phone2 = (row.length > 3 && !row[3].isEmpty()) ? row[3] : "";
                String phone3 = (row.length > 4 && !row[4].isEmpty()) ? row[4] : "";
                String mail1 = (row.length > 5 && !row[5].isEmpty()) ? row[5] : "";
                String mail2 = (row.length > 6 && !row[6].isEmpty()) ? row[6] : "";
                String mail3 = (row.length > 7 && !row[7].isEmpty()) ? row[7] : "";
                Contatto c = new Contatto(name , surname , mail1 , mail2 , mail3 , phone1 , phone2 , phone3);
                e.aggiungiContatto(c);
            }while((line = reader.readLine()) != null);
        }
        return e;
    }
}
