package com.exercici0602;

import com.exercici0601.ControllerItem;
import com.exercici0602.ControllerPokeItem;
import com.utils.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;


public class ControllerPokeList {

    @FXML
    private VBox list = new VBox();

    public void loadList() {
       AppData db = AppData.getInstance();
       db.connect("./data/pokemon.sqlite");

        ArrayList<HashMap<String, Object>> pokeList = db.query("SELECT * FROM Pokemons;");
        
       System.out.println("Dades dels Pokémon:");
        // Iterar sobre la llista de Pokémon i imprimir les dades);
        for (HashMap<String, Object> poke : pokeList) {
            System.out.println("Nom: " + poke.get("name") + ", " + "Tipus: " + poke.get("type") + ", " + "Imatge: " + poke.get("image"));
        }
    }

    @FXML
    private void setList(ArrayList<HashMap<String, Object>> pokeList) throws IOException {

        // Obtenir el recurs del template .fxml
        URL resource = this.getClass().getResource("/assets/viewPokeItem.fxml");

        // Netejar el contingut existent
        list.getChildren().clear();

        // Iterar sobre els elements del JSONArray 'jsonInfo' (ja carregat a initialize)
        for (int i = 0; i < pokeList.size(); i++) {
            // Obtenir l'objecte JSON individual (animal)
            HashMap<String, Object> pokemon = pokeList.get(i);

            // Extreure la informació necessària del JSON
            String name = (String) pokemon.get("name");
            String tipus = (String) pokemon.get("type");
            String image = (String) pokemon.get("image");

            // Carregar el template de 'exemple1606Item.fxml'
            FXMLLoader loader = new FXMLLoader(resource);
            ControllerPokeItem itemPokemon = loader.load();
            ControllerPokeItem itemController = loader.getController();

            // Assignar els valors als controls del template
            itemController.setTitle(name);
            itemController.setSubtitle(tipus);
            itemController.setImatge(image);
            //itemController.setImatge("/assets/images/" + name.toLowerCase() + ".png");

            // Afegir el nou element a 'yPane'
            try {
                list.getChildren().add(itemController);
            } catch (IOException e) {
                System.err.println("Error adding item to list: " + e.getMessage());
            }
        }
    }

    @FXML
    public void addPokemon(ActionEvent event) {
        System.out.println("Afegir Pokémon");
        Label tmp = new Label("hola");
        list.getChildren().clear();
        list.getChildren().add(tmp);
    }

}