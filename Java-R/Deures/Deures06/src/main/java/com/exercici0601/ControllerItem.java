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

public class ControllerItem {

    @FXML
    private Label title;

    @FXML
    private ImageView img;

    private String name;
    private String imagePath;

    public void setData(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;

        title.setText(name);
        img.setImage(new Image(getClass().getResource(imagePath).toExternalForm()));
    }

    @FXML
    private void toViewMain(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewMain");
    }

    @FXML
    private void toViewCharacters(MouseEvent event) {
        UtilsViews.setViewAnimating("ViewCharacters");
    }


    
}
