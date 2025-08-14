package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Eleve;

public class EleveexamensRepository {

    // ➤ Insérer un élève
    public void insertEleve(Eleve eleve) throws SQLException {
        String sql = "INSERT INTO eleve (d_eleve, nom, prenom, date_naissance, email, telephone, adresse, id_classe) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, eleve.getId_eleve());
            stmt.setString(2, eleve.getNom());
            stmt.setString(3, eleve.getPrenom());
            stmt.setDate(4, eleve.getDate_naissance());
            stmt.setString(5, eleve.getEmail());
            stmt.setString(6, eleve.getTelephone());
            stmt.setString(7, eleve.getAdresse());
            stmt.setInt(8, eleve.getId_classe());

            stmt.executeUpdate();
            System.out.println("Insertion de l'élève réussie !");
        }
    }

    // ➤ Liste de tous les élèves
    public List<Eleve> findAll() throws SQLException {
        String sql = "SELECT * FROM eleve";
        List<Eleve> eleveList = new ArrayList<>();

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id_eleve = rs.getInt("id_eleve");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                Date date_naissance = rs.getDate("date_naissance");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                String adresse = rs.getString("adresse");
                int id_classe = rs.getInt("id_classe");

                Eleve eleve = new Eleve(id_eleve, nom, prenom, date_naissance, email, telephone, adresse, id_classe);
                eleveList.add(eleve);
            }
        }

        return eleveList;
    }

    // ➤ Supprimer un élève par d_eleve
    public void deleteEleve(int d_eleve) throws SQLException {
        String sql = "DELETE FROM eleve WHERE d_eleve = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, d_eleve);
            stmt.executeUpdate();
            System.out.println("Suppression de l'élève réussie !");
        }
    }

    // ➤ Mettre à jour un élève
    public void updateEleve(Eleve eleve) throws SQLException {
        String sql = "UPDATE eleve SET nom = ?, prenom = ?, date_naissance = ?, email = ?, telephone = ?, adresse = ?, id_classe = ? WHERE d_eleve = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, eleve.getNom());
            stmt.setString(2, eleve.getPrenom());
            stmt.setDate(3, new java.sql.Date(eleve.getDate_naissance().getTime()));
            stmt.setString(4, eleve.getEmail());
            stmt.setString(5, eleve.getTelephone());
            stmt.setString(6, eleve.getAdresse());
            stmt.setInt(7, eleve.getId_classe());
            stmt.setInt(8, eleve.getId_eleve());

            stmt.executeUpdate();
            System.out.println("Mise à jour de l'élève réussie !");
        }
    }
}

