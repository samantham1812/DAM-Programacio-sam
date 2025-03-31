package com.exercici0602;

import com.utils.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerPokeCard {



    private int  number;

    private void loadPokemon(int number) {
        AppData db = AppData.getInstance();
        this.number = number;

        ArrayList<HashMap<String, Object>> llistaPokemons = db.query("SELECT * FROM pokemons WHERE number = '%s';", this.number);
        if(llistaPokemons.size() > 0) {
            HashMap<String, Object> pokemon = llistaPokemons.get(0);
            System.out.println(number);
        }
    }

    @FXML
    public void next(ActionEvent event) {
        System.out.println("To the next pokemon");;
    }
    
}