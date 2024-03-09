package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class HomePage {


    private WebElement allOrdersLink = Driver.getDriver().findElement(By.linkText("View all products"));


    public void clickOnLink(String textOfTheLink){
        Driver.getDriver().findElement(By.linkText(textOfTheLink)).click();
    }


}
