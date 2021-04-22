package com.automation.test.cucumbertests;

import com.automation.enums.Gender;
import com.automation.enums.Months;
import com.automation.pages.*;
import com.automation.utils.EnumUtils;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;

import static com.automation.Constants.BASE_URL;
import static com.automation.utils.FakerUtils.*;
import static com.automation.utils.FakerUtils.randomStateGenerator;
import static com.automation.utils.IntegerUtils.random;
import static com.codeborne.selenide.Selenide.open;

@SpringBootTest
public class MyStoreStepDefinitions {

    @Autowired
    private BestSellerPage bestSellerPage;

    @Autowired
    private SummaryCartPage summaryCartPage;

    @Autowired
    private SignInCartPage signInCartPage;

    @Autowired
    private AddressCartPage addressCartPage;

    @Autowired
    private ShippingCartPage shippingCartPage;

    @Autowired
    private PaymentCartPage paymentCartPage;

    private final EnumUtils<Gender> gender = new EnumUtils<>(Gender.class);

    private final EnumUtils<Months> month = new EnumUtils<>(Months.class);

    @Before
    public void setUp() {

        open(BASE_URL);
    }

    @Given("I add all best sellers items into cart")
    public void i_add_all_best_sellers_items_into_cart() {

        bestSellerPage
                .selectBestSellerTab()
                .selectItemsAndPutIntoCart();

        summaryCartPage
                .validatesIfProceedToCheckoutButtonIsVisible()
                .ProceedToCheckoutButtonClick();
    }

    @When("I register myself at My Store website")
    public void i_register_myself_at_my_store_website() throws FileNotFoundException, InterruptedException {

        Gender gender = this.gender.randomEnum();
        String firstName = randomFirstNameGenerator(gender);
        String lastName = randomLastNameGenerator();
        String email = emailGenerator(firstName, lastName);
        String password = random(11111, 99999).toString();
        Integer dayOfBirth = random(1, 28);
        Months monthOfBirth = month.randomEnum();
        Integer yearOfBirth = random(1980, 2000);
        String address = random(10, 9999) + " " + lastName + " " + randomPublicPlaceGenerator();
        String city = randomCityGenerator();
        String state = randomStateGenerator();
        String zipCode = random(11111, 99999).toString();
        String mobilePhone = "(" + random(44, 47) + ") " + random(1111, 9999) + "-" + random(1111, 9999);

        signInCartPage
                .validatesIfCreateAnAccountButtonIsVisible()
                .fillEmailAddressField(email)
                .createAnAccountButtonClick()
                .validatesIfRegisterButtonIsVisible();

        if(gender == Gender.MALE) {

            signInCartPage.mrRadioButtonClick();
        }
        else {

            signInCartPage.mrsRadioButtonClick();
        }

        signInCartPage
                .preencherFirstName(firstName)
                .fillLastNameField(lastName)
                .fillPasswordField(password)
                .fillDayOfBirthField(dayOfBirth)
                .fillMonthOfBirthField(monthOfBirth)
                .fillYearOfBirthField(yearOfBirth)
                .fillAddressField(address)
                .fillCityField(city)
                .fillStateField(state)
                .fillZipPostalCodeField(zipCode)
                .fillMobilePhoneField(mobilePhone)
                .registerButtonClick();
    }

    @When("I try to make the payment")
    public void i_try_to_make_the_payment() {

        addressCartPage
                .validatesIfProceedToCheckoutAddressButtonIsVisible()
                .proceedToCheckoutAddressButtonClick();

        shippingCartPage
                .validatesIfProceedToCheckoutButtonIsVisible()
                .termsOfServiceCheck()
                .proceedToCheckoutButtonClick();

        paymentCartPage
                .validatesIfPayByCheckButtonIsVisible()
                .payByCheckButtonClick()
                .validatesIfIConfirmMyOrderButtonIsVisible()
                .iConfirmMyOrderButtonClick();
    }

    @Then("should successful perform the order")
    public void should_successful_perform_the_order() {

        Assert.assertEquals("Your order on My Store is complete.", paymentCartPage.successMessage());
    }
}