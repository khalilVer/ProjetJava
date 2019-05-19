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
public class Tache {
    
    private int id_tache;
    private int id_chauffeur;
    private int id_chef_station;
    private int id_voyage;

    public Tache(int id_chauffeur, int id_chef_station, int id_voyage) {
        this.id_chauffeur = id_chauffeur;
        this.id_chef_station = id_chef_station;
        this.id_voyage = id_voyage;
    }

    public Tache() {
       
    }

    public int getId_chauffeur() {
        return id_chauffeur;
    }

    public int getId_chef_station() {
        return id_chef_station;
    }

    public int getId_voyage() {
        return id_voyage;
    }

    public void setId_chauffeur(int id_chauffeur) {
        this.id_chauffeur = id_chauffeur;
    }

    public void setId_chef_station(int id_chef_station) {
        this.id_chef_station = id_chef_station;
    }

    public void setId_voyage(int id_voyage) {
        this.id_voyage = id_voyage;
    }

    public void setId_tache(int id_tache) {
        this.id_tache = id_tache;
    }

    public int getId_tache() {
        return id_tache;
    }

    public Tache(int id_tache, int id_chauffeur, int id_chef_station, int id_voyage) {
        this.id_tache = id_tache;
        this.id_chauffeur = id_chauffeur;
        this.id_chef_station = id_chef_station;
        this.id_voyage = id_voyage;
    }
    
    
    
    
    
}
