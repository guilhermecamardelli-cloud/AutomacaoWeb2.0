package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private WebDriver driver;
    private Waits waits;

    public CheckoutPage(WebDriver driver){

        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getFirstNameInput(){

        return waits.visibilityOfElement(By.id("first-name"));
    }

    public WebElement getLastNameInput(){

        return waits.visibilityOfElement(By.id("last-name"));
    }

    public WebElement getZipCodeInput(){

        return waits.visibilityOfElement(By.id("postal-code"));
    }

    public WebElement getContinueButton(){

        return waits.visibilityOfElement(By.id("continue"));
    }
}
