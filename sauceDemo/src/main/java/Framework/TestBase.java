package Framework;

import Framework.Browser.DriverManager;
import Framework.Browser.TypeBrowser;
import Framework.Utils.FileOperations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TestBase extends DriverManager {

    private static WebDriver driver;
    private static String URL = FileOperations.getProperties("url").getProperty("index");

    public static WebDriver getDriverManager (){

        // navegador padrao e o Chrome; mvn test -Dbrowser=HEADLESS roda sem abrir janela
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
