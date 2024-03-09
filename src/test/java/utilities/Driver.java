package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

/**
 * This class represents singleton WebDriver object, use this class's getDriver method everywhere in this
 * framework when you need a driver object
 */
public class Driver {

    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){

        if(driver == null){

            String browserType = ConfigReader.getProperty("browser").toLowerCase();
            switch (browserType){
                case "chrome" -> driver = new ChromeDriver();
                case "firefox" -> driver = new FirefoxDriver();
                case "edge" -> driver = new EdgeDriver();
                case "safari" -> driver = new SafariDriver();
                case "chrome-headless" -> driver = new ChromeDriver(new ChromeOptions().addArguments("--headless").addArguments("window-size=1920x1080"));
                case "firefox-headless" -> driver = new FirefoxDriver(new FirefoxOptions().addArguments("--headless").addArguments("window-size=1920x1080"));
                case "edge-headless" -> driver = new EdgeDriver(new EdgeOptions().addArguments("--headless").addArguments("window-size=1920x1080"));
                default -> throw new IllegalArgumentException("Invalid driver.");
            }


        }


        return driver;
    }

    public static void quitDriver(){

        if(driver != null){
            driver.quit();
            driver = null;
        }

    }
}
