package practice1.Models;

import practice1.BoardAccess;

import javax.swing.*;
import java.net.Inet4Address;
import java.util.Collection;
import java.util.HashMap;

public class Board {
    private static Integer counter = 0;
    private Integer boardID;
    private String name;
    private HashMap<Integer, User> users;
    private HashMap<Integer, List> lists;
    private BoardAccess boardAccess;

    public Board(String name, BoardAccess boardAccess) {
        this.boardID = counter;
        counter++;
        this.name = name;
        this.users = new HashMap<>();
        this.lists = new HashMap<>();
        this.boardAccess = boardAccess;
    }

    public Integer getBoardID() {
        return boardID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser(Integer id) {
        return this.users.get(id);
    }

    public void addUser(Integer id, User user) {
        this.users.put(id, user);
    }

    public List getList(Integer id) {
        return this.lists.get(id);
    }

    public void addList(Integer id, List list) {
        this.lists.put(id, list);
    }

    public BoardAccess getBoardAccess() {
        return boardAccess;
    }

    public void removeUser(String emailID){
        this.users.remove(emailID);
    }

    public void removeList(String name){
        this.lists.remove(name);
    }

    public boolean isUserPresent(String emailID){
        return this.users.containsKey(emailID);
    }

    public boolean isListPresent(String name){
        return this.lists.containsKey(name);
    }

    public Collection<Integer> getAllList(){
        return this.lists.keySet();
    }

}
