package com.automation.test;


import com.automation.Constants;
import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.Selenide.open;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = {"src/test/resources/features"},
        glue = { "" },
        plugin = {"pretty", "html:target/report-html", "json:target/report-json"}, // Tipos de relatórios
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE //Definie a forma de gerar o nome das classes, no caso, sem underline e com a primera letra sempre maiúsculo
)
public class RunCucumberTest {

    @BeforeClass
    public static void setUp() throws IOException, URISyntaxException {

        Configuration.browser = "chrome";
        clearBrowserCache();
        open(Constants.BASE_URL);
        Configuration.startMaximized = true;

    }
}
