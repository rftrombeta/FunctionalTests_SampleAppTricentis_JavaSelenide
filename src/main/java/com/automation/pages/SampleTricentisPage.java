package com.automation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SampleTricentisPage {


    private static final SelenideElement AUTOMOBILE = $(byId("nav_automobile"));

    public SampleTricentisPage Automobile() {

        open("/app.php");
        return this;
    }

}
