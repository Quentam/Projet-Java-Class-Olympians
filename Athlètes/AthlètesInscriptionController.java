package fr.isep.algo.classolympians;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

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
    private TextField sexeField;

    @FXML
    private TextField disciplineField;

    @FXML
    private Button enregistrerButton;

    private BDD_Athlètes databaseService = new BDD_Athlètes();

    @FXML
    public void initialize() {
        enregistrerButton.setOnAction(event -> enregistrerAthlete());
    }

    @FXML
    private void enregistrerAthlete() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String pays = paysField.getText();
        int age = Integer.parseInt(ageField.getText());
        char sexe = sexeField.getText().charAt(0);
        String discipline = disciplineField.getText();

        Athlète athlète = new Athlète(nom, prenom, pays, age, sexe, discipline);

        try {
            // Add the athlete to the BDD via the service
            databaseService.addAthlete(athlète);
            // Ajouter l'athlète à ShareDataAthlètes
            ShareDataAthlètes.addAthlète(athlète);

            if (discipline == null || discipline.isEmpty()){
                // Affichage de la fenêtre d'alerte si l'athlète est enregistré sans discipline
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Athlète inscrit, mais sans discipline.");
                alert.getDialogPane().setStyle("-fx-background-color: orange;"); // Fond orange
                alert.showAndWait(); // Affichage de la fenêtre d'alerte et attente de la réponse de l'utilisateur
            } else {
                // Affichage de la fenêtre d'alerte si l'athlète est enregistré avec discipline
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Athlète inscrit avec discipline.");
                alert.getDialogPane().setStyle("-fx-background-color: green;"); // Fond orange
                alert.showAndWait(); // Affichage de la fenêtre d'alerte et attente de la réponse de l'utilisateur
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Close the current stage
        Stage stage = (Stage) enregistrerButton.getScene().getWindow();
        stage.close();
    }

    // Navigation methods (unchanged)
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
        openPage("/fr/isep/algo/classolympians/DisciplinesAccueil.fxml");
    }

    @FXML
    private void handleEventsButton() throws IOException {
        openPage("/fr/isep/algo/classolympians/EvènementsAccueil.fxml");
    }

    @FXML
    private void handleResultsButton() throws IOException {
        openPage("/fr/isep/algo/classolympians/AccueilRésultats.fxml");
    }

    @FXML
    private void handleReportsButton() throws IOException {
        openPage("/fr/isep/algo/classolympians/RapportsAccueil.fxml");
    }

    private void openPage(String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) enregistrerButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
