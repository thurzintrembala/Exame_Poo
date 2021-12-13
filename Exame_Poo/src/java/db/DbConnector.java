/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;


import java.util.ArrayList;

/**
 *
 * @author arthu
 */
public class DbConnector {
    private static ArrayList<User> users;
    public static ArrayList<User> getUsers(){
        if(users==null){
            users = new ArrayList<>();
            users.add(
                    new User(
                            "adm", 
                            "administrador", 
                            "1234".hashCode())
            );
            users.add(
                    new User(
                            "user1", 
                            "arthur", 
                            "123".hashCode())
            );
        }
        return users;
    }
    
    public static User getUser(String name, String password){
        int hashCode = password.hashCode();
        for(User user: getUsers()){
            if(user.getName().equals(name) 
                    && user.getPasswordHash() == hashCode){
                return user;
            }
        }
        return null;
    }
    
    public static void addUser(User newUser){
        getUsers().add(newUser);
    }
    public static void removeUser(String name){
        for(int i=0 ; i< users.size(); i++){
            if(users.get(i).getName().equals(name)){
                getUsers().remove(i);
            }
        }
    }
}