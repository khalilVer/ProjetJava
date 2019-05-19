/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceInterfaces;

import entities.Voyage;
import java.util.ArrayList;

/**
 *
 * @author Khalil
 */
public interface IVoyageService {
    
    public void addVoyage(Voyage v);
    public void deleteVoayage(int id);
    public void updateVoyage(Voyage v);
    public ArrayList<Voyage> getAllVoayages() ;
    
    
    
}
