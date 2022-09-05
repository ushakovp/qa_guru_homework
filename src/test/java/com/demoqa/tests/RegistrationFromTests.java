package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.utils.RandomDataGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.demoqa.utils.ExpectedResultsHelper.expectedDayOfBirth;
import static com.demoqa.utils.ExpectedResultsHelper.expectedSubjects;
import static io.qameta.allure.Allure.step;

public class RegistrationFromTests extends TestBase {

    RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
    private final String city = randomDataGenerator.getRandomCity();
    private final String state = randomDataGenerator.getRandomState();
    private final String gender = randomDataGenerator.getRandomGender();
    private final String hobby = randomDataGenerator.getRandomHobby();
    private final String[] subjects = randomDataGenerator.getRandomSubjects();
    private final String dayOfBirth = randomDataGenerator.getRandomBDay();
    private final String monthOfBirth = randomDataGenerator.getRandomBMonth();
    private final String yearOfBirth = randomDataGenerator.getRandomBYear();
    private final String name = randomDataGenerator.getRandomFirstName();
    private final String lastName = randomDataGenerator.getRandomLastName();
    private final String email = randomDataGenerator.getRandomEmail();
    private final String telephoneNumber = randomDataGenerator.getRandomPhone();
    private final String address = randomDataGenerator.getRandomAddress();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    static Stream<Arguments> fillFormMinimalWithParametrizedSubjectsTest() {
        return Stream.of(
                Arguments.of((Object) new String[]{"Arts"}),
                Arguments.of((Object) new String[]{"Biology", "Chemistry"}),
                Arguments.of((Object) new String[]{"English", "Maths", "Physics"})
        );
    }

    @Disabled
    @DisplayName("Отправляется форма заполеннная случайными данными")
    @Test
    public void fillFormTest() {
        String pathToPicture = "File.png";

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

        String expectedFullName = name + " " + lastName;
        String expectedDOB = expectedDayOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        String expectedSubjects = expectedSubjects(subjects);
        String expectedStateAndCity = state + " " + city;

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", telephoneNumber)
                .checkResult("Date of Birth", expectedDOB)
                .checkResult("Subjects", expectedSubjects)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", pathToPicture)
                .checkResult("Address", address)
                .checkResult("State and City", expectedStateAndCity)
                .closeModal();
    }

    @DisplayName("Отправляется форма заполненная минимальным количеством данных")
    @Test
    @Tag("minimalTest")
    public void fillFormMinimalTest() {

        step("Open registrations form", () -> {
            registrationFormPage.openPage();
        });

        step("Fill form", () -> {
            registrationFormPage.setName(name)
                    .setLastName(lastName)
                    .setGender(gender)
                    .setTelephoneNumber(telephoneNumber)
                    .submit();
        });

        step("Check form results", () -> {
            String expectedFullName = name + " " + lastName;

            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", expectedFullName)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", telephoneNumber)
                    .closeModal();
        });
    }

    @Disabled
    @ValueSource(strings = {"Male", "Female", "Other"})
    @ParameterizedTest(name = "Отправляется форма с гендером {0}")
    public void fillFormMinimalWithAllGendersTest(String testData) {
        registrationFormPage.openPage()
                .setName(name)
                .setLastName(lastName)
                .setGender(testData)
                .setTelephoneNumber(telephoneNumber)
                .submit();

        String expectedFullName = name + " " + lastName;

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Gender", testData)
                .checkResult("Mobile", telephoneNumber)
                .closeModal();
    }

    @Disabled
    @MethodSource()
    @ParameterizedTest(name = "Отправляется форма с subject {0}")
    public void fillFormMinimalWithParametrizedSubjectsTest(String[] testData) {
        registrationFormPage.openPage()
                .setName(name)
                .setLastName(lastName)
                .setGender(gender)
                .setTelephoneNumber(telephoneNumber)
                .setSubjects(testData)
                .submit();

        String expectedFullName = name + " " + lastName;
        String expectedSubjects = expectedSubjects(testData);

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", telephoneNumber)
                .checkResult("Subjects", expectedSubjects)
                .closeModal();
    }
}
