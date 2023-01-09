package Org.Practice.Selenium.Base;

import Org.Practice.Selenium.Utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void url(String endpoint) throws FileNotFoundException {

        driver.get(ConfigLoader.getInstance().getBaseUrl() + endpoint);
    }
}
