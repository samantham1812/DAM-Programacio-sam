package com.exercici0601;

import com.utils.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.exercici0601.ControllerMain;
import com.exercici0601.ControllerCharacters;

public class ControllerItem {

    private int number;

    @FXML
    private Label title;

    @FXML
    private ImageView img;

    public void setNumber(int value) {
        this.number = value;
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setImatge(String imagePath) {
        try {
            File file = new File(imagePath);
            Image image = new Image(file.toURI().toString());
            this.img.setImage(image);
        } catch (NullPointerException e) {
            System.err.println("Error loading image asset: " + imagePath);
            e.printStackTrace();
        }
    }


    @FXML
    private void toViewMain(MouseEvent event) {
        Object controller = UtilsViews.getController("ViewMain");
        if (controller instanceof ControllerMain) {
            ControllerMain ctrl = (ControllerMain) controller;
            ctrl.loadList(this.number);
            UtilsViews.setViewAnimating("ViewMain");
        } else {
            System.err.println("Error: Controller for 'ViewMain' is not of type ControllerMain or is null.");
        }
    }

    @FXML
    private void toViewCharacters(MouseEvent event) {
        ControllerCharacters ctrl = (ControllerCharacters) UtilsViews.getController("ViewCharacters");
        ctrl.loadList(this.number);
        UtilsViews.setViewAnimating("ViewCharacters");
    }


    
}
