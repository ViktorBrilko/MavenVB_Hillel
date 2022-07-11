import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AutorizationPage;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

public class SimpleTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        String browser = PropertyReader.BROWSER;
        switch (browser) {
            case ("chrome") -> {
                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("version");

                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case ("firefox") -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            default -> throw new InvalidArgumentException("cant initialize driver, available options: chrome, firefox");
        }
    }

    @Test
    public void contactUsTest() throws InterruptedException {
        driver.get(PropertyReader.BASEURL);
        By signIn = By.xpath("//div[@id='contact-link']");
        driver.findElement(signIn).click();
        By navigationSpan = By.xpath("//span[@class='navigation_page']");
        Assertions.assertTrue(driver.findElement(navigationSpan).isDisplayed());

        AutorizationPage autorizationPage = new AutorizationPage(driver);
        autorizationPage.navigateHere();
        autorizationPage.checkOnPage();
        autorizationPage.doAuthorize("skillupdemo@gmail.com", "12345");
        Thread.sleep(2000);
    }

    @AfterAll
    public static void tearDown(){
        driver.close();
    }

}
