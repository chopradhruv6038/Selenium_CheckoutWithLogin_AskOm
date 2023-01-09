package Org.Practice.Selenium.Pages;

import Org.Practice.Selenium.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileNotFoundException;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){

        super(driver);
    }

    //defining the elements:

    By storeLink = By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");


public HomePage loadUrl() throws FileNotFoundException {

        url("/");
        return this;
}


public StorePage clickStoreLink(){

    wait.until(ExpectedConditions.visibilityOfElementLocated(storeLink)).click();

    return new StorePage(driver);

}


}
