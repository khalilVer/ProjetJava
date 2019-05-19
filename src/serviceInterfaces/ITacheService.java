/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceInterfaces;

import entities.Tache;
import java.util.ArrayList;

/**
 *
 * @author Khalil
 */
public interface ITacheService {
    
     public void addTache(Tache t);
      public ArrayList<Tache> getAllTaches();
       public void deleteTache(Tache t);
        public Tache getTacheById(int id);
    
}
