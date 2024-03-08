package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

/**
 * This class contains common configuration methods for all other test classes in this framewor
 * All Test classes should extend this class to obtain the common configurations
 */
public class TestBase {

    public WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver =  new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
