/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author bhk
 */
public abstract class Users {

    private int id;
    private String username, password, nom, prenom, cin, adresse;
    private String date_naissance;

    public Users(String username, String password,String nom, String prenom, String date_naissance, String cin, String adresse ) {
       
        
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.cin = cin;
        this.adresse = adresse;
    }

    public Users() {
    }

    public Users(String username, String nom, String prenom, String date_naissance, String cin, String adresse) {
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.cin = cin;
        this.adresse = adresse;
        
    }

    public Users(int id, String username, String password, String nom, String prenom, String cin, String adresse, String date_naissance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.adresse = adresse;
        this.date_naissance = date_naissance;
    }
    
    

    
    

    public int getId() {
        return id;
    }

  

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public String getCin() {
        return cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

//    @Override
//    public String toString() {
//        return "Users{" + "id=" + id + ", role=" + role + ", username=" + username + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance + ", cin=" + cin + ", adresse=" + adresse + '}';
//    }

    
     @Override
    public String toString() {
        return  username ;
    }
    

   
}
