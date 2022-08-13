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

    private String state;

    private String city;

    public RandomDataGenerator() {
        getRandomBirthDay();
        getRandomStateAndCity();
    }

    public String getRandomState() {
        return state;
    }

    public String getRandomCity() {
        return city;
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

    public String[] getRandomSubjects() {
        ArrayList<String> subjects = new ArrayList<>(Arrays.asList(dataClass.subjects10));
        int randomLength = generator.nextInt(dataClass.subjects10.length - 1) + 1;
        String[] subject = new String[randomLength];

        for (int i = 0; i < subject.length; i++) {
            Collections.shuffle(subjects);
            subject[i] = subjects.get(0);
            subjects.remove(0);
        }
        return subject;
    }

    private void getRandomStateAndCity() {
        state = dataClass.states[generator.nextInt(dataClass.states.length)];
        if (state.equals("NCR")) {
            city = getRandomCityFromState(dataClass.citiesNCR);
        }
        if (state.equals("Uttar Pradesh")) {
            city = getRandomCityFromState(dataClass.citiesPradesh);
        }
        if (state.equals("Haryana")) {
            city = getRandomCityFromState(dataClass.citiesHaryana);
        }
        if (state.equals("Rajasthan")) {
            city = getRandomCityFromState(dataClass.citiesRajasthan);
        }
    }

    private String getRandomCityFromState(String[] cities) {
        return cities[generator.nextInt(cities.length)];
    }

    public String getRandomBDay() {
        return bDay;
    }

    public String getRandomBMonth() {
        return bMonth;
    }

    public String getRandomBYear() {
        return bYear;
    }
}
