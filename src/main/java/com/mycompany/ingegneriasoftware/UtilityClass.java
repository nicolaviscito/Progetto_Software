/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneriasoftware;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utenteContatto.Contatto;
import utenteContatto.ElencoContatti;
import utenteContatto.ElencoUtenti;
import utenteContatto.Utente;

/**
 *
 * @author 39334
 */
public class UtilityClass {
    public static Stage stage;
    public static String username;
    
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
    public static ElencoUtenti leggiUserInfoCSV() throws IOException{

        ElencoUtenti eu = new ElencoUtenti();
        
        ///< Istanziamento di due oggetti "Bufferedreader" e "FileReader" per la lettura del file "ElencoUtenti.csv".
        try(BufferedReader br = new BufferedReader(new FileReader("ElencoUtenti.csv"))){
            
            ///< Controllo per vedere se il file è terminato.
            if(br.readLine() == null)
                return eu;
            
            ///< Codice per comporre la lista di utenti che sono stati aggiungi nel file esterno "ElencoUtenti.csv".
            String line;
            while((line = br.readLine()) != null){
                String campi[] = line.split(";");
                Utente u = new Utente(campi[0], campi[1], campi[2], campi[3], campi[4], campi[5]);
                eu.aggiungiUtente(u);
            }
        }
        return eu;
    }   
}


