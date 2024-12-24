package Code;

import Code.State.AtmState;
import Code.State.IdleState;

public class ATM {

    private Card card;
    private AtmState atmState;
    Integer twoThousandNotes;
    Integer fiveHundredNotes;
    Integer hundredNotes;
    Integer totalAmount;

    public ATM(Integer twoThousandNotes, Integer fiveHundredNotes, Integer hundredNotes) {

        this.atmState = new IdleState(this);
        this.twoThousandNotes = twoThousandNotes;
        this.fiveHundredNotes = fiveHundredNotes;
        this.hundredNotes = hundredNotes;

        this.card = null;
        this.totalAmount = 2000*twoThousandNotes + 500*fiveHundredNotes + hundredNotes*100;

    }

    public AtmState getAtmState() {
        return atmState;
    }

    public void setAtmState(AtmState atmState) {
        this.atmState = atmState;
    }

    public Card getCard() {
        return card;
    }

    public Integer getTwoThousandNotes() {
        return twoThousandNotes;
    }

    public Integer getFiveHundredNotes() {
        return fiveHundredNotes;
    }

    public Integer getHundredNotes() {
        return hundredNotes;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setTwoThousandNotes(Integer twoThousandNotes) {
        this.twoThousandNotes = twoThousandNotes;
    }

    public void setFiveHundredNotes(Integer fiveHundredNotes) {
        this.fiveHundredNotes = fiveHundredNotes;
    }

    public void setHundredNotes(Integer hundredNotes) {
        this.hundredNotes = hundredNotes;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
