package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import tn.esprit.models.Clients;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AjouterClient {

    @FXML private TextField phoneField, nomField, prenomField, telField;
    @FXML private VBox clientInfo, addClientForm;
    @FXML private Label clientNameLabel;

    private final List<Clients> clients = new ArrayList<>(); // Simulation BDD

    @FXML
    public void searchClient() {
        try {
            int tel = Integer.parseInt(phoneField.getText());
            Optional<Clients> clientOpt = clients.stream()
                    .filter(c -> c.getTelephone_client() == tel)
                    .findFirst();

            if (clientOpt.isPresent()) {
                Clients client = clientOpt.get();
                clientNameLabel.setText("Client trouvé : " + client.getNom_client() + " " + client.getPrenom_client());
                clientInfo.setVisible(true);
                addClientForm.setVisible(false);
            } else {
                telField.setText(phoneField.getText());
                clientInfo.setVisible(false);
                addClientForm.setVisible(true);
            }
        } catch (NumberFormatException e) {
            showAlert("Erreur", "Veuillez saisir un numéro de téléphone valide.");
        }
    }

    @FXML
    public void addClient() {
        try {
            Clients newClient = new Clients(
                    nomField.getText(),
                    prenomField.getText(),
                    Integer.parseInt(telField.getText())
            );
            clients.add(newClient);
            clientNameLabel.setText("Nouveau client ajouté : " + newClient.getNom_client() + " " + newClient.getPrenom_client());
            clientInfo.setVisible(true);
            addClientForm.setVisible(false);
        } catch (NumberFormatException e) {
            showAlert("Erreur", "Le numéro de téléphone doit être un entier.");
        }
    }

    @FXML
    public void createOrder() {
        showAlert("Commande", "Passage de commande pour ce client (à implémenter).");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
