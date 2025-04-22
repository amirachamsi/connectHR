package tn.esprit.models;

public class employe {

    private int id , telephone;
    private String nom, prenom, poste;


    public employe() {
    }
    public employe(int id, int telephone, String nom, String prenom, String poste) {
        this.id = id;
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }

    public employe(int telephone, String nom, String prenom, String poste) {
        this.telephone = telephone;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override
    public String toString() {
        return "employe{" +
                "id=" + id +
                ", telephone=" + telephone +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", poste='" + poste + '\'' +
                '}';
    }
}
