package com.exercici0601;

import com.utils.*;

import java.io.File; // Importación de la clase File
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControllerCharacters implements Initializable {

    private int number;

    @FXML
    private ImageView imgArrowBack;

    @FXML
    private VBox list; // Cambiado de vboxContainer a list

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Cargar la imagen del botón de retroceso
            URL imageURL = getClass().getResource("/assets/images0601/arrow-back.png");
            if (imageURL != null) {
                Image image = new Image(imageURL.toExternalForm());
                imgArrowBack.setImage(image);
            } else {
                System.err.println("No se encontró la imagen de flecha.");
            }

            // Cargar la lista de personajes al inicializar
            loadList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadList(int number) {
        try {
            // Cargar el archivo JSON
            Path path = Paths.get("src/main/resources/assets/json0601/characters.json");
            String jsonString = Files.readString(path, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(jsonString);

            // Limpiar la lista antes de cargar nuevos elementos
            list.getChildren().clear();

            // Iterar sobre los elementos del JSON y crear los elementos de la interfaz
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/exercici0601/ItemCharacter.fxml"));
                AnchorPane item = loader.load();
                ControllerItem controller = loader.getController();
                controller.setNumber(i + 1);
                controller.setTitle(jsonObject.getString("name"));
                controller.setImatge(jsonObject.getString("image"));
                list.getChildren().add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    private void toViewMain() {
        UtilsViews.setViewAnimating("ViewMain");
    }
}
