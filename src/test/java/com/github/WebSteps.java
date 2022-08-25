package com.github;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void repositorySearch(String repo) {
        $("[data-test-selector=nav-search-input]").click();
        $("[data-test-selector=nav-search-input]").setValue(repo);
        $("[data-test-selector=nav-search-input]").submit();
    }

    @Step("Переходим в репозиторий selenide")
    public void openRepository() {
        $$(".repo-list-item").first().$("a").click();
    }

    @Step("Переходим на таб Issue")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем, что есть нужная issue - {issue}")
    public void checkIssue(String issue) {
        $(byText(issue)).should(exist);
    }
}
