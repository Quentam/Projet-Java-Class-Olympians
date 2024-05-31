package fr.isep.algo.classolympians;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class RapportsAccueilController {

    @FXML
    private Button athleteReportButton;

    @FXML
    private Button countryReportButton;

    @FXML
    private Button olympicsReportButton;

    @FXML
    private ImageView backgroundImage;

    @FXML
    private void handleAthleteReportButton(ActionEvent event) {
        // Code to handle athlete report button action
    }

    @FXML
    private void handleCountryReportButton(ActionEvent event) {
        navigateToPage("/fr/isep/algo/classolympians/Rapportspays.fxml");
    }

    @FXML
    private void handleOlympicsReportButton(ActionEvent event) {
        // Code to handle Olympics report button action
    }

    @FXML
    private void handleHomeButton(ActionEvent event) {
        navigateToPage("/fr/isep/algo/classolympians/Accueil.fxml");
    }

    @FXML
    private void handleAthletesButton(ActionEvent event) {
        navigateToPage("/fr/isep/algo/classolympians/AthlètesAccueil.fxml");
    }

    @FXML
    private void handleDisciplinesButton(ActionEvent event) {
        navigateToPage("/fr/isep/algo/classolympians/AccueilDisciplines.fxml");
    }

    @FXML
    private void handleEventsButton(ActionEvent event) {
        navigateToPage("/fr/isep/algo/classolympians/AccueilEvènements.fxml");
    }

    @FXML
    private void handleResultsButton(ActionEvent event) {
        navigateToPage("/fr/isep/algo/classolympians/AccueilRésultats.fxml");
    }

    @FXML
    private void handleReportsButton(ActionEvent event) {
        navigateToPage("/fr/isep/algo/classolympians/AccueilGénérationdeRapports.fxml");
    }

    private void navigateToPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) athleteReportButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
