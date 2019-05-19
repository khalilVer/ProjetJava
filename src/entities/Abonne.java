/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Khalil
 */
public class Abonne extends Users {

    public Abonne(String username, String password, String nom, String prenom, String date_naissance, String cin, String adresse) {
        super(username, password, nom, prenom, date_naissance, cin, adresse);
    }

    public Abonne() {
    }

    public Abonne(String username, String nom, String prenom, String date_naissance, String cin, String adresse) {
        super(username, nom, prenom, date_naissance, cin, adresse);
    }
    
    
    
}
