package com.automation.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.automation.utils.WaitUtils.waitElementVisibleOnScreen;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

@Component
public class ShippingCartPage {

    private final SelenideElement proceedToCheckoutButton = $(byName("processCarrier"));

    public ShippingCartPage termsOfServiceCheck() {

        $(byId("cgv")).click();

        return this;
    }

    public ShippingCartPage proceedToCheckoutButtonClick() {

        proceedToCheckoutButton.click();

        return this;
    }

    public ShippingCartPage validatesIfProceedToCheckoutButtonIsVisible() {

        waitElementVisibleOnScreen(proceedToCheckoutButton);

        return this;
    }
}