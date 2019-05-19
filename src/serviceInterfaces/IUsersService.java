/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceInterfaces;

import java.util.ArrayList;

/**
 *
 * @author Khalil
 */
public interface IUsersService<T> {
    
    public void addUser(T t);
    public ArrayList<T> getAllUsers();
    public ArrayList<T> getAllUsersByRole(String role);
    public void deleteUser(String cin);
    public T getUser(int id);
    
}
