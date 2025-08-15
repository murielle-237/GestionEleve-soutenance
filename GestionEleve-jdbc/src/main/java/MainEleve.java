


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
                        System.out.print("Id_eleve : ");
                        int id_eleve = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nom : ");
                        String nom = scanner.nextLine();
                        System.out.print("Prenom : ");
                        String prenom = scanner.nextLine();
                        System.out.print("Date_de_naissance (yyyy-mm-dd) : ");
                        String date_naissance = scanner.nextLine();
                        System.out.print("Email : ");
                        String email = scanner.nextLine();
                        System.out.print("Téléphone : ");
                        String telephone = scanner.nextLine();
                        System.out.print("Adresse : ");
                        String adresse = scanner.nextLine();
                        System.out.print("Matricule : ");
                        String matricule = scanner.nextLine();
                        System.out.print("Id_classe : ");
                        int id_classe = Integer.parseInt(scanner.nextLine());

                        Eleve eleve = new Eleve(id_eleve, nom, prenom, date_naissance, email, telephone, adresse, matricule, id_classe);
                        repo.create(eleve);
                        System.out.println("Élève ajouté avec succès !");
                        break;

                    case 2:
                        System.out.print("Id_eleve à modifier : ");
                        int idModif = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nom : ");
                        String newNom = scanner.nextLine();
                        System.out.print("Prenom : ");
                        String newPrenom = scanner.nextLine();
                        System.out.print("Date_de_naissance (yyyy-mm-dd) : ");
                        String newDate_naissance = scanner.nextLine();
                        System.out.print("Email : ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Téléphone : ");
                        String newTelephone = scanner.nextLine();
                        System.out.print("Adresse : ");
                        String newAdresse = scanner.nextLine();
                        System.out.print("Matricule : ");
                        String newMatricule = scanner.nextLine();
                        System.out.print("Id_classe : ");
                        int newId_classe = Integer.parseInt(scanner.nextLine());

                        Eleve eleveModif = new Eleve(idModif, newNom, newPrenom, newDate_naissance, newEmail, newTelephone, newAdresse, newMatricule, newId_classe);
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
                                + " - " + e.getDate_naissance() + " - " + e.getEmail()
                                + " - " + e.getTelephone() + " - " + e.getAdresse()
                                + " - " + e.getMatricule() + " - Id_classe: " + e.getId_classe());
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


