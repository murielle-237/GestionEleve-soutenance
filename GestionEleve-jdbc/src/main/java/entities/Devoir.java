

package entities;

import java.sql.Date;

public class Devoir {
    private int id_devoir;
    private String titre_devoir;
    private String description_devoir;
    private String type_devoir;
    private Date date_publication;
    private Date date_limite;
    private int id_matiere;
    private int id_classe;
    private int id_enseignant;
    private String fichier_joint;
    private boolean visible_par_eleve;

    // Constructeur par défaut
    public Devoir() {
    }

    // Constructeur avec tous les champs
    public Devoir(int id_devoir, String titre_devoir, String description_devoir, String type_devoir,
                  Date date_publication, Date date_limite, int id_matiere, int id_classe,
                  int id_enseignant, String fichier_joint, boolean visible_par_eleve) {
        this.id_devoir = id_devoir;
        this.titre_devoir = titre_devoir;
        this.description_devoir = description_devoir;
        this.type_devoir = type_devoir;
        this.date_publication = date_publication;
        this.date_limite = date_limite;
        this.id_matiere = id_matiere;
        this.id_classe = id_classe;
        this.id_enseignant = id_enseignant;
        this.fichier_joint = fichier_joint;
        this.visible_par_eleve = visible_par_eleve;
    }

    // Getters
    public int getId_devoir() {
        return id_devoir;
    }

    public String getTitre_devoir() {
        return titre_devoir;
    }

    public String getDescription_devoir() {
        return description_devoir;
    }

    public String getType_devoir() {
        return type_devoir;
    }

    public Date getDate_publication() {
        return date_publication;
    }

    public Date getDate_limite() {
        return date_limite;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public int getId_classe() {
        return id_classe;
    }

    public int getId_enseignant() {
        return id_enseignant;
    }

    public String getFichier_joint() {
        return fichier_joint;
    }

    public boolean isVisible_par_eleve() {
        return visible_par_eleve;
    }

    // Setters
    public void setId_devoir(int id_devoir) {
        this.id_devoir = id_devoir;
    }

    public void setTitre_devoir(String titre_devoir) {
        this.titre_devoir = titre_devoir;
    }

    public void setDescription_devoir(String description_devoir) {
        this.description_devoir = description_devoir;
    }

    public void setType_devoir(String type_devoir) {
        this.type_devoir = type_devoir;
    }

    public void setDate_publication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public void setDate_limite(Date date_limite) {
        this.date_limite = date_limite;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public void setId_enseignant(int id_enseignant) {
        this.id_enseignant = id_enseignant;
    }

    public void setFichier_joint(String fichier_joint) {
        this.fichier_joint = fichier_joint;
    }

    public void setVisible_par_eleve(boolean visible_par_eleve) {
        this.visible_par_eleve = visible_par_eleve;
    }
}
