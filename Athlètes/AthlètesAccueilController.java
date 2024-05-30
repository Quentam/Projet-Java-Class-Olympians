
package fr.isep.algo.classolympians;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AthlètesAccueilController {

    @FXML
    private TextField athleteNameField;

    @FXML
    private Button addButton;

    @FXML
    private VBox athleteList;

    private List<Athlète> athletes;

    @FXML
    public void initialize() {
        addButton.setOnAction(event -> openInscriptionPage());

        // Load athletes from shared data
        athletes = ShareDataAthlètes.getAthlètes();
        Collections.sort(athletes, (a1, a2) -> a1.getNom().compareToIgnoreCase(a2.getNom()));

        // Hide athleteList initially
        athleteList.setVisible(false);

        // Show athleteList when TextField is focused
        athleteNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                updateSuggestedAthletes();
                athleteList.setVisible(true);
            }
        });

        // Update suggestions when typing
        athleteNameField.textProperty().addListener((observable, oldValue, newValue) -> updateSuggestedAthletes());

        // Add listener to the scene property
        athleteNameField.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
                    if (!athleteNameField.isFocused() && !athleteList.isHover()) {
                        athleteList.setVisible(false);
                    }
                });
            }
        });

        // Populate athlete list with shared data
        updateAthleteList();

        // Populate athlete list with data from the database
        populateAthleteList();
    }

    @FXML
    private void openInscriptionPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/isep/algo/classolympians/AthlètesInscription.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Inscription d'un athlète");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            // Update athlete list after closing the inscription page
            updateAthleteList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateAthleteList() {
        try {
            List<Athlète> dbAthletes = BDD_Athlètes.getAllAthletes();
            for (Athlète athlete : dbAthletes) {
                HBox row = new HBox();
                row.setStyle("-fx-padding: 5; -fx-background-color: transparent;");
                Text athleteText = new Text(athlete.getPrenom() + " " + athlete.getNom());
                row.getChildren().add(athleteText);

                // Add mouse hover effect
                row.setOnMouseEntered(event -> row.setStyle("-fx-background-color: lightblue; -fx-padding: 5;"));
                row.setOnMouseExited(event -> row.setStyle("-fx-background-color: transparent; -fx-padding: 5;"));

                // Add double-click event to open athlete info page
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2) {
                        openAthleteInfoPage(athlete);
                    }
                });
                athleteList.getChildren().add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateSuggestedAthletes() {
        String searchText = athleteNameField.getText().toLowerCase();
        List<Athlète> filteredAthletes = athletes.stream()
                .filter(athlete -> athlete.getNom().toLowerCase().startsWith(searchText) || athlete.getPrenom().toLowerCase().startsWith(searchText))
                .collect(Collectors.toList());

        athleteList.getChildren().clear();  // Clear the existing list

        for (Athlète athlete : filteredAthletes) {
            HBox row = new HBox();
            row.setStyle("-fx-padding: 5; -fx-background-color: transparent;");
            Text athleteText = new Text(athlete.getPrenom() + " " + athlete.getNom());
            row.getChildren().add(athleteText);

            // Add mouse hover effect
            row.setOnMouseEntered(event -> row.setStyle("-fx-background-color: lightblue; -fx-padding: 5;"));
            row.setOnMouseExited(event -> row.setStyle("-fx-background-color: transparent; -fx-padding: 5;"));

            // Add double-click event to open athlete info page
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2) {
                    openAthleteInfoPage(athlete);
                }
            });

            athleteList.getChildren().add(row);
        }

        athleteList.setVisible(!filteredAthletes.isEmpty());
    }

    private void updateAthleteList() {
        athletes = ShareDataAthlètes.getAthlètes();
        Collections.sort(athletes, (a1, a2) -> a1.getNom().compareToIgnoreCase(a2.getNom()));
        updateSuggestedAthletes();
    }

    private void openAthleteInfoPage(Athlète athlete) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/isep/algo/classolympians/AthlètesInfos.fxml"));
            Parent root = loader.load();

            // Pass athlete data to the controller
            AthlètesInfosController controller = loader.getController();
            controller.setAthlete(athlete);

            Stage stage = new Stage();
            stage.setTitle("Informations de l'athlète");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Add methods to handle navigation button actions
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
            Stage stage = (Stage) athleteNameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
