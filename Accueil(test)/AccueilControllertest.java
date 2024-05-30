package fr.isep.algo.accueilprojet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;

public class AccueilController {

    @FXML
    private WebView webView;

    public void initialize() {
        WebEngine webEngine = webView.getEngine();
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"fr\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Class Olympians</title>\n" +
                "    <style>\n" +
                "        html, body {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            height: 100%;\n" +
                "            overflow: hidden;\n" +
                "            font-family: Arial, sans-serif;\n" +
                "        }\n" +
                "        body {\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "            align-items: center;\n" +
                "            background: url('fond.jpg') no-repeat center center fixed;\n" +
                "            background-size: cover;\n" +
                "            color: white;\n" +
                "            text-shadow: 2px 2px 4px #000;\n" +
                "        }\n" +
                "        .container {\n" +
                "            text-align: center;\n" +
                "            position: relative;\n" +
                "            width: 100%;\n" +
                "            height: 100%;\n" +
                "        }\n" +
                "        header {\n" +
                "            position: absolute;\n" +
                "            top: 10px;\n" +
                "            width: 100%;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        .logo {\n" +
                "            position: absolute;\n" +
                "            top: 10px;\n" +
                "            right: 10px;\n" +
                "            width: 80px;\n" +
                "        }\n" +
                "        h1 {\n" +
                "            margin: 5px 0;\n" +
                "            font-size: 2.5vw;\n" +
                "        }\n" +
                "        h2 {\n" +
                "            margin: 5px 0;\n" +
                "            font-size: 1.5vw;\n" +
                "        }\n" +
                "        main {\n" +
                "            position: relative;\n" +
                "            width: 100%;\n" +
                "            height: 100%;\n" +
                "        }\n" +
                "        .circle {\n" +
                "            width: 30vw;\n" +
                "            height: 30vw;\n" +
                "            border-radius: 50%;\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "            position: absolute;\n" +
                "            color: white;\n" +
                "            text-shadow: 2px 2px 4px #000;\n" +
                "            font-size: 1.5vw;\n" +
                "            font-weight: bold;\n" +
                "            opacity: 0.9;\n" +
                "        }\n" +
                "        .athletes {\n" +
                "            background: rgba(0, 123, 255, 0.7);\n" +
                "            top: 18%;\n" +
                "            left: 2%;\n" +
                "        }\n" +
                "        .disciplines {\n" +
                "            background: rgba(0, 0, 0, 0.7);\n" +
                "            top: 18%;\n" +
                "            left: 34%;\n" +
                "        }\n" +
                "        .events {\n" +
                "            background: rgba(255, 0, 0, 0.7);\n" +
                "            top: 19%;\n" +
                "            left: 66.5%;\n" +
                "        }\n" +
                "        .results {\n" +
                "            background: rgba(255, 165, 0, 0.7);\n" +
                "            top: 50%;\n" +
                "            left: 17%;\n" +
                "        }\n" +
                "        .reports {\n" +
                "            background: rgba(0, 128, 0, 0.7);\n" +
                "            top: 51.5%;\n" +
                "            left: 50.5%;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "    <header>\n" +
                "        <img src=\"logo.png\" alt=\"Logo Paris 2024\" class=\"logo\">\n" +
                "        <h1>Bienvenue sur Class Olympians</h1>\n" +
                "        <h2>votre application de gestion des J.O. 2024</h +
                "    </header>\n" +
                "    <main>\n" +
                "        <div class=\"circle athletes\"><a href=\"athletes\">Athlètes</a></div>\n" +
                "        <div class=\"circle disciplines\"><a href=\"disciplines\">Disciplines Sportive</a></div>\n" +
                "        <div class=\"circle events\"><a href=\"events\">Évènements Sportif</a></div>\n" +
                "        <div class=\"circle results\"><a href=\"results\">Résultats</a></div>\n" +
                "        <div class=\"circle reports\"><a href=\"reports\">Génération de rapports</a></div>\n" +
                "    </main>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";

        webEngine.loadContent(htmlContent);

        // Handle hyperlink click
        webEngine.setCreatePopupHandler(config -> {
            WebEngine newWebEngine = new WebEngine();
            newWebEngine.locationProperty().addListener((obs, oldLocation, newLocation) -> {
                if (newLocation != null) {
                    handleNavigation(newLocation);
                }
            });
            return newWebEngine;
        });
    }

    private void handleNavigation(String location) {
        if (location.endsWith("athletes")) {
            loadPage("athletes.fxml");
        } else if (location.endsWith("disciplines")) {
            loadPage("disciplines.fxml");
        } else if (location.endsWith("events")) {
            loadPage("events.fxml");
        } else if (location.endsWith("results")) {
            loadPage("results.fxml");
        } else if (location.endsWith("reports")) {
            loadPage("reports.fxml");
        }
    }

    private void loadPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlFile));
            AnchorPane newPage = loader.load();

            Stage stage = (Stage) webView.getScene().getWindow();
            Scene scene = new Scene(newPage);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
