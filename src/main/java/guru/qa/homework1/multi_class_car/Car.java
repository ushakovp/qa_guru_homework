package guru.qa.homework1.multi_class_car;

public class Car {
    private String carClass;
    private Engine engine;
    private Driver driver;
    private String brand;

    public Car(String carClass, Engine engine, Driver driver, String brand) {
        this.carClass = carClass;
        this.engine = engine;
        this.driver = driver;
        this.brand = brand;
    }

    public Car() {
    }

    public static Car mostPowerfulCar(Car... cars) {
        Car mostPowerCar = cars[0];
        for (Car car : cars) {
            if (car.getEngine().getPower() > mostPowerCar.getEngine().getPower()) {
                mostPowerCar = car;
            }
        }
        return mostPowerCar;
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setCarClass("clas1");
        car1.setBrand("BMW");
        car1.setDriver(new Driver("n1", 5));
        car1.setEngine(new Engine(250, "BMW"));

        System.out.println(car1);

        Car car2 = new Car("cl2", new Engine(260, "Mercedes"), new Driver("d2", 20), "Mercedes");

        System.out.println(car2);

        Driver driver1 = new Driver("d1", 10);
        Engine engine1 = new Engine(200, "Generic");

        Car car3 = new Car("cl2", engine1, driver1, "Volvo");
        System.out.println(car3);

        SportCar car4 = new SportCar("cl3", engine1, new Driver("d3", 5), "Mazda", 360.5);
        System.out.println(car4);

        System.out.println("Самая мощная машина: " + Car.mostPowerfulCar(car1, car2, car3, car4));

    }

    public void start() {
        System.out.println("Поехали");
    }

    public void stop() {
        System.out.println("Останавливаемся");
    }

    public void turnRight() {
        System.out.println("Поворот направо");
    }

    public void turnLeft() {
        System.out.println("Поворот налево");
    }

    @Override
    public String toString() {
        return "Car{" +
                "carClass='" + carClass + '\'' +
                ", engine=" + engine +
                ", driver=" + driver +
                ", brand='" + brand + '\'' +
                '}';
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
