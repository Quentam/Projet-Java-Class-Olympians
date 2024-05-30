package fr.isep.algo.classolympians;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BDD_Résultats {

    private static final String DB_URL = "jdbc:mysql://localhost:3307/classolympians"; //Mettre 3306 par défaut
    private static final String USER = "root";
    private static final String PASS = "root";

    public static List<String> getRecentEvents() throws SQLException {
        List<String> events = new ArrayList<>();

        String query = "SELECT Nom_Evenement FROM EvenementSportif " +
                "WHERE Date <= NOW() ORDER BY Date DESC LIMIT 4";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                events.add(rs.getString("Nom_Evenement"));
            }
        }

        return events;
    }
}
