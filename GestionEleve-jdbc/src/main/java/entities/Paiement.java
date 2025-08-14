package entities;

import java.time.LocalDate;

public class Paiement {
    private int id_paiement;
    private int id_eleve;
    private double montant;
    private String type_paiement;
    private LocalDate date_paiement;
    private String mode_paiement;
    private String statut;
    private String reference_transaction;

    // Constructeur complet
    public Paiement(int id_paiement, int id_eleve, double montant, String type_paiement, LocalDate date_paiement,
                    String mode_paiement, String statut, String reference_transaction) {
        this.id_paiement = id_paiement;
        this.id_eleve = id_eleve;
        this.montant = montant;
        this.type_paiement = type_paiement;
        this.date_paiement = date_paiement;
        this.mode_paiement = mode_paiement;
        this.statut = statut;
        this.reference_transaction = reference_transaction;
    }

    // Constructeur vide
    public Paiement() {
    }

    // Getters
    public int getId_paiement() { return id_paiement; }
    public int getId_eleve() { return id_eleve; }
    public double getMontant() { return montant; }
    public String getType_paiement() { return type_paiement; }
    public LocalDate getDate_paiement() { return date_paiement; }
    public String getMode_paiement() { return mode_paiement; }
    public String getStatut() { return statut; }
    public String getReference_transaction() { return reference_transaction; }

    // Setters
    public void setId_paiement(int id_paiement) { this.id_paiement = id_paiement; }
    public void setId_eleve(int id_eleve) { this.id_eleve = id_eleve; }
    public void setMontant(double montant) { this.montant = montant; }
    public void setType_paiement(String type_paiement) { this.type_paiement = type_paiement; }
    public void setDate_paiement(LocalDate date_paiement) { this.date_paiement = date_paiement; }
    public void setMode_paiement(String mode_paiement) { this.mode_paiement = mode_paiement; }
    public void setStatut(String statut) { this.statut = statut; }
    public void setReference_transaction(String reference_transaction) { this.reference_transaction = reference_transaction; }

    // Méthode optionnelle pour identifiant générique
    public int getId() {
        return id_paiement;
    }
}
