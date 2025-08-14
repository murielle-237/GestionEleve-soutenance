package entities;

import java.sql.Date;
import java.sql.Time;

public class Historique_de_presence {
    private int id_historique;
    private int id_eleve;
    private Date date;
    private Time heure_debut;
    private Time heure_fin;
    private int id_matiere;
    private int id_enseignant;
    private String statut;       // Présent, Absent, Retard, etc.
    private String motif;        // Raison de l'absence ou du retard
    private boolean justifiee;   // True si l'absence est justifiée

    // Constructeur par défaut
    public Historique_de_presence() {
    }

    // Constructeur avec tous les champs
    public Historique_de_presence(int id_historique, int id_eleve, Date date, Time heure_debut, Time heure_fin,
                                   int id_matiere, int id_enseignant, String statut, String motif, boolean justifiee) {
        this.id_historique = id_historique;
        this.id_eleve = id_eleve;
        this.date = date;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.id_matiere = id_matiere;
        this.id_enseignant = id_enseignant;
        this.statut = statut;
        this.motif = motif;
        this.justifiee = justifiee;
    }

    // Getters
    public int getId_historique() {
        return id_historique;
    }

    public int getId_eleve() {
        return id_eleve;
    }

    public Date getDate() {
        return date;
    }

    public Time getHeure_debut() {
        return heure_debut;
    }

    public Time getHeure_fin() {
        return heure_fin;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public String getStatut() {
        return statut;
    }

    public String getMotif() {
        return motif;
    }

    public boolean isJustifiee() {
        return justifiee;
    }

    // Setters
    public void setId_historique(int id_historique) {
        this.id_historique = id_historique;
    }

    public void setId_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeure_debut(Time heure_debut) {
        this.heure_debut = heure_debut;
    }

    public void setHeure_fin(Time heure_fin) {
        this.heure_fin = heure_fin;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public void setJustifiee(boolean justifiee) {
        this.justifiee = justifiee;
    }
}
