package com.exercici0602;

import com.utils.*;

import java.io.File;

import org.w3c.dom.events.MouseEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerPokeForm {

    private String status = "";

    public void setStatus(String value){
        this.status = value;
    }
    
    @FXML
    public void goBack(MouseEvent event){

    }
    

}