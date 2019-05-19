/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Ligne;
import entities.Tarif;
import entities.Voyage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import serviceInterfaces.ITarifService;
import utils.MyDB;

/**
 *
 * @author Khalil
 */
public class TarifService implements ITarifService {
    
      private Connection cnx = MyDB.getInstance().getCnx();
    
     @Override
    public void addTarif(Double t,  Ligne l) {

        try {

            String req = "INSERT INTO `tarif` (`tarif`,  `id_ligne` )"
                    + " VALUES ( ?, ?) ";
            PreparedStatement pst = cnx.prepareStatement(req);
          
        
            pst.setDouble(1, t);
            pst.setInt(2, l.getId());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
     @Override
     public ArrayList<Tarif> getAllTarifs() {
        ArrayList<Tarif> tarifs= new ArrayList<>();
        String req="SELECT * FROM `tarif` ";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);
            while(rst.next()){
                Tarif t = new Tarif();
                t.setId(rst.getInt("id"));
                t.setTarif(rst.getDouble("tarif"));
                 t.setId_ligne(rst.getInt("id_ligne"));
               
               
                tarifs.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tarifs;
        
    }
     
     
      @Override
    public void deleteTarif(Tarif t) {
        try {

            String req = "DELETE FROM `tarif` WHERE id=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId());
            System.out.println(pst);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    
    @Override
    public Tarif getTarifById(int id) {
      Tarif t = new Tarif();
       
         try {
         
         PreparedStatement pst = cnx.prepareStatement("select * from tarif where id=? ");
         pst.setInt(1, id);
             
            
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                
                t.setId(rst.getInt("id"));
                t.setTarif(rst.getDouble("tarif"));
                t.setId_ligne(rst.getInt("id_ligne"));
                
                        
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
        
    }
    
     public Tarif getTarifByLigne(int idLigne) {
      Tarif t = new Tarif();
       
         try {
         
         PreparedStatement pst = cnx.prepareStatement("select * from tarif where id_ligne=? ");
         pst.setInt(1, idLigne);
             
            
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                
                t.setId(rst.getInt("id"));
                t.setTarif(rst.getDouble("tarif"));
                t.setId_ligne(rst.getInt("id_ligne"));
                
                        
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
        
    }
     
     public void updatePrixTarif(Tarif t, String tarif) {
        try {
            

            String req = "UPDATE`tarif` SET tarif=? WHERE id=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, tarif);
            pst.setInt(2, t.getId());
            System.out.println(pst);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
     
    
   
     
 
    
}
