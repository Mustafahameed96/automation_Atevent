package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Alvina Kamran on 08/05/2018.
 */
public class SimulateFlightTest extends baseTest {

     String mystr = "YES";

    @Test(description = "VWSHADOW-41", priority = 1)
//    http://jira.vistajet.local/projects/VWSHADOW/issues/VWSHADOW-41
    public void SimulateFlightFlow() throws InterruptedException
    {
        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("Request quote");
        MainCall.GENERIC_FUNCTIONS.selectRandomDate("10 Oct 2018");
        MainCall.GENERIC_FUNCTIONS.selectRandomTime("0110\n");
        MainCall.GENERIC_FUNCTIONS.selectDepartureAirport("OMAA\n");
        MainCall.GENERIC_FUNCTIONS.selectArrivalAirport("LTAF\n");
        MainCall.GENERIC_FUNCTIONS.selectDirectPassenger();
//        MainCall.SimulateFlightPage.selectPassenger();
        MainCall.GENERIC_FUNCTIONS.selectAircraft();
        MainCall.GENERIC_FUNCTIONS.selectRequestFlightButton();

        Assert.assertTrue(MainCall.SimulateFlightPage.checkThankyouText().contains("Thank you"), "Thankyou message not displayed");

    }
}