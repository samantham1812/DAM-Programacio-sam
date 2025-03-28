package com.exercici0601;

import com.utils.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerCharacters {

      @FXML
    private VBox vboxContainer; // Contenedor principal donde se añadirán los ítems

    @FXML
    private void initialize() {
        loadCharactersFromJson();
    }

    private void loadCharactersFromJson() {
        try {
            // Ruta del archivo JSON
            File file = new File(getClass().getResource("/assets/characters.json").toURI());
            String content = new String(Files.readAllBytes(file.toPath()));
    
            // Parsear el JSON
            JSONArray jsonArray = new JSONArray(content);
    
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String name = obj.getString("name");
                String imagePath = obj.getString("image");
    
                // Depuración
                System.out.println("Nombre: " + name);
                System.out.println("Ruta de la imagen: " + imagePath);
    
                // Crear un ítem visual y añadirlo al VBox
                AnchorPane item = createCharacterItem(name, imagePath);
                vboxContainer.getChildren().add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private AnchorPane createCharacterItem(String name, String imagePath) {
        // Crear un AnchorPane para el ítem
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(80.0);
        anchorPane.setStyle("-fx-border-color: #ccc; -fx-padding: 10;");
    
        // Crear un ImageView para la imagen
        ImageView imageView = new ImageView();
        imageView.setImage(new Image(getClass().getResource(imagePath).toExternalForm()));
        imageView.setFitHeight(60.0);
        imageView.setFitWidth(60.0);
        AnchorPane.setLeftAnchor(imageView, 10.0);
        AnchorPane.setTopAnchor(imageView, 10.0);
    
        // Crear un Label para el nombre
        Label nameLabel = new Label(name);
        nameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        AnchorPane.setLeftAnchor(nameLabel, 80.0);
        AnchorPane.setTopAnchor(nameLabel, 25.0);
    
        // Añadir los elementos al AnchorPane
        anchorPane.getChildren().addAll(imageView, nameLabel);
    
        return anchorPane;
    }

    @FXML
    private void toViewMain(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewMain");
    }
}
