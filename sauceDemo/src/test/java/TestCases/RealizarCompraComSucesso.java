package TestCases;

import Framework.TesteBase;
import Task.CarrinhoTask;
import Task.CheckoutTask;
import Task.LoginTask;
import Task.ProdutoTask;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class RealizarCompraComSucesso extends TesteBase {

    private final WebDriver driver = getDriverManager();

    LoginTask loginTask = new LoginTask(driver);
    ProdutoTask produtoTask = new ProdutoTask(driver);
    CarrinhoTask carrinhoTask = new CarrinhoTask(driver);
    CheckoutTask checkoutTask = new CheckoutTask(driver);

    @Test
    public void realizarCompra(){

        loginTask.efetuarLogin();
        produtoTask.selecionarProduto();
        carrinhoTask.validarProdutoEFazerCheckout();
        checkoutTask.preencherInformacoes();
        checkoutTask.finalizarCompra();
        checkoutTask.validarCompraEFazerLogout();
        loginTask.validarLogout();

    }

}
