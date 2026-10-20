package Framework;

import Framework.Browser.DriverManager;
import Framework.Browser.TypeBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TesteBase extends DriverManager {

    private static WebDriver driver;
    private static String URL = "https://www.saucedemo.com/";

    public static WebDriver getDriverManager (){

        driver = getDriver(TypeBrowser.valueOf(System.getProperty("browser", "CHROME")));
        return driver;

    }

    @BeforeEach
    public void setUp(){

        getDriverManager().get(URL);

    }

    @AfterEach
    public void finish(){

        fecharDriver();
    }

}
