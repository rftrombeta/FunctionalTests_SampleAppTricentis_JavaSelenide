package com.automation.pages;

import com.automation.enums.Months;
import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.automation.utils.WaitUtils.waitElementVisibleOnScreen;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

@Component
public class SignInCartPage {

    private final SelenideElement createAccountButton = $(byId("SubmitCreate"));

    private final SelenideElement registerButton = $(byId("submitAccount"));

    public SignInCartPage fillEmailAddressField(String email) {

        $(byId("email_create")).sendKeys(email);

        return this;
    }

    public SignInCartPage createAnAccountButtonClick() {

        createAccountButton.click();

        return this;
    }

    public SignInCartPage validatesIfCreateAnAccountButtonIsVisible() {

        waitElementVisibleOnScreen(createAccountButton);

        return this;
    }

    public SignInCartPage mrRadioButtonClick() {

        $(byId("id_gender1")).click();

        return this;
    }

    public SignInCartPage mrsRadioButtonClick() {

        $(byId("id_gender2")).click();

        return this;
    }

    public SignInCartPage preencherFirstName(String name) {

        $(byId("customer_firstname")).sendKeys(name);

        return this;
    }

    public SignInCartPage fillLastNameField(String lastName) {

        $(byId("customer_lastname")).sendKeys(lastName);

        return this;
    }

    public SignInCartPage fillEmailField(String email) {

        $(byId("email")).sendKeys(email);

        return this;
    }

    public SignInCartPage fillPasswordField(String password) {

        $(byId("passwd")).sendKeys(password);

        return this;
    }

    public SignInCartPage fillDayOfBirthField(Integer dayOfBirth) {

        $(byId("days")).sendKeys(dayOfBirth.toString());

        return this;
    }

    public SignInCartPage fillMonthOfBirthField(Months monthOfBirth) {

        $(byId("months")).sendKeys(monthOfBirth.getMonthName());

        return this;
    }

    public SignInCartPage fillYearOfBirthField(Integer yearOfBirth) {

        $(byId("years")).sendKeys(yearOfBirth.toString());

        return this;
    }

    public SignInCartPage signUpForOurNewsletterClick() {

        $(byId("newsletter")).click();

        return this;
    }

    public SignInCartPage receiveSpecialOffersFromOursPartnersClick() {

        $(byId("optin")).click();

        return this;
    }

    public SignInCartPage fillFirstNameAddressField(String addressFirstName) {

        $(byId("firstname")).sendKeys(addressFirstName);

        return this;
    }

    public SignInCartPage fillLastNameAddressField(String addressLastName) {

        $(byId("lastname")).sendKeys(addressLastName);

        return this;
    }

    public SignInCartPage fillCompanyField(String company) {

        $(byId("company")).sendKeys(company);

        return this;
    }

    public SignInCartPage fillAddressField(String address) {

        $(byId("address1")).sendKeys(address);

        return this;
    }

    public SignInCartPage fillAddressField2(String address2) {

        $(byId("address2")).sendKeys(address2);

        return this;
    }

    public SignInCartPage fillCityField(String city) {

        $(byId("city")).sendKeys(city);

        return this;
    }

    public SignInCartPage fillStateField(String state) {

        $(byId("id_state")).sendKeys(state);

        return this;
    }

    public SignInCartPage fillZipPostalCodeField(String postCode) {

        $(byId("postcode")).sendKeys(postCode);

        return this;
    }

    public SignInCartPage fillCountryField(String country) {

        $(byId("id_country")).sendKeys(country);

        return this;
    }

    public SignInCartPage fillAdditionalInformationField(String additionalInformation) {

        $(byId("other")).sendKeys(additionalInformation);

        return this;
    }

    public SignInCartPage fillPhoneField(String phoneNumber) {

        $(byId("phone")).sendKeys(phoneNumber);

        return this;
    }

    public SignInCartPage fillMobilePhoneField(String mobilePhoneNumber) {

        $(byId("phone_mobile")).sendKeys(mobilePhoneNumber);

        return this;
    }

    public SignInCartPage fillAddressAliasField(String addressAlias) {

        $(byId("alias")).sendKeys(addressAlias);

        return this;
    }

    public SignInCartPage registerButtonClick() {

        registerButton.click();

        return this;
    }

    public SignInCartPage validatesIfRegisterButtonIsVisible() {

        waitElementVisibleOnScreen(registerButton);

        return this;
    }
}