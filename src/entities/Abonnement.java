/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Khalil
 */
public class Abonnement {
    
    private int id;
    private String date_achat, date_expiration;
    private int tarif;
    private int abonne;


    public Abonnement( String date_achat, String date_expiration, int abonne,  int tarif) {
       
        this.date_achat = date_achat;
        this.date_expiration = date_expiration;
        this.tarif = tarif;
        this.abonne=abonne;
        
    }

    public Abonnement() {
    }

    public int getId() {
        return id;
    }

    public String getDate_achat() {
        return date_achat;
    }

    public String getDate_expiration() {
        return date_expiration;
    }

    public int getTarif() {
        return tarif;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_achat(String date_achat) {
        this.date_achat = date_achat;
    }

    public void setDate_expiration(String date_expiration) {
        this.date_expiration = date_expiration;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public int getAbonne() {
        return abonne;
    }

    public void setAbonne(int abonne) {
        this.abonne = abonne;
    }

  

    @Override
    public String toString() {
        return "Abonnement{" + "id=" + id + ", date_achat=" + date_achat + ", date_expiration=" + date_expiration + ", tarif=" + tarif + ", abonne=" + abonne + '}';
    }
    
    

    
    
    

  
    
    
    
}
