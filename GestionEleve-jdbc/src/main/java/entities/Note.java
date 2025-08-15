package entities;

public class Note {
    private int id_note;
    private int id_evaluation;
    private int id_matiere;
    private int id_eleve;
    private double note_obtenue;
    private String appreciation;

    // Nouveaux attributs
    private double note_examen;
    private double note_moyenne;

    // Constructeur complet
    public Note(int id_note, int id_evaluation, int id_matiere, int id_eleve,
                double note_obtenue, String appreciation,
                double note_examen, double note_moyenne) {
        this.id_note = id_note;
        this.id_evaluation = id_evaluation;
        this.id_matiere = id_matiere;
        this.id_eleve = id_eleve;
        this.note_obtenue = note_obtenue;
        this.appreciation = appreciation;
        this.note_examen = note_examen;
        this.note_moyenne = note_moyenne;
    }

    // Constructeur vide
    public Note() {
    }

    // Getters
    public int getId_note() { return id_note; }
    public int getId_evaluation() { return id_evaluation; }
    public int getId_matiere() { return id_matiere; }
    public int getId_eleve() { return id_eleve; }
    public double getNote_obtenue() { return note_obtenue; }
    public String getAppreciation() { return appreciation; }
    public double getNote_examen() { return note_examen; }
    public double getNote_moyenne() { return note_moyenne; }

    // Setters
    public void setId_note(int id_note) { this.id_note = id_note; }
    public void setId_evaluation(int id_evaluation) { this.id_evaluation = id_evaluation; }
    public void setId_matiere(int id_matiere) { this.id_matiere = id_matiere; }
    public void setId_eleve(int id_eleve) { this.id_eleve = id_eleve; }
    public void setNote_obtenue(double note_obtenue) { this.note_obtenue = note_obtenue; }
    public void setAppreciation(String appreciation) { this.appreciation = appreciation; }
    public void setNote_examen(double note_examen) { this.note_examen = note_examen; }
    public void setNote_moyenne(double note_moyenne) { this.note_moyenne = note_moyenne; }

    // Méthode optionnelle
    public int getId() {
        return id_note;
    }
}
