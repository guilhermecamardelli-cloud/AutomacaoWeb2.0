package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenericPage {

    private WebDriver driver;

    public GenericPage(WebDriver driver){

        this.driver = driver;
    }

    private static final By TITLE = By.xpath("//*[@id='header_container']/div[@class='header_secondary_container']/span[@class='title']");

    public WebElement getTextTitle(){

        return driver.findElement(TITLE);
    }

    public boolean aguardarTitulo(String titulo){

        // espera a pagina nova carregar, senao o findElement pode pegar o titulo da pagina anterior
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBe(TITLE, titulo));
    }

    public WebElement getTextProduto(){

        return driver.findElement(By.className("inventory_item_name"));
    }
}
