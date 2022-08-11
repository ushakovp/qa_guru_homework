package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFromTests {
    private final String name = "Ivan";
    private final String lastName = "Ivanov";
    private final String email = "test@test.com";
    private final String telephoneNumber = "8912856050";
    private final String gender = "Other";
    private final String hobbie = "Sports";
    private final String pathToPicture = "File.png";
    private final String address = "ул. Пушкина";
    private final String state = "NCR";
    private final String city = "Noida";
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
                .setDateOfBirth("01", "September", "1939")
                .setHobbie(hobbie)
                .setSubjects(new String[]{"Maths", "Arts", "Physics"})
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
                .checkResult("Hobbies", hobbie)
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
