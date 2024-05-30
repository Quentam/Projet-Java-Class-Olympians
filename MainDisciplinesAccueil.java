package fr.isep.algo.classolympians;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainDisciplinesAccueil extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charger le fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/isep/algo/classolympians/DisciplinesAccueil.fxml"));
        Parent root = loader.load();

        // Créer et afficher la scène
        primaryStage.setTitle("Disciplines Accueil");
        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
