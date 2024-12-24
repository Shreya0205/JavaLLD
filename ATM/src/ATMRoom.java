import Code.ATM;
import Code.BankAccount;
import Code.Card;
import Code.State.TransactionType;
import Code.User;

public class ATMRoom {

    static ATM atm;
    static User user;

    public static void main(String args[]) {

        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atm.getAtmState().insertCard(user.getCard());
        atm.getAtmState().authenticateCard(2121);
        atm.getAtmState().selectOperation(TransactionType.withdrawal);
        atm.getAtmState().withdrawCash(2700);
        
        atm.getAtmState().insertCard(user.getCard());
        atm.getAtmState().authenticateCard(2121);
        atm.getAtmState().selectOperation(TransactionType.withdrawal);
        atm.getAtmState().withdrawCash(2700);

    }

    private void initialize() {
        atm = new ATM(1,2,5);
        user = createUser();
    }

    private User createUser(){
        return new User(createCard());
    }

    private Card createCard(){
        return new Card(1234567890, 123, 2121, createBankAccount());
    }

    private BankAccount createBankAccount() {
        return new BankAccount(3000);
    }

}
