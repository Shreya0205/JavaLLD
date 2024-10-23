package practice1;

import practice1.Models.List;
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

        boardService.setServices(listService, userService);
        listService.setServices(userService, boardService);
        cardService.setServices(listService, userService);

        boardService.createBoard("OrdersProjectBoard", BoardAccess.PUBLIC);
        boardService.createBoard("SupplyProjectBoard", BoardAccess.PUBLIC);
        boardService.createBoard("AndroidProjectBoard", BoardAccess.PUBLIC);

        userService.createUser("Scott", "scott@g.in");
        userService.createUser("Brett", "brett@g.in");
        userService.createUser("Tina", "tina@g.in");

        boardService.addMember("OrdersProjectBoard", "scott@g.in");
        boardService.addMember("SupplyProjectBoard", "brett@g.in");

        listService.createList("OrderProjectList1", "OrdersProjectBoard");
        listService.createList("OrderProjectList2", "OrdersProjectBoard");
        listService.createList("SupplyProjectList1", "SupplyProjectBoard");
        listService.createList("AndroidProjectList1", "AndroidProjectBoard");
        listService.createList("AndroidProjectList2", "AndroidProjectBoard");
        listService.createList("AndroidProjectList3", "AndroidProjectBoard");


        cardService.createCard("OrderProjectTask1", "OrderProjectList1", CardPriority.P0);
        cardService.createCard("OrderProjectTask2", "OrderProjectList1", CardPriority.P2);
        cardService.createCard("OrderProjectTask3", "OrderProjectList2", CardPriority.P1);
        cardService.createCard("OrderProjectTask4", "OrderProjectList2", CardPriority.P1);
        cardService.createCard("OrderProjectTask5", "OrderProjectList1", CardPriority.P0);

        boardService.viewBoard("OrdersProjectBoard");
    }
}