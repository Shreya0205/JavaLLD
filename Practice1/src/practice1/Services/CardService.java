package practice1.Services;

import practice1.CardPriority;
import practice1.Models.Board;
import practice1.Models.Card;
import practice1.Models.User;

import java.util.HashMap;
import java.util.List;

public class CardService {

    HashMap<String, Card> cards;
    ListService listService;
    UserService userService;
    BoardService boardService;

    public CardService(){
        this.cards = new HashMap<>();
    }

    public void setServices(ListService listService, UserService userService){
        this.listService = listService;
        this.userService = userService;
    }

    public void createCard(String name, String listname, CardPriority cardPriority){
        Card card = new Card(name, cardPriority);
        this.listService.addCard(listname, card);
    }

    public void assignCard(String name, String email){
        Card card =  this.cards.get(name);
        User user = this.userService.getUser(email);
        card.setAssignedUser(user);
    }

    public void unassignCard(String name){
        Card card =  this.cards.get(name);
        card.unassignCard();
    }

    public void moveCard(String name, String listname){
        Card card =  this.cards.get(name);
        this.listService.moveCard(card, listname);
    }

    public void deleteCard(String name, String email){
        Card card =  this.cards.get(name);
        User user = this.userService.getUser(email);
        this.listService.deleteCard(name);

    }



}
