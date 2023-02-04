package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTests extends DriverBaseTest {
    LoginPage loginPage;

    @Test(description = "TC 01: Really login with real username and real password")
    public void validUserValidPasswordLoginSuccessful() {
        loginPage = new LoginPage(driver, wait);
        loginPage.validUsernamValidPassword();

    }

    @Test(description = "TC 02: Unable to log in with incorrect username")
    public void wrongLoginMessage() {
        loginPage = new LoginPage(driver, wait);
        loginPage.wrongUserValidPassword();
    }

}
