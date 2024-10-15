//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        VendingMachine vendingMachine = VendingMachine.getInstance();

        vendingMachine.addProduct("juice", 2, 50);
        vendingMachine.addProduct("protein", 3, 100);
        vendingMachine.addProduct("cake", 1, 100);

        vendingMachine.getProductPrice("protein");

        vendingMachine.selectProduct("protein", 4);
        vendingMachine.selectProduct("protein", 2);
        vendingMachine.collectCash(100);
        vendingMachine.collectCash(150);
        vendingMachine.dispenseChange();
        vendingMachine.dispenseItem();

        vendingMachine.selectProduct("protein", 4);
    }
}