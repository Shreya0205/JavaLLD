//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

        VendingMachine vendingMachine = VendingMachine.getInstance();

        vendingMachine.addProduct("juice", 2, 50);
        vendingMachine.addProduct("protein", 3, 100);
        vendingMachine.addProduct("cake", 1, 100);

        vendingMachine.getProductPrice("protein");
        vendingMachine.buyProduct("protein", 2, 100, 2, 0, 0);

        vendingMachine.collectCoins();
        vendingMachine.collectNotes();
        vendingMachine.collectCoins();
        vendingMachine.collectNotes();

        vendingMachine.buyProduct("protein", 2, 100, 2, 0, 0);
        vendingMachine.buyProduct("protein", 1, 100, 1, 0, 0);
        vendingMachine.collectNotes();
    }
}