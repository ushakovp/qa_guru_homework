package com.demoqa.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultsModal {

    private final SelenideElement closeModal = $("#closeLargeModal");
    private final SelenideElement modealHeader = $(".modal-header");
    private final ElementsCollection tableRows = $$("tbody tr");
    private final SelenideElement tableRow = $(".table-responsive table");

    public ResultsModal checkVisible() {
        modealHeader.should(appear);
        tableRows.shouldHave(size(10));
        return this;
    }

    public ResultsModal checkResult(String key, String value) {
        tableRow.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }

    public void closeModal() {
        closeModal.click();
    }
}
