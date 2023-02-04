package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class ProfilPage {
    WebDriver driver;
    WebDriverWait wait;

    By usernameElement = By.id("txt-username");
    By passwordElement = By.id("txt-password");
    By loginButtonElement = By.id("btn-login");

    By menuToggleElement = By.id("menu-toggle");
    By profileMenuElement = By.cssSelector("a[href='profile.php#profile']");
    By logoutButtonElement = By.cssSelector("a[class='btn btn-default']");

    public ProfilPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @BeforeMethod
    public void successfulLogin() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebElement userNameInput = driver.findElement(usernameElement);
        userNameInput.sendKeys("John Doe");
        WebElement passwordInput = driver.findElement(passwordElement);
        passwordInput.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(loginButtonElement);
        loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");

    }

    public void profilePageLoads() {
        successfulLogin();
        WebElement menuToggle = driver.findElement(menuToggleElement);
        menuToggle.click();
        WebElement profileMenu = driver.findElement(profileMenuElement);
        profileMenu.click();
        WebElement logoutButton = driver.findElement(logoutButtonElement);
        logoutButton.isDisplayed();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#profile");
    }
}
