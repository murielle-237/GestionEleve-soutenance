package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Devoir;

public class DevoirRepository {

    // ➤ Insérer un devoir
    public void insertDevoir(Devoir devoir) throws SQLException {
        String sql = "INSERT INTO devoir (titre_devoir, description_devoir, type_devoir, date_publication, date_limite, id_matiere, id_classe, id_enseignant, fichier_joint, visible_par_eleve) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, devoir.getId_devoir());
            stmt.setString(2, devoir.getDescription_devoir());
            stmt.setString(3, devoir.getType_devoir());
            stmt.setDate(4, devoir.getDate_publication());
            stmt.setDate(5, devoir.getDate_limite());
            stmt.setInt(6, devoir.getId_matiere());
            stmt.setInt(7, devoir.getId_classe());
            stmt.setInt(8, devoir.getId_enseignant());
            stmt.setString(9, devoir.getFichier_joint());
            stmt.setBoolean(10, devoir.isVisible_par_eleve());
            stmt.executeUpdate();
            System.out.println("Insertion du devoir réussie !");
        }
    }

    // ➤ Liste de tous les devoirs
    public List<Devoir> getAllDevoirs() throws SQLException {
        String sql = "SELECT * FROM devoir";
        List<Devoir> devoirList = new ArrayList<>();

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id_devoir = rs.getInt("id_devoir");
                String titre = rs.getString("titre_devoir");
                String description_devoir = rs.getString("description_devoir");
                String type_devoir = rs.getString("type_devoir");
                Date date_Publication = rs.getDate("date_publication");
                Date date_limite = rs.getDate("date_limite");
                int id_matiere = rs.getInt("id_matiere");
                int id_classe = rs.getInt("id_classe");
                int id_enseignant = rs.getInt("id_enseignant");
                String fichier_joint = rs.getString("fichier_joint");
                boolean visible_par_eleve = rs.getBoolean("visible_par_eleve");

                Devoir devoir = new Devoir(
                    id_devoir,
                    titre,
                    description_devoir,
                  type_devoir,
                   date_Publication,
                    date_limite,
                    id_matiere,
                    id_classe,
                    id_enseignant,
                   fichier_joint,
                   visible_par_eleve
                );

                devoirList.add(devoir);
            }
        }

        return devoirList;
    }

    // ➤ Supprimer un devoir par id
    public void deleteDevoir(int id) throws SQLException {
        String sql = "DELETE FROM devoir WHERE id_devoir = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Suppression du devoir réussie !");
        }
    }

    // ➤ Mettre à jour un devoir
    public void updateDevoir(Devoir devoir) throws SQLException {
        String sql = "UPDATE devoir SET titre_devoir = ?, description_devoir = ?, type_devoir = ?, date_publication = ?, date_limite = ?, id_matiere = ?, id_classe = ?, id_enseignant = ?, fichier_joint = ?, visible_par_eleve = ? WHERE id_devoir = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, devoir.getId_devoir());
            stmt.setString(2, devoir.getDescription_devoir());
            stmt.setString(3, devoir.getType_devoir());
            stmt.setDate(4, devoir.getDate_publication());
            stmt.setDate(5, devoir.getDate_limite());
            stmt.setInt(6, devoir.getId_matiere());
            stmt.setInt(7, devoir.getId_classe());
            stmt.setInt(8, devoir.getId_enseignant());
            stmt.setString(9, devoir.getFichier_joint());
            stmt.setBoolean(10, devoir.isVisible_par_eleve());
            

            stmt.executeUpdate();
            System.out.println("Mise à jour du devoir réussie !");
        }
    }
}
