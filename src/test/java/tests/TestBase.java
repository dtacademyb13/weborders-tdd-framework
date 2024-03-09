package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;

/**
 * This class contains common configuration methods for all other test classes in this framewor
 * All Test classes should extend this class to obtain the common configurations
 */
public class TestBase {

    @BeforeMethod (alwaysRun = true)
    public void setup(){
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(){

        Driver.quitDriver();
    }
}
