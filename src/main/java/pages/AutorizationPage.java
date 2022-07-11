package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutorizationPage {
    String pageUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    static private WebDriver driver;
    By emailInputLocator = By.id("email");
    By passInputLocator = By.id("passwd");
    By signInButtonLocator = By.id("SubmitLogin");
    By navigationSpanLocator = By.className("navigation_page");

    public AutorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateHere(){
        driver.get(pageUrl);
    }

    public AutorizationPage checkOnPage(){
        Assertions.assertTrue(driver.findElement(navigationSpanLocator).isDisplayed());
        return this;
    }

    public void waitOnPage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.pollingEvery(Duration.ofSeconds(2));

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("SubmitLogin")));
        long time = Duration.ofDays(4).toHours();
    }

    public void doAuthorize(String login, String pass){
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(login);

        WebElement passInput = driver.findElement(passInputLocator);
        passInput.sendKeys(pass);

        WebElement signInButton = driver.findElement(signInButtonLocator);
        signInButton.click();
    }





}
