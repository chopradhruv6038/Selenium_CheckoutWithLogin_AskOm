package Org.Practice.Selenium.Pages;

import Org.Practice.Selenium.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {

    public StorePage(WebDriver driver) {
        super(driver);
    }

//defining the UI elements:

    By searchProductBox = By.cssSelector("#woocommerce-product-search-field-0");
    By searchBtn = By.cssSelector("button[value='Search']");
    By strorePageTitle = By.cssSelector(".woocommerce-products-header__title.page-title");
    By searchedProductTitle = By.cssSelector(".woocommerce-products-header__title.page-title");
    By viewCartBtn = By.cssSelector("a[title='View cart']");


    public String storePageTitle() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(strorePageTitle)).getText();
    }


    public StorePage searchProduct(String product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchProductBox)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchProductBox)).sendKeys(product);
        return this;
    }

    public StorePage clickSearchBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn)).click();
        return this;
    }

    public String titleOfSearchedProduct() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductTitle)).getText();
    }

public By getProductElement(String productName){



    return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");

}

public StorePage addToCardElementBtn(String productName){

        By addToCardElement = getProductElement(productName);

        wait.until(ExpectedConditions.elementToBeClickable(addToCardElement)).click();

        return this;
}

public CartPage clickViewCartLink(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartBtn)).click();

        return new CartPage(driver);
}

}