/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bhk
 */
public class MyDB {

   
    private Connection cnx;
    private static MyDB instance;
    private MyDB() {
        try {
            cnx = DriverManager.getConnection(Credentials.url
                    , Credentials.user, Credentials.password);
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static MyDB getInstance(){
        if(instance == null)
            instance = new MyDB();
        
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
    

}
