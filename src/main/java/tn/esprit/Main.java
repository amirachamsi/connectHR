package tn.esprit;

import tn.esprit.models.Clients;
import tn.esprit.models.Commande;
import tn.esprit.services.Clientservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Commande cmd1 = new Commande(101, 2, 50.0f);  // produit ID 101, 2 unités à 50 TND
        Commande cmd2 = new Commande(102, 1, 30.0f);  // produit ID 102, 1 unité à 30 TND

        List<Commande> commandes = new ArrayList<>();
        commandes.add(cmd1);
        commandes.add(cmd2);


        Clients client = new Clients("Ali", "Ben Salah", 55443322);
        client.setCommandes(commandes);


        Clientservice clientService = new Clientservice();
        boolean success = clientService.add(client);


        if (success) {
            System.out.println("✅ Client ajouté avec succès !");
        } else {
            System.out.println("❌ Échec de l'ajout du client.");
        }
    }
}