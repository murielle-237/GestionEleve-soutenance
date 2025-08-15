package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Note;

public class NoteRepository {

    // ➤ Insérer une note
    public void insertNote(Note note) throws SQLException {
        String sql = "INSERT INTO note (id_evaluation, id_matiere, id_eleve, note_obtenue, appreciation, note_examen, note_moyenne) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DataBase.connectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, note.getId_evaluation());
            preparedStatement.setInt(2, note.getId_matiere());
            preparedStatement.setInt(3, note.getId_eleve());
            preparedStatement.setDouble(4, note.getNote_obtenue());
            preparedStatement.setString(5, note.getAppreciation());
            preparedStatement.setDouble(6, note.getNote_examen());
            preparedStatement.setDouble(7, note.getNote_moyenne());

            preparedStatement.executeUpdate();
            System.out.println("Insertion de la note réussie !");
        }
    }

    // ➤ Récupérer toutes les notes
    public List<Note> getAllNotes() throws SQLException {
        String sql = "SELECT * FROM note";
        List<Note> listeNotes = new ArrayList<>();

        try (Connection connection = DataBase.connectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id_note = resultSet.getInt("id_note");
                int id_evaluation = resultSet.getInt("id_evaluation");
                int id_matiere = resultSet.getInt("id_matiere");
                int id_eleve = resultSet.getInt("id_eleve");
                double note_obtenue = resultSet.getDouble("note_obtenue");
                String appreciation = resultSet.getString("appreciation");
                double note_examen = resultSet.getDouble("note_examen");
                double note_moyenne = resultSet.getDouble("note_moyenne");

                Note note = new Note(
                        id_note,
                        id_evaluation,
                        id_matiere,
                        id_eleve,
                        note_obtenue,
                        appreciation,
                        note_examen,
                        note_moyenne
                );

                listeNotes.add(note);
            }
        }

        return listeNotes;
    }

    // ➤ Supprimer une note par son identifiant
    public void deleteNote(int id_note) throws SQLException {
        String sql = "DELETE FROM note WHERE id_note = ?";

        try (Connection connection = DataBase.connectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id_note);
            preparedStatement.executeUpdate();
            System.out.println("Suppression de la note réussie !");
        }
    }

    // ➤ Mettre à jour une note
    public void updateNote(Note note) throws SQLException {
        String sql = "UPDATE note SET id_evaluation = ?, id_matiere = ?, id_eleve = ?, note_obtenue = ?, appreciation = ?, note_examen = ?, note_moyenne = ? WHERE id_note = ?";

        try (Connection connection = DataBase.connectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, note.getId_evaluation());
            preparedStatement.setInt(2, note.getId_matiere());
            preparedStatement.setInt(3, note.getId_eleve());
            preparedStatement.setDouble(4, note.getNote_obtenue());
            preparedStatement.setString(5, note.getAppreciation());
            preparedStatement.setDouble(6, note.getNote_examen());
            preparedStatement.setDouble(7, note.getNote_moyenne());
            preparedStatement.setInt(8, note.getId_note());

            preparedStatement.executeUpdate();
            System.out.println("Mise à jour de la note réussie !");
        }
    }
}
