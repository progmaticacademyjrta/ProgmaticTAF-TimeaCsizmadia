package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class AppointmentPage {
    WebDriver driver;
    WebDriverWait wait;

    LoginPage loginPage;

    By facilitySelectElement = By.id("combo_facility");
    By healthcareProgramElement = By.id("radio_program_medicaid");
    By visitDateInputElement = By.id("txt_visit_date");
    By commentInputElement = By.id("txt_comment");
    By bookButtonElement = By.id("btn-book-appointment");

    public AppointmentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @BeforeMethod
    public void goToAppointmentPage() {
        loginPage = new LoginPage(driver, wait);
        loginPage.validUsernamValidPassword();
    }

    public void successfulReservation() {
        goToAppointmentPage();
        Select facilitySelectItem = new Select(driver.findElement(facilitySelectElement));
        facilitySelectItem.selectByVisibleText("Hongkong CURA Healthcare Center");
        WebElement healthcareProgramInput = driver.findElement(healthcareProgramElement);
        healthcareProgramInput.click();
        WebElement visitDateInput = driver.findElement(visitDateInputElement);
        visitDateInput.sendKeys("20/03/2023");
        WebElement commentInput = driver.findElement(commentInputElement);
        commentInput.sendKeys("Köszönöm");
        WebElement bookButton = driver.findElement(bookButtonElement);
        bookButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");

    }
}


