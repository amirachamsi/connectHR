/*package tn.esprit;

import tn.esprit.models.Clients;
import tn.esprit.services.Clientservice;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Exemple de service Clients
        Clientservice service = new Clientservice();

        // 1. Créer un nouveau client
        Clients client = new Clients();
        client.setNom_client("Ahmed");
        client.setPrenom_client("Ben Salah");
        client.setTelephone_client(55443322);

        // Produits et quantités associés
        int[] produits = {101, 102, 103};
        float[] quantites = {2, 1, 5};

        client.setId_produit(produits);
        client.setQuantite_commande(quantites);

        client.setDate_commande(LocalDate.now());

        System.out.println("Ajout du client...");
        if (service.add(client)) {
            System.out.println("Client ajouté avec succès !");
        } else {
            System.out.println("Erreur lors de l'ajout du client !");
        }

        // 2. Modifier le client
        client.setNom_client("Ahmed Modifié");
        client.setQuantite_commande(new float[]{3, 2, 1}); // Modifier quantités par ex.

        System.out.println("\nModification du client...");
        if (service.update(client)) {
            System.out.println("Client modifié avec succès !");
        } else {
            System.out.println("Erreur lors de la modification du client !");
        }

        // 3. Supprimer le client
        /*System.out.println("\nSuppression du client...");
        if (service.delete(client)) {
            System.out.println("Client supprimé avec succès !");
        } else {
            System.out.println("Erreur lors de la suppression du client !");
        }
    }
}*/