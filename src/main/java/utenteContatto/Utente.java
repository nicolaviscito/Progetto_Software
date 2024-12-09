/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utenteContatto;

/**
 *
 * @author bvisc
 */
public class Utente {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String numtel;
    private ElencoContatti elencoContatti;

    public Utente(String name, String surname, String username, String password, String email, String numtel) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.numtel = numtel;
        this.elencoContatti = new ElencoContatti();
    }
    
    public String getName() {
        return name;
    }
    
    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getNumtel() {
        return numtel;
    }

    public ElencoContatti getElencoContatti() {
        return elencoContatti;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public void setElencoContatti(ElencoContatti elencoContatti) {
        this.elencoContatti = elencoContatti;
    }
}

