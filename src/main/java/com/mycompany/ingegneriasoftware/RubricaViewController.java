/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneriasoftware;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.util.Callback;
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
    private TableColumn<String , String> contactColumn;
    @FXML
    private Button newContactButton;
    @FXML
    private Button profileButton;
    @FXML
    private TableView<String> contactBox;
    @FXML
    private Pane infoPanel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        // TODO        
        this.infoPanel.setOpacity(0);
    
        elencoContattiOsservabile = FXCollections.observableList(elencoContatti.getElencoTelefonico());
        
        /* istruzioni per prova della search box */
        
        this.contactColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()));
        ObservableList<String> data = FXCollections.observableArrayList(
            "Giuseppe",
            "Nicola"
        );
        
        FilteredList<String> filteredData = new FilteredList<>(data, s -> true);
        
        this.contactBox.setItems(data);
        this.searchField.textProperty().addListener((Observable , oldValue , newValue) -> {
            filteredData.setPredicate(item -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                return item.toLowerCase().contains(newValue.toLowerCase());                
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
        InitBindings.stage.close();
        InitBindings.openNewStage(new Scene(App.loadFXML("NewContactView")));
    }

    @FXML
    private void openProfileView(ActionEvent event) {
    }
    
}
