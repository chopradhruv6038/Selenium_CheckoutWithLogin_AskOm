package Org.Practice.Selenium.Base;

import Org.Practice.Selenium.Factory.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BaseTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    public WebDriver getDriver() {
        return this.driver.get();

    }

    @Parameters({"browser"})
    @BeforeMethod
    public void startDriver(String browser) {

        setDriver(new DriverManager().initializeDriver(browser));
    }

    @Parameters({"browser"})
    @AfterMethod
    public void quitDriver(ITestResult result, String browser) throws IOException { // We are going to take a screenshot using selenium's ITestResult interface

        //We are creating an if condition and ItestResult getStatus method to check if the test case failed or not.

        if (result.getStatus() == ITestResult.FAILURE) {


            // now we are going to create an object to of the File class to get the Testclass Test Method and also the browser information of the fail case.

            File destFile = new File("scr" + File.separator + browser + File.separator +
                    result.getTestClass().getRealClass().getSimpleName() + "_" +
                    result.getMethod().getMethodName() + ".png");

             getScreenshot(destFile);

            //getScreenshotUsingAshot(destFile);

            //Creating a file path and will assign it to the File object
            //We need the browser information so we will pass browser parameter in the @AfterMethod also.
            //Scr is the folder where our screenshots will be stored. We will use the file separator in the path instead of forward or backward slash
        }
        getDriver().quit();

    }

    // now we will create a screenshot method and we will pass the destination file (destFile)
    //Using take screenshot interface and get driver object.
    // we need to cast the driver.
    // creating the file object and using the takescreenshot instance variable.

    public void getScreenshot(File destFile) throws IOException {

        //using the FileUtils Dependency with copy file method and will pass the source file and destFile
//copy file method will copy the src file to the destination file

        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();

        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(srcFile, destFile);
    }

    // creating a method to get screenshot using Ashot me

    private void getScreenshotUsingAshot(File destFile){ //using Ashot method and shooting strategy method to take screenshot.

        Screenshot screenshot = new AShot() //creating new object for screenshot
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(getDriver());

    try{
        ImageIO.write(screenshot.getImage(), "PNG", destFile);

    } catch (IOException e){
        e.printStackTrace();

    }

    }

}
