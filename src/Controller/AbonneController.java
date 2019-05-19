/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entities.Abonne;

import java.util.ArrayList;
import services.AbonneService;

/**
 *
 * @author Khalil
 */
public class AbonneController {
    
    
    AbonneService as = new AbonneService();
    
 
    public void ajouterAbonne(Abonne a)
    {
        as.addUser(a);
    }
    
    public void updateAbonne(Abonne a)
    {
        as.updateAbonne(a);
    }
    
    
     public void afficherAllAbonne()
     {
         as.getAllUsers().forEach(System.out::println);
     }
     
   
     public void afficherAbonne(Abonne a)
     {
         System.out.println(as.getUser(a.getId()).toString());
     }
     
    public  ArrayList<Abonne> getAllAbonnes()
    {
        ArrayList<Abonne> allAbonne = new ArrayList<>();
        allAbonne=as.getAllUsers();
        return allAbonne;
    }
    
//    public  ArrayList<Users> getAllAbonnesByRole(String role)
//    {
//        ArrayList<Users> allAbonne = new ArrayList<>();
//        allAbonne=as.getAllAbonnesByRole(role);
//        return allAbonne;
//    }
    
    public void deleteAbonne(String cin){
    as.deleteUser(cin);
    }
    
     public Abonne getAbonneById(int id) 
     {
         Abonne a = new Abonne();
         a=as.getUser(id);
         return a;
     }
     
      public Abonne getAbonneByCIN(String cin) 
     {
         Abonne a = new Abonne();
         a=as.getAbonneByCIN(cin);
         return a;
     }
     
     public void modifierPasswordAbonne(Abonne a, String password)
     {
         as.updatePasswordAbonne(a, password);
     }
     
     
      public void modifierNomAbonne(Abonne a, String nom)
     {
         as.updateNomAbonne(a, nom);
     }
      
      
      public void modifierPrenomAbonne(Abonne a, String prenom)
     {
         as.updatePrenomAbonne(a, prenom);
     }
      
     
     
     
    
}
