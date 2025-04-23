package tn.esprit.models;

public class commandes {
    private int id_commande;
    private int[] id_produit;
    private float[] prix;
    private float[] quantite;

    public commandes() {
    }

    public commandes(int id_commande, int[] id_produit, float[] prix, float[] quantite) {
        this.id_commande = id_commande;
        this.id_produit = id_produit;
        this.prix = prix;
        this.quantite = quantite;
    }

    public commandes(int[] id_produit, float[] prix, float[] quantite) {
        this.id_produit = id_produit;
        this.prix = prix;
        this.quantite = quantite;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int[] getId_produit() {
        return id_produit;
    }

    public void setId_produit(int[] id_produit) {
        this.id_produit = id_produit;
    }

    public float[] getPrix() {
        return prix;
    }

    public void setPrix(float[] prix) {
        this.prix = prix;
    }

    public float[] getQuantite() {
        return quantite;
    }

    public void setQuantite(float[] quantite) {
        this.quantite = quantite;
    }
}
