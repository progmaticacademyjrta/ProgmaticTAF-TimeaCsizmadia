package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.*;
import org.testng.annotations.Test;

public class EndToEndTest extends DriverBaseTest {
    AppointmentPage appointmentPage;
    HomePage homePage;
    LoginPage loginPage;
    LogoutPage logoutPage;

    @Test(description = "TC01: page load, entry, booking, exit end we can step on")

    public void loginAppointmentLogout() throws InterruptedException {
        homePage = new HomePage(driver, wait);
        appointmentPage = new AppointmentPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        logoutPage = new LogoutPage(driver, wait);

        homePage.makeAppointmentClick();
        appointmentPage.successfulReservation();
        loginPage.validUsernamValidPassword();
        logoutPage.logoutFromTheProfile();

    }
}
