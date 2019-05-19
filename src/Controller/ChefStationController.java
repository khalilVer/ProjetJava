/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entities.ChefStation;
import java.util.ArrayList;
import services.ChefStationService;

/**
 *
 * @author Khalil
 */
public class ChefStationController {
    
    
      ChefStationService as = new ChefStationService();
    
 
    public void ajouterChefStation(ChefStation a)
    {
        as.addUser(a);
    }
    
      public void updateChefStation(ChefStation a)
    {
        as.updateChefStation(a);
    }
    
    
     public void afficherAllChefStation()
     {
         as.getAllUsers().forEach(System.out::println);
     }
     
   
     public void afficherChefStation(ChefStation a)
     {
         System.out.println(as.getUser(a.getId()).toString());
     }
     
    public  ArrayList<ChefStation> getAllChefStations()
    {
        ArrayList<ChefStation> allChefStation = new ArrayList<>();
        allChefStation=as.getAllUsers();
        return allChefStation;
    }
    
//    public  ArrayList<Users> getAllAbonnesByRole(String role)
//    {
//        ArrayList<Users> allAbonne = new ArrayList<>();
//        allAbonne=as.getAllAbonnesByRole(role);
//        return allAbonne;
//    }
    
    public void deleteChefStation(String cin){
    as.deleteUser(cin);
    }
    
     public ChefStation getChefStationById(int id) 
     {
         ChefStation a = new ChefStation();
         a=as.getUser(id);
         return a;
     }
     
      public ChefStation getChefStationByCIN(String cin) 
     {
         ChefStation a = new ChefStation();
         a=as.getChefStationByCIN(cin);
         return a;
     }
       public  ArrayList<ChefStation> getAllChefStationByLigne(String nomLigne)
    {
        ArrayList<ChefStation> allChefStation = new ArrayList<>();
        allChefStation=as.getAllChefStationByLigne(nomLigne);
        return allChefStation;
    }
       
       
    
       
    
}
