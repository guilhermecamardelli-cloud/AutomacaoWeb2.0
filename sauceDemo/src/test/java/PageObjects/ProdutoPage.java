package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutoPage {

    private WebDriver driver;
    private Waits waits;

    public ProdutoPage(WebDriver driver){

        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getAddToCartButton(){

        return waits.visibilityOfElement(By.id("add-to-cart-sauce-labs-onesie"));
    }

    public WebElement getCartButton(){

        return waits.visibilityOfElement(By.className("shopping_cart_link"));
    }
}
