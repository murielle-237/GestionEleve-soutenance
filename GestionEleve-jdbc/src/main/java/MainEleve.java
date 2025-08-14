

import java.sql.Date;
import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import entities.Eleve;
import repository.EleveRepository;

public class MainEleve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EleveRepository repo = new EleveRepository();

        while (true) {
            System.out.println("\n=== GESTION DES ELEVES ===");
            System.out.println("1. Ajouter un élève");
            System.out.println("2. Modifier un élève");
            System.out.println("3. Supprimer un élève");
            System.out.println("4. Lister les élèves");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");

            int choix;
            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez saisir un chiffre.");
                continue;
            }

            try {
                switch (choix) {
                    case 1:
                        
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nom : ");
                        String nom = scanner.nextLine();
                        System.out.print("Prenom : ");
                        String prenom = scanner.nextLine();
                        System.out.print("Adresse : ");
                        String adresse = scanner.nextLine();
                        System.out.print("Email : ");
                        String email = scanner.nextLine();
                        System.out.print("Date_de_naissance (yyyy-mm-dd) : ");
                        String NewDate_naissance = scanner.nextLine();
                        java.sql.Date date_naissance = java.sql.Date.valueOf(NewDate_naissance);

                        System.out.print("Téléphone : ");
                        String telephone = scanner.nextLine();
                        System.out.print("Mot_de_passe : ");
                        String mot_de_passe = scanner.nextLine();
                        

                        Eleve eleve = new Eleve(id, nom, prenom, date_naissance, email, telephone, adresse);
                        eleve.setMot_de_passe(mot_de_passe);

                        repo.create(eleve);
                        System.out.println("Élève ajouté avec succès !");
                        break;

                    case 2:
                       
                        System.out.print("Nouveau Nom : ");
                        String newNom = scanner.nextLine();
                        System.out.print("Nouveau Prénom : ");
                        String newPrenom = scanner.nextLine();
                        System.out.print("Nouvelle Adresse : ");
                        String newAdresse = scanner.nextLine();
                        System.out.print("Nouvel Email : ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Nouvelle Date de naissance (yyyy-mm-dd) : ");
                        String   newDatenaissance = scanner.nextLine();
                        java.sql.Date newDate_naissance = java.sql.Date.valueOf(newDatenaissance);

                        String newTelephone = scanner.nextLine();
                        System.out.print("Nouveau Mot de passe : ");
                        String newMot_de_passe = scanner.nextLine();
                       

                        Eleve eleveModif = new Eleve( newNom, newPrenom, newDate_naissance, newEmail, newTelephone, newAdresse;=
                        eleveModif.setMot_de_passe(newMot_de_passe);

                        repo.updateEleve(eleveModif);
                        System.out.println("Élève modifié avec succès !");
                        break;

                    case 3:
                        System.out.print("Id de l'élève à supprimer : ");
                        int idSuppr = Integer.parseInt(scanner.nextLine());
                        repo.deleteEleve(idSuppr);
                        System.out.println("Élève supprimé avec succès !");
                        break;

                    case 4:
                        List<Eleve> eleves = repo.findAll();
                        for (Eleve e : eleves) {
                            System.out.println(e.getId_eleve() + " - " + e.getNom() + " " + e.getPrenom() 
                                + " - " + e.getEmail() + " - " + e.getDate_naissance() 
                                + " - " + e.getAdresse() + " - " + e.getTelephone() 
                                + " - Id_classe: " + e.getId_classe());
                        }
                        break;

                    case 0:
                        System.out.println("Au revoir !");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                        break;
                }
            } catch (SQLException e) {
                System.out.println("Erreur de base de données : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }
}


