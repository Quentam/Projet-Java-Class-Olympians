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
import java.util.ArrayList;
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

    private final List<String> athletes = new ArrayList<>();

    @FXML
    public void initialize() {
        addButton.setOnAction(event -> openInscriptionPage());

        // Add default athletes
        addDefaultAthletes();

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
    }

    private void addDefaultAthletes() {
        athletes.add("Teddy Riner");
        athletes.add("Kevin Mayer");
        athletes.add("Renaud Lavillenie");
        athletes.add("Kylian Mbappé");
        athletes.add("Léon Marchand");
        Collections.sort(athletes);  // Sort the list alphabetically
    }

    private void updateSuggestedAthletes() {
        String searchText = athleteNameField.getText().toLowerCase();
        List<String> filteredAthletes = athletes.stream()
                .filter(name -> name.toLowerCase().startsWith(searchText))
                .collect(Collectors.toList());

        athleteList.getChildren().clear();  // Clear the existing list

        for (String name : filteredAthletes) {
            HBox row = new HBox();
            row.setStyle("-fx-padding: 5; -fx-background-color: transparent;");
            Text athleteText = new Text(name);
            row.getChildren().add(athleteText);

            // Add mouse hover effect
            row.setOnMouseEntered(event -> row.setStyle("-fx-background-color: lightblue; -fx-padding: 5;"));
            row.setOnMouseExited(event -> row.setStyle("-fx-background-color: transparent; -fx-padding: 5;"));

            athleteList.getChildren().add(row);
        }

        athleteList.setVisible(!filteredAthletes.isEmpty());
    }

    private void openInscriptionPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AthlètesInscription.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Inscription d'un athlète");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
