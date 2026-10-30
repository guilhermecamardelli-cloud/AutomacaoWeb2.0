package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    private Waits waits;

    public LoginPage(WebDriver driver){

        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getUserNameInput(){

        return waits.visibilityOfElement(By.id("user-name"));
    }

    public WebElement getPasswordInput(){

        return waits.visibilityOfElement(By.id("password"));
    }

    public WebElement getLoginButton(){

        return waits.visibilityOfElement(By.id("login-button"));
    }
}
