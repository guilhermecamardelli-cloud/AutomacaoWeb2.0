package Validacao;

import Framework.Utils.TakeScreenshot;
import PageObjects.FinishPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class FinishValidacao {

    private WebDriver driver;
    private FinishPage finishPage;

    public FinishValidacao (WebDriver driver){

        this.driver = driver;
        finishPage = new FinishPage(this.driver);
    }

    public void validationSucessoCompra(){

        try {
            Assertions.assertEquals("Thank you for your order!", finishPage.getFinishTextLabel().getText());
            TakeScreenshot.screenshotPage(driver, "Finish");
        } catch (AssertionError | RuntimeException e) {
            TakeScreenshot.screenshotPage(driver, "ERRO - Finish");
            throw e;
        }
    }
}
