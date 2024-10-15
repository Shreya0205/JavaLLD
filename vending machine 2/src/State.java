public interface State {

    public void collectCash(Integer cash);

    public void dispenseChange();

    public void dispenseItem();

    public void cancelTxn();

}
