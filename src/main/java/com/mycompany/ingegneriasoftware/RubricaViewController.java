/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneriasoftware;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Collection;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import utenteContatto.Contatto;
import utenteContatto.ElencoContatti;

/**
 * @file RubricaviewController.java
 * @brief Questa classe implementa l'interfaccia della rubrica.
 * 
 * Questa classe si occupa di gestire tutte le interazioni possibili che l'utente può avere con l'interfaccia grafica
 * che gestisce la rubrica.
 * 
 * @author Nicola Viscito, Giuseppe Messalino, Paolo Vitale.
 * @date December 09, 2024.
 */
public class RubricaViewController implements Initializable {
    private ObservableList<Contatto> elencoContattiOsservabile = FXCollections.observableArrayList();
    public static String selectionedName;
    public static String selectionedSurname;
    
    @FXML
    private TextField searchField;
    @FXML
    private Label nameLabel;
    @FXML
    private Label phoneLabel1;
    @FXML
    private Label phoneLabel2;
    @FXML
    private Label phoneLabel3;
    @FXML
    private Label surnameLabel;
    @FXML
    private Label mailLabel1;
    @FXML
    private Label mailLabel2;
    @FXML
    private Label mailLabel3;
    @FXML
    private Button delateButton;
    @FXML
    private Button modifyButton;
    @FXML
    private TableColumn<Contatto , String> contactColumn;
    @FXML
    private Button newContactButton;
    @FXML
    private Button profileButton;
    @FXML
    private TableView<Contatto> contactBox;
    @FXML
    private Pane infoPanel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){        

        this.infoPanel.setOpacity(0);
        this.delateButton.setDisable(true);
        this.modifyButton.setDisable(true);

        this.contactColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCognome() + " " + cellData.getValue().getNome()));
        ObservableList<Contatto> data = FXCollections.observableArrayList();
        
        elencoContattiOsservabile.setAll(UtilityClass.elencoContatti.getElencoContatti());
        for(Contatto c : UtilityClass.elencoContatti.getElencoContatti()){
            data.add(c);
        }
        
        ///< Sorting della rubrica: in ordine alfabetico (per cognome e poi nome).
        data.sort(Comparator.comparing(Contatto :: getCognome).thenComparing(Contatto :: getNome));
        
    
        
        FilteredList<Contatto> filteredData = new FilteredList<>(data, s -> true);
        
        this.contactBox.setItems(data);
        
        this.searchField.textProperty().addListener((Observable , oldValue , newValue) -> {
            filteredData.setPredicate(item -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                return item.getNome().toLowerCase().contains(newValue.toLowerCase()) || item.getCognome().toLowerCase().contains(newValue.toLowerCase());                
            });
            this.contactBox.setItems(filteredData);
        });    
    }    

    /**
     * @brief Questo metodo implementa l'eliminazione del contatto dalla rubrica.
     * 
     * @param[in] event Il metodo prende in ingresso l'evento di pressione del tasto "Elimina". 
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito, Giuseppe Messalino, Poalo Vitale.
     * @throws IOException
     */
    @FXML
    private void deleteContact(ActionEvent event) throws IOException {
        
        ///< Riferimento al contatto da eliminare.
        Contatto contattoDaEliminare = null;
        
        ///< Scorrimento di tutta la lista per trovare il contatto da eliminare;
        for (Contatto c : UtilityClass.elencoContatti.getElencoContatti()) {
            if (c.getNome().equals(nameLabel.getText()) &&
                c.getCognome().equals(surnameLabel.getText()) &&
                c.getEmail1().equals(mailLabel1.getText()) &&
                c.getEmail2().equals(mailLabel2.getText()) &&
                c.getEmail3().equals(mailLabel3.getText()) &&
                c.getNumTel1().equals(phoneLabel1.getText()) &&
                c.getNumTel2().equals(phoneLabel2.getText()) &&
                c.getNumTel3().equals(phoneLabel3.getText())) {
                System.out.println("contatto trovato");
                contattoDaEliminare = c;    ///< Assegnazione dell'utente da eliminare in una variabile d'appoggio.
                break; // Esci dal ciclo dopo aver trovato il contatto
            }
        }
        
        ///< Rimozione dalla lista di utenti dell'utente da eliminare.
        if (contattoDaEliminare != null) {
            UtilityClass.elencoContatti.getElencoContatti().remove(contattoDaEliminare);
        }
        
        ///< Riscrittura del file esterno.
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(UtilityClass.username + ".csv")))) {
            for (Contatto contatto : UtilityClass.elencoContatti.getElencoContatti()) {
                pw.append(contatto.getNome().isEmpty() ? "null" : contatto.getNome()).append(";");
                pw.append(contatto.getCognome().isEmpty() ? "null" : contatto.getCognome()).append(";");
                pw.append(contatto.getEmail1().isEmpty() ? "null" : contatto.getEmail1()).append(";");
                pw.append(contatto.getEmail2().isEmpty() ? "null" : contatto.getEmail2()).append(";");
                pw.append(contatto.getEmail3().isEmpty() ? "null" : contatto.getEmail3()).append(";");
                pw.append(contatto.getNumTel1().isEmpty() ? "null" : contatto.getNumTel1()).append(";");
                pw.append(contatto.getNumTel2().isEmpty() ? "null" : contatto.getNumTel2()).append(";");
                pw.append(contatto.getNumTel3().isEmpty() ? "null" : contatto.getNumTel3()).append(";");
                pw.append('\n');
            }
        }
        
        ///< Ricarica dell'interfaccia della rubrica.
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene (App.loadFXML("RubricaView")));
    }
    
    /**
     * @brief Metodo di apertura interfaccia di registrazione utente "ModifyContactView".
     *  
     * @param[in] event Il metodo prende in ingresso l'evento di pressione del tasto "Modifica".  
     * @return Nessun valore di ritorno.
     * 
     * @author Nicola Viscito.
     * @throws IOException 
     */
    @FXML
    private void modifyContact(ActionEvent event) throws IOException {
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene(App.loadFXML("ModifyContactView")));
    }

    /**
     * @brief Metodo di apertura interfaccia di registrazione utente "NewContactView".
     *  
     * @param[in] event Il metodo prende in ingresso l'evento di pressione del tasto "Crea Contatto".  
     * @return Nessun valore di ritorno.
     * 
     * @author Giuseppe Messalino.
     * @throws IOException 
     */
    @FXML
    private void openNewContactView(ActionEvent event) throws IOException {
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene(App.loadFXML("NewContactView")));
    }

    /**
     * @brief Metodo di apertura interfaccia di registrazione utente "ProfileView".
     *  
     * @param[in] event Il metodo prende in ingresso l'evento di pressione del tasto "Profilo".  
     * @return Nessun valore di ritorno.
     * 
     * @author Giuseppe Messalino.
     * @throws IOException 
     */
    @FXML
    private void openProfileView(ActionEvent event) throws IOException {
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene(App.loadFXML("ProfileView")));
    }

    
    /**
     * @brief Metodo per visualizzare le informazioni di un contatto nel panel dedicato.
     * 
     * @param[in] Il metodo ha in input l'evento "Click su una riga della tabella".
     * @return Nessun valore di ritorno.
     * 
     * @author Giuseppe Messalino.
     */
    @FXML
    private void openContactView(MouseEvent event) {
        if(contactBox.getSelectionModel().getSelectedItem() != null){
            this.infoPanel.setOpacity(1);
            this.delateButton.setDisable(false);
            this.modifyButton.setDisable(false);
            
            String selectedContact = contactBox.getSelectionModel().getSelectedItem().getNome();
            selectionedName = contactBox.getSelectionModel().getSelectedItem().getNome();
            selectionedSurname = contactBox.getSelectionModel().getSelectedItem().getCognome();
            
            for(Contatto c : elencoContattiOsservabile){
                if(c.getNome().equals(selectedContact)){
                    if(c.getNome().equals(""))
                        nameLabel.setText("");
                    else nameLabel.setText(c.getNome());
                    
                    if(c.getCognome().equals(""))
                        surnameLabel.setText("");
                    else surnameLabel.setText(c.getCognome());

                    if(c.getEmail1().equals(""))
                        mailLabel1.setText("");
                    else mailLabel1.setText(c.getEmail1());
                    
                    if(c.getEmail2().equals(""))
                        mailLabel2.setText("");
                    else mailLabel2.setText(c.getEmail2());
                    
                    if(c.getEmail3().equals(""))
                        mailLabel3.setText("");
                    else mailLabel3.setText(c.getEmail3()); 
                    
                    if(c.getNumTel1().equals(""))
                        phoneLabel1.setText("");
                    else phoneLabel1.setText(c.getNumTel1());
                    
                    if(c.getNumTel2().equals(""))
                        phoneLabel2.setText("");
                    else phoneLabel2.setText(c.getNumTel2());
                    
                    if(c.getNumTel3().equals(""))
                        phoneLabel3.setText("");
                    else phoneLabel3.setText(c.getNumTel3());                   
                }
            }             
        }
    }
}
