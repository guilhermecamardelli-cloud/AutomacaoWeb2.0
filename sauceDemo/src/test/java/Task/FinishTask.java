package Task;

import PageObjects.FinishPage;
import Validacao.FinnishValidacao;
import Validacao.GenericValidacao;
import Validacao.LoginValidacao;
import org.openqa.selenium.WebDriver;

public class FinishTask {

    private WebDriver driver;
    private FinishPage finishPage;
    private GenericValidacao genericValidacao;
    private FinnishValidacao finnishValidacao;
    private LoginValidacao loginValidacao;



    public FinishTask (WebDriver driver){

        this.driver = driver;
        finishPage = new FinishPage(this.driver);
        genericValidacao = new GenericValidacao(this.driver);
        finnishValidacao = new FinnishValidacao(this.driver);
        loginValidacao = new LoginValidacao(this.driver);
    }

    public void finalizarCompra(){

        finishPage.getFinnishButton().click();
        genericValidacao.validationTitlePages("Checkout: Complete!");
        finnishValidacao.validationSucessoCompra();
        finishPage.getMenuButton().click();
        finishPage.getLogoutLink().click();
        loginValidacao.validationLogout();

    }

}
