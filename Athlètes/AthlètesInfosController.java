package fr.isep.algo.classolympians;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class AthlètesInfosController {

    @FXML
    private Label nomLabel;

    @FXML
    private Label prenomLabel;

    @FXML
    private Label paysLabel;

    @FXML
    private Label ageLabel;

    @FXML
    private Label sexeLabel;

    @FXML
    private Label disciplineLabel;

    @FXML
    private Label eventsLabel;

    @FXML
    private Button HomeButton;
    @FXML
    private Button athletesButton;
    @FXML
    private Button DisciplinesButton;
    @FXML
    private Button EventsButton;
    @FXML
    private Button ResultsButton;
    @FXML
    private Button ReportsButton;

    private TextField editField;
    private HBox currentBox;

    private Athlète currentAthlete;

    public void setAthlete(Athlète athlete) {
        this.currentAthlete = athlete;
        prenomLabel.setText(athlete.getPrenom());
        nomLabel.setText(athlete.getNom());
        paysLabel.setText(athlete.getPays());
        ageLabel.setText(String.valueOf(athlete.getAge()));
        sexeLabel.setText(String.valueOf(athlete.getSexe()));
        disciplineLabel.setText(athlete.getDiscipline());
        eventsLabel.setText(athlete.getEvents());
    }

    @FXML
    public void initialize() {
        HomeButton.setOnAction(event -> openPage("/fr/isep/algo/classolympians/Accueil.fxml"));
        athletesButton.setOnAction(event -> openPage("/fr/isep/algo/classolympians/AthlètesAccueil.fxml"));
        DisciplinesButton.setOnAction(event -> openPage("/fr/isep/algo/classolympians/AccueilDisciplines.fxml"));
        EventsButton.setOnAction(event -> openPage("/fr/isep/algo/classolympians/AccueilEvènements.fxml"));
        ResultsButton.setOnAction(event -> openPage("/fr/isep/algo/classolympians/AccueilRésultats.fxml"));
        ReportsButton.setOnAction(event -> openPage("/fr/isep/algo/classolympians/AccueilGénérationdeRapports.fxml"));
    }

    private void openPage(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Stage stage = (Stage) HomeButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleModifyNom() {
        modifyField(nomLabel, "nom");
    }

    @FXML
    public void handleModifyPrenom() {
        modifyField(prenomLabel, "prenom");
    }

    @FXML
    public void handleModifyPays() {
        modifyField(paysLabel, "pays");
    }

    @FXML
    public void handleModifyAge() {
        modifyField(ageLabel, "age");
    }

    @FXML
    public void handleModifySexe() {modifyField(sexeLabel, "sexe"); }

    @FXML
    public void handleModifyDiscipline() {
        modifyField(disciplineLabel, "discipline");
    }

    @FXML
    public void handleModifyEvents() {
        modifyField(eventsLabel, "events");
    }

    private void modifyField(Label label, String field) {
        if (currentBox != null) {
            currentBox.getChildren().remove(editField);
        }

        currentBox = (HBox) label.getParent();
        editField = new TextField(label.getText());
        currentBox.getChildren().add(editField);

        editField.setOnAction(e -> {
            String newValue = editField.getText();
            label.setText(newValue);
            currentBox.getChildren().remove(editField);
            switch (field) {
                case "nom":
                    currentAthlete.setNom(newValue);
                    break;
                case "prenom":
                    currentAthlete.setPrenom(newValue);
                    break;
                case "pays":
                    currentAthlete.setPays(newValue);
                    break;
                case "age":
                    currentAthlete.setAge(Integer.parseInt(newValue));
                    break;
                case "sexe":
                    currentAthlete.setSexe((newValue).charAt(0));
                    break;
                case "discipline":
                    currentAthlete.setDiscipline(newValue);
                    break;
                case "events":
                    currentAthlete.setEvents(newValue);
                    break;
            }
        });
    }

}
