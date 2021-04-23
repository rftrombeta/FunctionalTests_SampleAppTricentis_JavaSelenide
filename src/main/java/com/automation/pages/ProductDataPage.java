package com.automation.pages;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class ProductDataPage {

    public ProductDataPage startDate(String date) {

        $(byId("startdate")).sendKeys(date);
        return this;
    }

    public ProductDataPage insuranceSum(String insuranceSum) {

        $(byId("insurancesum")).sendKeys(insuranceSum);
        return this;
    }

    public ProductDataPage meritRating(String meritRating){

        $(byId("meritrating")).sendKeys(meritRating);
        return this;
    }

    public ProductDataPage damageInsurance(String damageInsurance){

        $(byId("damageinsurance")).sendKeys(damageInsurance);
        return this;
    }

    public ProductDataPage optionalProducts(){

        $(byId("EuroProtection")).sendKeys(" ");
        $(byId("LegalDefenseInsurance")).sendKeys(" ");
        return this;
    }

    public ProductDataPage courtesyCar(String courtesyCar){

        //private static final SelenideElement COURTESY_CAR = $(byId("courtesycar"));
        $(byId("courtesycar")).sendKeys(courtesyCar);
        return this;
    }

    public ProductDataPage nextPage() {

        $(byId("nextselectpriceoption")).click();
        return this;
    }

}
