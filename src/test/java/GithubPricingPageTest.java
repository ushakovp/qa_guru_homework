import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubPricingPageTest {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1020";
    }

    @Test
    void shouldOpenPricingPage() {
        open("https://github.com/");
        $("html").hover();

        $(byText("Pricing")).hover();
        $(byXpath("//nav/ul/li[6]/details/div")).shouldBe(visible);

        $(byText("Compare plans")).click();
        $("body").shouldHave(text("Choose the plan that’s right for you."));
    }
}
