package guru.qa.homework1.single_class;

public class Phone {
    int number;
    String model;
    double weight;

    public Phone(int number, String model, double weight) {
        this(number, model);
        this.weight = weight;
    }

    public Phone(int number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {
    }

    public static void main(String[] args) {
        Phone iphone = new Phone(1, "IPhone 2", 120);
        Phone samsung = new Phone(2, "SG22", 100);
        Phone lg = new Phone(3, "LG1", 125.5);
        System.out.println(iphone.model);
        System.out.println(iphone.number);
        System.out.println(iphone.weight);
        System.out.println(samsung.model);
        System.out.println(samsung.number);
        System.out.println(samsung.weight);
        System.out.println(lg.model);
        System.out.println(lg.number);
        System.out.println(lg.weight);

        iphone.recieveCall("Василий");
        System.out.println(lg.getNumber());
        samsung.recieveCall("Евгений", 8888);
        lg.sendMessage(1, 2, 3, 4, 5, 6, 7, 8, 9, 1111111);
    }

    public void recieveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public void recieveCall(String name, int number) {
        System.out.println("Звонит { " + name + " } номер: " + number);
    }

    public void sendMessage(int... number) {
        for (int a : number) {
            System.out.print(a + " ");
        }
    }

    public int getNumber() {
        return number;
    }
}
