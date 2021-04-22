package com.automation.test.functionaltests;

import com.automation.enums.Gender;
import com.automation.enums.Months;
import com.automation.pages.*;
import com.automation.utils.EnumUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;

import static com.automation.Constants.BASE_URL;
import static com.automation.utils.FakerUtils.*;
import static com.automation.utils.IntegerUtils.random;
import static com.codeborne.selenide.Selenide.open;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class MyStoreTest {

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

    @Test
    public void mustAddAllBestSellersIntoCartAndMakePayment() throws FileNotFoundException, InterruptedException {

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

        bestSellerPage
                .selectBestSellerTab()
                .selectItemsAndPutIntoCart();

        summaryCartPage
                .validatesIfProceedToCheckoutButtonIsVisible()
                .ProceedToCheckoutButtonClick();

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

        Assert.assertEquals("Your order on My Store is complete.", paymentCartPage.successMessage());
    }
}