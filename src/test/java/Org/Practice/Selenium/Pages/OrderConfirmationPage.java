package Org.Practice.Selenium.Pages;

import Org.Practice.Selenium.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderConfirmationPage extends BasePage {

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);

    }

    By thankYouMessage = By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");


    public String thankyouMessageUser() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMessage)).getText();

    }
}