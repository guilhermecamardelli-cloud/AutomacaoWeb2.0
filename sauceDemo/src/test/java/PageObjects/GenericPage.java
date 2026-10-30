package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericPage {

    // o site trocou <div id="header_container"> por <header>, por isso o XPath parte da div secundaria
    public static final By TITLE = By.xpath("//div[@class='header_secondary_container']/span[@class='title']");

    private WebDriver driver;
    private Waits waits;

    public GenericPage(WebDriver driver){

        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getTextTitle(){

        return waits.visibilityOfElement(TITLE);
    }

    public WebElement getTextProduto(){

        return waits.visibilityOfElement(By.className("inventory_item_name"));
    }
}
