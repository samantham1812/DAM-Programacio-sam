package com.exercici1603;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import com.utils.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller0 {

    @FXML
    private Button button0, button1;
    @FXML
    private AnchorPane container;

    @FXML
    private TextField nom;

    @FXML
    private TextField activitat;

    @FXML
    private TextField datanaixement;

    @FXML
    private TextField txtexplicatiu;

    @FXML
    private Button loadjson;

    @FXML
    private Button toforms;

    @FXML
    private ImageView imagen;

    // @FXML
    // private void actionLoadJson(ActionEvent event) {
    //     Stage stage = (Stage) loadjson.getScene().getWindow();
    //     FileChooser fileChooser = new FileChooser();
    //     fileChooser.setTitle("Seleccionar archivos JSON");
    //     fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files", "*.json"));
        
    //     File selectedFile = fileChooser.showOpenDialog(new Stage());
    //     if (selectedFile != null) {
    //         try {
    //             String content = new String(Files.readAllBytes(selectedFile.toPath()));
    //             JSONObject jsonObject = new JSONObject(content);
                
    //             String nm = jsonObject.getString("Nom");
    //             String act = jsonObject.getString("Activitat");
    //             String data = jsonObject.getString("Data de naixement");
    //             String explicatiu = jsonObject.getString("Text explicatiu");

    //             nom.setText(nm);
    //             activitat.setText(act);
    //             datanaixement.setText(data);
    //             txtexplicatiu.setText(explicatiu);    

    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         } 
    //     }
    // }

    // @FXML
    // private void actionLoadImage(){
    //     Stage stage = (Stage) loadjson.getScene().getWindow();
    //     FileChooser fileChooser = new FileChooser();
    //     fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
    //     fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.png", "*.jpg", "*.jpeg"));
        
    //     File selectedFile = fileChooser.showOpenDialog(stage);
    //     if (selectedFile != null) {
    //         try {
    //             Image im1 = new Image(selectedFile.toURI().toString());
    //             imagen.setImage(im1);
    //         } catch (Exception e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }
    @FXML
    private void actionLoadJson(ActionEvent event) {
    Stage stage = (Stage) loadjson.getScene().getWindow();
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Seleccionar archivos JSON");
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files", "*.json"));
    
    File selectedFile = fileChooser.showOpenDialog(stage);
    if (selectedFile != null) {
        try {
            String content = new String(Files.readAllBytes(selectedFile.toPath()));
            JSONObject jsonObject = new JSONObject(content);
            
            // Leer los datos del JSON
            String nm = jsonObject.getString("Nom");
            String act = jsonObject.getString("Activitat");
            String data = jsonObject.getString("Data de naixement");
            String explicatiu = jsonObject.getString("Text explicatiu");
            String imagePath = jsonObject.getString("image"); // Ruta de la imagen

            // Establecer los valores en los campos de texto
            nom.setText(nm);
            activitat.setText(act);
            datanaixement.setText(data);
            txtexplicatiu.setText(explicatiu);

            // Llamar a la función para cargar la imagen
            //loadImageFromPath(imagePath);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }
}

@FXML
private void loadImageFromPath(String imagePath) {
    // Cargar la imagen en el ImageView
    File imageFile = new File(imagePath);
    if (imageFile.exists()) {
        Image image = new Image(imageFile.toURI().toString());
        imagen.setImage(image);
    } else {
        System.out.println("La ruta de la imagen no es válida: " + imagePath);
    }
}

    @FXML
    private void initialize(){
        loadjson.setOnAction(this::actionLoadJson);
        
        //imagen.setOnMouseClicked(e -> actionLoadImage());
    }

    @FXML
    private void animateToView0(ActionEvent event) {
        UtilsViews.setViewAnimating("View0");
    }

    @FXML
    private void animateToView1(ActionEvent event) {
        UtilsViews.setViewAnimating("View1");
    }
}