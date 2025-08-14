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
        String sql = "INSERT INTO note (id_evaluation, id_matiere, id_eleve, note_obtenue, appreciation) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, note.getId_evaluation());
            stmt.setInt(2, note.getId_matiere());
            stmt.setInt(3, note.getId_eleve());
            stmt.setDouble(4, note.getNote_obtenue());
            stmt.setString(5, note.getAppreciation());

            stmt.executeUpdate();
            System.out.println("Insertion de la note réussie !");
        }
    }

    // ➤ Récupérer la liste de toutes les notes
    public List<Note> getAllNotes() throws SQLException {
        String sql = "SELECT * FROM note";
        List<Note> noteList = new ArrayList<>();

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idNote = rs.getInt("id_note");
                int idEvaluation = rs.getInt("id_evaluation");
                int idMatiere = rs.getInt("id_matiere");
                int idEleve = rs.getInt("id_eleve");
                double noteObtenue = rs.getDouble("note_obtenue");
                String appreciation = rs.getString("appreciation");

                Note note = new Note(idNote, idEvaluation, idMatiere, idEleve, noteObtenue, appreciation);
                noteList.add(note);
            }
        }

        return noteList;
    }

    // ➤ Supprimer une note par id
    public void deleteNote(int id) throws SQLException {
        String sql = "DELETE FROM note WHERE id_note = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Suppression de la note réussie !");
        }
    }

    // ➤ Mettre à jour une note
    public void updateNote(Note note) throws SQLException {
        String sql = "UPDATE note SET id_evaluation = ?, id_matiere = ?, id_eleve = ?, note_obtenue = ?, appreciation = ? WHERE id_note = ?";

        try (Connection conn = DataBase.connectDB();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

           stmt.setInt(1, note.getId_evaluation());
            stmt.setInt(2, note.getId_matiere());
            stmt.setInt(3, note.getId_eleve());
            stmt.setDouble(4, note.getNote_obtenue());
            stmt.setString(5, note.getAppreciation());


            stmt.executeUpdate();
            System.out.println("Mise à jour de la note réussie !");
        }
    }

    public void create(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
}
