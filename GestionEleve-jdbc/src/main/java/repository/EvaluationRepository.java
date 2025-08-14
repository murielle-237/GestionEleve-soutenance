package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Evaluation;

public class EvaluationRepository {

    // ➤ Insérer une évaluation
    public void insertEvaluation(Evaluation evaluation) throws SQLException {
        String sql = "INSERT INTO evaluation (titre, description, type_evaluation, date_evaluation, coefficient, id_matiere, id_classe, id_enseignant) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, evaluation.getTitre());
            stmt.setString(2, evaluation.getDescription());
            stmt.setString(3, evaluation.getType_evaluation());
            stmt.setDate(4, evaluation.getDate_evaluation());
            stmt.setDouble(5, evaluation.getCoefficient());
            stmt.setInt(6, evaluation.getId_matiere());
            stmt.setInt(7, evaluation.getId_classe());
            stmt.setInt(8, evaluation.getId_enseignant());

            stmt.executeUpdate();
            System.out.println("Insertion de l'évaluation réussie !");
        }
    }

    // ➤ Lister toutes les évaluations
    public List<Evaluation> getAllEvaluations() throws SQLException {
        String sql = "SELECT * FROM evaluation";
        List<Evaluation> evaluationList = new ArrayList<>();

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_evaluation");
                String titre = rs.getString("titre");
                String description = rs.getString("description");
                String type_evaluation = rs.getString("type_evaluation");
                Date date_evaluation = rs.getDate("date_evaluation");
                int coefficient = rs.getInt("coefficient");
                int id_matiere = rs.getInt("id_matiere");
                int id_classe = rs.getInt("id_classe");
                int id_enseignant = rs.getInt("id_enseignant");

                Evaluation evaluation = new Evaluation(id, titre, description, type_evaluation, date_evaluation, coefficient, id_matiere, id_classe, id_enseignant);
                evaluationList.add(evaluation);
            }
        }
        return evaluationList;
    }

    // ➤ Supprimer une évaluation par id
    public void deleteEvaluation(int id) throws SQLException {
        String sql = "DELETE FROM evaluation WHERE id_evaluation = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Suppression de l'évaluation réussie !");
        }
    }

    // ➤ Mettre à jour une évaluation
    public void updateEvaluation(Evaluation evaluation) throws SQLException {
        String sql = "UPDATE evaluation SET titre = ?, description = ?, type_evaluation = ?, date_evaluation = ?, coefficient = ?, id_matiere = ?, id_classe = ?, id_enseignant = ? WHERE id_evaluation = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, evaluation.getTitre());
            stmt.setString(2, evaluation.getDescription());
            stmt.setString(3, evaluation.getType_evaluation());
            stmt.setDate(4, evaluation.getDate_evaluation());
            stmt.setDouble(5, evaluation.getCoefficient());
            stmt.setInt(6, evaluation.getId_matiere());
            stmt.setInt(7, evaluation.getId_classe());
            stmt.setInt(8, evaluation.getId_enseignant());

            stmt.executeUpdate();
            System.out.println("Mise à jour de l'évaluation réussie !");
        }
    }
}
            