package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Parent;

public class ParentRepository {

    // ➤ Insérer un parent
    public void insertParent(Parent parent) throws SQLException {
        String sql = "INSERT INTO parent (nom, prenom, email, telephone, adresse, profession, mot_de_passe) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, parent.getNom());
            stmt.setString(2, parent.getPrenom());
            stmt.setString(3, parent.getEmail());
            stmt.setString(4, parent.getTelephone());
            stmt.setString(5, parent.getAdresse());
            stmt.setString(6, parent.getProfession());
            stmt.setString(7, parent.getMot_de_passe());

            stmt.executeUpdate();
            System.out.println("Insertion du parent réussie !");
        }
    }

    // ➤ Récupérer la liste de tous les parents
    public List<Parent> getAllParents() throws SQLException {
        String sql = "SELECT * FROM parent";
        List<Parent> parentList = new ArrayList<>();

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idParent = rs.getInt("id_parent");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                String adresse = rs.getString("adresse");
                String profession = rs.getString("profession");
                String motDePasse = rs.getString("mot_de_passe");

                Parent parent = new Parent(idParent, nom, prenom, email, telephone, adresse, profession, motDePasse);
                parentList.add(parent);
            }
        }

        return parentList;
    }

    // ➤ Supprimer un parent par id
    public void deleteParent(int id) throws SQLException {
        String sql = "DELETE FROM parent WHERE id_parent = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Suppression du parent réussie !");
        }
    }

    // ➤ Mettre à jour un parent
    public void updateParent(Parent parent) throws SQLException {
        String sql = "UPDATE parent SET nom = ?, prenom = ?, email = ?, telephone = ?, adresse = ?, profession = ?, mot_de_passe = ? WHERE id_parent = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(8, parent.getId_parent());
            stmt.setString(1, parent.getNom());
            stmt.setString(2, parent.getPrenom());
            stmt.setString(3, parent.getEmail());
            stmt.setString(4, parent.getTelephone());
            stmt.setString(5, parent.getAdresse());
            stmt.setString(6, parent.getProfession());
            stmt.setString(7, parent.getMot_de_passe());
      
            stmt.executeUpdate();
            System.out.println("Mise à jour du parent réussie !");
        }
    }
}
