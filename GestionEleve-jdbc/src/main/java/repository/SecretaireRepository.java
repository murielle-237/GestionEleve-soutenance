package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Secretaire;

public class SecretaireRepository {

    // Insérer une nouvelle secrétaire
    public void insertSecretaire(Secretaire secretaire) throws SQLException {
        String sql = "INSERT INTO secretaire (nom, prenom, email, mot_de_passe, telephone, adresse,  date_naissance) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, secretaire.getNom());
            stmt.setString(2, secretaire.getPrenom());
            stmt.setString(3, secretaire.getEmail());
            stmt.setString(4, secretaire.getMot_de_passe());
            stmt.setString(5, secretaire.getTelephone());
            stmt.setString(6, secretaire.getAdresse());
            
            stmt.setDate(8, secretaire.getDate_naissance());

            stmt.executeUpdate();
            System.out.println("Insertion de la secrétaire réussie !");
        }
    }

    // Récupérer toutes les secrétaires
    public List<Secretaire> getAllSecretaires() throws SQLException {
        String sql = "SELECT * FROM secretaire";
        List<Secretaire> secretaires = new ArrayList<>();

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Secretaire s = new Secretaire(
                    rs.getInt("id_utilisateur"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("email"),
                    rs.getString("mot_de_passe"),
                    rs.getString("telephone"),
                    rs.getString("adresse"),
                   rs.getDate("date_naissance")
                );
                secretaires.add(s);
            }
        }

        return secretaires;
    }

    // Mettre à jour une secrétaire existante
    public void updateSecretaire(Secretaire secretaire) throws SQLException {
        String sql = "UPDATE secretaire SET nom = ?, prenom = ?, email = ?, mot_de_passe = ?, telephone = ?, adresse = ?, sexe = ?, date_naissance = ? WHERE id_utilisateur = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, secretaire.getNom());
            stmt.setString(2, secretaire.getPrenom());
            stmt.setString(3, secretaire.getEmail());
            stmt.setString(4, secretaire.getMot_de_passe());
            stmt.setString(5, secretaire.getTelephone());
            stmt.setString(6, secretaire.getAdresse());
            
            stmt.setDate(8, secretaire.getDate_naissance());
            stmt.setInt(9, secretaire.getId_utilisateur());

            stmt.executeUpdate();
            System.out.println("Mise à jour de la secrétaire réussie !");
        }
    }

    // Supprimer une secrétaire par id
    public void deleteSecretaire(int id) throws SQLException {
        String sql = "DELETE FROM secretaire WHERE id_utilisateur = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Suppression de la secrétaire réussie !");
        }
    }
}
