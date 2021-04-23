package com.automation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class SampleTricentisPage {


    private static final SelenideElement AUTOMOBILE = $(byId("nav_automobile"));

    public SampleTricentisPage Automobile() {

        AUTOMOBILE.click();
        return this;
    }

}
