/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entities.GeneralUser;
import java.util.ArrayList;
import services.GeneralService;

/**
 *
 * @author Khalil
 */
public class GeneralUserController {
    
    GeneralService gs = new GeneralService();
    
      public void ajouterUser(GeneralUser a)
    {
        gs.addTableUser(a);
    }
      
       public  ArrayList<GeneralUser> getAllUser()
    {
        ArrayList<GeneralUser> allUser = new ArrayList<>();
         allUser=gs.getAllUsers();
        return allUser;
    }
       
       public void deleteUser(String username){
    gs.deleteUser(username);
    }
    
     public GeneralUser getUserById(int id) 
     {
         GeneralUser a = new GeneralUser();
         a=gs.getUser(id);
         return a;
     }
    
     public void updateUser(GeneralUser a)
    {
        gs.updateUserTable(a);
    }
    
}
