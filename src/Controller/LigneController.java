/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entities.Ligne;
import java.util.ArrayList;
import services.LigneService;

/**
 *
 * @author Khalil
 */
public class LigneController {

    LigneService ls = new LigneService();
    
    public void AjouterLigne(Ligne a)
    {
        ls.insert(a);
    }
    
    
    public void SupprimerLigne(int id)
    {
        ls.delete(id);
    }
    
    
    public void ModifierLigne(Ligne a)
    {
        ls.update(a);
    }
    
    public Ligne searchLigneById(int id)
    {
        Ligne l = new Ligne();
       l= ls.searchLigneById(id);
       return l;
    }
    
    public ArrayList < Ligne > searchLigneByNameTransport(String transport)
    {
        ArrayList<Ligne> lignes = new ArrayList<>();
        lignes = ls.searchLineByNameTransport(transport);
        return lignes;
    }
    
    
    public ArrayList < Ligne > findAll()
    {
    
        ArrayList<Ligne> lignes = new ArrayList<>();
        lignes = ls.findAll();
        return lignes;
        
    }
    
}
