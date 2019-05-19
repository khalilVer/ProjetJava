/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Chauffeur;
import entities.Voyage;
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
public class ChauffeurService implements IUsersService<Chauffeur> {

      private final Connection cnx = MyDB.getInstance().getCnx();
      
    
    @Override
    public void addUser(Chauffeur a) {
         try {
            

            String req = "INSERT INTO `chauffeur` (`username`,`password`, `nom` ,`prenom`, `date_naissance`, `cin` ,`adresse`, `nbTacheTotal`,  `nbTacheParJour`, `dispo`, nomLigne)"
                    + " VALUES ( ?,?,?, ?, ?, ?, ?, ?, ?, ?,?) ";
            PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setString(1, a.getUsername());
            pst.setString(2, a.getPassword());
            pst.setString(3, a.getNom());
            pst.setString(4, a.getPrenom());
            pst.setString(5,  a.getDate_naissance());
            pst.setString(6, a.getCin());
            pst.setString(7, a.getAdresse());
            pst.setInt(8, a.getNbTacheTotal());
            pst.setInt(9, a.getNbTacheParJour());
            pst.setInt(10, a.getDispo());
            pst.setString(11, a.getNomLigne());
          
            pst.executeUpdate();
            System.out.println("chauffeur ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Chauffeur> getAllUsers() {
         ArrayList<Chauffeur> chauffeurs= new ArrayList<>();
        
        String req="SELECT * FROM `chauffeur` ";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);
            while(rst.next()){
                Chauffeur a = new Chauffeur();
                a.setId(rst.getInt("id"));
                a.setUsername(rst.getString("username"));
                 a.setPassword(rst.getString("password"));
                a.setNom(rst.getString("nom"));
                a.setPrenom(rst.getString("prenom"));
                a.setDate_naissance(rst.getString("date_naissance"));
                a.setCin(rst.getString("cin"));
                a.setAdresse(rst.getString("adresse"));
                a.setNbTacheTotal(rst.getInt("nbTacheTotal"));
                a.setNbTacheParJour(rst.getInt("nbTacheParJour"));
                a.setDispo(rst.getInt("dispo"));
                a.setNomLigne(rst.getString("nomLigne"));
                
                
                chauffeurs.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return chauffeurs;
    }

    @Override
    public ArrayList<Chauffeur> getAllUsersByRole(String role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(String cin) {
        
          try {
         

            String req = "DELETE FROM `chauffeur` WHERE cin=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, cin);
          
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Chauffeur getUser(int id) {
        Chauffeur ab = new Chauffeur();
        
        
         try {
        
         PreparedStatement pst = cnx.prepareStatement("SELECT * FROM `chauffeur` WHERE id=? ");
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
                ab.setNbTacheTotal(rst.getInt("nbTacheTotal"));
                ab.setNbTacheParJour(rst.getInt("nbTacheParJour"));
                ab.setDispo(rst.getInt("dispo"));
                ab.setNomLigne(rst.getString("nomLigne"));
               
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ab;
        
    }
    
    
     public ArrayList<Chauffeur> getAllChauffeurByLigne(String nomLigne) {
         ArrayList<Chauffeur> chauffeurs= new ArrayList<>();
        
       
        try {
           
             PreparedStatement pst = cnx.prepareStatement("SELECT * FROM `chauffeur` WHERE nomLigne=? ");
            pst.setString(1, nomLigne);
             
          
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                Chauffeur a = new Chauffeur();
                a.setId(rst.getInt("id"));
                a.setUsername(rst.getString("username"));
                 a.setPassword(rst.getString("password"));
                a.setNom(rst.getString("nom"));
                a.setPrenom(rst.getString("prenom"));
                a.setDate_naissance(rst.getString("date_naissance"));
                a.setCin(rst.getString("cin"));
                a.setAdresse(rst.getString("adresse"));
                  a.setNbTacheTotal(rst.getInt("nbTacheTotal"));
                a.setNbTacheParJour(rst.getInt("nbTacheParJour"));
                a.setDispo(rst.getInt("dispo"));
                a.setNomLigne(rst.getString("nomLigne"));
               
                chauffeurs.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return chauffeurs;
    }
     
     public ArrayList<Chauffeur> getAllChauffeurDispo() {
         ArrayList<Chauffeur> chauffeurs= new ArrayList<>();
        
        String req="SELECT * FROM `chauffeur` WHERE dispo=1 ";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);
            while(rst.next()){
                Chauffeur a = new Chauffeur();
                a.setId(rst.getInt("id"));
                a.setUsername(rst.getString("username"));
                 a.setPassword(rst.getString("password"));
                a.setNom(rst.getString("nom"));
                a.setPrenom(rst.getString("prenom"));
                a.setDate_naissance(rst.getString("date_naissance"));
                a.setCin(rst.getString("cin"));
                a.setAdresse(rst.getString("adresse"));
                a.setNbTacheTotal(rst.getInt("nbTacheTotal"));
                a.setNbTacheParJour(rst.getInt("nbTacheParJour"));
                a.setDispo(rst.getInt("dispo"));
                a.setNomLigne(rst.getString("nomLigne"));
                
                
                chauffeurs.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return chauffeurs;
    }

      public Chauffeur getChauffeurByCIN(String cin) {
      Chauffeur ab = new Chauffeur();
       
        
         try {
        
         PreparedStatement pst = cnx.prepareStatement("SELECT * FROM `chauffeur` WHERE cin=? ");
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
                ab.setNbTacheTotal(rst.getInt("nbTacheTotal"));
                ab.setNbTacheParJour(rst.getInt("nbTacheParJour"));
                ab.setDispo(rst.getInt("dispo"));
                ab.setNomLigne(rst.getString("nomLigne"));
                    return ab; 
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   return null ;
        
    }
     
      public void updateChauffeur(Chauffeur a) {
        
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
