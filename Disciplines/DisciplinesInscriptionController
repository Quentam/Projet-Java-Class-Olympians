package fr.isep.algo.classolympians;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class DisciplinesInscriptionController {

    @FXML
    private TextField nomEvenementField;

    @FXML
    private TextField dateField;

    @FXML
    private Button enregistrerButton;

    @FXML
    private Button HomeButton;
    @FXML
    private Button athletesButton;
    @FXML
    private Button DisciplinesButton;
    @FXML
    private Button EventsButton;
    @FXML
    private Button ResultsButton;
    @FXML
    private Button ReportsButton;

    @FXML
    public void initialize() {
        enregistrerButton.setOnAction(event -> enregistrerEvenement());

        // Set navigation button actions
        HomeButton.setOnAction(event -> handleHomeButton());
        athletesButton.setOnAction(event -> handleAthletesButton());
        DisciplinesButton.setOnAction(event -> handleDisciplinesButton());
        EventsButton.setOnAction(event -> handleEventsButton());
        ResultsButton.setOnAction(event -> handleResultsButton());
        ReportsButton.setOnAction(event -> handleReportsButton());
    }

    private void enregistrerEvenement() {
        String nomEvenement = nomEvenementField.getText();
        String date = dateField.getText();

        // Add the event to shared data
        ShareDataEvents.addEvent(new Event(nomEvenement, date));

        // Close the current stage
        Stage stage = (Stage) enregistrerButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleHomeButton() {
        openPage("/fr/isep/algo/classolympians/Accueil.fxml");
    }

    @FXML
    private void handleAthletesButton() {
        openPage("/fr/isep/algo/classolympians/AthlètesAccueil.fxml");
    }

    @FXML
    private void handleDisciplinesButton() {
        openPage("/fr/isep/algo/classolympians/DisciplinesAccueil.fxml");
    }

    @FXML
    private void handleEventsButton() {
        openPage("/fr/isep/algo/classolympians/EvènementsAccueil.fxml");
    }

    @FXML
    private void handleResultsButton() {
        openPage("/fr/isep/algo/classolympians/AccueilRésultats.fxml");
    }

    @FXML
    private void handleReportsButton() {
        openPage("/fr/isep/algo/classolympians/RapportsAccueil.fxml");
    }

    private void openPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) HomeButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
