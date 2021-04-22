package com.automation.utils;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    static WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 10);

    public static void waitElementVisibleOnScreen(SelenideElement element) {

        wait.until(e ->  element.isDisplayed());
    }
}