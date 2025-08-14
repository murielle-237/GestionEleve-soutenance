
package entities;
import java.sql.Date;

public class Classe{
    private int Id_classe;
    private String Nom_classe;
    private int Niveau;

    public Classe(int id_classe, String nom_classe, int niveau ) {
        this.Id_classe = id_classe;
        this.Nom_classe = nom_classe;
        this.Niveau= niveau;
       
    }

    public Classe() {
        //TODO Auto-generated constructor stub
    }

    // Getters
    public int getId_classe() { return Id_classe; }
    public String getNom_classe() { return Nom_classe; }
    public int getNiveau() { return Niveau; }
  
   
   
    // Setters
    public void setId_classe(int id_classe) { this.Id_classe= id_classe; }
    public void setNom_classe(String nom_classe) { this.Nom_classe = nom_classe; }
    public void setNiveau(int niveau) { this.Niveau = niveau; }
  

    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}
