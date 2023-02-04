package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By usernameElement = By.id("txt-username");
    By passwordElement = By.id("txt-password");
    By loginButtonElement = By.id("btn-login");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void validUsernamValidPassword() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebElement userNameInput = driver.findElement(usernameElement);
        userNameInput.sendKeys("John Doe");
        WebElement passwordInput = driver.findElement(passwordElement);
        passwordInput.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(loginButtonElement);
        loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");

    }

    public void wrongUserValidPassword() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebElement userNameInput = driver.findElement(usernameElement);
        userNameInput.sendKeys("somebody");
        WebElement passwordInput = driver.findElement(passwordElement);
        passwordInput.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(loginButtonElement);
        loginButton.click();
        WebElement failedLoginMessage = driver.findElement(By.cssSelector("p[class='lead text-danger']"));
        failedLoginMessage.isDisplayed();


    }
}
