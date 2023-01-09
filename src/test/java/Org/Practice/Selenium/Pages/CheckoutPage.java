package Org.Practice.Selenium.Pages;

import Org.Practice.Selenium.Base.BasePage;
import Org.Practice.Selenium.Objects.BillingAddress;
import Org.Practice.Selenium.Utils.ConfigLoader;
import org.apache.hc.client5.http.auth.InvalidCredentialsException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //defining UI elements:

    By clickHereTologinLink = By.cssSelector(".showlogin");
    By userName = By.cssSelector("#username");
    By password = By.cssSelector("#password");
    By loginBtn = By.cssSelector("button[value='Login']");

    By firstName = By.cssSelector("#billing_first_name");
    By lastName = By.cssSelector("#billing_last_name");
    By companyName = By.cssSelector("#billing_company");
    By countryName = By.cssSelector("#billing_country");
    By streetAddress = By.cssSelector("#billing_address_1");
    By streetAddress2 = By.cssSelector("#billing_address_2");
    By town = By.cssSelector("#billing_city");
    By stateName = By.cssSelector("#billing_state");
    By zipCode = By.cssSelector("#billing_postcode");
    By phoneNumber = By.cssSelector("#billing_phone");
    By email = By.cssSelector("#billing_email");
    By orderComments = By.cssSelector("#order_comments");
    By cashOnDelivery = By.cssSelector("#payment_method_cod");
    By placeOrderBtn = By.cssSelector("#place_order");

    public CheckoutPage clickHereToLoginBtn() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(clickHereTologinLink)).click();

        return this;
    }

    public CheckoutPage enterUserName(String username) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).sendKeys(username);

        return this;

    }

    public CheckoutPage enterPassword(String Password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(Password);

        return this;
    }


public CheckoutPage enterUsernameAndPassword() throws FileNotFoundException, InvalidCredentialsException {



            enterUserName(ConfigLoader.getInstance().getUsername()) //calling from config.properties.
                    .enterPassword(ConfigLoader.getInstance().getPassword());


        return this;
}

    public CheckoutPage clickLgnBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
        return this;
    }


    public CheckoutPage enterFirstName(String firstname) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(firstname);

        return this;
    }

    public CheckoutPage enterLastName(String lastname) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lastname);

        return this;
    }

    public CheckoutPage enterCompanyName(String companyname) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(companyName)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyName)).sendKeys(companyname);

        return this;
    }

public CheckoutPage selectCountry(String countryname){
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(countryName)));
    select.selectByVisibleText(countryname);
    return this;
}

public CheckoutPage enterStreetAddOne(String StreetAddressOne){

    wait.until(ExpectedConditions.visibilityOfElementLocated(streetAddress)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(streetAddress)).sendKeys(StreetAddressOne);
        return this;
}

    public CheckoutPage enterStreetAddTwo(String StreetAddressTwo){

        wait.until(ExpectedConditions.visibilityOfElementLocated(streetAddress2)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(streetAddress2)).sendKeys(StreetAddressTwo);
        return this;
    }


    public CheckoutPage enterTown(String towndetails){


        wait.until(ExpectedConditions.visibilityOfElementLocated(town)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(town)).sendKeys(towndetails);
        return this;
    }

    public CheckoutPage selectState(String statename){

        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(stateName)));

        select.selectByVisibleText(statename);

        return this;
    }

    public CheckoutPage enterZipCode(String zipcode){

        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode)).sendKeys(zipcode);
        return this;
    }

    public CheckoutPage enterPhoneNumber(String phonenumber){

        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumber)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumber)).sendKeys(phonenumber);
        return this;
    }

    public CheckoutPage enterEmail(String Email){

        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(Email);
        return this;
    }

    public CheckoutPage enterComments(String comments){


        wait.until(ExpectedConditions.visibilityOfElementLocated(orderComments)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderComments)).sendKeys(comments);
        return this;
    }


    public CheckoutPage billingAddressDetails(BillingAddress billingAddress){
        enterFirstName(billingAddress.getEnterFirstName())
                .enterLastName(billingAddress.getEnterLastName())
                .enterCompanyName(billingAddress.getEnterCompanyName())
                .selectCountry(billingAddress.getSelectCountry())
                .enterStreetAddOne(billingAddress.getEnterStreetAddOne())
                .enterStreetAddTwo(billingAddress.getEnterStreetAddTwo())
                .enterTown(billingAddress.getEnterTown())
                .selectState(billingAddress.getSelectState())
                .enterZipCode(billingAddress.getEnterZipCode())
                .enterPhoneNumber(billingAddress.getEnterPhoneNumber())
                .enterEmail(billingAddress.getEnterEmail())
                .enterComments(billingAddress.getEnterComments());

        return this;
    }






    public CheckoutPage selectCashOnDelivery(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cashOnDelivery)).click();
        return this;
    }

    public OrderConfirmationPage placeOrderBtn(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderBtn)).click();

        return new OrderConfirmationPage(driver);
    }

}

