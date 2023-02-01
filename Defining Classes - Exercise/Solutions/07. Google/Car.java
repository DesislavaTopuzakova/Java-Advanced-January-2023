package Google_07;

public class Car {
    //характеристики
    private String carModel;
    private int carSpeed;


    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return carModel + " " + carSpeed;
    }
}
