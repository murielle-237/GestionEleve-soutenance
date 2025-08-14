package entities;


public class Parent{
    private int Id_parent;
    private String Nom;
    private String Prenom;
    private String Adresse;
    private String Email;
    private String Profession;
    private String Telephone;
    private String  Mot_de_passe; 



    public Parent(int id_parent, String nom, String prenom, String adresse, String email, String profession, String telephone, String mot_de_passe) {
        this.Id_parent = id_parent;
        this.Nom = nom;
        this.Prenom = prenom;
        this.Adresse = adresse;
        this.Email = email;
        this.Profession = profession;
        this.Telephone = telephone;
        this.Mot_de_passe = mot_de_passe;
    }

    public Parent() {
        //TODO Auto-generated constructor stub
    }

    // Getters
    public int getId_parent() { return Id_parent; }
    public String getNom() { return Nom; }
    public String getPrenom() { return Prenom; }
    public String getAdresse() { return Adresse; }
    public String getEmail() { return Email; }
    public String   getProfession() { return Profession; }
    public String getTelephone() { return Telephone; }
    public String getMot_de_passe() { return Mot_de_passe; }

    // Setters
    public void setId_parent(int id_parent) { this.Id_parent= id_parent; }
    public void setNom(String nom) { this.Nom = nom; }
    public void setPrenom(String prenom) { this.Prenom = prenom; }
    public void setAdresse(String adresse) { this.Adresse = adresse; }
    public void setEmail(String email) { this.Email = email; }
    public void setProfession(String profession) { this.Profession = profession; }
    public void setTelephone(String telephone) { this.Telephone = telephone; }
    public void setMot_de_passe(String mot_de_passe) { this.Mot_de_passe = mot_de_passe; }



    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}
