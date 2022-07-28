package guru.qa.homework1.multi_class_car;

public class Driver {
    String fullName;
    int experience;

    public Driver(String fullName, int experience) {
        this.fullName = fullName;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "fullName='" + fullName + '\'' +
                ", experience=" + experience +
                '}';
    }
}
