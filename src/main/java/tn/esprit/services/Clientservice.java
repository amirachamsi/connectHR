package tn.esprit.services;

import tn.esprit.interfaces.Icrud;
import tn.esprit.models.Clients;
import tn.esprit.models.Commande;
import tn.esprit.models.employe;
import tn.esprit.utils.connecthrDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Clientservice implements Icrud<Clients> {

    private Connection cnx  ;
    public Clientservice() {
        cnx = connecthrDB.getInstance().getCnx();
    }

    @Override
    public boolean add(Clients c) {
        String qryClient = "INSERT INTO clients (nom_client, prenom_client, telephone_client) VALUES (?, ?, ?)";
        String qryCommande = "INSERT INTO commandes (id_client, id_produit, quantite, prix) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pstClient = cnx.prepareStatement(qryClient, Statement.RETURN_GENERATED_KEYS);
            pstClient.setString(1, c.getNom_client());
            pstClient.setString(2, c.getPrenom_client());
            pstClient.setInt(3, c.getTelephone_client());
            pstClient.executeUpdate();

            ResultSet rs = pstClient.getGeneratedKeys();
            if (rs.next()) {
                int clientId = rs.getInt(1);
                for (Commande cmd : c.getCommandes()) {
                    PreparedStatement pstCmd = cnx.prepareStatement(qryCommande);
                    pstCmd.setInt(1, clientId);
                    pstCmd.setInt(2, cmd.getId_prod());
                    pstCmd.setInt(3, cmd.getQuantite());
                    pstCmd.setFloat(4, cmd.getPrix());
                    pstCmd.executeUpdate();
                }
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    @Override
    public List<Clients> getAll() {
        List<Clients> clients = new ArrayList<>();
        String qry ="SELECT * FROM clients ";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);

            while(rs.next()){
                Clients c =new Clients();
                c.setId_client(rs.getInt(1));
                c.setNom_client(rs.getString(2));
                c.setPrenom_client(rs.getString(3));
                c.setTelephone_client(rs.getInt(4));
                clients.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clients;
    }


    @Override
    public boolean update(Clients c) {
        String qry ="UPDATE clients SET `nom_client`=?,`prenom_client`=?,`telephone_client`=? where `id`=?";
        try {
            PreparedStatement pstm1 = cnx.prepareStatement(qry);
            pstm1.setString(1,c.getNom_client());
            pstm1.setString(2,c.getPrenom_client());
            pstm1.setInt(3,c.getTelephone_client());

            pstm1.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


    @Override
    public boolean delete(Clients c) {
        String qry ="DELETE FROM clients WHERE id=?";
        PreparedStatement pstm2 = null;

        try {
            pstm2 = cnx.prepareStatement(qry);
            pstm2.setInt(1, c.getId_client());
            pstm2.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }


}




