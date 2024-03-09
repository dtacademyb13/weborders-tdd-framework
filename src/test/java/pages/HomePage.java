package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import utilities.Driver;

@Data
public class HomePage {

  public HomePage(){
      PageFactory.initElements(Driver.getDriver(), this);
  }

    @FindBy (linkText = "View all products")
    private WebElement allOrdersLink;


    public void clickOnLink( String textOfTheLink){
        Driver.getDriver().findElement(By.linkText(textOfTheLink)).click();
    }


}
