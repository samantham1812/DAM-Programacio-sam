package com.exercici0601;

import com.utils.*;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

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
import javafx.scene.layout.VBox;

public class ControllerCharacters implements Initializable {

    @FXML
    private ImageView imgArrowBack;

    @FXML
    private VBox list = new VBox();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Path imagePath = null;
        try {
            URL imageURL = getClass().getResource("/assets/images0601/arrow-back.png");
            Image image = new Image(imageURL.toExternalForm());
            imgArrowBack.setImage(image);
        } catch (Exception e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }

    public void loadList() {
        try {
            URL jsonFileURL = getClass().getResource("/assets/data/characters.json");
            Path path = Paths.get(jsonFileURL.toURI());
            String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            JSONArray jsonInfo = new JSONArray(content);

            list.getChildren().clear();
            for (int i = 0; i < jsonInfo.length(); i++) {
                JSONObject character = jsonInfo.getJSONObject(i);
                String name = character.getString("name");
                
                // TODO: Aquí carregar subvista  
                // amb les dades de cada objecte enlloc d'un Label
                Label label = new Label(name);
                label.setStyle("-fx-border-color: green;");
                list.getChildren().add(label);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
