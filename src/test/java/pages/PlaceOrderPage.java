package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


@Data
public class PlaceOrderPage {

    public PlaceOrderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement fullName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement street;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement city;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement state;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    private WebElement zip;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    private WebElement radioButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement creditCard;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement expiry;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement placeOrderButton;

    @FindBy(tagName = "strong")
    private WebElement successMessage;


   public void placeOrder(String quantity,String fullName,
                          String street,
                          String city,
                          String state,
                          String zip,
                          String card,
                          String expiryDate){
       getQuantity().clear();
       getQuantity().sendKeys(quantity);
       getFullName().sendKeys(fullName);
       getStreet().sendKeys(street);
       getCity().sendKeys(city);
       getStreet().sendKeys(state);
       getZip().sendKeys(zip);
       getRadioButton().click();
      getCreditCard().sendKeys(card);
       getExpiry().sendKeys();
       getPlaceOrderButton().click();
   }


}
