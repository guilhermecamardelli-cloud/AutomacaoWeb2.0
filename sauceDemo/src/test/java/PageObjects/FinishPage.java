package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FinishPage {

    private WebDriver driver;

    public FinishPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement getFinnishButton(){

        return driver.findElement(By.id("finish"));
    }

    public WebElement getFinnishTextLabel() {

        return driver.findElement(By.className("complete-header"));

    }

    public WebElement getMenuButton() {

        return driver.findElement(By.id("react-burger-menu-btn"));

    }

    public WebElement getLogoutLink() {

        // o menu lateral abre com animacao, entao espera o link ficar clicavel
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));

    }
}
