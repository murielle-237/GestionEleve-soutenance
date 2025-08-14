package repository;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Eleve;

public class EleveRepository {

    // ➤ Créer / insérer un élève
    public void create(Eleve eleve) throws SQLException {
        String sql = "INSERT INTO Eleve (id_eleve, nom, prenom, date_naissance, email, telephone, adresse, id_classe, mot_de_passe) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, eleve.getId_eleve());
            stmt.setString(2, eleve.getNom());
            stmt.setString(3, eleve.getPrenom());
            stmt.setString(4, eleve.getDate_naissance());
            stmt.setString(5, eleve.getEmail());
            stmt.setString(6, eleve.getTelephone());
            stmt.setString(7, eleve.getAdresse());
            stmt.setInt(8, eleve.getId_classe());
            stmt.setString(9, eleve.getMot_de_passe());

            stmt.executeUpdate();
            System.out.println("✅ Élève ajouté avec succès !");
        }
    }

    // ➤ Liste de tous les élèves
    public List<Eleve> findAll() throws SQLException {
        String sql = "SELECT * FROM Eleve";
        List<Eleve> eleveList = new ArrayList<>();

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id_eleve = rs.getInt("id_eleve");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String date_naissance = rs.getString("date_naissance");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                String adresse = rs.getString("adresse");
                int id_classe = rs.getInt("id_classe");
                String mot_de_passe = rs.getString("mot_de_passe");

                Eleve eleve = new Eleve(id_eleve, nom, prenom, date_naissance, email, telephone, adresse, id_classe);
                eleve.setMot_de_passe(mot_de_passe);

                eleveList.add(eleve);
            }
        }
        return eleveList;
    }

    // ➤ Supprimer un élève par id_eleve
    public void deleteEleve(int id_eleve) throws SQLException {
        String sql = "DELETE FROM Eleve WHERE id_eleve = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id_eleve);
            stmt.executeUpdate();
            System.out.println("🗑 Élève supprimé avec succès !");
        }
    }

    // ➤ Mettre à jour un élève
    public void updateEleve(Eleve eleve) throws SQLException {
        String sql = "UPDATE Eleve SET nom = ?, prenom = ?, date_naissance = ?, email = ?, telephone = ?, adresse = ?, id_classe = ?, mot_de_passe = ? " +
                     "WHERE id_eleve = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, eleve.getNom());
            stmt.setString(2, eleve.getPrenom());
            stmt.setString(3, eleve.getDate_naissance());
            stmt.setString(4, eleve.getEmail());
            stmt.setString(5, eleve.getTelephone());
            stmt.setString(6, eleve.getAdresse());
            stmt.setInt(7, eleve.getId_classe());
            stmt.setString(8, eleve.getMot_de_passe());
            stmt.setInt(9, eleve.getId_eleve());

            stmt.executeUpdate();
            System.out.println("✏ Élève modifié avec succès !");
        }
    }
}
