/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;





/**
 *
 * @author ghazy
 */
public class Voyage {
    
    private int id,id_ligne;
    private String type;
    private Date heure_depart;
    private Date heure_arrive;
    private String destination_depart;
    private String destination_arrive;


    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHeure_depart(Date heure_depart) {
        this.heure_depart = heure_depart;
    }

    public void setHeure_arrive(Date heure_arrive) {
        this.heure_arrive = heure_arrive;
    }

    public void setDestination_depart(String destination_depart) {
        this.destination_depart = destination_depart;
    }

    public void setDestination_arrive(String destination_arrive) {
        this.destination_arrive = destination_arrive;
    }

    public int getId_ligne() {
        return id_ligne;
    }

    public void setId_ligne(int id_ligne) {
        this.id_ligne = id_ligne;
    }

  
    
    
    public Voyage() {
    }

    public Voyage(int id, String type, Date heure_depart, Date heure_arrive, String destination_depart, String destination_arrive,int id_ligne) {
        this.id = id;
        this.type = type;
        this.heure_depart = heure_depart;
        this.heure_arrive = heure_arrive;
        this.destination_depart = destination_depart;
        this.destination_arrive = destination_arrive;
        this.id_ligne = id_ligne;
        
    }
    
    

    
    
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Date getHeure_depart() {
        return heure_depart;
    }

    public Date getHeure_arrive() {
        return heure_arrive;
    }

    public String getDestination_depart() {
        return destination_depart;
    }

    public String getDestination_arrive() {
        return destination_arrive;
    }

    @Override
    public String toString() {
        return "type=" + type + " heure_depart=" + heure_depart + " heure_arrive=" + heure_arrive ;
    }

  
    
    
}
