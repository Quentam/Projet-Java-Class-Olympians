package fr.isep.algo.accueilprojet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class AccueilController {

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


    // Add methods to handle navigation button actions
    @FXML
    private void athletesButton() {
        navigateToPage("/fr/isep/algo/classolympians/AthlètesAccueil.fxml");
    }

    @FXML
    private void disciplinesButton() {
        navigateToPage("/fr/isep/algo/classolympians/AthlètesAccueil.fxml");
    }

    @FXML
    private void eventsButton() {
        navigateToPage("/fr/isep/algo/classolympians/AthlètesAccueil.fxml");
    }

    @FXML
    private void resultsButton() {
        navigateToPage("/fr/isep/algo/classolympians/AthlètesAccueil.fxml");
    }

    @FXML
    private void reportsButton() {
        navigateToPage("/fr/isep/algo/classolympians/AthlètesAccueil.fxml");
    }


    private void navigateToPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) athleteNameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
