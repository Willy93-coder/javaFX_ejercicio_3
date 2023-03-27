package com.example.ejercicio_3;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSurName;

    @FXML
    private TextField txtAge;

    @FXML
    private TableView <Persona> table;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colSurName;

    @FXML
    private TableColumn colAge;

    private ObservableList<Persona> personas;

    @FXML
    private void addDataInTable(ActionEvent event) {
       try {
            String nombre = this.txtName.getText();
            String apellido = this.txtSurName.getText();
            int edad = Integer.parseInt(this.txtAge.getText());

            Persona persona = new Persona(nombre, apellido, edad);

            if (!this.personas.contains(persona)){
                this.personas.add(persona);

                this.table.setItems(personas);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Has repetido lo mismos datos");
                alert.showAndWait();
            }

       } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
       }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personas = FXCollections.observableArrayList();
        this.colName.setCellValueFactory(new PropertyValueFactory("name"));
        this.colSurName.setCellValueFactory(new PropertyValueFactory("surName"));
        this.colAge.setCellValueFactory(new PropertyValueFactory("age"));
    }
}