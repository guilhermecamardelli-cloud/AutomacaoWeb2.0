package Validacao;

import PageObjects.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginValidacao {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginValidacao (WebDriver driver){

        this.driver = driver;
        loginPage = new LoginPage(this.driver);

    }

    public void validationLogout(){

        Assertions.assertTrue(loginPage.getLoginButtonInput().isDisplayed());
    }
}
