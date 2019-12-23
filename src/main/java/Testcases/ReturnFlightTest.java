package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReturnFlightTest extends baseTest {

    @Test(description = "VWSHADOW-248", priority = 1)
    //http://jira.vistajet.local/browse/VWSHADOW-248
    public static void ReturnFlightFlow() throws InterruptedException
    {
        loginTests.loginIntoVistaJetApplication("dan22@gmail.com", "Abc12345");

        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("Plan a flight");
        Assert.assertEquals(MainCall.ReturnFlightPage.checkTitleName(),"Plan a flight", "Incorrect title name");

        MainCall.GENERIC_FUNCTIONS.selectContract();
        MainCall.GENERIC_FUNCTIONS.selectAircraft();
        MainCall.GENERIC_FUNCTIONS.selectRandomDate("10 dec 2018");
        MainCall.GENERIC_FUNCTIONS.selectRandomTime("0110\n");
        MainCall.GENERIC_FUNCTIONS.selectDepartureAirport("OPKC\n");
        MainCall.GENERIC_FUNCTIONS.selectArrivalAirport("WSSL\n");
        MainCall.GENERIC_FUNCTIONS.selectPassenger();
        MainCall.ReturnFlightPage.clickReturnFlightBtn();
        MainCall.ReturnFlightPage.selectReturnDepartureDate("29 dec 2018");
        MainCall.ReturnFlightPage.selectReturnDepartureTime("2335\n");
        MainCall.GENERIC_FUNCTIONS.selectRequestFlightButton();

        Assert.assertTrue(MainCall.SimulateFlightPage.checkThankyouText().contains("Thank you"), "Thankyou message not displayed");

    }
}