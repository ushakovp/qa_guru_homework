package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement telephoneInput = $("#userNumber");
    private final SelenideElement registrationFromHeader = $(".practice-form-wrapper");
    private final SelenideElement genderInput = $("#genterWrapper");
    private final SelenideElement calendar = $("#dateOfBirthInput");
    private final SelenideElement calendarMonths = $(".react-datepicker__month-select");
    private final SelenideElement calendarYears = $(".react-datepicker__year-select");
    private final SelenideElement hobbies = $("#hobbiesWrapper");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement submit = $("#submit");
    ResultsModal resultsModal = new ResultsModal();

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        registrationFromHeader.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationFormPage setTelephoneNumber(String number) {
        telephoneInput.setValue(number);
        return this;
    }

    public RegistrationFormPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
        calendar.click();
        calendarMonths.selectOptionContainingText(month);
        calendarYears.selectOptionContainingText(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }

    public RegistrationFormPage setHobby(String hobbie) {
        hobbies.$(byText(hobbie)).click();
        return this;
    }

    public RegistrationFormPage setSubjects(String[] subjects) {
        for (String subject : subjects) {
            subjectInput.setValue(subject).pressEnter();
        }
        return this;
    }

    public RegistrationFormPage uploadPicture(String pathToPicture) {
        uploadPictureInput.uploadFromClasspath(pathToPicture);
        return this;
    }

    public RegistrationFormPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationFormPage setStateAndCity(String state, String city) {
        $(byText("Select State")).click();
        $(byText(state)).click();
        $(byText("Select City")).click();
        $(byText(city)).click();
        return this;
    }

    public void submit() {
        submit.click();
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModal.checkResult(key, value);
        return this;
    }

    public void closeModal() {
        resultsModal.closeModal();
    }

}
