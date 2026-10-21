package Task;

import PageObjects.CheckoutPage;
import Validacao.GenericValidacao;
import org.openqa.selenium.WebDriver;

public class CheckoutTask {

    private WebDriver driver;
    private CheckoutPage checkoutPage;
    private GenericValidacao genericValidacao;

    public CheckoutTask (WebDriver driver){

        this.driver = driver;
        checkoutPage = new CheckoutPage(this.driver);
        genericValidacao = new GenericValidacao((this.driver));
    }

    public void preencherCheckout(){

        genericValidacao.validationTitlePages("Checkout: Your Information");
        checkoutPage.getFirstNameInput().sendKeys("Francielle");
        checkoutPage.getLastNameNameInput().sendKeys("Francielle");
        checkoutPage.getZipCodeInput().sendKeys("123456789");
        checkoutPage.getContinueButton().click();
        genericValidacao.validationTitlePages("Checkout: Overview");
        genericValidacao.validationProduto();
    }
}
