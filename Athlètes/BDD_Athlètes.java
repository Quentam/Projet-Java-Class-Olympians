package fr.isep.algo.classolympians;

import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BDD_Athlètes {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3307/classolympians"; //Mettre 3306 par défaut
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static List<Athlète> getAllAthletes() throws SQLException {
        List<Athlète> athletes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Athlète");

            while (rs.next()) {
                int athleteId = rs.getInt("idAthlète");
                String nom = rs.getString("Nom");
                String prenom = rs.getString("Prénom");
                String pays = rs.getString("Pays");
                int age = rs.getInt("Âge");
                char sexe = rs.getString("Sexe").charAt(0);

                // Retrieve the discipline name
                String disciplineQuery = "SELECT d.Nom_Discipline FROM DisciplineSportive d " +
                        "JOIN athlète_has_disciplinesportive ad ON d.idDisciplineSportive = ad.DisciplineSportive_idDisciplineSportive " +
                        "WHERE ad.Athlète_idAthlète = " + athleteId;
                Statement disciplineStmt = connection.createStatement();
                ResultSet disciplineRs = disciplineStmt.executeQuery(disciplineQuery);

                String discipline = "";
                if (disciplineRs.next()) {
                    discipline = disciplineRs.getString("Nom_Discipline");
                }

                disciplineRs.close();
                disciplineStmt.close();

                Athlète athlete = new Athlète(nom, prenom, pays, age, sexe, discipline);
                athletes.add(athlete);
            }

            rs.close();
            stmt.close();
        }
        return athletes;
    }


    public void addAthlete(Athlète athlète) throws SQLException {
        try (Connection connex = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO Athlète (Nom, Prénom, Pays, Âge, Sexe) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = connex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, athlète.getNom());
                pstmt.setString(2, athlète.getPrenom());
                pstmt.setString(3, athlète.getPays());
                pstmt.setInt(4, athlète.getAge());
                pstmt.setString(5, String.valueOf(athlète.getSexe()));

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating athlete failed, no rows affected.");
                }

                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int athleteId = generatedKeys.getInt(1);
                        String discipline = athlète.getDiscipline();
                        if (discipline != null && !discipline.isEmpty()) {
                            String disciplineQuery = "SELECT idDisciplineSportive FROM DisciplineSportive WHERE Nom_Discipline = ?";
                            try (PreparedStatement disciplineStmt = connex.prepareStatement(disciplineQuery)) {
                                disciplineStmt.setString(1, discipline);
                                try (ResultSet resultSet = disciplineStmt.executeQuery()) {
                                    if (resultSet.next()) {
                                        int disciplineId = resultSet.getInt("idDisciplineSportive ");
                                        String insertAthleteDisciplineQuery = "INSERT INTO athlete_has_disciplinesportive (Athlète_idAthlète, DisciplineSportive_idDisciplineSportive) VALUES (?, ?)";
                                        try (PreparedStatement insertAthleteDisciplineStmt = connex.prepareStatement(insertAthleteDisciplineQuery)) {
                                            insertAthleteDisciplineStmt.setInt(1, athleteId);
                                            insertAthleteDisciplineStmt.setInt(2, disciplineId);
                                            insertAthleteDisciplineStmt.executeUpdate();
                                        }
                                    } else {
                                        Platform.runLater(() -> {
                                            Alert alert = new Alert(Alert.AlertType.ERROR);
                                            alert.setTitle("Erreur");
                                            alert.setHeaderText(null);
                                            alert.setContentText("Discipline non trouvée");
                                            alert.showAndWait();
                                        });
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
