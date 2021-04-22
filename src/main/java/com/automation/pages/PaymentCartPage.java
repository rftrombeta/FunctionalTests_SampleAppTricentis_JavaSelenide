package com.automation.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.automation.utils.WaitUtils.waitElementVisibleOnScreen;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

@Component
public class PaymentCartPage {

    private final SelenideElement payByBankWireButton = $(byClassName("bankwire"));

    private final SelenideElement payByCheckButton = $(byClassName("cheque"));

    private final SelenideElement iConfirmMyOrderButton = $("button.button.btn.btn-default.button-medium");

    public PaymentCartPage payByBankWireButtonClick() {

        payByBankWireButton.click();

        return this;
    }

    public PaymentCartPage payByCheckButtonClick() {

        payByCheckButton.click();

        return this;
    }

    public PaymentCartPage iConfirmMyOrderButtonClick() {

        iConfirmMyOrderButton.click();

        return this;
    }

    public String successMessage() {

        return $(byCssSelector("p.alert.alert-success")).getText();
    }

    public PaymentCartPage validatesIfIConfirmMyOrderButtonIsVisible() {

        waitElementVisibleOnScreen(iConfirmMyOrderButton);

        return this;
    }

    public PaymentCartPage validatesIfPayByCheckButtonIsVisible() {

        waitElementVisibleOnScreen(payByCheckButton);

        return this;
    }
}