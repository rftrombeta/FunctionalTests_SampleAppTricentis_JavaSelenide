package com.automation.pages;

import com.automation.enums.Hobbies;
import com.automation.enums.OptionPrice;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class SelectPriceOptionPage {


    private static final SelenideElement OPTION_SILVER = $(byId("selectsilver"));
    private static final SelenideElement OPTION_GOLD = $(byId("selectgold"));
    private static final SelenideElement OPTION_PLATINUM = $(byId("selectplatinum"));
    private static final SelenideElement OPTION_ULTIMATE = $(byId("selectultimate"));

    private static final SelenideElement BTN_NEXT = $(byId("nextsendquote"));

    public SelectPriceOptionPage optionPrice(OptionPrice optionPrice) {

        //$(byId("selectplatinum")).sendKeys(optionPrice);

        if(optionPrice == OptionPrice.SILVER){
            $(byId("selectsilver")).sendKeys(" ");
        } if(optionPrice == OptionPrice.GOLD) {
            $(byId("selectgold")).sendKeys(" ");
        } if(optionPrice == OptionPrice.PLATINUM) {
            $(byId("selectplatinum")).sendKeys(" ");
        } else {
            $(byId("selectultimate")).sendKeys(" ");
        }

        return this;
    }

    public SelectPriceOptionPage nextPage() {

        $(byId("nextsendquote")).click();
        return this;
    }

}
