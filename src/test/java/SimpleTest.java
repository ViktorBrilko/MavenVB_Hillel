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
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyReader;

public class SimpleTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        String browser = PropertyReader.BROWSER;
        switch (browser) {
            case ("chrome") -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
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
        driver.findElement(By.xpath("//div[@id='contact-link']")).click();
        WebElement navigationSpan = driver.findElement(By.xpath("//span[@class='navigation_page']"));
        Assertions.assertEquals(navigationSpan.getText(), "Contact");
        Thread.sleep(2000);
    }

    @AfterAll
    public static void tearDown(){
        driver.close();
    }

}
