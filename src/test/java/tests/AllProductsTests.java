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
import java.util.ArrayList;
import java.util.List;

public class AllProductsTests  extends TestBase{




    @Test
    public void verifyColumns(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        driver.findElement(By.linkText("View all products")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='ProductsTable']//th"));
        List<String> elementsText  = new ArrayList<>();
        elements.forEach( webElement -> elementsText.add(webElement.getText()) );

        Assert.assertEquals(elementsText, List.of("Product name", "Price", "Discount"));
    }


    @Test
    public void verifyProductNames(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        driver.findElement(By.linkText("View all products")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='ProductsTable']//tr//td[1]"));
        List<String> elementsText  = new ArrayList<>();
        elements.forEach( webElement -> elementsText.add(webElement.getText()) );

        Assert.assertEquals(elementsText, List.of("MyMoney", "FamilyAlbum", "ScreenSaver"));
    }
}
