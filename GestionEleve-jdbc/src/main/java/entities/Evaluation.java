package entities;
import java.sql.Date;

public class Evaluation{
    private int Id_evaluation;
    private String Titre;
    private String Description;
    private String Type_evaluation;
    private Date Date_evaluation;
    private int Coefficient;
    private int Id_matiere;
    private int  Id_classe; 
    private int  Id_enseignant; 



    public Evaluation(int id_evaluation, String titre, String description, String type_evaluation, Date date_evaluation, int coefficient, int id_matiere, int id_classe, int id_enseignant ) {
        this.Id_evaluation = id_evaluation;
        this.Titre = titre;
        this.Description= description;
        this.Type_evaluation = type_evaluation;
        this.Date_evaluation= date_evaluation;
        this.Coefficient = coefficient;
        this.Id_matiere = id_matiere;
        this.Id_classe = id_classe;
        this.Id_enseignant = id_enseignant;
    }

    public Evaluation() {
        //TODO Auto-generated constructor stub
    }

    // Getters
    public int getId_evaluation() { return Id_evaluation; }
    public String getTitre() { return Titre; }
    public String getDescription() { return Description; }
    public String getType_evaluation() { return Type_evaluation	; }
    public Date getDate_evaluation() { return Date_evaluation; }
    public int    getCoefficient() { return Coefficient; }
    public int getId_matiere() { return Id_matiere; }
    public int getId_classe() { return Id_classe; }
    public int getId_enseignant() { return Id_enseignant; }

    // Setters
    public void setId_evaluation(int id_evaluation) { this.Id_evaluation= id_evaluation; }
    public void setTitre(String titre) { this.Titre = titre; }
    public void setDescription(String description) { this.Description = description; }
    public void setType_evaluation(String  type_evaluation) { this. Type_evaluation = type_evaluation; }
    public void setDate_evaluation(Date date_evaluation) { this.Date_evaluation = date_evaluation; }
    public void setCoefficient(int coefficient) { this.Coefficient = coefficient; }
    public void setId_matiere(int id_matiere) { this.Id_matiere = id_matiere; }
    public void setId_classe(int id_classe) { this.Id_classe = id_classe; }



    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}