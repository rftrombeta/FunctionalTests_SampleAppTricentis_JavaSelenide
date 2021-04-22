package com.automation.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.automation.utils.WaitUtils.waitElementVisibleOnScreen;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

@Component
public class BestSellerPage {

    @Autowired
    private AddToCartPage addToCartPage;

    public BestSellerPage selectBestSellerTab() {

        $(byClassName("blockbestsellers")).click();

        return this;
    }

    private SelenideElement bestSellersTable() {

        return $(byId("blockbestsellers"));
    }

    private List<SelenideElement> bestSellerRows() {

        return bestSellersTable().findAll(byClassName("product-container"));
    }

    public BestSellerPage selectItemsAndPutIntoCart() {

        int lines = bestSellerRows().size();

        for(int i=0; i<lines; i++) {

            SelenideElement produtName = bestSellerRows().get(i).find(byCssSelector("a.product-name"));

            actions().moveToElement(produtName).build().perform();

            SelenideElement addButton =
                    bestSellerRows().get(i)
                            .find(byCssSelector("a.button.ajax_add_to_cart_button.btn.btn-default"));

            waitElementVisibleOnScreen(addButton);

            addButton.click();

            if (i != bestSellerRows().size() - 1) {

                addToCartPage
                        .validatesIfContinueShoppingButtonIsVisible()
                        .continueShoppingButtonClick();
            }
            else
            {
                addToCartPage
                        .validatesIfProceedToCheckoutButtonIsVisible()
                        .proceedToCheckoutButtonClick();
            }
        }

        return this;
    }
}