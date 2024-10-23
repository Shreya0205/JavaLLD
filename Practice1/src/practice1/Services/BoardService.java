package practice1.Services;

import practice1.BoardAccess;
import practice1.Models.Board;
import practice1.Models.List;
import practice1.Models.User;

import java.util.ArrayList;
import java.util.HashMap;

public class BoardService {

    private HashMap<String, Board> boards;
    private UserService userService;
    private ListService listService;

    public BoardService(){
        this.boards = new HashMap<>();
    }

    public void setServices(UserService userService, ListService listService){
        this.userService = userService;
        this.listService = listService;
    }

    public Board createBoard(String name, BoardAccess boardAccess){
        Board board = new Board(name, boardAccess);
        this.boards.put(name, board);
        return board;
    }

    public Board getBoard(String name){
        return this.boards.get(name);
    }

    public void addList(String name, List list){
        Board board = this.boards.get(name);
        board.addList(list.getListID(), list);
    }


    public void addMember(Board board, String emailID){
        User user = this.userService.getUser(emailID);
        board.addUser(user.getUserID(), user);
    }

    public void removeMember(String name, String emailID){
        Board board = this.boards.get(name);

        if(board.isUserPresent(emailID)) {
            board.removeUser(emailID);
            System.out.println("User removed successfully");
        }
        else{
            System.out.println("User not present");
        }

    }

    public boolean isUserAllowed(Board board, String emailID){
        if( board.isUserPresent(emailID) == false && board.getBoardAccess()==BoardAccess.PRIVATE ){
            System.out.println("You dont have access");
            return false;
        }

        return true;
    }

    public boolean removeList(List list, String emailID){
        User user = this.userService.getUser(emailID);

        for( String key: this.boards.keySet() ){
            Board board = this.boards.get(key);

            if ( board.isListPresent(list.getListID())){
                board.removeList(list.getListID());
                return true;
            }
        }

        return false;

    }

    public void deleteBoard(String name, String emailID){

        if(this.boards.containsKey(name)==false){
            System.out.println("Board not present");
            return;
        }

        Board board = this.boards.get(name);

        ArrayList<List> lists = board.getAllList();
        for (List memberList: lists){
            this.listService.deleteList(memberList.getName(), emailID);
        }
        this.boards.remove(name);
        System.out.println("Board " + name + " deleted Successfully");
    }

    public void viewBoard(String name){

        if(this.boards.containsKey(name)) {
            Board board = this.boards.get(name);
            ArrayList<List> lists = board.getAllList();

            for (List memberList : lists) {
                System.out.println("List " + memberList.getName() + " have cards: ");
                memberList.viewCards();
            }
        }
        else{
            System.out.println("Board not present");
        }

    }

}
