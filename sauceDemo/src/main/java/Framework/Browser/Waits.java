package Framework.Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private static final Duration TEMPO = Duration.ofSeconds(30);

    private WebDriver driver;

    public Waits (WebDriver driver){

        this.driver = driver;
    }

    //Metodo usado nas pages: espera o elemento aparecer na tela antes de devolver
    public WebElement visibilityOfElement(By by){

        return new WebDriverWait(driver, TEMPO).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Metodo usado nas pages: espera o elemento poder ser clicado (ex.: link do menu lateral, que abre com animacao)
    public WebElement clickableElement(By by){

        return new WebDriverWait(driver, TEMPO).until(ExpectedConditions.elementToBeClickable(by));
    }

    //Metodo usado nas validacoes: espera o texto do elemento mudar para o esperado (troca de pagina)
    //Devolve false em vez de lancar erro, para o assert mostrar o texto esperado e o encontrado
    public boolean textToBe(By by, String texto){

        try {
            return new WebDriverWait(driver, TEMPO).until(ExpectedConditions.textToBe(by, texto));
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
}
