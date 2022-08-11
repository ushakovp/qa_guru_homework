package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultsModal {

    private final SelenideElement closeModal = $("#closeLargeModal");

    public ResultsModal checkVisible() {
        $(".modal-header").should(appear);
        $$("tbody tr").shouldHave(size(10));
        return this;
    }

    public ResultsModal checkResult(String key, String value) {
        $(".table-responsive table").$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }

    public void closeModal() {
        closeModal.click();
    }
}
