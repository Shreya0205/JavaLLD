package practice1;

import practice1.Models.Board;
import practice1.Models.Card;
import practice1.Models.List;
import practice1.Models.User;
import practice1.Services.BoardService;
import practice1.Services.CardService;
import practice1.Services.ListService;
import practice1.Services.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        UserService userService = new UserService();
        BoardService boardService = new BoardService();
        ListService listService = new ListService();
        CardService cardService =  new CardService();

        boardService.setServices(userService, listService);
        listService.setServices(boardService, cardService);
        cardService.setServices(listService, userService);

        Board OrdersProjectBoard = boardService.createBoard("OrdersProjectBoard", BoardAccess.PUBLIC);
        Board SupplyProjectBoard = boardService.createBoard("SupplyProjectBoard", BoardAccess.PUBLIC);
        Board AndroidProjectBoard = boardService.createBoard("AndroidProjectBoard", BoardAccess.PUBLIC);

        User scott = userService.createUser("Scott", "scott@g.in");
        User brett = userService.createUser("Brett", "brett@g.in");
        User Tina = userService.createUser("Tina", "tina@g.in");

        boardService.addMember(OrdersProjectBoard, "scott@g.in");
        boardService.addMember(SupplyProjectBoard, "brett@g.in");

        List OrderProjectList1 = listService.createList("OrderProjectList1", OrdersProjectBoard);
        List OrderProjectList2 = listService.createList("OrderProjectList2", OrdersProjectBoard);
        List SupplyProjectList1 = listService.createList("SupplyProjectList1", SupplyProjectBoard);
        List AndroidProjectList1 = listService.createList("AndroidProjectList1", AndroidProjectBoard);
        List AndroidProjectList2 = listService.createList("AndroidProjectList2", AndroidProjectBoard);
        List AndroidProjectList3 = listService.createList("AndroidProjectList3", AndroidProjectBoard);

        Card OrderProjectTask1 = cardService.createCard("OrderProjectTask1", "OrderProjectList1", CardPriority.P0);
        Card OrderProjectTask2 = cardService.createCard("OrderProjectTask2", "OrderProjectList1", CardPriority.P2);
        Card OrderProjectTask3 = cardService.createCard("OrderProjectTask3", "OrderProjectList2", CardPriority.P1);
        Card OrderProjectTask4 = cardService.createCard("OrderProjectTask4", "OrderProjectList2", CardPriority.P1);
        Card OrderProjectTask5 = cardService.createCard("OrderProjectTask5", "OrderProjectList1", CardPriority.P0);

        boardService.viewBoard("OrdersProjectBoard");
        boardService.deleteBoard("OrdersProjectBoard", "scott@g.in");
        boardService.viewBoard("OrdersProjectBoard");

        listService.deleteList("OrderProjectList1", "scott@g.in");
        cardService.deleteCard("OrderProjectTask1", "scott@g.in");
    }
}