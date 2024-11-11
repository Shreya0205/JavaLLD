package Java.models;

import java.util.ArrayList;

public class Topic {
    Integer id;
    String name;
    ArrayList<User> subscribers;

    public Topic(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getSubscribers() {
        return subscribers;
    }

    public void addSubscriber(User user) {
        this.subscribers.add(user);
    }

    public void removeSubscriber(User user) {
        this.subscribers.remove(user);
    }

    public boolean isUserSubscribed(User user){
        return this.subscribers.contains(user);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                '}';
    }
}
