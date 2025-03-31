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

    public void loadList() {
        try {
            // Ruta del archivo JSON
            File file = new File(getClass().getResource("/data/characters.json").toURI());
            String content = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);

            JSONArray jsonArray = new JSONArray(content);
            System.out.println("Número de personajes encontrados: " + jsonArray.length());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String name = obj.getString("name");
                String imagePath = obj.getString("image");

                System.out.println("Cargando personaje: " + name + ", Imagen: " + imagePath);

                // Crear un ítem visual y añadirlo al VBox
                AnchorPane item = createCharacterItem(name, imagePath);
                if (item != null) {
                    list.getChildren().add(item); // Usar la variable 'list'
                    System.out.println("Ítem añadido al VBox.");
                } else {
                    System.err.println("No se pudo crear el ítem para: " + name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AnchorPane createCharacterItem(String name, String imagePath) {
        try {
            System.out.println("Cargando diseño FXML para el ítem...");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/viewItem.fxml"));
            AnchorPane anchorPane = loader.load();

            ControllerItem controllerItem = loader.getController();
            controllerItem.setData(name, imagePath);
            System.out.println("Datos configurados para el ítem: " + name);

            return anchorPane;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    private void toViewMain() {
        UtilsViews.setViewAnimating("ViewMain");
    }
}
