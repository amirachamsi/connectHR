package tn.esprit.models;

public class Commande {
    private int id_prod;
    private int quantite;
    private float prix;

    public Commande(int id_prod, int quantite, float prix) {
        this.id_prod = id_prod;
        this.quantite = quantite;
        this.prix = prix;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id_prod=" + id_prod +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }
}
