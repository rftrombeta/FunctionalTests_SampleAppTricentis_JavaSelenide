package com.automation.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.automation.utils.WaitUtils.waitElementVisibleOnScreen;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

@Component
public class SummaryCartPage {

    private final SelenideElement proceedToCheckoutButton =
            $(byCssSelector("a.button.btn.btn-default.standard-checkout.button-medium"));

    public SelenideElement cartItem() {

        return $(byClassName("shopping_cart"));
    }

    public String cartTotalItems() {

        return cartItem().findElement(By.cssSelector("span.ajax_cart_quantity")).getText();
    }

    public SummaryCartPage ProceedToCheckoutButtonClick() {

        proceedToCheckoutButton.click();

        return this;
    }

    public SummaryCartPage validatesIfProceedToCheckoutButtonIsVisible() {

        waitElementVisibleOnScreen(proceedToCheckoutButton);

        return this;
    }
}