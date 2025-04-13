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
    private VBox list; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            URL imageURL = getClass().getResource("/assets/images0601/arrow-back.png");
            if (imageURL != null) {
                Image image = new Image(imageURL.toExternalForm());
                imgArrowBack.setImage(image);
            } else {
                System.err.println("No se encontró la imagen de flecha.");
            }

            loadList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadList(int number) {
        try {
            Path path = Paths.get("/assets/data/characters.json");
            String jsonString = Files.readString(path, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(jsonString);

            list.getChildren().clear();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/viewItem.fxml"));
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
