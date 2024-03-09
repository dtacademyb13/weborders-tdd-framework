package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class AllProductsPage {


    List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//table[@class='ProductsTable']//th"));


    public List<WebElement> getHeaders() {
        return elements;
    }

    public List<String> extractHeadersText(){
        return SeleniumUtils.getElementsText(elements);
    }
}
