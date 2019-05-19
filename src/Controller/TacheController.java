/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entities.Tache;
import entities.Voyage;
import java.util.ArrayList;
import java.util.Date;
import services.ChauffeurService;
import services.TacheService;

/**
 *
 * @author Khalil
 */
public class TacheController {
    
    TacheService ts = new TacheService();
    
    public void updateTache(Tache t)
    {
        ts.updateTache(t);
    }
    
    public void addTache(Tache t) 
     {
         ts.addTache(t);
     }
     
      public ArrayList<Tache> getAllTaches()
      {
          ArrayList<Tache> allTache = new ArrayList<>();
          allTache = ts.getAllTaches();
          return allTache;
      }
      
       public void deleteTache(Tache t)
       {
           ts.deleteTache(t);
       }
       
       
       public Tache getTacheById(int id)
       {
           Tache t = new Tache();
         t= ts.getTacheById(id);
          return t;
       }
       
       public void afficherAllTache(){
    
        getAllTaches().forEach(System.out::println);
    }
    
     public void afficherTache(Tache t)
     {
         System.out.println(getTacheById(t.getId_tache()).toString()); 
     }
     
     
  
     
     public Tache getTacheByChauffeur(int id_chauffeur)
     {
         Tache t = new Tache();
        t= ts.getTacheByChauffeur(id_chauffeur);
        return t;
     }
     
     public Tache getTacheByChefStation(int id_chef_station)
     {
         Tache t = new Tache();
        t= ts.getTacheByChauffeur(id_chef_station);
        return t;
     }
     
     public Tache getTacheByVoyage(int id_voyage)
     {
         Tache t = new Tache();
        t= ts.getTacheByChauffeur(id_voyage);
        return t;
     }
     
    
    
    
}
