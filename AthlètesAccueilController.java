package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class AthlètesAccueilController {

    @FXML
    private ImageView backgroundImage;

    @FXML
    private ImageView logoImage;

    @FXML
    private Button homeButton;

    @FXML
    private Button athletesButton;

    @FXML
    private Button disciplinesButton;

    @FXML
    private Button eventsButton;

    @FXML
    private Button resultsButton;

    @FXML
    private Button reportsButton;

    @FXML
    private TextField athleteNameField;

    @FXML
    private Button addButton;

    @FXML
    public void initialize() {
        addButton.setOnAction(event -> {
            String athleteName = athleteNameField.getText();
            // Logic to handle athlete name submission
            System.out.println("Athlete Name: " + athleteName);
        });
    }
}
