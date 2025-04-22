package tn.esprit.services;
import tn.esprit.interfaces.Icrud;
import tn.esprit.models.employe;
import tn.esprit.utils.connecthrDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class employeservice implements Icrud<employe> {
    private Connection cnx  ;
    public employeservice(){
        cnx = connecthrDB.getInstance().getCnx();
    }

    @Override
    public boolean add(employe e) {
        String qry ="INSERT INTO `e`( `nom`,`prenom`, `telephone`,`poste`) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1,e.getNom());
            pstm.setString(2,e.getPrenom());
            pstm.setInt(3,e.getTelephone());
            pstm.setString(4,e.getPoste());
            pstm.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<employe> getAll() {
        List<employe> employes = new ArrayList<>();
        String qry ="SELECT * FROM `e`";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);

            while(rs.next()){
                employe e =new employe();
                e.setId(rs.getInt(1));
                e.setNom(rs.getString(2));
                e.setPrenom(rs.getString(3));
                e.setTelephone(rs.getInt(4));
                e.setPoste(rs.getString(5));
                employes.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return employes;
    }

    @Override
    public boolean update(employe e) {
        String qry ="UPDATE `e` SET `nom`=?,`prenom`=?,`telephone`=?,`poste`=? where `id`=?";
        try {
            PreparedStatement pstm1 = cnx.prepareStatement(qry);
            pstm1.setString(1,e.getNom());
            pstm1.setString(2,e.getPrenom());
            pstm1.setInt(3,e.getTelephone());
            pstm1.setString(4,e.getPoste());
            pstm1.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    @Override
    public boolean delete(employe e) {
        String qry ="DELETE FROM `e` WHERE id=?";
        PreparedStatement pstm2 = null;

        try {
            pstm2 = cnx.prepareStatement(qry);
            pstm2.setInt(1, e.getId());
            pstm2.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }


    }


}
