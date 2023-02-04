package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.ProfilPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilPageTests extends DriverBaseTest {
    ProfilPage profilPage;


    @Test(description = "TC 01: After logging in, the profile can be opened")

    public void profilePageSuccessfullyLoad() {
        profilPage = new ProfilPage(driver, wait);
        profilPage.profilePageLoads();

    }
}
