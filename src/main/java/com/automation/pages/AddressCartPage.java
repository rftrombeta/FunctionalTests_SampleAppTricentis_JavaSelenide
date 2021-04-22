package com.automation.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.automation.utils.WaitUtils.waitElementVisibleOnScreen;
import static com.codeborne.selenide.Selenide.$;

@Component
public class AddressCartPage {

    private final SelenideElement proceedToCheckoutAddressButton = $(By.name("processAddress"));

    public AddressCartPage proceedToCheckoutAddressButtonClick() {

        proceedToCheckoutAddressButton.click();

        return this;
    }

    public AddressCartPage validatesIfProceedToCheckoutAddressButtonIsVisible() {

        waitElementVisibleOnScreen(proceedToCheckoutAddressButton);

        return this;
    }
}