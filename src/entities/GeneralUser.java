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
public class GeneralUser {
    
    private int id ;
    private String username ;
    private String password ;
    private String mail;
    private String numero;
    private String role ;

    public GeneralUser(String username, String password, String mail, String numero, String role) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.numero = numero;
        this.role = role;
    }

    public GeneralUser(int id, String username, String password, String mail, String numero, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.numero = numero;
        this.role = role;
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

    public String getMail() {
        return mail;
    }

    public String getNumero() {
        return numero;
    }

    public String getRole() {
        return role;
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

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public GeneralUser() {
    }
    
    
    
    
    
}
