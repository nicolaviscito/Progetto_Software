/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utenteContatto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author bvisc
 */
public class ElencoContatti {
    private List<Contatto> elencoContatti;
    
    public ElencoContatti(){
        this.elencoContatti = new LinkedList<>();
    }

    public List<Contatto> getElencoTelefonico() {
        return this.elencoContatti;
    }
    
    public void aggiungiContatto(Contatto c){
        this.elencoContatti.add(c);
    }
    
    public void salvaContattiInfoCSV() throws IOException{
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ElencoContatti.csv")))){
            pw.println("NOME;COGNOME;E-MAIL1;E-MAIL2;E-MAIL3;NUMERO DI TELEFONO1;NUMERO DI TELEFONO2;NUMERO DI TELEFONO3");
            for(Contatto c : elencoContatti){
                pw.append(c.getNome());
                pw.append(";");
                pw.append(c.getCognome());
                pw.append(";");
                pw.append(c.getEmail1());
                pw.append(";");
                pw.append(c.getEmail2());
                pw.append(";");
                pw.append(c.getEmail3());
                pw.append(";");
                pw.append(c.getNumTel1());
                pw.append(";");
                pw.append(c.getNumTel2());
                pw.append(";");
                pw.append(c.getNumTel3());
                pw.append('\n');
            }
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
     * @author Nicola Viscito.
     * @throws IOException 
     */
    
    public static ElencoContatti leggiContattiInfoCSV() throws IOException{
        ElencoContatti ec = new ElencoContatti();
        
        try(BufferedReader br = new BufferedReader(new FileReader("ElencoContatti.csv"))){
            if(br.readLine() == null)
                return ec;
            
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
