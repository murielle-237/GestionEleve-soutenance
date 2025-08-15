

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import entities.Note;
import repository.NoteRepository;

public class MainNote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NoteRepository noteRepo = new NoteRepository();

        try {
            // 1️⃣ Saisie des informations par l'utilisateur
             System.out.print("Id_note : ");
            int id_note = sc.nextInt();

            System.out.print("Id_evaluation : ");
            int id_evaluation = sc.nextInt();

            System.out.print("Id_matière : ");
            int id_matiere = sc.nextInt();

            System.out.print("Id_elève : ");
            int id_eleve = sc.nextInt();

            System.out.print("Note_obtenue : ");
            double note_obtenue = sc.nextDouble();

            sc.nextLine(); // vider le buffer
            System.out.print("Appréciation : ");
            String appreciation = sc.nextLine();

            System.out.print("Note_examen : ");
            double note_examen = sc.nextDouble();

            System.out.print("Note_moyenne : ");
            double note_moyenne = sc.nextDouble();

            // 2️⃣ Création de l'objet Note
            Note note = new Note(
                0, // id_note (auto-incrément)
                id_evaluation,
                id_matiere,
                id_eleve,
                note_obtenue,
                appreciation,
                note_examen,
                note_moyenne
            );

            // 3️⃣ Insertion dans la base
            noteRepo.insertNote(note);
            System.out.println("✅ Note enregistrée avec succès !");

            // 4️⃣ Affichage de toutes les notes
            System.out.println("\n📋 Liste des notes :");
            List<Note> notes = noteRepo.getAllNotes();
            for (Note n : notes) {
                System.out.println(
                    "Id_note: " + n.getId_note() +
                    ", Id_evaluation: " + n.getId_evaluation() +
                    ", Id_matiere: " + n.getId_matiere() +
                    ", Id_eleve: " + n.getId_eleve() +
                    ", Note_obtenue: " + n.getNote_obtenue() +
                    ", Note_examen: " + n.getNote_examen() +
                    ", Note_moyenne: " + n.getNote_moyenne() +
                    ", Appreciation: " + n.getAppreciation()
                );
            }

        } catch (SQLException e) {
            System.err.println("❌ Erreur SQL : " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
