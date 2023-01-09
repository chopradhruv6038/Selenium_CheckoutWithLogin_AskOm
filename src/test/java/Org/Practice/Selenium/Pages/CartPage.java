package Org.Practice.Selenium.Pages;

import Org.Practice.Selenium.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {

        super(driver);
    }

    //defining elements

    By searchedProdTitleOnCartPage = By.cssSelector("td[class='product-name'] a");
    By checkoutBtn = By.cssSelector(".checkout-button.button.alt.wc-forward");


    public String getTitleOfSearchedProdCartPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProdTitleOnCartPage)).getText();
    }

    public CheckoutPage clickCheckoutBtn() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn)).click();

        return new CheckoutPage(driver);
    }

}