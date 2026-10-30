package Tasks;

import Framework.Utils.FileOperations;
import PageObjects.LoginPage;
import Validacao.GenericValidacao;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class LoginTask {

    private WebDriver driver;
    private LoginPage loginPage;
    private GenericValidacao genericValidacao;

    public LoginTask (WebDriver driver){

        this.driver = driver;
        loginPage = new LoginPage(this.driver);
        genericValidacao = new GenericValidacao(this.driver);
    }

    public void efetuarLogin(){

        Properties user = FileOperations.getProperties("user");

        loginPage.getUserNameInput().sendKeys(user.getProperty("usuario"));
        loginPage.getPasswordInput().sendKeys(user.getProperty("password"));
        loginPage.getLoginButton().click();
        genericValidacao.validationTitlePages("Products");
    }
}
