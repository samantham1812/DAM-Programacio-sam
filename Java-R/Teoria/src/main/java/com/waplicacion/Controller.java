package com.waplicacion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
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
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivo JSON");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos JSON", "*.json"));

        // Mostrar el diálogo para seleccionar un archivo
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            try {
                // Leer el archivo JSON
                String content = new String(Files.readAllBytes(file.toPath()));
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
    }

    @FXML
    private void guardarInformacion(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar archivo JSON");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos JSON", "*.json"));

        // Mostrar el diálogo para guardar el archivo
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            String titulo = Entrada.getText();
            String parrafo = texto.getText();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("title", titulo);
            jsonObject.put("paragraph", parrafo);

            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(jsonObject.toString());
                fileWriter.flush();
                texto.setText("Data saved successfully!");
            } catch (IOException e) {
                texto.setText("Error saving data: " + e.getMessage());
            }
        }
    }

    @FXML
    private void initialize() {
        Guardar.setOnAction(this::guardarInformacion);
        load.setOnAction(this::cargarInformacion);
    }
}