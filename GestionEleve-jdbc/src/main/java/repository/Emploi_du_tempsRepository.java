package repository;
import java.sql.Time;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Emploi_du_temps;

public class Emploi_du_tempsRepository {

    // ➤ Insérer un emploi du temps
    public void insertEmploi_du_temps(Emploi_du_temps Emploi_du_temps) throws SQLException {
        String sql = "INSERT INTO emploi_du_temps (id_edt, jour_semaine, heure_debut, heure_fin, id_classe, id_matiere, id_enseignant, salle) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, Emploi_du_temps.getId_edt());
            stmt.setString(2, Emploi_du_temps.getJour_semaine());
            stmt.setTime(3, Emploi_du_temps.getHeure_debut());
            stmt.setTime(4, Emploi_du_temps.getHeure_fin());
            stmt.setInt(5, Emploi_du_temps.getId_classe());
            stmt.setInt(6, Emploi_du_temps.getId_matiere());
            stmt.setInt(7, Emploi_du_temps.getId_enseignant());
            stmt.setString(8, Emploi_du_temps.getSalle());

            stmt.executeUpdate();
            System.out.println("Insertion de l'emploi du temps réussie !");
        }
    }

    // ➤ Lister tous les emplois du temps
    public List<Emploi_du_temps> getAllEmploisDuTemps() throws SQLException {
        String sql = "SELECT * FROM emploi_du_temps";
        List<Emploi_du_temps> edtList = new ArrayList<>();

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id_edt = rs.getInt("id_edt");
                String jour_semaine = rs.getString("jour_semaine");
                Time heure_debut = rs.getTime("heure_debut");
                Time heure_fin = rs.getTime("heure_fin");
                int id_classe = rs.getInt("id_classe");
                int id_matiere = rs.getInt("id_matiere");
                int id_enseignant = rs.getInt("id_enseignant");
                String salle = rs.getString("salle");

              Emploi_du_temps edt = new Emploi_du_temps(
                    id_edt,
                    jour_semaine,
                    heure_debut,
                    heure_fin,
                    id_classe,
                    id_matiere,
                    id_enseignant,
                    salle
                );

                edtList.add(edt);
            }
        }

        return edtList;
    }

    // ➤ Supprimer un emploi du temps par id
    public void deleteEmploiDuTemps(int id) throws SQLException {
        String sql = "DELETE FROM emploi_du_temps WHERE id_edt = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Suppression de l'emploi du temps réussie !");
        }
    }

    // ➤ Mettre à jour un emploi du temps
    public void updateEmploiDuTemps(Emploi_du_temps Emploi_du_temps) throws SQLException {
        String sql = "UPDATE emploi_du_temps SET WHERE id_edt = ?\"jour_semaine = ?, heure_debut = ?, heure_fin = ?, id_classe = ?, id_matiere = ?, id_enseignant = ?, salle = ? ";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, Emploi_du_temps.getId_edt());
            stmt.setString(2, Emploi_du_temps.getJour_semaine());
            stmt.setTime(3, Emploi_du_temps.getHeure_debut());
            stmt.setTime(4, Emploi_du_temps.getHeure_fin());
            stmt.setInt(5, Emploi_du_temps.getId_classe());
            stmt.setInt(6, Emploi_du_temps.getId_matiere());
            stmt.setInt(7, Emploi_du_temps.getId_enseignant());
            stmt.setString(8, Emploi_du_temps.getSalle());
            

            stmt.executeUpdate();
            System.out.println("Mise à jour de l'emploi du temps réussie !");
        }
    }
}

