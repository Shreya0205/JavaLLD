package Code;

public class BankAccount {
    Integer balance;

    public BankAccount(Integer balance) {
        this.balance = balance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void withdrawBalance(Integer amount) {
        this.balance -= amount;
    }

}
