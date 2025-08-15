
package entities;

import java.util.*;

public class Eleve{
    private int Id_eleve;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private String Email;
    private String Date_naissance;
    private String Telephone;
    private String  Matricule;
    private int   Id_classe;
    




    public Eleve(int id_eleve, String nom, String prenom, Date newDate_naissance, String adresse, String email, String date_naissance, String telephone, String matricule, int id_classe) {
        this.Id_eleve = id_eleve;
        this.Nom = nom;
        this.Prenom = prenom;
        this.Adresse = adresse;
        this.Email = email;
        this.Date_naissance = date_naissance;
        this.Telephone = telephone;
        this.Matricule = matricule;
        this.Id_classe = id_classe;
    }

    public Eleve(int id_eleve2, String nom2, String prenom2, String date_naissance2, String email2, String telephone2,
            String adresse2, String matricule2, int id_classe2) {
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
    public String getMatricule() { return Matricule; }
    public int getId_classe() { return Id_classe; }
    // Setters
    public void setId_eleve(int id_eleve) { this.Id_eleve= id_eleve; }
    public void setNom(String nom) { this.Nom = nom; }
    public void setPrenom(String prenom) { this.Prenom = prenom; }
    public void setAdresse(String adresse) { this.Adresse = adresse; }
    public void setEmail(String email) { this.Email = email; }
    public void setDate_naissance(String date_naissance) { this.Date_naissance = date_naissance; }
    public void setTelephone(String telephone) { this.Telephone = telephone; }
    public void setMatricule(String matricule) { this.Matricule = matricule; }
    public void setId_classe(int id_classe ) { this.Id_classe = id_classe; }
   

    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public static void add(Eleve eleve) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
}
