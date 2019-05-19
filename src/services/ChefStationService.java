/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.ChefStation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import serviceInterfaces.IUsersService;
import utils.MyDB;

/**
 *
 * @author Khalil
 */
public class ChefStationService implements IUsersService<ChefStation>{
    
      private Connection cnx = MyDB.getInstance().getCnx();

    @Override
    public void addUser(ChefStation a) {
        
          try {
           

            String req = "INSERT INTO `chefStation` (`username`, `password`, `nom` ,`prenom`, `date_naissance`, `cin` ,`adresse`, `nomLigne`)"
                    + " VALUES ( ?, ?, ?, ?, ?, ?,? ,?) ";
            PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setString(1, a.getUsername());
            pst.setString(2, a.getPassword());
            pst.setString(3, a.getNom());
            pst.setString(4, a.getPrenom());
            pst.setString(5,  a.getDate_naissance());
            pst.setString(6, a.getCin());
            pst.setString(7, a.getAdresse());
            pst.setString(8, a.getNomLigne());
           
          
            pst.executeUpdate();
            System.out.println("chef station ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<ChefStation> getAllUsers() {
        ArrayList<ChefStation> chefs= new ArrayList<>();
        
        String req="SELECT * FROM `chefStation` ";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);
            while(rst.next()){
                ChefStation a = new ChefStation();
                a.setId(rst.getInt("id"));
                a.setUsername(rst.getString("username"));
                 a.setPassword(rst.getString("password"));
                a.setNom(rst.getString("nom"));
                a.setPrenom(rst.getString("prenom"));
                a.setDate_naissance(rst.getString("date_naissance"));
                a.setCin(rst.getString("cin"));
                a.setAdresse(rst.getString("adresse"));
                 a.setNomLigne(rst.getString("nomLigne"));
                
                chefs.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return chefs;
        
    }

    @Override
    public ArrayList<ChefStation> getAllUsersByRole(String role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(String cin) {
         try {
         

            String req = "DELETE FROM `chefStation` WHERE cin=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, cin);
            System.out.println(pst);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ChefStation getUser(int id) {
        ChefStation ab = new ChefStation();
        
        
         try {
        
         PreparedStatement pst = cnx.prepareStatement("SELECT * FROM `chefStation` WHERE id=? ");
            pst.setInt(1, id);
             
          
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                
                ab.setId(rst.getInt("id"));
                ab.setUsername(rst.getString("username"));
                 ab.setPassword(rst.getString("password"));
                ab.setNom(rst.getString("nom"));
                ab.setPrenom(rst.getString("prenom"));
                ab.setDate_naissance(rst.getString("date_naissance"));
                ab.setCin(rst.getString("cin"));
                ab.setAdresse(rst.getString("adresse"));
                 ab.setNomLigne(rst.getString("nomLigne"));
               
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ab;
    }
    
    public ArrayList<ChefStation> getAllChefStationByLigne(String nomLigne) {
         ArrayList<ChefStation> chefs= new ArrayList<>();
        
       
        try {
           
             PreparedStatement pst = cnx.prepareStatement("SELECT * FROM `chefStation` WHERE nomLigne=? ");
            pst.setString(1, nomLigne);
             
          
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                ChefStation a = new ChefStation();
                a.setId(rst.getInt("id"));
                a.setUsername(rst.getString("username"));
                 a.setPassword(rst.getString("password"));
                a.setNom(rst.getString("nom"));
                a.setPrenom(rst.getString("prenom"));
                a.setDate_naissance(rst.getString("date_naissance"));
                a.setCin(rst.getString("cin"));
                a.setAdresse(rst.getString("adresse"));
                a.setNomLigne(rst.getString("nomLigne"));
               
                chefs.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return chefs;
    }
    
     public ChefStation getChefStationByCIN(String cin) {
      ChefStation ab = new ChefStation();
       
        
         try {
        
         PreparedStatement pst = cnx.prepareStatement("SELECT * FROM `chefStation` WHERE cin=? ");
            pst.setString(1, cin);
             
          
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                
                ab.setId(rst.getInt("id"));
                ab.setUsername(rst.getString("username"));
                 ab.setPassword(rst.getString("password"));
                ab.setNom(rst.getString("nom"));
                ab.setPrenom(rst.getString("prenom"));
                ab.setDate_naissance(rst.getString("date_naissance"));
                ab.setCin(rst.getString("cin"));
                ab.setAdresse(rst.getString("adresse"));
               
                ab.setNomLigne(rst.getString("nomLigne"));
                 return ab;
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return null ;
        
    }
     
     
      public void updateChefStation(ChefStation a) {
        
          try {
   PreparedStatement pst = cnx.prepareStatement("update chauffeur set username=?,password=?,nom=?,prenom=?,date_naissance=?,cin=?,adresse=?,nomLigne=? where id=?");
    pst.setString(1, a.getUsername());
            pst.setString(2, a.getPassword());
            pst.setString(3, a.getNom());
            pst.setString(4, a.getPrenom());
            pst.setString(5,  a.getDate_naissance());
            pst.setString(6, a.getCin());
            pst.setString(7, a.getAdresse());
            pst.setString(8, a.getNomLigne());
            pst.setInt(9, a.getId());

   
      pst.executeUpdate();
   
  } catch (SQLException e) {
  }
    }
    
}
