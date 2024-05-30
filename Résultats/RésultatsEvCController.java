package fr.isep.algo.classolympians;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RésultatsEvCController {

    @FXML
    public Label evCtitile;

    public void setEvCtitle(String eventName) {
        evCtitile.setText(eventName + " - Résultats");
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
            Stage stage = (Stage) evCtitile.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
