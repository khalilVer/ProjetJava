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
public class Tarif {
    
    private int id,id_ligne;
    private double tarif;

    public Tarif( double tarif,int id_ligne) {
        
        this.id_ligne = id_ligne;
        this.tarif = tarif;
    }

    public Tarif() {
    }
    
    

    public int getId() {
        return id;
    }

    public int getId_ligne() {
        return id_ligne;
    }

    public double getTarif() {
        return tarif;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_ligne(int id_ligne) {
        this.id_ligne = id_ligne;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    @Override
    public String toString() {
        return "Tarif{" + "id=" + id + ", id_ligne=" + id_ligne + ", tarif=" + tarif + '}';
    }
    
    
    
    
    
    
}
