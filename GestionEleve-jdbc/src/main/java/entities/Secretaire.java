package entities;
import java.sql.Date;

public class Secretaire{
    private int Id_utilisateur;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private String Email;
    private Date Date_naissance;
    private String Telephone;
    private Character Sexe;
    private String  Mot_de_passe; 



    public Secretaire(int id_utilisateur, String nom, String prenom, String adresse, String email, Date date_naissance, String telephone, Character sexe, String mot_de_passe) {
        this.Id_utilisateur = id_utilisateur;
        this.Nom = nom;
        this.Prenom = prenom;
        this.Adresse = adresse;
        this.Email = email;
        this.Date_naissance = date_naissance;
        this.Telephone = telephone;
        this.Sexe = sexe;
        this.Mot_de_passe = mot_de_passe;
    }

    public Secretaire(int i, String string, String string2, String string3, String string4, String string5, String string6, Date date) {
        //TODO Auto-generated constructor stub
    }

    // Getters
    public int getId_utilisateur() { return Id_utilisateur; }
    public String getNom() { return Nom; }
    public String getPrenom() { return Prenom; }
    public String getAdresse() { return Adresse; }
    public String getEmail() { return Email; }
    public Date   getDate_naissance() { return Date_naissance; }
    public String getTelephone() { return Telephone; }
    public Character getSexe() { return Sexe; }
    public String getMot_de_passe() { return Mot_de_passe; }

    // Setters
    public void setId_utilisateur(int id_utilisateur) { this.Id_utilisateur= id_utilisateur; }
    public void setNom(String nom) { this.Nom = nom; }
    public void setPrenom(String prenom) { this.Prenom = prenom; }
    public void setAdresse(String adresse) { this.Adresse = adresse; }
    public void setEmail(String email) { this.Email = email; }
    public void setDate_naissance(Date date_naissance) { this.Date_naissance = date_naissance; }
    public void setTelephone(String telephone) { this.Telephone = telephone; }
    public void setSexe(Character sexe) { this.Sexe = sexe; }
    public void setMot_de_passe(String mot_de_passe) { this.Mot_de_passe = mot_de_passe; }

  

    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}
