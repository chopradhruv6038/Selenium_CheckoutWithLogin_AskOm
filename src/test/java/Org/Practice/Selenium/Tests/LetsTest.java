package Org.Practice.Selenium.Tests;

import Org.Practice.Selenium.Base.BaseTest;
import Org.Practice.Selenium.Objects.BillingAddress;
import Org.Practice.Selenium.Pages.*;
import Org.Practice.Selenium.Utils.ConfigLoader;
import Org.Practice.Selenium.Utils.JacksonUtils;
import io.qameta.allure.*;
import org.apache.hc.client5.http.auth.InvalidCredentialsException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class LetsTest extends BaseTest {

    @Issue("8788999")
    @TmsLink("772222")
    @Feature("Checkout via login using COD")
    @Story("User should be able to checkout ")
    @Description("Run this test using an existing account")
    @Test
    public void checkoutWithLoginUsingCOD() throws IOException, InvalidCredentialsException {

        BillingAddress billingAddress = new BillingAddress();
        InputStream is = getClass().getClassLoader().getResourceAsStream("billingAddress.json");
        billingAddress = JacksonUtils.deserializeJson(is, billingAddress);

       /* Credentials credentials = new Credentials();
        InputStream yes = getClass().getClassLoader().getResourceAsStream("credentials.json");
        credentials = JacksonUtils.deserializeJsonCredenials(yes, credentials);*/


        HomePage homePage = new HomePage(getDriver());
        homePage.loadUrl();

        StorePage storePage = homePage.clickStoreLink();
        Assert.assertEquals(storePage.storePageTitle(), "Store");
        storePage.searchProduct("Blue").clickSearchBtn();
        Assert.assertEquals(storePage.titleOfSearchedProduct(), "Search results: “Blue”");
        storePage.addToCardElementBtn("Blue Shoes");

        CartPage cartPage = storePage.clickViewCartLink();
        Assert.assertEquals(cartPage.getTitleOfSearchedProdCartPage(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        checkoutPage.clickHereToLoginBtn();


            checkoutPage.enterUsernameAndPassword();
            checkoutPage.clickLgnBtn();



            checkoutPage.billingAddressDetails(billingAddress);
            checkoutPage.selectCashOnDelivery();

            OrderConfirmationPage orderConfirmationPage = checkoutPage.placeOrderBtn();
            Assert.assertEquals(orderConfirmationPage.thankyouMessageUser(), "Thank you. Your order has been received.");
        }

    }

