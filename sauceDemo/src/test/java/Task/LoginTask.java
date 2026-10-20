package Task;

import PageObjects.GenericPage;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTask {

    private WebDriver driver;
    private LoginPage loginPage;
    private GenericPage genericPage;

    public LoginTask (WebDriver driver){

        this.driver = driver;
        loginPage = new LoginPage(this.driver);
        genericPage = new GenericPage(this.driver);

    }

    public void efetuarLogin(){

        loginPage.getUserNameInput().sendKeys("standard_user");
        loginPage.getPasswordInput().sendKeys("secret_sauce");
        loginPage.getLoginButtonInput().click();
        assertTrue(genericPage.aguardarTitulo("Products"));
    }

    public void validarLogout(){

        assertTrue(loginPage.getLoginButtonInput().isDisplayed());
    }
}
