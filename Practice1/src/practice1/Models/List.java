package practice1.Models;

import practice1.CardPriority;

import java.util.*;

public class List {

    private static Integer counter = 0;
    private Integer listID;
    private String name;
    HashMap<String, Card> cards;

    public List(String name) {
        this.listID = counter;
        counter++;
        this.name = name;
        this.cards = new HashMap<>();
    }

    public Integer getListID() {
        return listID;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card){
        this.cards.put(card.getName(), card);
    }

    public void removeCard(String name){
        this.cards.remove(name);
    }

    public boolean isCardPresent(String name){
        return this.cards.containsKey(name);
    }

    public void viewCards(){
        ArrayList<Card> cardArrayList = new ArrayList<>(this.cards.values());
        cardArrayList.sort(Comparator.comparing(Card::getPriority).reversed());

        for (Card card: cardArrayList){
           System.out.println("Card " + card.getName() + " is present with priority " + card.getPriority());
        }

    }
}
