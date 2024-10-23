package practice1.Services;

import practice1.Models.Board;
import practice1.Models.Card;
import practice1.Models.List;
import practice1.Models.User;

import java.util.ArrayList;
import java.util.HashMap;


public class ListService {

    private HashMap<String, List> lists;
    private BoardService boardService;
    private CardService cardService;

    public ListService(){
        this.lists = new HashMap<>();
    }

    public void setServices(BoardService boardService, CardService cardService){
        this.boardService = boardService;
        this.cardService = cardService;
    }

    public List createList(String name, Board board){
        List list = new List(name);
        this.lists.put(name, list);
        board.addList(list.getListID(), list);
        return list;
    }

    public void deleteList(String name, String emailID){

        if( this.lists.containsKey(name) == false ){
            System.out.println("List not present");
            return;
        }

        List list = this.lists.get(name);

        if(this.boardService.removeList(list, emailID)){
            ArrayList<Card> memberCards = list.getAllCards();

            for( Card card: memberCards){
                this.cardService.deleteCard(card.getName(), emailID);
            }
            this.lists.remove(name);
        }
        else{
            System.out.println("Operation not successful");
        }

    }


    public void addCard(String listname, Card card){
        List list = this.lists.get(listname);
        list.addCard(card);
    }

    public void moveCard(Card card, List targetList){

        for ( String key: this.lists.keySet()){
            if ( this.lists.get(key).isCardPresent(card.getName()) ){
                this.lists.get(key).removeCard(card.getName());
                break;
            }
        }

        targetList.addCard(card);

    }

    public void deleteCard(String name){

        for ( String key: this.lists.keySet()){
            if ( this.lists.get(key).isCardPresent(name) ){
                this.lists.get(key).removeCard(name);
                break;
            }
        }

    }


}
