package com.waplicacion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

public class Controller {
    
    @FXML
    private Button Guardar;

    @FXML
    private TextField Entrada;

    @FXML
    private TextField texto;

    @FXML
    private Button load;

    @FXML
    private void cargarInformacion(ActionEvent event) {
        try {
            // Leer el archivo JSON
            String content = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("aplicacion.json")));
            JSONObject jsonObject = new JSONObject(content);

            // Obtener los valores del JSON y mostrarlos en los campos de texto
            String titulo = jsonObject.getString("title");
            String parrafo = jsonObject.getString("paragraph");

            Entrada.setText(titulo);
            texto.setText(parrafo);
        } catch (IOException e) {
            texto.setText("Error loading data: " + e.getMessage());
        } catch (org.json.JSONException e) {
            texto.setText("Error parsing JSON: " + e.getMessage());
        }
    }

    @FXML
    private void guardarInformacion(ActionEvent event) {
        String titulo = Entrada.getText();
        String parrafo = texto.getText();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", titulo);
        jsonObject.put("paragraph", parrafo);

        try (FileWriter file = new FileWriter("aplicacion.json")) { // ruta del archivo
            file.write(jsonObject.toString());
            file.flush();
            texto.setText("Data saved successfully!");
            javafx.application.Platform.exit(); // Finaliza
        } catch (IOException e) {
            texto.setText("Error saving data: " + e.getMessage());
        }
    }

    @FXML
    private void initialize() {
        Guardar.setOnAction(this::guardarInformacion);
        load.setOnAction(this::cargarInformacion);
    }
}
