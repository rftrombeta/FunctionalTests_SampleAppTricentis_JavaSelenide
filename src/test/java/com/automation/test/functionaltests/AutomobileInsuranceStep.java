package com.automation.test.functionaltests;

import com.automation.enums.Gender;
import com.automation.enums.Hobbies;
import com.automation.enums.OptionPrice;
import com.automation.test.SampleAppTricentisBaseTest;
import com.automation.utils.EnumUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AutomobileInsuranceStep extends SampleAppTricentisBaseTest {

    private final EnumUtils<Gender> gender = new EnumUtils<>(Gender.class);
    private final EnumUtils<Hobbies> hobbies = new EnumUtils<>(Hobbies.class);
    private final EnumUtils<OptionPrice> optionPrice = new EnumUtils<>(OptionPrice.class);

    @Given("that I'm in the Automobile Insurance form")
    public void thatIMInTheAutomobileInsuranceForm() {

        //sampleTricentisPage.Automobile();

    }

    @When("I fill in all fields of the Vehicle Data form")
    public void iFillInAllFieldsOfTheVehicleDataForm() {

        vehicleDataPage
                .make("Audi")
                .model("Scooter")
                .cylinderCapacity("1234")
                .enginePerformance("1234")
                .dateOfManufacture("04/22/2021")
                .numberOfSeats("5")
                .numberOfSeatsMotorcycle("3")
                .fuelType("Gas")
                .payload("100")
                .totalWeight("5000")
                .listPrice("5000")
                .licensePlateNumber("ABC456")
                .annualMileage("1500")
                .nextPage();

    }

    @When("I fill in all fields of the Insurant Data form")
    public void iFillInAllFieldsOfTheInsurantDataForm() {

        Gender gender = this.gender.randomEnum();
        Hobbies hobbies = this.hobbies.randomEnum();

        insurantDataPage
                .firstName("Rodrigo")
                .lastName("Trombeta")
                .birthDate("04/22/2000")
                .gender(gender)
                .streetAddress("Rua Chile")
                .country("Brasil")
                .zipCode("1234567")
                .city("Maringá")
                .occupation("Employee")
                .hobbies(hobbies)
                .webSite("www.rodrigotrombeta.com.br")
                .nextPage();

    }

    @When("I fill in all fields of the Product Data form")
    public void iFillInAllFieldsOfTheProductDataForm() {

        productDataPage
                .startDate("04/22/2022")
                .insuranceSum("3")
                .meritRating("Super Bonus")
                .damageInsurance("Full Coverage")
                .optionalProducts()
                .courtesyCar("Yes")
                .nextPage();

    }

    @When("I fill in all fields of the Price Option form")
    public void iFillInAllFieldsOfThePriceOptionForm() {

        OptionPrice optionPrice = this.optionPrice.randomEnum();

        selectPriceOptionPage
                .optionPrice(optionPrice)
                .nextPage();

    }

    @When("I fill in all fields of the Send Quote form")
    public void iFillInAllFieldsOfTheSendQuoteForm() {

        sendQuotePage
                .email("rftrombeta@gmail.com")
                .phone("44991439336")
                .userName("rftrombeta")
                .passsord("RFtrombeta123")
                .confirmPassword("RFtrombeta123");

    }

    @When("send quotation")
    public void sendQuotation() {

        sendQuotePage.SendQuote();

    }

    @Then("I should see the message Sending e-mail success")
    public void iShouldSeeTheMessageSendingEMailSuccess() {

        Assert.assertEquals("Sending e-mail success!", sendQuotePage.SuccesMessage());

    }
}
