/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utenteContatto;

/**
 *
 * @author bvisc
 */
public class Contatto {
    private String nome;
    private String cognome;
    private String email1;
    private String email2;
    private String email3;
    private String numTel1;
    private String numTel2;
    private String numTel3;
    
    public Contatto(String nome, String cognome, String email1, String email2, String email3, String numTel1, String numTel2, String numTel3){
        this.nome = nome;
        this.cognome = cognome;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.numTel1 = numTel1;
        this.numTel2 = numTel2;
        this.numTel3 = numTel3;
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

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getNumTel1() {
        return numTel1;
    }

    public String getNumTel2() {
        return numTel2;
    }

    public String getNumTel3() {
        return numTel3;
    }  

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public void setNumTel1(String numTel1) {
        this.numTel1 = numTel1;
    }

    public void setNumTel2(String numTel2) {
        this.numTel2 = numTel2;
    }

    public void setNumTel3(String numTel3) {
        this.numTel3 = numTel3;
    }
    
    
}
