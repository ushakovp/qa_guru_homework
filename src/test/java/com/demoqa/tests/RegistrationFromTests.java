package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFromTests {
    private final String gender = "Other";
    private final String hobby = "Sports";
    private final String pathToPicture = "File.png";
    private final String state = "NCR";
    private final String city = "Noida";
    private final String[] subjects = {"Maths", "Arts", "Physics"};
    private final String dayOfBirth = "01";
    private final String monthOfBirth = "September";
    private final String yearOfBirth = "1939";
    Faker faker = new Faker();
    private final String name = faker.name().firstName();
    private final String lastName = faker.name().lastName();
    private final String email = faker.internet().emailAddress();
    private final String telephoneNumber = faker.numerify("##########");
    private final String address = faker.address().fullAddress();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void fillFormTest() {
        registrationFormPage.openPage()
                .setName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setTelephoneNumber(telephoneNumber)
                .setGender(gender)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setHobby(hobby)
                .setSubjects(subjects)
                .uploadPicture(pathToPicture)
                .setAddress(address)
                .setStateAndCity(state, city)
                .submit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", name + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", telephoneNumber)
                .checkResult("Date of Birth", "01 September,1939")
                .checkResult("Subjects", "Maths, Arts, Physics")
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", pathToPicture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city)
                .closeModal();
    }

    @Test
    public void fillFormMinimalTest() {
        registrationFormPage.openPage()
                .setName(name)
                .setLastName(lastName)
                .setGender(gender)
                .setTelephoneNumber(telephoneNumber)
                .submit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", name + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", telephoneNumber)
                .closeModal();
    }
}
