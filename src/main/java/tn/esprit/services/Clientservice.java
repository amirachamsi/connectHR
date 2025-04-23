package tn.esprit.services;

import tn.esprit.interfaces.Icrud;
import tn.esprit.models.Clients;
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
        String qry ="INSERT INTO `c`( `nom_client`,`prenom_client`, `telephone_client`) VALUES (?,?,?)";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1, c.getNom_client());
            pstm.setString(2, c.getPrenom_client());
            pstm.setInt(3,c.getTelephone_client());

            pstm.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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




