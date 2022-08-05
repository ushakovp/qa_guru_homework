package guru.qa.homework1.single_class;

public class Person {
    String fullName;
    int age;

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.age = 18;
        person1.fullName = "VVP";

        Person person2 = new Person("Test", 19);
        System.out.println(person1);
        System.out.println(person2);

    }

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
                ", age=" + age +
                '}';
    }

    public void move() {

    }

    public void talk() {
        System.out.println(fullName + " говорит");
    }
}
