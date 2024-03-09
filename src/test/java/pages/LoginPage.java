package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginPage {

    // Object repository
     private WebElement usernameField = Driver.getDriver().findElement(By.id("ctl00_MainContent_username"));


     public WebElement getUsernameField() {
          return usernameField;
     }


     public void login(String username, String password){
         usernameField.sendKeys(username, Keys.TAB, password, Keys.ENTER);
     }

    public void login(){
        usernameField.sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);
    }
}
