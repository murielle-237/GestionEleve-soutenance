package entities;

import java.sql.Time;

public class Emploi_du_temps {
    private int id_edt;
    private String jour_semaine;
    private Time heure_debut;
    private Time heure_fin;
    private int id_classe;
    private int id_matiere;
    private int id_enseignant;
    private String salle;

    // Constructeur par défaut
    public Emploi_du_temps() {
    }

    // Constructeur avec tous les champs
    public Emploi_du_temps(int id_edt, String jour_semaine, Time heure_debut, Time heure_fin, int id_classe, int id_matiere, int id_enseignant, String salle) {
       
        this.id_edt = id_edt;
        this.jour_semaine = jour_semaine;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.id_classe = id_classe;
        this.id_matiere = id_matiere;
        this.id_enseignant = id_enseignant;
        this.salle = salle;
    }

    // Getters
    public int getId_edt() {
        return id_edt;
    }

    public String getJour_semaine() {
        return jour_semaine;
    }

    public Time getHeure_debut() {
        return heure_debut;
    }

    public Time getHeure_fin() {
        return heure_fin;
    }

    public int getId_classe() {
        return id_classe;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public String getSalle() {
        return salle;
    }

    // Setters
    public void setId_edt(int id_edt) {
        this.id_edt = id_edt;
    }

    public void setJour_semaine(String jour_semaine) {
        this.jour_semaine = jour_semaine;
    }

    public void setHeure_debut(Time heure_debut) {
        this.heure_debut = heure_debut;
    }

    public void setHeure_fin(Time heure_fin) {
        this.heure_fin = heure_fin;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }
}
