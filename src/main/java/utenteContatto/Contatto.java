/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utenteContatto;

/**
 * @file Contatto.java
 * @brief Classe per la gestione del contatto.
 * 
 * Questa classe si occupa di gestire il contatto e di implementare tutti i suoi metodi derivanti.
 * 
 * @author Nicola Viscito, Poalo Vitale, Giuseppe Messalino.
 * @date December 10, 2024. 
 */
public class Contatto {
    
    ///< Attributi: attributi necessari a soddisfare le specifiche del progetto, ideati da: Nicola Viscito, Poalo Vitale, Giuseppe Messalino.
    private String nome;
    private String cognome;
    private String email1;
    private String email2;
    private String email3;
    private String numTel1;
    private String numTel2;
    private String numTel3;
    
    /**
     * @brief Costruttore: inizializza tutti gli attributi.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @retutn Nessun valore di ritorno.
     */ 
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
    
    /**
     * @brief Questo metodo "setNome()" associa a un contatto un nome.
     * 
     * @param[in] name Il metodo prende in ingresso il nome da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * @brief Questo metodo "setCognome()" associa a un contatto un cognome.
     * 
     * @param[in] name Il metodo prende in ingresso il cognome da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    
    /**
     * @brief Questo metodo "getNome()" restituisce il nome di un contatto.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna il nome di un contatto.
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * @brief Questo metodo "getCognome()" restituisce il cognome di un contatto.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna il cognome di un contatto.
     */
    public String getCognome(){
        return this.cognome;
    }
    
    /**
     * @brief Questo metodo "getEmail1()" restituisce l'E-Mail di un contatto.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna una delle E-Mail (la prima) di un contatto.
     */
    public String getEmail1() {
        return this.email1;
    }

    /**
     * @brief Questo metodo "getEmail2()" restituisce l'E-Mail di un contatto.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna una delle E-Mail (la seconda) di un contatto.
     */
    public String getEmail2() {
        return this.email2;
    }

    /**
     * @brief Questo metodo "getEmail3()" restituisce l'E-Mail di un contatto.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna una delle E-Mail (la terza) di un contatto.
     */
    public String getEmail3() {
        return this.email3;
    }

    /**
     * @brief Questo metodo "getNumTel1()" restituisce il numero di telefono di un contatto.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna uno dei numeri di telefono (il primo) di un contatto.
     */
    public String getNumTel1() {
        return this.numTel1;
    }

    /**
     * @brief Questo metodo "getNumTel2()" restituisce il numero di telefono di un contatto.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna uno dei numeri di telefono (il secondo) di un contatto.
     */
    public String getNumTel2() {
        return this.numTel2;
    }

    /**
     * @brief Questo metodo "getNumTel3()" restituisce il numero di telefono di un contatto.
     * 
     * @param[in] Il metodo non usa nessun parametro in ingresso.
     * @return Il metodo ritorna uno dei numeri di telefono (il terzo) di un contatto.
     */
    public String getNumTel3() {
        return this.numTel3;
    }  

    /**
     * @brief Questo metodo "setEmail1()" associa a un contatto un'E-Mail.
     * 
     * @param[in] name Il metodo prende in ingresso (la prima) l'E-Mail da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    /**
     * @brief Questo metodo "setEmail2()" associa a un contatto un'E-Mail.
     * 
     * @param[in] name Il metodo prende in ingresso (la seconda) l'E-Mail da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    /**
     * @brief Questo metodo "setEmail3()" associa a un contatto un'E-Mail.
     * 
     * @param[in] name Il metodo prende in ingresso (la terza) l'E-Mail da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    /**
     * @brief Questo metodo "setNumTel1()" associa a un contatto un numero di telefono.
     * 
     * @param[in] name Il metodo prende in ingresso (il primo) il numero di telefono da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setNumTel1(String numTel1) {
        this.numTel1 = numTel1;
    }

    /**
     * @brief Questo metodo "setNumTel2()" associa a un contatto un numero di telefono.
     * 
     * @param[in] name Il metodo prende in ingresso (il secondo) il numero di telefono da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setNumTel2(String numTel2) {
        this.numTel2 = numTel2;
    }

    /**
     * @brief Questo metodo "setNumTel3()" associa a un contatto un numero di telefono.
     * 
     * @param[in] name Il metodo prende in ingresso (il terzo) il numero di telefono da impostare.
     * @return Nessun valore di ritorno.
     */
    public void setNumTel3(String numTel3) {
        this.numTel3 = numTel3;
    } 
}
