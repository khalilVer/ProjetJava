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
public class Chauffeur extends Users{
    
    private int nbTacheTotal ;
    private static int NB_TACHE_TOTAL_PAR_JOUR = 3 ;
    private int nbTacheParJour;
    private String nomLigne;
    private int dispo;

    public Chauffeur(int nbTacheTotal, int nbTacheParJour, String nomLigne, int dispo, String username, String password, String nom, String prenom, String date_naissance, String cin, String adresse) {
        super(username, password, nom, prenom, date_naissance, cin, adresse);
        this.nbTacheTotal = nbTacheTotal;
        this.nbTacheParJour = nbTacheParJour;
        this.nomLigne = nomLigne;
        this.dispo = dispo;
    }

    public Chauffeur(int nbTacheTotal, int nbTacheParJour, String nomLigne, int dispo) {
        this.nbTacheTotal = nbTacheTotal;
        this.nbTacheParJour = nbTacheParJour;
        this.nomLigne = nomLigne;
        this.dispo = dispo;
    }

    public Chauffeur(int nbTacheTotal, int nbTacheParJour, String nomLigne, int dispo, String username, String nom, String prenom, String date_naissance, String cin, String adresse) {
        super(username, nom, prenom, date_naissance, cin, adresse);
        this.nbTacheTotal = nbTacheTotal;
        this.nbTacheParJour = nbTacheParJour;
        this.nomLigne = nomLigne;
        this.dispo = dispo;
    }

    public Chauffeur(int nbTacheTotal, int nbTacheParJour, String nomLigne, int dispo, int id, String username, String password, String nom, String prenom, String cin, String adresse, String date_naissance) {
        super(id, username, password, nom, prenom, cin, adresse, date_naissance);
        this.nbTacheTotal = nbTacheTotal;
        this.nbTacheParJour = nbTacheParJour;
        this.nomLigne = nomLigne;
        this.dispo = dispo;
    }

    
    public Chauffeur() {
    }

    public int getNbTacheTotal() {
        return nbTacheTotal;
    }

    public static int getNB_TACHE_TOTAL_PAR_JOUR() {
        return NB_TACHE_TOTAL_PAR_JOUR;
    }

    public int getNbTacheParJour() {
        return nbTacheParJour;
    }

    public String getNomLigne() {
        return nomLigne;
    }

    public int getDispo() {
        return dispo;
    }

    public void setNbTacheTotal(int nbTacheTotal) {
        this.nbTacheTotal = nbTacheTotal;
    }

    public void setNbTacheParJour(int nbTacheParJour) {
        this.nbTacheParJour = nbTacheParJour;
    }

    public void setNomLigne(String nomLigne) {
        this.nomLigne = nomLigne;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    

   

    
    

    

    

    
    

   
    
    
}
