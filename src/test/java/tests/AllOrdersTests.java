package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AllOrdersTests  extends TestBase{




    @Test
    public void testButtons(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Assert.assertTrue(driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("ctl00_MainContent_btnDelete")).isDisplayed());
    }

    @Test
    public void testCheckAll(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

       driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement checkbox : elements) {
            Assert.assertTrue(checkbox.isSelected());
        }

    }

}
