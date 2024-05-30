package fr.isep.algo.classolympians;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EvènementsInscriptionDisciplineController {

    @FXML
    private VBox eventList;

    @FXML
    public void initialize() {
        // Add default events for demonstration
        List<String[]> events = new ArrayList<>();
        events.add(new String[]{"100 mètres Finale", "2024-07-23"});
        events.add(new String[]{"Football France-Brésil", "2024-07-24"});
        events.add(new String[]{"Lancer de marteau Demie-Finale", "2024-07-25"});
        events.add(new String[]{"Qualifications Saut en hauteur", "2024-07-26"});
        events.add(new String[]{"Waterpolo : Ecosse-Allemagne", "2024-07-27"});
        events.add(new String[]{"Saut à la perche finale", "2024-07-28"});
        events.add(new String[]{"Tennis Finale", "2024-07-29"});

        boolean addTick = true;
        for (String[] event : events) {
            addEventToList(event[0], event[1], addTick);
            addTick = !addTick; // Alternance entre tick et plus
        }
    }

    @FXML
    private void handleAddEvent() {
        // Code to handle adding a new event
    }

    @FXML
    private void handleRegisterAthlete() {
        // Code to handle registering an athlete to an event
    }

    private void addEventToList(String eventName, String eventDate, boolean addTick) {
        HBox eventBox = new HBox();
        eventBox.setStyle("-fx-border-color: black; -fx-padding: 10;");
        eventBox.setSpacing(20);
        eventBox.setOnMouseEntered(e -> eventBox.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-padding: 10;"));
        eventBox.setOnMouseExited(e -> eventBox.setStyle("-fx-border-color: black; -fx-padding: 10;"));

        Label nameLabel = new Label(eventName);
        nameLabel.setStyle("-fx-font-size: 16px;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label dateLabel = new Label(eventDate);
        dateLabel.setStyle("-fx-font-size: 16px;");

        ImageView icon = new ImageView(new Image(addTick ? getClass().getResourceAsStream("/fr/isep/algo/classolympians/Images/Tick.png") : getClass().getResourceAsStream("/fr/isep/algo/classolympians/Images/Plus.jpg")));
        icon.setFitHeight(20);
        icon.setFitWidth(20);
        Button actionButton = new Button("", icon);

        eventBox.getChildren().addAll(nameLabel, spacer, dateLabel, actionButton);
        eventList.getChildren().add(eventBox);
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

    private void openPage(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) eventList.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
