package com.exercici1603;

import com.utils.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller1 {

    @FXML
    private AnchorPane container;

    @FXML
    private TextField nom;

    @FXML
    private TextField activitat;

    @FXML
    private TextField datanaixement;

    @FXML
    private TextField txtexplicatiu;

    @FXML
    private Button savebut;

    @FXML
    private Button toficha;

    @FXML
    private ImageView imagen;

    

    @FXML
    private void animateToView0(ActionEvent event) {
        UtilsViews.setViewAnimating("View0");
    }

    @FXML
    private void animateToView1(ActionEvent event) {
        UtilsViews.setViewAnimating("View1");
    }
}