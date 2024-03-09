package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.CSVReader;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.Arrays;

public class DemoSeleniumUtils {


    public static void main(String[] args) {


        Object[][] objects = CSVReader.readData("src/test/resources/customers.csv");

        System.out.println(Arrays.deepToString(objects));

    }



}
