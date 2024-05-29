package fr.isep.algo.classolympians;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EvènementsAccueilController {

    @FXML
    private VBox eventList;

    @FXML
    public void initialize() {
        // Add default events for demonstration
        List<Event> events = new ArrayList<>();
        events.add(new Event("Evènement 1", "Section 53", "Blablabla"));
        events.add(new Event("Evènement 2", "Section 15", "Blablabla"));
        events.add(new Event("Evènement 3", "Section 16", "Blablabla"));
        events.add(new Event("Evènement 4", "Section 17", "Blablabla"));
        events.add(new Event("Evènement 5", "Section 18", "Blablabla"));
        events.add(new Event("Evènement 6", "Section 19", "Blablabla"));
        events.add(new Event("Evènement 7", "Section 20", "Blablabla"));

        for (Event event : events) {
            addEventToList(event);
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

    private void addEventToList(Event event) {
        HBox eventBox = new HBox();
        eventBox.setStyle("-fx-border-color: black; -fx-padding: 10;");
        eventBox.setSpacing(20);

        Label sectionLabel = new Label(event.getSection());
        Label nameLabel = new Label(event.getName() + " : " + event.getDescription());

        eventBox.getChildren().addAll(sectionLabel, nameLabel);
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
        openPage("/fr/isep/algo/classolympians/AccueilDisciplines.fxml");
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
        openPage("/fr/isep/algo/classolympians/AccueilGénérationdeRapports.fxml");
    }

    private void openPage(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setMaximized(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Event {
        private final String name;
        private final String section;
        private final String description;

        public Event(String name, String section, String description) {
            this.name = name;
            this.section = section;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public String getSection() {
            return section;
        }

        public String getDescription() {
            return description;
        }
    }
}
