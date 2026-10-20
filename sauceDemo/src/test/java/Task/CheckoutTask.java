package Task;

import PageObjects.CheckoutCompletePage;
import PageObjects.CheckoutInformacoesPage;
import PageObjects.GenericPage;
import PageObjects.OverviewPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTask {

    private WebDriver driver;
    private CheckoutInformacoesPage informacoesPage;
    private OverviewPage overviewPage;
    private CheckoutCompletePage completePage;
    private GenericPage genericPage;

    public CheckoutTask(WebDriver driver){

        this.driver = driver;
        informacoesPage = new CheckoutInformacoesPage(this.driver);
        overviewPage = new OverviewPage(this.driver);
        completePage = new CheckoutCompletePage(this.driver);
        genericPage = new GenericPage(this.driver);

    }

    public void preencherInformacoes(){

        assertTrue(genericPage.aguardarTitulo("Checkout: Your Information"));
        informacoesPage.getFirstNameInput().sendKeys("Guilherme");
        informacoesPage.getLastNameInput().sendKeys("Camardelli");
        informacoesPage.getZipCodeInput().sendKeys("90000000");
        informacoesPage.getContinueButton().click();
    }

    public void finalizarCompra(){

        assertTrue(genericPage.aguardarTitulo("Checkout: Overview"));
        assertEquals("Sauce Labs Onesie", genericPage.getTextProduto().getText());
        overviewPage.getFinishButton().click();
    }

    public void validarCompraEFazerLogout(){

        assertEquals("Thank you for your order!", completePage.getTextSucesso().getText());
        completePage.getMenuButton().click();
        completePage.getLogoutLink().click();
    }
}
