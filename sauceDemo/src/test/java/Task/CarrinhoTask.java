package Task;

import PageObjects.CarrinhoPage;
import PageObjects.GenericPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarrinhoTask {

    private WebDriver driver;
    private CarrinhoPage carrinhoPage;
    private GenericPage genericPage;

    public CarrinhoTask(WebDriver driver){

        this.driver = driver;
        carrinhoPage = new CarrinhoPage(this.driver);
        genericPage = new GenericPage(this.driver);

    }

    public void validarProdutoEFazerCheckout(){

        assertTrue(genericPage.aguardarTitulo("Your Cart"));
        assertEquals("Sauce Labs Onesie", genericPage.getTextProduto().getText());
        carrinhoPage.getCheckoutButton().click();
    }
}
