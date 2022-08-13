package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.utils.RandomDataGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.demoqa.utils.ExpectedResultsHelper.expectedDayOfBirth;
import static com.demoqa.utils.ExpectedResultsHelper.expectedSubjects;

public class RegistrationFromTests {

    private final String pathToPicture = "File.png";
    private final String state = "NCR";
    private final String city = "Noida";
    RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
    private final String gender = randomDataGenerator.getRandomGender();
    private final String hobby = randomDataGenerator.getRandomHobby();
    private final String[] subjects = randomDataGenerator.getSubjects();
    private final String dayOfBirth = randomDataGenerator.getbDay();
    private final String monthOfBirth = randomDataGenerator.getbMonth();
    private final String yearOfBirth = randomDataGenerator.getbYear();
    private final String name = randomDataGenerator.getRandomFirstName();
    private final String lastName = randomDataGenerator.getRandomLastName();
    private final String email = randomDataGenerator.getRandomEmail();
    ;
    private final String telephoneNumber = randomDataGenerator.getRandomPhone();
    private final String address = randomDataGenerator.getRandomAddress();
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

        sleep(3000);
        String expectedDOB = expectedDayOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        String expectedSubjects = expectedSubjects(subjects);

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", name + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", telephoneNumber)
                .checkResult("Date of Birth", expectedDOB)
                .checkResult("Subjects", expectedSubjects)
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

        sleep(3000);
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", name + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", telephoneNumber)
                .closeModal();
    }
}
