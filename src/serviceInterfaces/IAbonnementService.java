/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceInterfaces;

import entities.Users;
import entities.Abonnement;
import entities.Ligne;
import entities.Tarif;
import java.util.ArrayList;

/**
 *
 * @author Khalil
 */
public interface IAbonnementService {
    
     public void addAbonnement(Abonnement ab) ;
     public ArrayList<Abonnement> getAllAbonnements();
    public Abonnement getAbonnementById(int id);
    public void deleteAbonnement(Abonnement a);
    public Abonnement getAbonnementByAbonne(Users a);
    public ArrayList<Abonnement> getAbonnementByLigne(Ligne ligne) ;
    
     public ArrayList<Abonnement> getAbonnementByTarif(Tarif t);
    
}
