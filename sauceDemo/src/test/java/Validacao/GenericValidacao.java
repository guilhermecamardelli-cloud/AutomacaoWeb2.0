package Validacao;

import PageObjects.GenericPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericValidacao {

    WebDriver driver;
    private GenericPage genericPage;

    public GenericValidacao(WebDriver driver){
        this.driver = driver;
        genericPage = new GenericPage(this.driver);

    }

    public void validationTitlePages(String texto){

        // espera a pagina nova carregar, senao o titulo lido pode ser o da pagina anterior
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.textToBe(By.className("title"), texto));
        } catch (TimeoutException e) {
            // segue para o assert, que mostra o texto esperado e o encontrado
        }
        String label = genericPage.getTextTitle().getText();
        Assertions.assertEquals(texto,label);
    }

    public void validationProduto(){

        String labelProduto = genericPage.getTextProduto().getText();
        Assertions.assertEquals("Sauce Labs Onesie", labelProduto);
    }
}
