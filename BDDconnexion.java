package fr.isep.algo.classolympians;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BDDconnexion {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3307/classolympians";  //Mettre 3306 par défault, et appeller la bdd "classolympians" sur xampp
        String username = "root";
        String password = "root";

        try {
            // Charger le driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir une connexion
            Connection connex = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("Test de connectivité à la BDD : OK");
            /* Exemple d'extraction d'information de la BDD :
            // Créer un statement
            Statement stmt = connex.createStatement();

            // Exécuter une requête
            ResultSet rs = stmt.executeQuery("SELECT * FROM Athlète");

            // Traiter les résultats
            while (rs.next()) {
                int id = rs.getInt("idAthlète");
                String nom = rs.getString("Nom");
                System.out.println("ID: " + id + ", Nom: " + nom);
            }

            // Fermer les ressources
            rs.close();
            stmt.close();*/
            connex.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
