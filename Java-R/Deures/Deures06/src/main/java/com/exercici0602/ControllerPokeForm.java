package com.exercici0602;

import com.utils.*;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

import javax.print.DocFlavor.STRING;

import org.w3c.dom.events.MouseEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerPokeForm implements Initializable{

    private Button buttonAdd = new Button();

    private Button buttonUpdate = new Button();

    public static final String STATUS_ADD = "add";
    public static final String STATUS_EDIT = "edit";
    private String status = "";

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        Path imagePath = null;
        try {
            URL imageURL = getClass().getResource("/assets/images0602/arrow-back.png");
            Image image = new Image(imageURL.toExternalForm());
            imgBackArrow.setImage(image);
        } catch (Exception e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }

    public void setStatus(String value){
        this.status = value;
        if (this.status.equalsIgnoreCase(STATUS_ADD)){
            buttonAdd.setVisible(true);
            buttonUpdate.setVisible(false);
        }
        if (this.status.equalsIgnoreCase(STATUS_EDIT)){
            buttonAdd.setVisible(false);
            buttonUpdate.setVisible(true);
        } 
    }
    
    @FXML
    public void goBack(MouseEvent event){
        if (this.status.equalsIgnoreCase(STATUS_ADD)){
            UtilsViews.setViewAnimating("ViewList");
        } 
        if (this.status.equalsIgnoreCase(STATUS_EDIT)){
            UtilsViews.setViewAnimating("ViewCard");
        } 
    }
    

}