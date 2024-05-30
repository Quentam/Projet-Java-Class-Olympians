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

public class RésultatsAccueilController {

    @FXML
    private HBox evA;

    @FXML
    private HBox evB;

    @FXML
    private HBox evC;

    @FXML
    private HBox evD;

    @FXML
    private void initialize() {
        try {
            List<String> recentEvents = BDD_Résultats.getRecentEvents();
            if (recentEvents.size() > 0) setEventLabel(evA, recentEvents.get(0));
            if (recentEvents.size() > 1) setEventLabel(evB, recentEvents.get(1));
            if (recentEvents.size() > 2) setEventLabel(evC, recentEvents.get(2));
            if (recentEvents.size() > 3) setEventLabel(evD, recentEvents.get(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setEventLabel(HBox hbox, String eventName) {
        Label label = new Label(eventName);
        label.setFont(Font.font(label.getFont().getFamily(), FontWeight.BOLD, label.getFont().getSize()*1.5));
        hbox.getChildren().add(label);
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
            Stage stage = (Stage) evA.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    private void evAButton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/isep/algo/classolympians/RésultatsEvA.fxml"));
            Parent root = loader.load();
            RésultatsEvAController controller = loader.getController();
            controller.setEvAtitle(((Label) evA.getChildren().get(0)).getText());
            Stage stage = (Stage) evA.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void evBButton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/isep/algo/classolympians/RésultatsEvB.fxml"));
            Parent root = loader.load();
            RésultatsEvBController controller = loader.getController();
            controller.setEvBtitle(((Label) evB.getChildren().get(0)).getText());
            Stage stage = (Stage) evB.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void evCButton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/isep/algo/classolympians/RésultatsEvC.fxml"));
            Parent root = loader.load();
            RésultatsEvCController controller = loader.getController();
            controller.setEvCtitle(((Label) evC.getChildren().get(0)).getText());
            Stage stage = (Stage) evC.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void evDButton() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/isep/algo/classolympians/RésultatsEvD.fxml"));
            Parent root = loader.load();
            RésultatsEvDController controller = loader.getController();
            controller.setEvDtitle(((Label) evD.getChildren().get(0)).getText());
            Stage stage = (Stage) evD.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
