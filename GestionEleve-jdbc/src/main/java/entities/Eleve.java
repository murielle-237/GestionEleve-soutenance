
package entities;
import java.sql.Date;
import java.util.*;

public class Eleve{
    private int Id_eleve;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private String Email;
    private String Date_naissance;
    private String Telephone;
    private String  Mot_de_passe;
    private int   Id_classe;
    



    
    public Eleve(String nom2, String prenom2, Date date_naissance2, String email2, String telephone2, String adresse2) {
        //TODO Auto-generated constructor stub
    }

    // Getters
    public int getId_eleve() { return Id_eleve; }
    public String getNom() { return Nom; }
    public String getPrenom() { return Prenom; }
    public String getAdresse() { return Adresse; }
    public String getEmail() { return Email; }
    public String  getDate_naissance() { return Date_naissance; }
    public String getTelephone() { return Telephone; }
    public String getMot_de_passe() { return Mot_de_passe; }
    public int getId_classe() { return Id_classe; }
    // Setters
    public void setId_eleve(int id_eleve) { this.Id_eleve= id_eleve; }
    public void setNom(String nom) { this.Nom = nom; }
    public void setPrenom(String prenom) { this.Prenom = prenom; }
    public void setAdresse(String adresse) { this.Adresse = adresse; }
    public void setEmail(String email) { this.Email = email; }
    public void setDate_naissance(String date_naissance) { this.Date_naissance = date_naissance; }
    public void setTelephone(String telephone) { this.Telephone = telephone; }
    public void setMot_de_passe(String mot_de_passe) { this.Mot_de_passe = mot_de_passe; }
    public void setId_classe(int id_classe ) { this.Id_classe = id_classe; }
   

    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}
