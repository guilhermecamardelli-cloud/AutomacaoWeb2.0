package Tasks;

import PageObjects.FinishPage;
import Validacao.FinishValidacao;
import Validacao.GenericValidacao;
import Validacao.LoginValidacao;
import org.openqa.selenium.WebDriver;

public class FinishTask {

    private WebDriver driver;
    private FinishPage finishPage;
    private GenericValidacao genericValidacao;
    private FinishValidacao finishValidacao;
    private LoginValidacao loginValidacao;

    public FinishTask (WebDriver driver){

        this.driver = driver;
        finishPage = new FinishPage(this.driver);
        genericValidacao = new GenericValidacao(this.driver);
        finishValidacao = new FinishValidacao(this.driver);
        loginValidacao = new LoginValidacao(this.driver);
    }

    public void finalizarCompra(){

        genericValidacao.validationTitlePages("Checkout: Complete!");
        finishValidacao.validationSucessoCompra();
        finishPage.getMenuButton().click();
        finishPage.getMenuLogoutLink().click();
        loginValidacao.loginValidation();
    }
}
