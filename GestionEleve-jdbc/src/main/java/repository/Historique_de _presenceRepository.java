import java.sql.Date;
import java.sql.Time;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import entities.Historique_de_presence;
import repository.HistoriquePresenceRepository;

public class MainHistoriquePresence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HistoriquePresenceRepository repo = new HistoriquePresenceRepository();

        while (true) {
            System.out.println("\n=== GESTION DES HISTORIQUES DE PRESENCE ===");
            System.out.println("1. Ajouter un historique");
            System.out.println("2. Modifier un historique");
            System.out.println("3. Supprimer un historique");
            System.out.println("4. Lister les historiques");
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
                        System.out.print("Id élève : ");
                        int idEleve = Integer.parseInt(scanner.nextLine());
                        System.out.print("Date (yyyy-mm-dd) : ");
                        Date date = Date.valueOf(scanner.nextLine());
                        System.out.print("Heure début (HH:mm:ss) : ");
                        Time heureDebut = Time.valueOf(scanner.nextLine());
                        System.out.print("Heure fin (HH:mm:ss) : ");
                        Time heureFin = Time.valueOf(scanner.nextLine());
                        System.out.print("Id Matière : ");
                        int idMatiere = Integer.parseInt(scanner.nextLine());
                        System.out.print("Id Enseignant : ");
                        int idEnseignant = Integer.parseInt(scanner.nextLine());
                        System.out.print("Statut (Présent/Absent/Retard) : ");
                        String statut = scanner.nextLine();
                        System.out.print("Motif (si absent ou retard) : ");
                        String motif = scanner.nextLine();
                        System.out.print("Justifiée ? (true/false) : ");
                        boolean justifiee = Boolean.parseBoolean(scanner.nextLine());

                        Historique_de_presence historique = new Historique_de_presence(
                                0, idEleve, date, heureDebut, heureFin,
                                idMatiere, idEnseignant, statut, motif, justifiee
                        );

                        repo.insertHistorique(historique);
                        System.out.println("Historique ajouté avec succès !");
                        break;

                    case 2:
                        System.out.print("Id de l'historique à modifier : ");
                        int idModif = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nouvel Id élève : ");
                        int newIdEleve = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nouvelle date (yyyy-mm-dd) : ");
                        Date newDate = Date.valueOf(scanner.nextLine());
                        System.out.print("Nouvelle heure début (HH:mm:ss) : ");
                        Time newHeureDebut = Time.valueOf(scanner.nextLine());
                        System.out.print("Nouvelle heure fin (HH:mm:ss) : ");
                        Time newHeureFin = Time.valueOf(scanner.nextLine());
                        System.out.print("Nouvel Id Matière : ");
                        int newIdMatiere = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nouvel Id Enseignant : ");
                        int newIdEnseignant = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nouveau statut : ");
                        String newStatut = scanner.nextLine();
                        System.out.print("Nouveau motif : ");
                        String newMotif = scanner.nextLine();
                        System.out.print("Justifiée ? (true/false) : ");
                        boolean newJustifiee = Boolean.parseBoolean(scanner.nextLine());

                        Historique_de_presence historiqueModif = new Historique_de_presence(
                                idModif, newIdEleve, newDate, newHeureDebut, newHeureFin,
                                newIdMatiere, newIdEnseignant, newStatut, newMotif, newJustifiee
                        );

                        repo.updateHistorique(historiqueModif);
                        System.out.println("Historique modifié avec succès !");
                        break;

                    case 3:
                        System.out.print("Id de l'historique à supprimer : ");
                        int idSuppr = Integer.parseInt(scanner.nextLine());
                        repo.deleteHistorique(idSuppr);
                        System.out.println("Historique supprimé avec succès !");
                        break;

                    case 4:
                        List<Historique_de_presence> historiques = repo.getAllHistoriques();
                        for (Historique_de_presence h : historiques) {
                            System.out.println(h.getId_historique() + " - Élève ID: " + h.getId_eleve()
                                    + " - Date: " + h.getDate() + " - Début: " + h.getHeure_debut()
                                    + " - Fin: " + h.getHeure_fin() + " - Matière ID: " + h.getId_matiere()
                                    + " - Enseignant ID: " + h.getId_enseignant() + " - Statut: " + h.getStatut()
                                    + " - Motif: " + h.getMotif() + " - Justifiée: " + h.isJustifiee());
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
