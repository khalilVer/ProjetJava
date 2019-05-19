/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entities.Voyage;
import java.util.ArrayList;
import services.VoyageService;

/**
 *
 * @author Khalil
 */
public class VoyageController {
    
      VoyageService ts = new VoyageService();
    
    public void addVoyage(Voyage v) 
     {
         ts.addVoyage(v);
     }
     
      public ArrayList<Voyage> getAllVoyages()
      {
          ArrayList<Voyage> allVoyage = new ArrayList<>();
          allVoyage = ts.getAllVoayages();
          return allVoyage;
      }
      
       public void deleteTache(int id)
       {
           ts.deleteVoayage(id);
       }
       
       
       public Voyage getVoyageById(int id)
       {
           Voyage t = new Voyage();
         t= ts.getVoayageById(id);
          return t;
       }
       
       public void afficherAllVoyages(){
    
        getAllVoyages().forEach(System.out::println);
    }
    
     public void afficherVoyage(Voyage t)
     {
         System.out.println(getVoyageById(t.getId()).toString()); 
     }
    
}
