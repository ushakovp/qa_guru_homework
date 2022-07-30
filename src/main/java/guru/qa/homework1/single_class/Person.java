package guru.qa.homework1.single_class;

public class Person {
    String fullName;
    int age;

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.age = 18;
        person1.fullName = "VVP";

        Person person2 = new Person("DAM", 19);

    }

    public void move() {

    }

    public void talk() {
        System.out.println(fullName + " говорит");
    }
}
