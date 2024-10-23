package practice1.Services;

import practice1.Models.User;

import java.util.HashMap;

public class UserService {

    private HashMap<String, User> users;

    public UserService(){
        this.users =  new HashMap<>();
    }

    public User createUser(String name, String emailID){
        User user = new User(emailID, name);
        this.users.put(emailID, user);
        return user;
    }

    public User getUser(String emailID){
        return this.users.get(emailID);
    }

    public void deleteUser(String name){
        this.users.remove(name);
    }

}
