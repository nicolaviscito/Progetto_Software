/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ingegneriasoftware;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 39334
 */
public class InitBindings {
    public static Stage stage;
    
    public static void openNewStage(Scene scene){
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
