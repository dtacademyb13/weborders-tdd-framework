package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.CSVReader;
import utilities.Driver;

public class PlaceOrderTests extends TestBase{



    @Test (dataProvider = "customerData")
    public void placeOrderDataDrivenTest(String fullName,
                                         String street,
                                         String city,
                                         String state,
                                         String zip,
                                         String card){

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Driver.getDriver().findElement(By.linkText("Order")).click();

        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).clear();
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("5");


        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(fullName);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(street);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(card);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("12/27");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        Assert.assertTrue( Driver.getDriver().findElement(By.tagName("strong")).isDisplayed());



    }



    @DataProvider (name = "customerData")
    public Object[][] getData(){
        Object[][] data = CSVReader.readData("src/test/resources/testData/customers.csv");
        return data;
    }




}
