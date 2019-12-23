package Testcases;

import General.MainCall;
import General.WebDriverWaits;
import General.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by VD on 5/19/2018.
 */
public class requestquoteTest extends baseTest
{
    @Test(description = "VWSHADOW-6604", priority = 2)
    //http://jira.vistajet.local/browse/VWSHADOW-6604
    public void RequestAQuoteForGuestUser () throws InterruptedException
    {
        WebDriverWaits.waitForPageReadyByJquery();
        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("Request quote");
        Assert.assertEquals(MainCall.ReturnFlightPage.checkTitleName(),"Request Quote", "Incorrect title name");
        MainCall.GENERIC_FUNCTIONS.selectRandomDate("22 Nov 2018");
        MainCall.GENERIC_FUNCTIONS.selectRandomTime("1410\n");
        MainCall.GENERIC_FUNCTIONS.selectDepartureAirport("LECO\n");
        MainCall.GENERIC_FUNCTIONS.selectArrivalAirport("EKYT\n");
        MainCall.GENERIC_FUNCTIONS.selectAircraft();
        MainCall.GENERIC_FUNCTIONS.selectDirectPassenger();
        MainCall.GENERIC_FUNCTIONS.selectRequestFlightButton();

        Assert.assertTrue(MainCall.REQUESTQUOTE_PAGE.checkThankyouscreen().equals("New Request"),"Assertion failed on thankyouscreen");

    }
} 