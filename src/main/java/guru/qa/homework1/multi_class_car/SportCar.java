package guru.qa.homework1.multi_class_car;

public class SportCar extends Car {
    double speed;

    public SportCar(String carClass, Engine engine, Driver driver, String brand, double speed) {
        super(carClass, engine, driver, brand);
        this.speed = speed;
    }

}
