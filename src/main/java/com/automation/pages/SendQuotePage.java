package com.automation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.automation.utils.WaitUtils.waitElementVisibleOnScreen;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class SendQuotePage {

    private SelenideElement alertForm = $(byClassName("sweet-alert"));

    public SendQuotePage email(String email) {

        $(byId("email")).sendKeys(email);
        return this;
    }

    public SendQuotePage phone(String phone) {

        $(byId("phone")).sendKeys(phone);
        return this;
    }

    public SendQuotePage userName(String userName) {

        $(byId("username")).sendKeys(userName);
        return this;
    }

    public SendQuotePage passsord(String passsord) {

        $(byId("password")).sendKeys(passsord);
        return this;
    }

    public SendQuotePage confirmPassword(String confirmPassword) {

        $(byId("confirmpassword")).sendKeys(confirmPassword);
        return this;
    }

    public SendQuotePage SendQuote() {

        $(byId("sendemail")).click();
        return this;
    }

    public String SuccesMessage() {

        waitElementVisibleOnScreen(alertForm);
        return $(byCssSelector("div h2")).getText();
    }

}
