package com.exercici0602;

import com.utils.*;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerPokeCard implements Initializable {

    @FXML
    private Label labelAbility = new Label();
    private Label labelName = new Label();
    private Label labelType = new Label();
    private Label labelWeigth = new Label();

    @FXML
    private ImageView imgBackArrow;
    private ImageView imgPokemon;

    private int number;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Cargar la imagen del botón de retroceso
            URL imageURL = getClass().getResource("/assets/images0602/arrow-back.png");
            if (imageURL != null) {
                Image image = new Image(imageURL.toExternalForm());
                imgBackArrow.setImage(image);
            } else {
                System.err.println("No se encontró la imagen de flecha.");
            }

            // Cargar la lista de personajes al inicializar
            loadList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadPokemon(int number) {
        this.number = number;

        AppData db = AppData.getInstance();

        ArrayList<HashMap<String, Object>> llistaPokemons = db.query(String.format("SELECT * FROM pokemons WHERE number = '%d';", this.number));
        if (llistaPokemons.size() == 1) {
            HashMap<String, Object> pokemon = llistaPokemons.get(0); 
        }
    }

    @FXML
    public void goBack(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewList");
    }

    @FXML
    public void editPokemon(ActionEvent event) {
        System.out.println("To view edit pokemon");
    }

    @FXML
    public void previous(ActionEvent event) {
        System.out.println("To previous pokemon");
    }

    @FXML
    public void next(ActionEvent event) {
        System.out.println("To next pokemon");
    }
}