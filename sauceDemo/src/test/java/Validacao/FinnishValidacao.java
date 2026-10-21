package Validacao;

import PageObjects.FinishPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class FinnishValidacao {

    private WebDriver driver;
    private FinishPage finishPage;

    public FinnishValidacao (WebDriver driver){

        this.driver = driver;
        finishPage = new FinishPage(this.driver);

    }

    public void validationSucessoCompra(){

        // sem try/catch: se o texto estiver errado o teste precisa falhar
        Assertions.assertEquals("Thank you for your order!", finishPage.getFinnishTextLabel().getText());
    }
}
