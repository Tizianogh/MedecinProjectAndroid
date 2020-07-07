package model;

public class Medecin {
    String telephone;
    String nom;
    String prenom;
    String adresse;
    String specialite;

    public Medecin(String telephone, String nom, String prenom, String adresse, String specialite) {
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.specialite = specialite;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getSpecialite() {
        return specialite;
    }
}
