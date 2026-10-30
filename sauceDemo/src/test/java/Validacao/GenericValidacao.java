package Validacao;

import Framework.Browser.Waits;
import Framework.Utils.TakeScreenshot;
import PageObjects.GenericPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericValidacao {

    private WebDriver driver;
    private GenericPage genericPage;
    private Waits waits;

    public GenericValidacao(WebDriver driver){

        this.driver = driver;
        genericPage = new GenericPage(this.driver);
        waits = new Waits(this.driver);
    }

    // AssertionError nao e Exception, por isso o catch pega os dois: assim o print de erro sempre sai no relatorio
    public void validationTitlePages(String texto){

        try {
            // espera a pagina nova carregar, senao o titulo lido pode ser o da pagina anterior
            waits.textToBe(GenericPage.TITLE, texto);
            Assertions.assertEquals(texto, genericPage.getTextTitle().getText());
            TakeScreenshot.screenshotPage(driver, texto);
        } catch (AssertionError | RuntimeException e) {
            TakeScreenshot.screenshotPage(driver, "ERRO - " + texto);
            throw e;
        }
    }

    public void validationProduto(){

        try {
            Assertions.assertEquals("Sauce Labs Onesie", genericPage.getTextProduto().getText());
            TakeScreenshot.screenshotPage(driver, "Selecionar Produto");
        } catch (AssertionError | RuntimeException e) {
            TakeScreenshot.screenshotPage(driver, "ERRO - Selecionar Produto");
            throw e;
        }
    }
}
