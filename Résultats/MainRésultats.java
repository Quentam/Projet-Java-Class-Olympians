package fr.isep.algo.classolympians;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.awt.Toolkit;


public class MainRésultats extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fr/isep/algo/classolympians/AccueilRésultats.fxml"));
        Scene scene = new Scene(root,Toolkit.getDefaultToolkit().getScreenSize().getWidth(),Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        primaryStage.setTitle("Page Résultats");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println();
    }

}
