package practice1.Services;

import practice1.BoardAccess;
import practice1.Models.Board;
import practice1.Models.List;
import practice1.Models.User;

import java.util.Collection;
import java.util.HashMap;

public class BoardService {

    private HashMap<String, Board> boards;
    private UserService userService;
    private ListService listService;

    public BoardService(){
        this.boards = new HashMap<>();
    }

    public void setServices(ListService listService, UserService userService){
        this.listService = listService;
        this.userService = userService;
    }

    public void createBoard(String name, BoardAccess boardAccess){
        Board board = new Board(name, boardAccess);
        this.boards.put(name, board);
    }

    public void addList(String name, List list){
        Board board = this.boards.get(name);
        board.addList(list.getListID(), list);
    }

    public void addMember(String name, String emailID){
        Board board = this.boards.get(name);
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

    public void removeList(String name){

        for( String key: this.boards.keySet() ){
            Board board = this.boards.get(key);

            if ( board.isListPresent(name)){
                board.removeList(name);
                break;
            }
        }

    }

    public void deleteBoard(String name, String emailID){

        Board board = this.boards.get(name);
        User user = this.userService.getUser(emailID);

        if(board.isUserPresent(emailID) == false && board.getBoardAccess()==BoardAccess.PRIVATE ){
            System.out.println("You dont have access");
            return;
        }

        this.boards.remove(name);

    }

    public void viewBoard(String name){
        Board board = this.boards.get(name);

        Collection<Integer> lists = board.getAllList();

        for (Integer list: lists){
            this.listService.viewList(list);
        }

    }

}
