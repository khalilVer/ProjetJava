/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Khalil
 */
public class ChefStation extends Users {
    
    private String nomLigne ;

    public ChefStation(String nomLigne, String username, String password, String nom, String prenom, String date_naissance, String cin, String adresse) {
        super(username, password, nom, prenom, date_naissance, cin, adresse);
        this.nomLigne = nomLigne;
    }

    public ChefStation(String nomLigne) {
        this.nomLigne = nomLigne;
    }

    public ChefStation(String nomLigne, String username, String nom, String prenom, String date_naissance, String cin, String adresse) {
        super(username, nom, prenom, date_naissance, cin, adresse);
        this.nomLigne = nomLigne;
    }

    public ChefStation() {
    }

    public String getNomLigne() {
        return nomLigne;
    }

    public void setNomLigne(String nomLigne) {
        this.nomLigne = nomLigne;
    }
    
    
    

   
   
    
}
