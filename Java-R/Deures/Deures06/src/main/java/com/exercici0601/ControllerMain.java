package com.exercici0601;

import com.utils.*;

import java.net.URL;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;        

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class ControllerMain {

    @FXML
    private AnchorPane container;

    @FXML
    private VBox vboxCarac = new VBox();

    private String noms[] = { "Mario", "Luigi", "Peach", "Inkling", "Link", "Samus Aran", "Donkey Kong", "Pikachu", "Bowser", "Fox", "Kirby", "Olimar", "Wario" };

    private JSONArray jsonnoms;

    public void initialize(URL url, ResourceBundle rb) {
        try {
            URL jsonFileURL = getClass().getResource("/assets/characters.json");
            Path path = Paths.get(jsonFileURL.toURI());
            String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            jsonnoms = new JSONArray(content);

            // Actualitza la UI amb els valors inicials dels personatges
            setPersonatges(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setPersonatges(ActionEvent event) {
        // Esborrar la llista anterior
        vboxCarac.getChildren().clear();

        // Generar la nova llista
        for (int i = 0; i < noms.length; i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/viewCharacters.fxml"));
            try {
                Parent item = loader.load();
                ControllerCharacters controllerCharacters = loader.getController();
                controllerCharacters.setTitle(noms[i]);
                controllerCharacters.setImatge("/assets/images0601/character_" + noms[i] + ".png");
                vboxCarac.getChildren().add(item);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    private void toViewCharacters(MouseEvent event) {
        System.out.println("To View Characters");
        UtilsViews.setViewAnimating("ViewCharacters");
    }
}
