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
        $("label[for=\"gender-radio-1\"]").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("September");
        $(".react-datepicker__year-select").selectOptionContainingText("1939");
        $("div[aria-label=\"Choose Saturday, September 2nd, 1939\"").click();
        $("label[for=\"hobbies-checkbox-1\"]").click();
        $("label[for=\"hobbies-checkbox-3\"]").click();
        $("#subjectsInput").setValue("Test");
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
        $("tbody tr", 2).shouldHave(text("Gender"), text("Male"));
        $("tbody tr", 3).shouldHave(text("Mobile"), text("8912856050"));
        $("tbody tr", 4).shouldHave(text("Date of Birth"), text("02 September,1939"));

        //$("tbody tr", 5).shouldHave(text("Subject"), text("Test"));
        $("tbody tr", 6).shouldHave(text("Hobbies"), text("Sports, Music"));
        $("tbody tr", 7).shouldHave(text("Picture"), text("File.png"));
        $("tbody tr", 8).shouldHave(text("Address"), text("ул. Пушкина"));
        $("tbody tr", 9).shouldHave(text("State and City"), text("NCR Noida"));
        $("#closeLargeModal").click();
    }
}
