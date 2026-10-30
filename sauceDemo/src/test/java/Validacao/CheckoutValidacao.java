package Validacao;

import Framework.Utils.FileOperations;
import Framework.Utils.TakeScreenshot;
import PageObjects.CheckoutPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class CheckoutValidacao {

    private WebDriver driver;
    private CheckoutPage checkoutPage;

    public CheckoutValidacao (WebDriver driver){

        this.driver = driver;
        checkoutPage = new CheckoutPage(this.driver);
    }

    // confere se o que esta nos campos e o mesmo que foi gerado e salvo no form.properties
    public void validaCamposForm(){

        try {
            Properties form = FileOperations.getProperties("form");

            Assertions.assertEquals(form.getProperty("primeiroNome"), checkoutPage.getFirstNameInput().getDomProperty("value"));
            Assertions.assertEquals(form.getProperty("ultimoNome"), checkoutPage.getLastNameInput().getDomProperty("value"));
            Assertions.assertEquals(form.getProperty("cep"), checkoutPage.getZipCodeInput().getDomProperty("value"));
            TakeScreenshot.screenshotPage(driver, "Checkout");
        } catch (AssertionError | RuntimeException e) {
            TakeScreenshot.screenshotPage(driver, "ERRO - Checkout");
            throw e;
        }
    }
}
