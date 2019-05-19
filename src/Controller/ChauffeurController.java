/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entities.Chauffeur;
import entities.Voyage;
import java.util.ArrayList;
import java.util.Date;
import services.ChauffeurService;

/**
 *
 * @author Khalil
 */
public class ChauffeurController {
    
      ChauffeurService as = new ChauffeurService();
    
 
    public void ajouterChauffeur(Chauffeur a)
    {
        as.addUser(a);
    }
    
    public void updateChauffeur(Chauffeur a)
    {
        as.updateChauffeur(a);
    }
    
    
     public void afficherAllChauffeur()
     {
         as.getAllUsers().forEach(System.out::println);
     }
     
   
     public void afficherChauffeur(Chauffeur a)
     {
         System.out.println(as.getUser(a.getId()).toString());
     }
     
    public  ArrayList<Chauffeur> getAllChauffeurs()
    {
        ArrayList<Chauffeur> allChauffeur = new ArrayList<>();
        allChauffeur=as.getAllUsers();
        return allChauffeur;
    }
    
//    public  ArrayList<Users> getAllAbonnesByRole(String role)
//    {
//        ArrayList<Users> allAbonne = new ArrayList<>();
//        allAbonne=as.getAllAbonnesByRole(role);
//        return allAbonne;
//    }
    
    public void deleteChauffeur(String cin){
    as.deleteUser(cin);
    }
    
     public Chauffeur getChauffeurById(int id) 
     {
         Chauffeur a = new Chauffeur();
         a=as.getUser(id);
         return a;
     }
     
      public Chauffeur getChauffeurByCIN(String cin) 
     {
         Chauffeur a = new Chauffeur();
         a=as.getChauffeurByCIN(cin);
         return a;
     }
       public  ArrayList<Chauffeur> getAllChauffeurByLigne(String nomLigne)
    {
        ArrayList<Chauffeur> allChauffeur = new ArrayList<>();
        allChauffeur=as.getAllChauffeurByLigne(nomLigne);
        return allChauffeur;
    }
       
       
        public  ArrayList<Chauffeur> getAllChauffeurDispo()
    {
        ArrayList<Chauffeur> allChauffeur = new ArrayList<>();
        allChauffeur=as.getAllChauffeurDispo();
        return allChauffeur;
    }
       
    
    
     
   
       
    
}
