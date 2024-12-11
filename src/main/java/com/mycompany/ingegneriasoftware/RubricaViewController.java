/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneriasoftware;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import utenteContatto.ElencoContatti;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import utenteContatto.Contatto;

/**
 * FXML Controller class
 *
 * @author 39334
 */
public class RubricaViewController implements Initializable {
    
    private ElencoContatti elencoContatti;
    
    private ObservableList<Contatto> elencoContattiOsservabile;
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
        //TODO        
        this.infoPanel.setOpacity(0);
        this.delateButton.setDisable(true);
        this.modifyButton.setDisable(true);
        this.elencoContatti = new ElencoContatti();
        
            
        /* istruzioni per prova della search box */
        
        this.contactColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome() + " " + cellData.getValue().getCognome()));
        ObservableList<Contatto> data = FXCollections.observableArrayList();
        

        elencoContattiOsservabile = FXCollections.observableList(elencoContatti.getElencoContatti());

        elencoContattiOsservabile.add(new Contatto("Giuseppe","Messalino","3341589034","","","mess@gmail.com","mess10@gmail.com",""));
        elencoContattiOsservabile.add(new Contatto("","Messalino","3341589034","","","","mess10@gmail.com",""));
        elencoContattiOsservabile.add(new Contatto("Paolo","Messalino","","","","mess@gmail.com","mess10@gmail.com",""));
        elencoContattiOsservabile.add(new Contatto("Nicola","","3341589034","","","mess@gmail.com","mess10@gmail.com",""));



        for(Contatto c : elencoContattiOsservabile){
            data.add(c);
        }
        
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
        
        /* ---------------------------------------------------- */    
    }    

    @FXML
    private void deleteContact(ActionEvent event) {
        for(Contatto c : elencoContattiOsservabile){
            if((c.getNome().equals(nameLabel.getText()))&& (c.getCognome().equals(surnameLabel.getText()))){
                elencoContattiOsservabile.remove(c);
            }
        }
    }

    @FXML
    private void modifyContact(ActionEvent event) {
    }

    @FXML
    private void openNewContactView(ActionEvent event) throws IOException {
        UtilityClass.stage.close();
        UtilityClass.openNewStage(new Scene(App.loadFXML("NewContactView")));
    }

    @FXML
    private void openProfileView(ActionEvent event) {
    }

    
/**
 * @brief metodo per visualizzare le informazioni di un contatto nel panel dedicato 
 * 
 * @param[in] Il metodo ha in input l'evento "Click su una riga della tabella".
 * @return Nessun valore di ritorno.
 * 
 * @author Giuseppe Messalino.
 */
    @FXML
    private void openContactView(MouseEvent event) {
        this.infoPanel.setOpacity(1);
        this.delateButton.setDisable(false);
        this.modifyButton.setDisable(false);
        
        String selectedContact = contactBox.getSelectionModel().getSelectedItem().getNome();
        
        for(Contatto c : elencoContattiOsservabile){
            if(c.getNome().equals(selectedContact)){
                nameLabel.setText(c.getNome());
                surnameLabel.setText(c.getCognome());
                phoneLabel1.setText(c.getNumTel1());
                phoneLabel2.setText(c.getNumTel2());
                phoneLabel3.setText(c.getNumTel3());
                mailLabel1.setText(c.getEmail1());
                mailLabel2.setText(c.getEmail2());
                mailLabel3.setText(c.getEmail3());
            }
        }
        
    }
}
