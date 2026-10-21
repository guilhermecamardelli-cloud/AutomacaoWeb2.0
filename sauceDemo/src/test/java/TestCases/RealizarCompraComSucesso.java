package TestCases;

import Framework.TesteBase;
import Task.CheckoutTask;
import Task.FinishTask;
import Task.LoginTask;
import Task.ProdutoTask;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class RealizarCompraComSucesso extends TesteBase {

    private final WebDriver driver = getDriverManager();

    LoginTask loginTask = new LoginTask(driver);
    ProdutoTask produtoTask = new ProdutoTask(driver);
    CheckoutTask checkoutTask = new CheckoutTask(driver);
    FinishTask finishTask = new FinishTask(driver);

    @Test
    public void realizarCompra(){

        loginTask.efetuarLogin();
        produtoTask.selecionarProduto();
        checkoutTask.preencherCheckout();
        finishTask.finalizarCompra();

    }

}
