package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishPage {

    private WebDriver driver;
    private Waits waits;

    public FinishPage(WebDriver driver){

        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getFinishButton(){

        return waits.visibilityOfElement(By.id("finish"));
    }

    public WebElement getFinishTextLabel(){

        return waits.visibilityOfElement(By.className("complete-header"));
    }

    public WebElement getMenuButton(){

        return waits.visibilityOfElement(By.id("react-burger-menu-btn"));
    }

    // o menu lateral abre com animacao, entao espera o link ficar clicavel
    public WebElement getMenuLogoutLink(){

        return waits.clickableElement(By.id("logout_sidebar_link"));
    }
}
