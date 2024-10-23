package practice1.Services;

import practice1.CardPriority;
import practice1.Models.Board;
import practice1.Models.Card;
import practice1.Models.List;
import practice1.Models.User;

import java.util.HashMap;

public class CardService {

    HashMap<String, Card> cards;
    ListService listService;
    UserService userService;

    public CardService(){
        this.cards = new HashMap<>();
    }

    public void setServices(ListService listService, UserService userService){
        this.listService = listService;
        this.userService = userService;
    }

    public Card createCard(String name, String listname, CardPriority cardPriority){
        Card card = new Card(name, cardPriority);
        this.cards.put(name, card);
        this.listService.addCard(listname, card);
        return card;
    }

    public void assignCard(String name, String email){
        Card card =  this.cards.get(name);
        User user = this.userService.getUser(email);
        card.setAssignedUser(user);
    }

    public void unassignCard(Card card){
        card.unassignCard();
    }

    public void moveCard(Card card, List list){
        this.listService.moveCard(card, list);
    }

    public void deleteCard(String name, String email){

        if(this.cards.containsKey(name)==false){
            System.out.println("Card not present");
            return;
        }
        Card card =  this.cards.get(name);
        User user = this.userService.getUser(email);
        this.listService.deleteCard(name);
        this.cards.remove(name);
    }



}
