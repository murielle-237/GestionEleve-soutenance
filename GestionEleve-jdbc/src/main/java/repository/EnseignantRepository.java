package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Enseignant;

public class EnseignantRepository {

    // ➤ Insérer un enseignant
    public void insertEnseignant(Enseignant enseignant) throws SQLException {
        String sql = "INSERT INTO enseignant (nom, prenom, specialite, email, telephone, mot_de_passe) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, enseignant.getNom());
            stmt.setString(2, enseignant.getPrenom());
            stmt.setString(3, enseignant.getSpecialite());
            stmt.setString(4, enseignant.getEmail());
            stmt.setString(5, enseignant.getTelephone());
            stmt.setString(6, enseignant.getMot_de_passe());

            stmt.executeUpdate();
            System.out.println("Insertion de l'enseignant réussie !");
        }
    }

    // ➤ Lister tous les enseignants
    public List<Enseignant> getAllEnseignants() throws SQLException {
        String sql = "SELECT * FROM enseignant";
        List<Enseignant> enseignantList = new ArrayList<>();

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_enseignant");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String specialite = rs.getString("specialite");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                String motDePasse = rs.getString("mot_de_passe");

                Enseignant enseignant = new Enseignant(id, nom, prenom, specialite, email, telephone, motDePasse);
                enseignantList.add(enseignant);
            }
        }
        return enseignantList;
    }

    // ➤ Supprimer un enseignant par id
    public void deleteEnseignant(int id) throws SQLException {
        String sql = "DELETE FROM enseignant WHERE id_enseignant = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Suppression de l'enseignant réussie !");
        }
    }

    // ➤ Mettre à jour un enseignant
    public void updateEnseignant(Enseignant enseignant) throws SQLException {
        String sql = "UPDATE enseignant SET nom = ?, prenom = ?, specialite = ?, email = ?, telephone = ?, mot_de_passe = ? WHERE id_enseignant = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(7, enseignant.getId_enseignant());
            stmt.setString(1, enseignant.getNom());
            stmt.setString(2, enseignant.getPrenom());
            stmt.setString(3, enseignant.getSpecialite());
            stmt.setString(4, enseignant.getEmail());
            stmt.setString(5, enseignant.getTelephone());
            stmt.setString(6, enseignant.getMot_de_passe());
            stmt.setInt(7, enseignant.getId_enseignant());

            stmt.executeUpdate();
            System.out.println("Mise à jour de l'enseignant réussie !");
        }
    }
}
