package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTests extends TestBase {



    @Test
    public void testInvalidCredentials(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "invalid", Keys.ENTER);
        Assert.assertNotEquals(driver.getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoUsername(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB, "invalid", Keys.ENTER);
        Assert.assertNotEquals(driver.getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoPassword(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("cscs", Keys.TAB, "", Keys.ENTER);
        Assert.assertNotEquals(driver.getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoCred(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB, "", Keys.ENTER);
        Assert.assertNotEquals(driver.getTitle(), "Web Orders");
    }
}
