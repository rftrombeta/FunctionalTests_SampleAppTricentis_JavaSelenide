package com.automation.test.cucumbertests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:/features",
        glue = {"com.automation.test.cucumbertests"})
public class MyStoreRunCucumber {

}