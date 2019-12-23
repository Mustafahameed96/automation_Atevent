package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Objects.editPastFlightPage.byClickOnHome;

/**
 * Created by VD on 5/27/2018.
 */
public class requestQuoteDirect extends baseTest {

    @Test(description = "Jira ID", priority = 2)
     public void requestQuoteMethod () throws InterruptedException
    {
        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("Home");
        MainCall.quoteDirectPage.fillFlightFormDirect();

        MainCall.GENERIC_FUNCTIONS.selectRandomTime("2300\n");
        MainCall.GENERIC_FUNCTIONS.selectAircraft();
        MainCall.GENERIC_FUNCTIONS.selectRequestFlightButton();

        Assert.assertTrue(MainCall.SimulateFlightPage.checkThankyouText().contains("Thank you"), "Thankyou message not displayed");

    }
}
