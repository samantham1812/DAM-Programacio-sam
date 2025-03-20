package com.exercici1600;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private Button buttonCalculate;

    @FXML
    private TextField valuea;

    @FXML
    private TextField valueb;

    @FXML
    private Text textCounter;

    //private int counter = 0;

    @FXML
    private void actionCalculate(ActionEvent event) {
        int n1 = Integer.parseInt(valuea.getText());
        int n2 = Integer.parseInt(valueb.getText());

        int counter = n1 + n2;

        textCounter.setText(String.valueOf(counter));
        valuea.getText();
        valueb.getText();
    }

}
