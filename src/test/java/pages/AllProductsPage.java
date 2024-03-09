package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;


@Data
public class AllProductsPage {



    public AllProductsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//table[@class='ProductsTable']//th")
    private List<WebElement> elements;

    public List<String> extractHeadersText(){
        return SeleniumUtils.getElementsText(elements);
    }
}
