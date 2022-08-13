package com.demoqa.utils;

import com.demoqa.data.DataClass;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class RandomDataGenerator {
    Faker faker = new Faker();
    DataClass dataClass = new DataClass();
    Random generator = new Random();

    private String bDay;
    private String bMonth;
    private String bYear;

    public RandomDataGenerator() {
        getRandomBirthDay();
    }

    public String getRandomFirstName() {
        return faker.name().firstName();
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomPhone() {
        return faker.numerify("##########");
    }

    public String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public String getRandomGender() {
        int randomIndex = generator.nextInt(dataClass.gender.length);
        return dataClass.gender[randomIndex];
    }

    public String getRandomHobby() {
        int randomIndex = generator.nextInt(dataClass.hobbies.length);
        return dataClass.hobbies[randomIndex];
    }

    private void getRandomBirthDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy", Locale.US);
        String[] dob = sdf.format(faker.date().birthday()).split("/");
        bDay = dob[0];
        bMonth = dob[1];
        bYear = dob[2];
    }

    public String[] getSubjects() {
        ArrayList<String> subjects = new ArrayList<String>(Arrays.asList(dataClass.subjects10));
        int randomLength = generator.nextInt(dataClass.subjects10.length - 1) + 1;
        String[] subject = new String[randomLength];

        for (int i = 0; i < subject.length; i++) {
            Collections.shuffle(subjects);
            subject[i] = subjects.get(0);
            subjects.remove(0);
        }
        return subject;
    }

    public String getbDay() {
        return bDay;
    }

    public String getbMonth() {
        return bMonth;
    }

    public String getbYear() {
        return bYear;
    }
}
