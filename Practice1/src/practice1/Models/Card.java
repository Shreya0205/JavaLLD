package practice1.Models;

import practice1.CardPriority;

public class Card {
    private static Integer counter = 0;
    private Integer counterID;
    private String name;
    private User assignedUser;
    private CardPriority priority;

    public Card(String name, CardPriority priority) {
        this.name = name;
        this.priority = priority;
    }

    public Integer getCounterID() {
        return counterID;
    }

    public String getName() {
        return name;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }

    public void unassignCard(){
        this.assignedUser = null;
    }

    public CardPriority getPriority() {
        return priority;
    }

}
