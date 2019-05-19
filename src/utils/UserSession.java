/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package utils;

import entities.Users;



/**
 *
 * @author Khalil
 */
public final class UserSession {

    private static UserSession instance;

    private Users user;

    private UserSession(Users user) {
        this.user=user;
    }

    public static UserSession getInstace(Users user) {
        if(instance == null) {
            instance = new UserSession(user);
        }
        return instance;
    }

    public Users getUser() {
        return user;
    }

    

    public void cleanUserSession() {
       user=null;
    }

    @Override
    public String toString() {
        return user.toString();
    }
}