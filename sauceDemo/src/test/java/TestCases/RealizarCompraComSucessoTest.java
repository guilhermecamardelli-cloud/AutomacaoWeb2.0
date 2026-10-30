package TestCases;

import Framework.TestBase;
import Framework.Utils.TakeScreenshot;
import Tasks.CheckoutTask;
import Tasks.FinishTask;
import Tasks.LoginTask;
import Tasks.ProdutoTask;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

@Epic("Teste E-commerce")
@Feature("Realizar Compra com Sucesso")
public class RealizarCompraComSucessoTest extends TestBase {

    private final WebDriver driver = getDriverManager();

    LoginTask loginTask = new LoginTask(driver);
    ProdutoTask produtoTask = new ProdutoTask(driver);
    CheckoutTask checkoutTask = new CheckoutTask(driver);
    FinishTask finishTask = new FinishTask(driver);

    @Test
    @Story("Usuário faz login com credenciais válidas e finaliza uma compra")
    @Description("Testa uma compra com sucesso: login, produto, carrinho, checkout, finish e logout")
    public void realizarCompra(){

        try {
            loginTask.efetuarLogin();
            produtoTask.selecionarProduto();
            checkoutTask.preencherCheckout();
            finishTask.finalizarCompra();
        } catch (AssertionError | RuntimeException e) {
            TakeScreenshot.screenshotPage(driver, "ERRO");
            throw e;
        }
    }

}
