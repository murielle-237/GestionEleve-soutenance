package entities;


public class Enseignant{
    private int Id_enseignant;
    private String Nom;
    private String Prenom;
    private String Specialite;
    private String Email;
    private String Telephone;
    private String  Mot_de_passe; 



    public Enseignant(int id_enseignant, String nom, String prenom, String specialite, String email, String telephone, String mot_de_passe) {
        this.Id_enseignant = id_enseignant;
        this.Nom = nom;
        this.Prenom = prenom;
        this.Specialite = specialite;
        this.Email = email;
        this.Telephone = telephone;
        this.Mot_de_passe = mot_de_passe;
    }

    public Enseignant() {
        //TODO Auto-generated constructor stub
    }

    // Getters
    public int getId_enseignant() { return Id_enseignant; }
    public String getNom() { return Nom; }
    public String getPrenom() { return Prenom; }
    public String getSpecialite() { return Specialite; }
    public String getEmail() { return Email; }
    public String getTelephone() { return Telephone; }
    public String getMot_de_passe() { return Mot_de_passe; }

    // Setters
    public void setId_ensiegnant(int id_enseignant) { this.Id_enseignant= id_enseignant; }
    public void setNom(String nom) { this.Nom = nom; }
    public void setPrenom(String prenom) { this.Prenom = prenom; }
    public void setSpecialite(String specialite) { this.Specialite = specialite; }
    public void setEmail(String email) { this.Email = email; }
    public void setTelephone(String telephone) { this.Telephone = telephone; }
    public void setMot_de_passe(String mot_de_passe) { this.Mot_de_passe = mot_de_passe; }



    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}
