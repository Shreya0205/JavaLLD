public class Car {
    public String plateNumber;
    public Type type;
    public Integer pricePerDay;

    public Car(String plateNumber, Type type, Integer pricePerDay){
        this.plateNumber =  plateNumber;
        this.type = type;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return "Car [plateNumber=" + this.plateNumber + ", type=" + this.type + ", price/day=" + this.pricePerDay + "]";
    }

}
