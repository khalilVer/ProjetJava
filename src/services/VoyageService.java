/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Voyage;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import serviceInterfaces.IVoyageService;
import utils.MyDB;

/**
 *
 * @author Khalil
 */
public class VoyageService implements IVoyageService {
    
        private final Connection cnx  = MyDB.getInstance().getCnx();

    @Override
    public void addVoyage(Voyage a) {
       
         try {
   PreparedStatement ps = cnx.prepareStatement("insert into voyage " +
    "              (type,heure_depart,heure_arrive,destination_depart,destination_arrive,id_ligne)" +
    "               values(?,?,?,?,?,?)");


   ps.setString(1, a.getType());
   ps.setString(2,String.valueOf(a.getHeure_depart()) );
   ps.setString(3, String.valueOf(a.getHeure_arrive()));
   ps.setString(4, a.getDestination_depart());
   ps.setString(5, a.getDestination_arrive());
    ps.setInt(6, a.getId_ligne());
   


    ps.executeUpdate();

  
  } catch (SQLException e) {
  }
        
        
    }

    @Override
    public void deleteVoayage(int id) {
       
        try {
   PreparedStatement ps = cnx.prepareStatement("delete from voyage where id=?");
   ps.setInt(1, id);
   ps.executeUpdate();
  
  } catch (SQLException e) {
      System.out.println(e);
  }
    }

    @Override
    public void updateVoyage(Voyage a) {
        
          try {
   PreparedStatement ps = cnx.prepareStatement("update voyage set type=?,heure_depart=?,heure_arrive=?,destination_depart=?,destination_arrive=?,id_ligne=?  " + "where id=?");
   ps.setString(1, a.getType());
    ps.setString(2,String.valueOf(a.getHeure_depart()) );
    ps.setString(3, String.valueOf(a.getHeure_arrive()));
   ps.setString(4, a.getDestination_depart());
   ps.setString(5, a.getDestination_arrive());
    ps.setInt(6, a.getId_ligne());
   ps.setInt(7, a.getId());
  



      ps.executeUpdate();
   
  } catch (SQLException e) {
  }
    }

    @Override
    public ArrayList<Voyage> getAllVoayages() {
        
         ArrayList < Voyage > voyages = new ArrayList < > ();


  try {
   PreparedStatement ps = cnx.prepareStatement("select * from voyage");
   ResultSet res = ps.executeQuery();
   while (res.next()) {
    Voyage voy = new Voyage();
    voy.setId(res.getInt(1));
    voy.setType(res.getString(2));
    voy.setHeure_depart(res.getDate(3));
    voy.setHeure_arrive(res.getDate(4));
    voy.setDestination_depart(res.getString(5));
    voy.setDestination_arrive(res.getString(6));
    voy.setId_ligne(res.getInt(7));
 


    voyages.add(voy);
   }
  } catch (SQLException ex) {
   System.out.println(ex.getMessage());
  }
  return voyages;
    }
    
    
     public Voyage getVoayageById(int id) {
      
         Voyage voy = new Voyage();
       
         try {
         
         PreparedStatement pst = cnx.prepareStatement("select * from voyage where id=? ");
         pst.setInt(1, id);
             
            
            ResultSet res = pst.executeQuery();
            while(res.next()){
                
                     voy.setId(res.getInt(1));
    voy.setType(res.getString(2));
    voy.setHeure_depart(res.getDate(3));
    voy.setHeure_arrive(res.getDate(4));
    voy.setDestination_depart(res.getString(5));
    voy.setDestination_arrive(res.getString(6));
    voy.setId_ligne(res.getInt(7));
 
    
                
                        
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return voy;
        
    }
     
    
    
    
    }
        
        


