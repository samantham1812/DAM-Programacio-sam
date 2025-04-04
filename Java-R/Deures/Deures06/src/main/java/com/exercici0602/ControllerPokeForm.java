package com.exercici0602;

import com.utils.*;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.print.DocFlavor.STRING;
import javax.swing.text.html.ImageView;

import org.w3c.dom.events.MouseEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ControllerPokeForm implements Initializable{

    @FXML
    private TextField fieldName = new TextField();

    @FXML
    private TextField fieldAvility = new TextField();
  
    @FXML
    private TextField fieldCategory = new TextField();
    
    @FXML
    private TextField fieldType = new TextField();
  
    @FXML
    private TextField fieldHeight = new TextField();
  
    @FXML
    private TextField fieldWidth = new TextField();
  
    @FXML
    private ImageView imgBackArrow;

    @FXML
    private ImageView imgPokemon;

    @FXML
    private Button buttonAdd = new Button();

    @FXML
    private Button buttonUpdate = new Button();

    public static final String STATUS_ADD = "add";
    public static final String STATUS_EDIT = "edit";
    private String status = "";
    private int number = -1;

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
        this.number = number;
        if (this.status.equalsIgnoreCase(STATUS_ADD)){
            buttonAdd.setVisible(true);
            buttonUpdate.setVisible(false);

            fieldName.clear();
            fieldAvility.clear();
            fieldCategory.clear();
            fieldType.clear();
            fieldHeight.clear();
            fieldWidth.clear();
            imgPokemon.setImage(null);
        }
        if (this.status.equalsIgnoreCase(STATUS_EDIT)){
            buttonAdd.setVisible(false);
            buttonUpdate.setVisible(true);

            AppData db = AppData.getInstance();
            ArrayList<HashMap<String, Object>> lista = db.query(String.format("SELECT * FROM pokemons WHERE number = '%d';", this.number));
            if (lista.size() == 1) {
                HashMap<String, Object> pokemon = lista.get(0);
            }
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