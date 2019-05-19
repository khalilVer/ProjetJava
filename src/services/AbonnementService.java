/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Users;
import entities.Abonnement;
import entities.Ligne;
import entities.Tarif;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import serviceInterfaces.IAbonnementService;
import utils.MyDB;

/**
 *
 * @author Khalil
 */
public class AbonnementService implements IAbonnementService{
    
     private Connection cnx = MyDB.getInstance().getCnx();
    
     @Override
    public void addAbonnement(Abonnement ab) {

        try {
            

            String req = "INSERT INTO `abonnement` (`date_achat`, `date_expiration` ,`id_abonne`,  `id_tarif` )"
                    + " VALUES ( ?, ?, ?, ?) ";
            PreparedStatement pst = cnx.prepareStatement(req);
          
            pst.setString(1, ab.getDate_achat());
            pst.setString(2, ab.getDate_expiration());
            
            pst.setInt(3, ab.getAbonne());
           
            pst.setDouble(4, ab.getTarif());
           
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
     @Override
     public ArrayList<Abonnement> getAllAbonnements() {
        ArrayList<Abonnement> abonnements= new ArrayList<>();
        String req="SELECT * FROM `abonnement` ";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);
            while(rst.next()){
                Abonnement a = new Abonnement();
                a.setId(rst.getInt("id"));
                a.setDate_achat(rst.getString("date_achat"));
                 a.setDate_expiration(rst.getString("date_expiration"));
                a.setTarif(rst.getInt("id_tarif"));
                a.setAbonne(rst.getInt("id_abonne"));
                
               
                abonnements.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return abonnements;
        
    }
     
     
      @Override
    public void deleteAbonnement(Abonnement a) {
        try {

            String req = "DELETE FROM `abonnement` WHERE id=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, a.getId());
            System.out.println(pst);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    
    @Override
    public Abonnement getAbonnementById(int id) {
      Abonnement ab = new Abonnement();
       
         try {
         
         PreparedStatement pst = cnx.prepareStatement("select * from abonnement where id=? ");
         pst.setInt(1, id);
             
            
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                
                ab.setId(rst.getInt("id"));
                ab.setDate_achat(rst.getString("date_achat"));
                ab.setDate_expiration(rst.getString("date_expiration"));
                ab.setTarif(rst.getInt("id_tarif"));
                ab.setAbonne(rst.getInt("id_abonne"));
                
                        
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ab;
        
    }
  
    
   @Override
    public Abonnement getAbonnementByAbonne(Users a) {
      Abonnement ab = new Abonnement();
        Statement st;
         try {
         
         PreparedStatement pst = cnx.prepareStatement("select * from abonnement where id_abonne=? ");
            pst.setInt(1, a.getId());
             
          //  st = cnx.createStatement();
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
               
                 ab.setId(rst.getInt("id"));
                ab.setDate_achat(rst.getString("date_achat"));
                 ab.setDate_expiration(rst.getString("date_expiration"));
                ab.setTarif(rst.getInt("id_tarif"));
                ab.setAbonne(rst.getInt("id_abonne"));
              
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ab;
        
    }
    
    
     @Override
     public ArrayList<Abonnement> getAbonnementByLigne(Ligne ligne) {
        ArrayList<Abonnement> abonnements= new ArrayList<>();
        
         try {
         
         PreparedStatement pst = cnx.prepareStatement("SELECT * FROM `abonnement` WHERE id_ligne=? ");
            pst.setInt(1, ligne.getId());
             
     
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                 Abonnement ab = new Abonnement();
                 ab.setId(rst.getInt("id"));
                ab.setDate_achat(rst.getString("date_achat"));
                 ab.setDate_expiration(rst.getString("date_expiration"));
                ab.setTarif(rst.getInt("id_tarif"));
                ab.setAbonne(rst.getInt("id_abonne"));
               
                
            
                abonnements.add(ab);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return abonnements;
        
    }
     
      @Override
     public ArrayList<Abonnement> getAbonnementByTarif(Tarif t) {
        ArrayList<Abonnement> abonnements= new ArrayList<>();
        
         try {
       
         PreparedStatement pst = cnx.prepareStatement("SELECT * FROM `abonnement` WHERE id_ligne=? ");
            pst.setInt(1, t.getId());
     
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                 Abonnement ab = new Abonnement();
                 ab.setId(rst.getInt("id"));
                ab.setDate_achat(rst.getString("date_achat"));
                 ab.setDate_expiration(rst.getString("date_expiration"));
                ab.setTarif(rst.getInt("id_tarif"));
                ab.setAbonne(rst.getInt("id_abonne"));
         
                
            
                abonnements.add(ab);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return abonnements;
        
    }
     
     
    
      
     
    
    
}
