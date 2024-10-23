package practice1.Services;

import practice1.Models.Card;
import practice1.Models.List;
import practice1.Models.User;

import java.util.HashMap;


public class ListService {

    private HashMap<String, List> lists;
    private UserService userService;
    private BoardService boardService;

    public ListService(){
        this.lists = new HashMap<>();
    }

    public void setServices(UserService userService, BoardService boardService){
        this.userService = userService;
        this.boardService = boardService;
    }

    public void createList(String name, String boardname){
        List list = new List(name);
        this.lists.put(name, list);
        this.boardService.addList(boardname, list);
    }


    public void deleteList(String name, String emailID){
        User user = this.userService.getUser(emailID);
        this.boardService.removeList(name);
        this.lists.remove(name);
    }

    public void addCard(String listname, Card card){
        List list = this.lists.get(listname);
        list.addCard(card);
    }

    public void moveCard(Card card, String listname){
        List targetList = this.lists.get(listname);

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

    public void viewList(Integer listID){

        for(String key:this.lists.keySet()){

            if( this.lists.get(key).getListID() == listID ){
                System.out.println("List ID is " +  this.lists.get(key).getName() );
                this.lists.get(key).viewCards();
            }
        }
    }


}
