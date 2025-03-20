package com.waplicacion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

public class Controller {
    
    @FXML
    private Button buttonGuardar;

    @FXML
    private TextField textEntrada;

    @FXML
    private TextArea texto;

    @FXML
    private void guardarInformacion(ActionEvent event) {
        String inputText = textEntrada.getText();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("input", inputText);

        try (FileWriter file = new FileWriter("datos.json")) {
            file.write(jsonObject.toString());
            file.flush();
            texto.setText("Data saved successfully!");
        } catch (IOException e) {
            texto.setText("Error saving data: " + e.getMessage());
        }
    }

    @FXML
    private void initialize() {
        buttonGuardar.setOnAction(this::guardarInformacion);
    }
}
