package fr.isep.algo.classolympians;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AthlètesInscriptionController {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField paysField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField disciplineField;

    @FXML
    private Button enregistrerButton;

    @FXML
    public void initialize() {
        enregistrerButton.setOnAction(event -> enregistrerAthlete());
    }

    private void enregistrerAthlete() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String pays = paysField.getText();
        String age = ageField.getText();
        String discipline = disciplineField.getText();

        Athlète athlète = new Athlète(nom, prenom, pays, age, discipline);
        ShareDataAthlètes.addAthlète(athlète);

        // Close the current stage
        Stage stage = (Stage) enregistrerButton.getScene().getWindow();
        stage.close();
    }

    // Navigation methods
    @FXML
    private void handleHomeButton() throws IOException {
        openPage("/fr/isep/algo/classolympians/Accueil.fxml");
    }

    @FXML
    private void handleAthletesButton() throws IOException {
        openPage("/fr/isep/algo/classolympians/AthlètesAccueil.fxml");
    }

    @FXML
    private void handleDisciplinesButton() throws IOException {
        openPage("/fr/isep/algo/classolympians/AccueilDisciplines.fxml");
    }

    @FXML
    private void handleEventsButton() throws IOException {
        openPage("/fr/isep/algo/classolympians/AccueilEvènements.fxml");
    }

    @FXML
    private void handleResultsButton() throws IOException {
        openPage("/fr/isep/algo/classolympians/AccueilRésultats.fxml");
    }

    @FXML
    private void handleReportsButton() throws IOException {
        openPage("/fr/isep/algo/classolympians/AccueilGénérationdeRapports.fxml");
    }

    private void openPage(String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) enregistrerButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
