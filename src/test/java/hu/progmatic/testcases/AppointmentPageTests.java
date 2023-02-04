package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import org.testng.annotations.Test;

public class AppointmentPageTests extends DriverBaseTest {
    AppointmentPage appointmentPage;

    @Test(description="We can successfully book an appointment")

    public void AppointmentSuccessfulFillingOut() {
        appointmentPage = new AppointmentPage(driver, wait);
        appointmentPage.successfulReservation();
    }
}

