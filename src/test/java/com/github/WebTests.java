package com.github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class WebTests {

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test
    void repositoryHasIssueListenerTest() {
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").click();
        $("[data-test-selector=nav-search-input]").setValue("selenide");
        $("[data-test-selector=nav-search-input]").submit();
        $$(".repo-list-item").first().$("a").click();
        $("#issues-tab").click();
        $(byText("Add caching API into standard API")).should(exist);

    }

    @Test
    void repositoryHasIssueLambdaTest() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий Selenide", () -> {
            $("[data-test-selector=nav-search-input]").click();
            $("[data-test-selector=nav-search-input]").setValue("selenide");
            $("[data-test-selector=nav-search-input]").submit();
        });

        step("Переходим в репозиторий Selenide", () -> {
            $$(".repo-list-item").first().$("a").click();
        });

        step("Переходим на таб Issue", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем, что есть нужная Issue", () -> {
            $(byText("Add caching API into standard API")).should(exist);
        });
    }
}
