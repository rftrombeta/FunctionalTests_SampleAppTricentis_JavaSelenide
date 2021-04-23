package com.automation.pages;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class VehicleDataPage {

    public VehicleDataPage make(String make){

        $(byId("make")).sendKeys(make);
        return this;
    }

    public VehicleDataPage model(String model){

        $(byId("model")).sendKeys(model);
        return this;
    }

    public VehicleDataPage cylinderCapacity(String cylinderCapacity){

        $(byId("cylindercapacity")).sendKeys(cylinderCapacity);
        return this;
    }

    public VehicleDataPage enginePerformance(String enginePerformance){

        $(byId("engineperformance")).sendKeys(enginePerformance);
        return this;
    }

    public VehicleDataPage dateOfManufacture(String dateOfManufacture){

        $(byId("dateofmanufacture")).sendKeys(dateOfManufacture);
        return this;
    }

    public VehicleDataPage numberOfSeats(String numberOfSeats){

        $(byId("numberofseats")).sendKeys(numberOfSeats);
        return this;
    }

    public VehicleDataPage numberOfSeatsMotorcycle(String numberOfSeatsMotorcycle){

        $(byId("numberofseatsmotorcycle")).sendKeys(numberOfSeatsMotorcycle);
        return this;
    }

    public VehicleDataPage fuelType(String fuelType){

        $(byId("fuel")).sendKeys(fuelType);
        return this;
    }

    public VehicleDataPage payload(String payload){

        $(byId("payload")).sendKeys(payload);
        return this;
    }

    public VehicleDataPage totalWeight(String totalWeight){

        $(byId("totalweight")).sendKeys(totalWeight);
        return this;
    }

    public VehicleDataPage listPrice(String listPrice){

        $(byId("listprice")).sendKeys(listPrice);
        return this;
    }

    public VehicleDataPage licensePlateNumber(String licensePlateNumber){

        $(byId("licenseplatenumber")).sendKeys(licensePlateNumber);
        return this;
    }

    public VehicleDataPage annualMileage(String annualMileage){

        $(byId("annualmileage")).sendKeys(annualMileage);
        return this;
    }

    public VehicleDataPage nextPage() {

        $(byId("nextenterinsurantdata")).click();
        return this;
    }

}
