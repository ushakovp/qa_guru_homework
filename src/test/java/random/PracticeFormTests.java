package random;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void firstTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("test@test.com");
        $("#userNumber").setValue("89128560501");
        $("#genterWrapper").$(byText("Other")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("September");
        $(".react-datepicker__year-select").selectOptionContainingText("1939");
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#uploadPicture").uploadFile(new File("src/test/resources/File.png"));
        $("#currentAddress").setValue("ул. Пушкина");
        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Noida")).click();
        $("#submit").click();

        $(".modal-header").shouldBe(visible);
        $$("tbody tr").shouldHave(size(10));
        $("tbody tr", 0).shouldHave(text("Student Name"), text("Ivan Ivanov"));
        $("tbody tr", 1).shouldHave(text("Student Email"), text("test@test.com"));
        $("tbody tr", 2).shouldHave(text("Gender"), text("Other"));
        $("tbody tr", 3).shouldHave(text("Mobile"), text("8912856050"));
        $("tbody tr", 4).shouldHave(text("Date of Birth"), text("01 September,1939"));
        $("tbody tr", 5).shouldHave(text("Subject"), text("Maths"));
        $("tbody tr", 6).shouldHave(text("Hobbies"), text("Sports"));
        $("tbody tr", 7).shouldHave(text("Picture"), text("File.png"));
        $("tbody tr", 8).shouldHave(text("Address"), text("ул. Пушкина"));
        $("tbody tr", 9).shouldHave(text("State and City"), text("NCR Noida"));
        $("#closeLargeModal").click();
    }
}
