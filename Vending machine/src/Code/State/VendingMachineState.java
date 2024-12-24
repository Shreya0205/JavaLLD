package Code.State;

import Code.Coin;
import Code.Item;

import java.util.List;


public interface VendingMachineState {

    public void pressInsertCoinButton();

    public void insertCoin(Coin coin);

    public List<Coin> refund();

    public void pressSelectProductButton();

    public void selectProduct(Integer rackId);

    public List<Coin> returnChange();

    public Item getProduct();

}
