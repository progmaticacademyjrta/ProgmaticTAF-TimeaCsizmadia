package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LogoutPage;
import org.testng.annotations.Test;

public class LogoutTest extends DriverBaseTest {
    LogoutPage logoutPage;

    @Test(description="Exit the profile successfully")

    public void logoutFromTheProfile() throws InterruptedException {
        logoutPage = new LogoutPage(driver, wait);
        logoutPage.logoutFromTheProfile();
    }
}
