/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Tache;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import serviceInterfaces.ITacheService;
import utils.MyDB;

/**
 *
 * @author Khalil
 */
public class TacheService implements ITacheService{

    
    private final Connection cnx  = MyDB.getInstance().getCnx();
    @Override
    public void addTache(Tache t) {
      
         try {
            

            String req = "INSERT INTO `tache` (id_chauffeur,  id_chef_station, id_voyage )"
                    + " VALUES ( ?,?, ?) ";
            PreparedStatement pst = cnx.prepareStatement(req);
          
        
            pst.setDouble(1, t.getId_chauffeur());
            pst.setInt(2, t.getId_chef_station());
            pst.setInt(3, t.getId_voyage());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Tache> getAllTaches() {
          ArrayList<Tache> taches= new ArrayList<>();
        String req="SELECT * FROM `tache` ";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);
            while(rst.next()){
                Tache t = new Tache();
                t.setId_tache(rst.getInt("id_tache"));
                t.setId_chauffeur(rst.getInt("id_chauffeur"));
                t.setId_chef_station(rst.getInt("id_chef_station"));
                t.setId_voyage(rst.getInt("id_voyage"));
               
               
                taches.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return taches;
    }

    @Override
    public void deleteTache(Tache t) {
        
        try {

            String req = "DELETE FROM `tache` WHERE id_tache=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, t.getId_tache());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Tache getTacheById(int id_tache) {
      
         Tache t = new Tache();
       
         try {
         
         PreparedStatement pst = cnx.prepareStatement("select * from tache where id_tache=? ");
         pst.setInt(1, id_tache);
             
            
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                
                       t.setId_tache(rst.getInt("id_tache"));
                t.setId_chauffeur(rst.getInt("id_chauffeur"));
                t.setId_chef_station(rst.getInt("id_chef_station"));
                t.setId_voyage(rst.getInt("id_voyage"));
                
                        
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
        
    }
    
    public Tache getTacheByChauffeur(int id_chauffeur) {
      Tache t = new Tache();
       
         try {
         
         PreparedStatement pst = cnx.prepareStatement("select * from tache where id_chauffeur=? ");
         pst.setInt(1, id_chauffeur);
             
            
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                
                t.setId_tache(rst.getInt("id_tache"));
                t.setId_chauffeur(rst.getInt("id_chauffeur"));
                t.setId_chef_station(rst.getInt("id_chef_station"));
                t.setId_voyage(rst.getInt("id_voyage"));
                
                        
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
        
    }
    
     public Tache getTacheByChefStation(int id_chef_station) {
      Tache t = new Tache();
       
         try {
         
         PreparedStatement pst = cnx.prepareStatement("select * from tache where id_chef_station=? ");
         pst.setInt(1, id_chef_station);
             
            
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                
                t.setId_tache(rst.getInt("id_tache"));
                t.setId_chauffeur(rst.getInt("id_chauffeur"));
                t.setId_chef_station(rst.getInt("id_chef_station"));
                t.setId_voyage(rst.getInt("id_voyage"));
                
                        
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
        
    }
     
     
       public Tache getTacheByVoyage(int id_voyage) {
      Tache t = new Tache();
       
         try {
         
         PreparedStatement pst = cnx.prepareStatement("select * from tache where id_voyage=? ");
         pst.setInt(1, id_voyage);
             
            
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                
                t.setId_tache(rst.getInt("id_tache"));
                t.setId_chauffeur(rst.getInt("id_chauffeur"));
                t.setId_chef_station(rst.getInt("id_chef_station"));
                t.setId_voyage(rst.getInt("id_voyage"));
                
                        
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return t;
        
    }
       
       
        public void updateTache(Tache a) {
        
          try {
   PreparedStatement ps = cnx.prepareStatement("update tache set id_chauffeur=?,id_chef_station=?,id_voyage=? " + "where id_tache=?");
   ps.setInt(1, a.getId_chauffeur());
      ps.setInt(2, a.getId_chef_station());

         ps.setInt(3, a.getId_voyage());
   ps.setInt(4, a.getId_tache());

   
  



      ps.executeUpdate();
   
  } catch (SQLException e) {
  }
    }
        
    
}
