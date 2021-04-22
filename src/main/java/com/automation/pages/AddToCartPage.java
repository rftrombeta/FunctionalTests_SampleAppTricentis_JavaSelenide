package com.automation.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.automation.utils.WaitUtils.waitElementVisibleOnScreen;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

@Component
public class AddToCartPage {

    private final SelenideElement proceedToCheckoutButton = $(byCssSelector("a.btn.btn-default.button.button-medium"));

    private final SelenideElement continueShopping = $(byCssSelector("span.continue.btn.btn-default.button.exclusive-medium"));

    public AddToCartPage continueShoppingButtonClick() {

        continueShopping.click();

        return this;
    }

    public void proceedToCheckoutButtonClick() {

        proceedToCheckoutButton.click();
    }

    public AddToCartPage validatesIfContinueShoppingButtonIsVisible() {

        waitElementVisibleOnScreen(continueShopping);

        return this;
    }

    public AddToCartPage validatesIfProceedToCheckoutButtonIsVisible() {

        waitElementVisibleOnScreen(proceedToCheckoutButton);

        return this;
    }
}