/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entities.Ligne;
import entities.Tarif;
import entities.Voyage;
import java.util.ArrayList;
import services.TarifService;

/**
 *
 * @author Khalil
 */
public class TarifController {
    
    TarifService ts = new TarifService();
    
     public void addTarif(Double t,  Ligne l) 
     {
         ts.addTarif(t, l);
     }
     
      public ArrayList<Tarif> getAllTarifs()
      {
          ArrayList<Tarif> allTarif = new ArrayList<>();
          allTarif = ts.getAllTarifs();
          return allTarif;
      }
      
       public void deleteTarif(Tarif t)
       {
           ts.deleteTarif(t);
       }
       
       
       public Tarif getTarifById(int id)
       {
           Tarif t = new Tarif();
         t= ts.getTarifById(id);
          return t;
       }
       
       public void afficherAllTarif(){
    
        getAllTarifs().forEach(System.out::println);
    }
    
     public void afficherTarif(Tarif t)
     {
         System.out.println(getTarifById(t.getId()).toString()); 
     }
     
     public void afficherTarifPersonnalisé(double min , double max){
     
         getAllTarifs().stream().filter(e->e.getTarif()>min && e.getTarif()<max ).forEach(e->System.out.println(e.toString()));
         
     }
  
     public ArrayList<Tarif> calculPormotion()
     {
     
         ArrayList<Tarif> tarifP = new ArrayList<>();
         tarifP = getAllTarifs();
         for(Tarif t : tarifP)
         {
             t.setTarif(t.getTarif()*0.80);
         }
         
         return tarifP ;
     }
     
     public void afficherTarifP(){
     
         ArrayList<Tarif> tarifP = new ArrayList<>();
         tarifP=calculPormotion();
         tarifP.forEach(System.out::println);
         
     }
     
     public Tarif getTarifByLigne(int idLigne)
     {
         Tarif t = new Tarif();
        t= ts.getTarifByLigne(idLigne);
        return t;
     }
     public void modifierprixdTarif(Tarif t, String tarif)
     {
         ts.updatePrixTarif(t, tarif);
     }
   
    
}
