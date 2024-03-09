package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginTests extends TestBase {



    @Test (groups = "smoke")
    public void testValidCredentials() throws IOException {


        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, "invalid", Keys.ENTER);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders");

    }

    @Test (groups = "smoke")
    public void testInvalidCredentials() throws IOException {

        Properties properties = new Properties();
        properties.load(new BufferedReader(new FileReader("config.properties")));
        String url = properties.getProperty("url");
        System.out.println(url);
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
        System.out.println(properties.getProperty("browser"));
        System.out.println(properties.getProperty("timeout"));

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, "invalid", Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoUsername(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB, "invalid", Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoPassword(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("cscs", Keys.TAB, "", Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoCred(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB, "", Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }
}
