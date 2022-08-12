package random;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {


    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        $("#column-a").dragAndDropTo("#column-b");

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
