package Testcases;

import General.MainCall;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoRequestFlightTests {

    @Test(description = "VWSHADOW-790", priority = 6)
    //http://jira.vistajet.local/browse/VWSHADOW-790

    public void NoFLightBooking() throws InterruptedException
    {
        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("Plan a flight");
        MainCall.GENERIC_FUNCTIONS.selectDepartureAirport("LECO\n");
        MainCall.GENERIC_FUNCTIONS.selectArrivalAirport("LIRQ\n");
        MainCall.GENERIC_FUNCTIONS.selectAircraft();
        MainCall.GENERIC_FUNCTIONS.selectRandomDate("12 oct 2018");
        MainCall.GENERIC_FUNCTIONS.selectRandomTime("1125\n");
        MainCall.GENERIC_FUNCTIONS.selectPassenger();
        MainCall.GENERIC_FUNCTIONS.selectRequestFlightButton();
        MainCall.reqfnegPage.IssueMsg();

        Assert.assertEquals(MainCall.ReturnFlightPage.checkTitleName(),"Plan a flight", "Incorrect title name");
    }
}