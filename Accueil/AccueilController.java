package fr.isep.algo.classolympians;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class AccueilController {

    @FXML
    private Label At;

    @FXML
    private Label Di;

    @FXML
    private Label Ev;

    @FXML
    private Label Re;

    @FXML
    private Label Ge;

    // Add methods to handle navigation button actions

    @FXML
    private void handleAthletesButton() {
        navigateToPage("/fr/isep/algo/classolympians/AthlètesAccueil.fxml");
    }

    @FXML
    private void handleDisciplinesButton() {
        navigateToPage("/fr/isep/algo/classolympians/AccueilDisciplines.fxml");
    }

    @FXML
    private void handleEventsButton() {
        navigateToPage("/fr/isep/algo/classolympians/AccueilEvènements.fxml");
    }

    @FXML
    private void handleResultsButton() {
        navigateToPage("/fr/isep/algo/classolympians/AccueilRésultats.fxml");
    }

    @FXML
    private void handleReportsButton() {
        navigateToPage("/fr/isep/algo/classolympians/AccueilGénérationdeRapports.fxml");
    }

    private void navigateToPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) At.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
