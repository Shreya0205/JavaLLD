import java.util.HashMap;

public class VendingMachine implements VendingInterface{

    Inventory inventory;
    HashMap<Coin, Integer> coins;
    HashMap<Note, Integer> notes;
    static VendingMachine vendingMachine=null;
    HashMap<String, Product> products;

    private VendingMachine(){
        this.inventory = new Inventory();
        this.coins = new HashMap<>();
        this.notes = new HashMap<>();
        this.products = new HashMap<>();

        for(Note note: Note.values()){
            this.notes.put(note, 0);
        }

        for(Coin coin: Coin.values()){
            this.coins.put(coin, 0);
        }
    }

    public synchronized static VendingMachine getInstance(){
        if(vendingMachine==null){
            vendingMachine = new VendingMachine();
        }
        return vendingMachine;
    }

    public void addProduct(String name, Integer quantity, Integer price){
        Product product = new Product(name, price);
        this.products.put(name, product);
        inventory.addProduct(product, quantity);
    }

    public void restockProduct(String name, Integer Quantity){
        Product product = this.products.get(name);
        this.inventory.restockProduct(product, Quantity);
    }

    public Integer collectCoins(){
        Integer totalCoinValue=0;

        for(Coin coin: Coin.values()){
            totalCoinValue += coin.getCode() * this.coins.get(coin);
            this.coins.put(coin, 0);
        }
        System.out.println("total cash collected from coins: " + totalCoinValue);
        return totalCoinValue;
    }

    public Integer collectNotes(){
        Integer totalNoteValue=0;

        for(Note note: Note.values()){
            totalNoteValue += note.getCode() * this.notes.get(note);
            this.notes.put(note, 0);
        }
        System.out.println("total cash collected from notes: " + totalNoteValue);
        return totalNoteValue;

    }

    public Integer getProductPrice(String name){
        Product product = this.products.get(name);
        return product.getPrice();
    }

    public void buyProduct(String name, Integer Quantity, Integer notes, Integer Nnotes, Integer coins, Integer Ncoins) throws Exception {

        Product product = this.products.get(name);
        Integer leftItems = this.inventory.getQuantity(product);

        if (leftItems < Quantity){
            System.out.println("Insufficient Products");
            return;
        }

        this.inventory.sellProduct(product, Quantity);

        if(Ncoins!=0)
            this.coins.put(Coin.getCoinEnum(coins), this.coins.get(Coin.getCoinEnum(coins)) + Ncoins);
        if(Nnotes!=0)
            this.notes.put(Note.getNoteEnum(notes), this.notes.get(Note.getNoteEnum(notes)) + Nnotes);

        Integer diff = (notes*Nnotes + coins*Ncoins) - getProductPrice(name);
    }


}
