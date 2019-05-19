/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.GeneralUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.MyDB;

/**
 *
 * @author Khalil
 */
public class GeneralService {
    
    private final Connection cnx  = MyDB.getInstance().getCnx();
   
    public void addTableUser(GeneralUser a) {
      
         try {
            

            String req = "INSERT INTO `user` (username,  password, mail, numero, role )"
                    + " VALUES ( ?,?,?,?, ?) ";
            PreparedStatement pst = cnx.prepareStatement(req);
          
        
            pst.setString(1,a.getUsername());
            pst.setString(2,a.getPassword());
            pst.setString(3,a.getMail());
            pst.setString(4,a.getNumero());
            pst.setString(5,a.getRole());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public ArrayList<GeneralUser> getAllUsers() {
        ArrayList<GeneralUser> users= new ArrayList<>();
        
        String req="SELECT * FROM `user` ";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rst = st.executeQuery(req);
            while(rst.next()){
                GeneralUser a = new GeneralUser();
                a.setId(rst.getInt("id"));
                a.setUsername(rst.getString("username"));
                 a.setPassword(rst.getString("password"));
               a.setMail((rst.getString("mail")));
                a.setNumero((rst.getString("numero")));
                 a.setRole((rst.getString("role")));
                
                users.add(a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return users;
        
    }
    
     public void deleteUser(String username) {
        try {
         

            String req = "DELETE FROM `user` WHERE username=? ";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, username);
            System.out.println(pst);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
     
  public void updateUserTable(GeneralUser a) {
        
          try {
   PreparedStatement pst = cnx.prepareStatement("update user set username=?,password=?,mail=?,numero=?,role=? where id=?");
    pst.setString(1, a.getUsername());
            pst.setString(2, a.getPassword());
            pst.setString(3, a.getMail());
            pst.setString(4, a.getNumero());
            pst.setString(5,  a.getRole());
           
            pst.setInt(8, a.getId());

   
      pst.executeUpdate();
   
  } catch (SQLException e) {
  }
    }
  
  
  
   public GeneralUser getUser(int id) {
         GeneralUser ab = new GeneralUser();
        
        
         try {
        
         PreparedStatement pst = cnx.prepareStatement("SELECT * FROM `user` WHERE id=? ");
            pst.setInt(1, id);
             
          
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
                
                ab.setId(rst.getInt("id"));
                ab.setUsername(rst.getString("username"));
                 ab.setPassword(rst.getString("password"));
                ab.setMail(rst.getString("mail"));
                ab.setNumero(rst.getString("numero"));
                ab.setRole(rst.getString("role"));
         
               
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ab;
        
    }
}
