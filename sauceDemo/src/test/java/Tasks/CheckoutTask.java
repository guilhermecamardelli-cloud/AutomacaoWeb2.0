package Tasks;

import Framework.Utils.FakersGeneration;
import Framework.Utils.FileOperations;
import PageObjects.CheckoutPage;
import PageObjects.FinishPage;
import Validacao.CheckoutValidacao;
import Validacao.GenericValidacao;
import org.openqa.selenium.WebDriver;

public class CheckoutTask {

    private WebDriver driver;
    private CheckoutPage checkoutPage;
    private GenericValidacao genericValidacao;
    private CheckoutValidacao checkoutValidacao;
    private FakersGeneration fakersGeneration;
    private FinishPage finishPage;

    public CheckoutTask (WebDriver driver){

        this.driver = driver;
        checkoutPage = new CheckoutPage(this.driver);
        genericValidacao = new GenericValidacao(this.driver);
        checkoutValidacao = new CheckoutValidacao(this.driver);
        fakersGeneration = new FakersGeneration();
        finishPage = new FinishPage(this.driver);
    }

    public void preencherCheckout(){

        String name = fakersGeneration.getFirstName();
        String lastName = fakersGeneration.getLastName();
        String zipCode = fakersGeneration.getZipCode();

        // salva os dados gerados para a validacao conferir depois
        FileOperations.setProperties("form", "primeiroNome", name);
        FileOperations.setProperties("form", "ultimoNome", lastName);
        FileOperations.setProperties("form", "cep", zipCode);

        genericValidacao.validationTitlePages("Checkout: Your Information");
        checkoutPage.getFirstNameInput().sendKeys(name);
        checkoutPage.getLastNameInput().sendKeys(lastName);
        checkoutPage.getZipCodeInput().sendKeys(zipCode);
        checkoutValidacao.validaCamposForm();
        checkoutPage.getContinueButton().click();
        genericValidacao.validationTitlePages("Checkout: Overview");
        genericValidacao.validationProduto();
        finishPage.getFinishButton().click();
    }
}
