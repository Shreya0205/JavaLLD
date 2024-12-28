package Code;

public class Address {

    Integer addressID;
    String houseNo;
    String line1;
    String state;
    Integer pinCode;

    public Address(Integer addressID, String houseNo, String line1, String state, Integer pinCode) {
        this.addressID = addressID;
        this.houseNo = houseNo;
        this.line1 = line1;
        this.state = state;
        this.pinCode = pinCode;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getLine1() {
        return line1;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public String getState() {
        return state;
    }
}

