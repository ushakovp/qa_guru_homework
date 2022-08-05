import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTest {

    @Test
    void shouldContainJunitCodeExample() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-more-pages-link button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box a[href*=SoftAssertions]").click();
        $("#wiki-body").parent().shouldHave(text("JUnit5"));
    }
}
