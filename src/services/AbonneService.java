/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Abonne;
import entities.Users;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.MyDB;

import serviceInterfaces.IUsersService;

/**
 *
 * @author bhk
 */
public class AbonneService implements IUsersService<Abonne>{

    private Connection cnx = MyDB.getInstance().getCnx();


   

   
    
//    @Override
//    public ArrayList<Users> getAllAbonnesByRole(String role) {
//        ArrayList<Users> abonnes= new ArrayList<>();
//        cnx = MyDB.getInstance().getCnx();
//       
//        try {
//           
//             PreparedStatement pst = cnx.prepareStatement("SELECT * FROM `abonne` WHERE role=? ");
//            pst.setString(1, role);
//             
//          
//            ResultSet rst = pst.executeQuery();
//            while(rst.next()){
//                Users a = new Users();
//                a.setId(rst.getInt("id"));
//                a.setUsername(rst.getString("username"));
//                 a.setPassword(rst.getString("password"));
//                a.setNom(rst.getString("nom"));
//                a.setPrenom(rst.getString("prenom"));
//                a.setDate_naissance(rst.getString("date_naissance"));
//                a.setCin(rst.getString("cin"));
//                a.setAdresse(rst.getString("addresse"));
//                a.setRole(rst.getString("role"));
//                abonnes.add(a);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return abonnes;
//        
//
//    }
//    
   
    
    
    
  
    /*
    public void insertTwo(Abonne a){
    
    }
    
    */
   

    @Override
    public void addUser(Abonne a) {
         try {
           // insertTwo();

            String req = "INSERT INTO `abonne` (`username`, `password`, `nom` ,`prenom`, `date_naissance`, `cin` ,`addresse`)"
                    + " VALUES ( ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement pst = cnx.prepareStatement(req);
            
            pst.setString(1, a.getUsername());
            pst.setString(2, a.getPassword());
            pst.setString(3, a.getNom());
            pst.setString(4, a.getPrenom());
            pst.setString(5, a.getDate_naissance());
            pst.setString(6, a.getCin());
            pst.setString(7, a.getAdresse());
           
          
            pst.executeUpdate();
            System.out.println("abonne ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Abonne> getAllUsers() {
        ArrayList<Abonne> abonnes= new ArrayList<>();
        
        String req="SELECT * FROM `abonne` ";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);
            while(rst.next()){
                Abonne a = new Abonne();
                a.setId(rst.getInt("id"));
                a.setUsername(rst.getString("username"));
                 a.setPassword(rst.getString("password"));
                a.setNom(rst.getString("nom"));
                a.setPrenom(rst.getString("prenom"));
                a.setDate_naissance(rst.getString("date_naissance"));
                a.setCin(rst.getString("cin"));
                a.setAdresse(rst.getString("addresse"));
                
                abonnes.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return abonnes;
        
    }

    @Override
    public ArrayList<Abonne> getAllUsersByRole(String role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(String cin) {
        try {
         

            String req = "DELETE FROM `abonne` WHERE cin=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, cin);
            System.out.println(pst);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Abonne getUser(int id) {
         Abonne ab = new Abonne();
        
        
         try {
        
         PreparedStatement pst = cnx.prepareStatement("SELECT * FROM `abonne` WHERE id=? ");
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
                ab.setAdresse(rst.getString("addresse"));
               
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ab;
        
    }
     
     
     public Abonne getAbonneByCIN(String cin) {
      Abonne ab = new Abonne();
       
        
         try {
        
         PreparedStatement pst = cnx.prepareStatement("SELECT * FROM `abonne` WHERE cin=? ");
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
                ab.setAdresse(rst.getString("addresse"));
                
                return ab;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
        
    }
    
    
  
     public void updatePasswordAbonne(Abonne a, String password) {
        try {
            

            String req = "UPDATE`abonne` SET password=? WHERE id=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, password);
            pst.setInt(2, a.getId());
            System.out.println(pst);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
     
     
     
   
     public void updateNomAbonne(Abonne a, String nom) {
        try {
            

            String req = "UPDATE`abonne` SET nom=? WHERE id=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, nom);
            pst.setInt(2, a.getId());
            System.out.println(pst);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
     
     
   
     public void updatePrenomAbonne(Abonne a, String prenom) {
        try {
            cnx = MyDB.getInstance().getCnx();

            String req = "UPDATE`abonne` SET prenom=? WHERE id=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, prenom);
            pst.setInt(2, a.getId());
            System.out.println(pst);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
     
     public void updateAbonne(Abonne a) {
        
          try {
   PreparedStatement pst = cnx.prepareStatement("update abonne set username=?,password=?,nom=?,prenom=?,date_naissance=?,cin=?,adresse=? where id=?");
    pst.setString(1, a.getUsername());
            pst.setString(2, a.getPassword());
            pst.setString(3, a.getNom());
            pst.setString(4, a.getPrenom());
            pst.setString(5,  a.getDate_naissance());
            pst.setString(6, a.getCin());
            pst.setString(7, a.getAdresse());
            pst.setInt(8, a.getId());

   
      pst.executeUpdate();
   
  } catch (SQLException e) {
  }
    }
     
     
     
     
     
    
}
