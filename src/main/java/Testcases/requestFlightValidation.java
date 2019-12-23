package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static General.WebDriverWaits.wait;

/**
 * Created by VD on 5/23/2018.
 */
public class requestFlightValidation extends baseTest {

    @Test(description = "Jira ID", priority = 1)
    public void requestFlightUnknownAirport()  throws InterruptedException
    {
        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("Plan a flight");
        org.testng.Assert.assertEquals(MainCall.ReturnFlightPage.checkTitleName(),"Plan a flight", "Incorrect title name");

        MainCall.GENERIC_FUNCTIONS.selectContract();
        MainCall.GENERIC_FUNCTIONS.selectRandomDate("29 Oct 2018");
        MainCall.unknownAirport.unknownDeptAirport("OPKD\n");
        MainCall.GENERIC_FUNCTIONS.selectArrivalAirport("OMDB\n");
        MainCall.GENERIC_FUNCTIONS.selectPassenger();
        MainCall.GENERIC_FUNCTIONS.selectAircraft();
        MainCall.GENERIC_FUNCTIONS.selectRandomTime("2000");
        MainCall.GENERIC_FUNCTIONS.selectRequestFlightButton();

        org.testng.Assert.assertTrue(MainCall.requestPage.thankyouMsg().contains("Thank you."), "Flight not requested");

    }
}
