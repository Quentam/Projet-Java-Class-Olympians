package fr.isep.algo.accueilprojet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class RapportspaysController {

    @FXML
    private TextField sectionField;

    @FXML
    private TextField countryField;

    @FXML
    private Button generateButton;

    @FXML
    public void initialize() {
        generateButton.setOnAction(event -> generateReport());
    }

    @FXML
    private void generateReport() {
        // Implement your report generation logic here
        System.out.println("Generating report for section: " + sectionField.getText() + ", country: " + countryField.getText());
    }

    @FXML
    private void handleHomeButton() {
        navigateToPage("/fr/isep/algo/classolympians/Accueil.fxml");
    }

    @FXML
    private void handleAthletesButton() {
        navigateToPage("/fr/isep/algo/classolympians/AthlètesAccueil.fxml");
    }

    @FXML
    private void handleDisciplinesButton() {
        navigateToPage("/fr/isep/algo/classolympians/DisciplinesAccueil.fxml");
    }

    @FXML
    private void handleEventsButton() {
        navigateToPage("/fr/isep/algo/classolympians/EvènementsAccueil.fxml");
    }

    @FXML
    private void handleResultsButton() {
        navigateToPage("/fr/isep/algo/classolympians/AccueilRésultats.fxml");
    }

    @FXML
    private void handleReportsButton() {
        navigateToPage("/fr/isep/algo/classolympians/RapportsAccueil.fxml");
    }

    private void navigateToPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) sectionField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
