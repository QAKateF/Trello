package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    EventFiringWebDriver driver;
    HelperLogin helperLogin;
    public HelperLogin getHelperLogin(){
        return helperLogin;
    }

    @BeforeSuite
    public void init(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver((WebDriver) chromeOptions);
        helperLogin = new HelperLogin(driver);
        driver.manage().window().maximize();
        driver.navigate().to("https://trello.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterSuite
    public void tearDown(){
        //driver.quit();
    }
}
