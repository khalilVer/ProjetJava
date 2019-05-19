/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceInterfaces;

import entities.Ligne;
import entities.Tarif;
import entities.Voyage;
import java.util.ArrayList;

/**
 *
 * @author Khalil
 */
public interface ITarifService {
    
    
      public void addTarif(Double t,  Ligne l);
      public ArrayList<Tarif> getAllTarifs();
       public void deleteTarif(Tarif t);
        public Tarif getTarifById(int id);
}
