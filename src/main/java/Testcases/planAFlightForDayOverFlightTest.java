package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by VD-Shireen on 5/17/2018.
 */
public class planAFlightForDayOverFlightTest extends baseTest {

    //http://jira.vistajet.local/browse/VWSHADOW-305
    @Test(description = "VWSHADOW-305", priority = 2)
    public void planAFlightForDayOverFlight() throws InterruptedException {

        Thread.sleep(3000);

        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("Plan a flight");
        org.testng.Assert.assertEquals(MainCall.ReturnFlightPage.checkTitleName(),"Plan a flight", "Incorrect title name");

        MainCall.GENERIC_FUNCTIONS.selectRandomDate("29 Oct 2018");
        MainCall.GENERIC_FUNCTIONS.selectRandomTime("2335\n");
        MainCall.GENERIC_FUNCTIONS.selectContract();
        MainCall.GENERIC_FUNCTIONS.selectAircraft();
        //dubai - fixed
        MainCall.GENERIC_FUNCTIONS.selectDepartureAirport("OMDB\n");
        //new zealand - fixed
        MainCall.GENERIC_FUNCTIONS.selectArrivalAirport("NZAA\n");
        MainCall.GENERIC_FUNCTIONS.selectPassenger();
        MainCall.GENERIC_FUNCTIONS.selectRequestFlightButton();

        org.testng.Assert.assertTrue(MainCall.requestPage.thankyouMsg().contains("Thank you."), "Flight not requested");

        Thread.sleep(8000);
        MainCall.itineraryPage.clickMyItineraryTabPage();
        org.testng.Assert.assertTrue(MainCall.requestPage.checkFlightInItinerary().contains("Dubai Intl OMDB - Auckland Intl NZAA"), "Flight not created");

    }
}
