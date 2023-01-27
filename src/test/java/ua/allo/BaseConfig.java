package ua.allo;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseConfig {
    private final static String urlMain = "https://www.allo.ua/";

    @Before
    public void setUp()  {
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities ();
        ChromeOptions options = new ChromeOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        setWebDriver(webDriver);
        open(urlMain);
    }

    @After
    public void closeDriver(){
        getWebDriver().close();
    }


}
