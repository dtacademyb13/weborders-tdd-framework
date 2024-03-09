package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;
import utilities.FrameworkConstants;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class AllProductsTests  extends TestBase{




    @Test (groups = "smoke")
    public void verifyColumns(){
        Driver.getDriver().get(FrameworkConstants.HOMEPAGE_URL);
        new LoginPage().login();
        new HomePage().clickOnLink("View all products");
        List<String> actualHeadersText = new AllProductsPage().extractHeadersText();

        Assert.assertEquals(actualHeadersText, List.of("Product name", "Price", "Discount"));
    }


    @Test
    public void verifyProductNames(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Driver.getDriver().findElement(By.linkText("View all products")).click();

        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//table[@class='ProductsTable']//tr//td[1]"));
        List<String> elementsText  = new ArrayList<>();
        elements.forEach( webElement -> elementsText.add(webElement.getText()) );

        Assert.assertEquals(elementsText, List.of("MyMoney", "FamilyAlbum", "ScreenSaver"));
    }
}
