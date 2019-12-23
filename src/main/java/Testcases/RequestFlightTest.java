package Testcases;

import General.baseTest;
import General.MainCall;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RequestFlightTest extends baseTest {

    @Test(description = "VWSHADOW-6780", priority = 2)
    //http://jira.vistajet.local/browse/VWSHADOW-6780
    public static void test2RequestFlightFlow() throws InterruptedException {

        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("Plan a flight");
        Assert.assertEquals(MainCall.ReturnFlightPage.checkTitleName(),"Plan a flight", "Incorrect title name");

        MainCall.GENERIC_FUNCTIONS.selectDepartureAirport("LECO\n");
        MainCall.GENERIC_FUNCTIONS.selectArrivalAirport("EKYT\n");
        MainCall.GENERIC_FUNCTIONS.selectRandomDate("24 Oct 2018");
        MainCall.GENERIC_FUNCTIONS.selectRandomTime("0120\n");
        MainCall.GENERIC_FUNCTIONS.selectContract();
        MainCall.GENERIC_FUNCTIONS.selectAircraft();
        MainCall.GENERIC_FUNCTIONS.selectPassenger();
        MainCall.GENERIC_FUNCTIONS.selectRequestFlightButton();

        Assert.assertTrue(MainCall.requestPage.thankyouMsg().contains("Thank you."), "Flight not requested");

    }

}
