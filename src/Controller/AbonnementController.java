/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entities.Users;
import entities.Abonnement;
import entities.Ligne;
import entities.Tarif;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import services.AbonnementService;

/**
 *
 * @author Khalil
 */
public class AbonnementController {
    
    AbonnementService abs = new AbonnementService();
    
    public void ajouterAbonnement(Abonnement ab)
    {
        abs.addAbonnement(ab);
    }
    
    
    public ArrayList<Abonnement> getAllAbonnements()
    {
        ArrayList<Abonnement> allAbonnement = new ArrayList<>();
        allAbonnement = abs.getAllAbonnements();
        return allAbonnement;
    }
    
    
     public ArrayList<Abonnement> getAbonnementByLigne(Ligne ligne)
    {
        ArrayList<Abonnement> AbonnementByLigne = new ArrayList<>();
        AbonnementByLigne = abs.getAbonnementByLigne(ligne);
        return AbonnementByLigne;
    }
    
     public ArrayList<Abonnement> getAbonnementByTarif(Tarif tarif)
    {
        ArrayList<Abonnement> AbonnementByTarif = new ArrayList<>();
        AbonnementByTarif = abs.getAbonnementByTarif(tarif);
        return AbonnementByTarif;
    }
    
    public void deleteAbonnement(Abonnement a)
    {
        abs.deleteAbonnement(a);
    }
    
    public Abonnement getAbonnementById(int id)
    {
        Abonnement ab = new Abonnement();
        ab=abs.getAbonnementById(id);
        return ab;
    }
    
    public Abonnement getAbonnementByAbonne(Users a)
    {
        Abonnement ab = new Abonnement();
        ab=abs.getAbonnementByAbonne(a);
        return ab;
    }
    
    
      
     public void afficherAllAbonnement()
     {
         abs.getAllAbonnements().forEach(System.out::println);
     }
     
    
     public void afficherAbonnement(Abonnement ab)
     {
         System.out.println(abs.getAbonnementById(ab.getId()).toString()); 
     }
    
    
     public void afficherAbonnementParAbonne(Users a)
     {
         System.out.println(abs.getAbonnementByAbonne(a).toString());
     }
     
   
      public void afficherAbonnementParLigne(Ligne ligne)
     {
         System.out.println(abs.getAbonnementByLigne(ligne).toString()); 
     }
      
      
      public String incrDate(String curDate, int durrée)
      {
     
         return LocalDate.parse(curDate).plusMonths(6).toString();
          
      
      }
    
}
