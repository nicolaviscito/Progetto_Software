/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utenteContatto;

/**
 * @file Utente.java
 * @brief Classe per la gestione dell'utente.
 * 
 * Questa classe si occupa di gestire l'utente e di implementare tutti i suoi metodi derivanti.
 * 
 * @author Nicola Viscito, Poalo Vitale, Giuseppe Messalino.
 * @date December 10, 2024. 
 */
public class Utente {
    
    ///< Attributi: un Nome, un Cognome, un Username, una Password, un'E-Mail, un Numerdo di telefono e un elenco di contatti, ideati da: Nicola Viscito, Poalo Vitale, Giuseppe Messalino.
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String numtel;
    
    /**
     * @brief Costruttore senza paramteri.
     */
    public Utente(){
        
    }
    /**
     * @brief Costruttore: inizializza tutti gli attributi.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @retutn Nessun valore di ritorno.
     */ 
    public Utente(String name, String surname, String username, String password, String email, String numtel) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.numtel = numtel;
    }
    
    /**
     * @brief Questo metodo "getName()" restituisce il nome di un utente.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna il nome di un utente.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * @brief Questo metodo "getSurname()" restituisce il cognome di un utente.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna il cognome di un utente.
     */
    public String getSurname() {
        return this.surname;
    }
    
    /**
     * @brief Questo metodo "getUsername()" restituisce l'username di un utente.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna l'username di un utente.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @brief Questo metodo "getPassword()" restituisce la password di un utente.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna la password di un utente.
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     * @brief Questo metodo "getEmail()" restituisce l'E-Mail di un utente.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna l'E-Mail di un utente.
     */
    public String getEmail() {
        return this.email;
    }
    
    /**
     * @brief Questo metodo "getNumTel()" restituisce il numero di telefono di un utente.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna il numero di telefono di un utente.
     */
    public String getNumtel() {
        return this.numtel;
    }
    
    /**
     * @brief Questo metodo "setName()" associa a un utente un nome.
     * 
     * @param[in] name Il metodo prende in ingresso il nome da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @brief Questo metodo "setSurame()" associa a un utente un cognome.
     * 
     * @param[in] name Il metodo prende in ingresso il cognome da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @brief Questo metodo "setUsername()" associa a un utente un username.
     * 
     * @param[in] name Il metodo prende in ingresso l'username da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @brief Questo metodo "setPassword()" associa a un utente una password.
     * 
     * @param[in] name Il metodo prende in ingresso la password da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @brief Questo metodo "setEmail()" associa a un utente un'E-Mail.
     * 
     * @param[in] name Il metodo prende in ingresso l'E-Mail da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @brief Questo metodo "setNumTel()" associa a un utente un numero di telefono.
     * 
     * @param[in] name Il metodo prende in ingresso il numero di telefono da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }
}

