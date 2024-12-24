package Code;

import java.util.Objects;

public class Card {
    Integer cardNumber;
    Integer cvv;
    Integer pin;
    BankAccount bankAccount;

    public Card(Integer cardNumber, Integer cvv, Integer pin, BankAccount bankAccount) {
        this.cvv = cvv;
        this.pin = pin;
        this.cardNumber = cardNumber;
        this.bankAccount = bankAccount;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public Integer getCvv() {
        return cvv;
    }

    public Integer getPin() {
        return pin;
    }

    public boolean isCorrectPin(Integer pin){
        return Objects.equals(this.pin, pin);
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
