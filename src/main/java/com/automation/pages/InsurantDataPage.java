package com.automation.pages;

import com.automation.enums.Gender;
import com.automation.enums.Hobbies;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class InsurantDataPage {

    public InsurantDataPage firstName(String firstName) {

        $(byId("firstname")).sendKeys(firstName);
        return this;
    }

    public InsurantDataPage lastName(String lastName) {

        $(byId("lastname")).sendKeys(lastName);
        return this;
    }

    public InsurantDataPage birthDate(String birthDate) {

        $(byId("birthdate")).sendKeys(birthDate);
        return this;
    }

    public InsurantDataPage gender(Gender gender) {

        if(gender == Gender.MALE){
            $(byId("gendermale")).sendKeys(" ");
        } else {
            $(byId("genderfemale")).sendKeys(" ");
        }

        return this;
    }

    public InsurantDataPage streetAddress(String streetAddress) {

        $(byId("streetaddress")).sendKeys(streetAddress);
        return this;
    }

    public InsurantDataPage country(String country) {

        $(byId("country")).sendKeys(country);
        return this;
    }

    public InsurantDataPage zipCode(String zipCode) {

        $(byId("zipcode")).sendKeys(zipCode);
        return this;
    }

    public InsurantDataPage city(String city) {

        $(byId("city")).sendKeys(city);
        return this;
    }

    public InsurantDataPage occupation(String occupation) {

        $(byId("occupation")).sendKeys(occupation);
        return this;
    }

    public InsurantDataPage hobbies(Hobbies hobbies) {

        if(hobbies == Hobbies.SPEEDING){
            $(byId("speeding")).sendKeys(" ");
        } if(hobbies == Hobbies.BUNGEEJUNMPING) {
            $(byId("bungeejumping")).sendKeys(" ");
        } if(hobbies == Hobbies.CLIFFDIVING) {
            $(byId("cliffdiving")).sendKeys(" ");
        } if(hobbies == Hobbies.SKYDIVING) {
            $(byId("skydiving")).sendKeys(" ");
        } else {
            $(byId("other")).sendKeys(" ");
        }

        return this;
    }

    public InsurantDataPage webSite(String webSite) {

        $(byId("website")).sendKeys(webSite);
        return this;
    }

    public InsurantDataPage picture(String picture) {

        $(byId("picture")).sendKeys(picture);
        return this;
    }

    public InsurantDataPage nextPage() {

        $(byId("nextenterproductdata")).click();
        return this;
    }

}
