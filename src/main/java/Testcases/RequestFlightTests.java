package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Objects.loginPage.by_logout;
import static Objects.requestFlightPage.byRAFsubmitButton;

/**
 * Created by Shafaq on 31/05/2018.
 */
public class RequestFlightTests extends baseTest {

    @Test(description = "VWSHADOW-6595", priority = 2)
    //http://jira.vistajet.local/browse/VWSHADOW-6595

    public void PlanAFlight() throws InterruptedException
    {
        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("Plan a flight");
        Assert.assertEquals(MainCall.ReturnFlightPage.checkTitleName(),"Plan a flight", "Incorrect title name");

        MainCall.GENERIC_FUNCTIONS.selectDepartureAirport("OPLA\n");
        MainCall.GENERIC_FUNCTIONS.selectArrivalAirport("OMDB\n");
        MainCall.GENERIC_FUNCTIONS.selectAircraft();
        MainCall.GENERIC_FUNCTIONS.selectRandomDate("12 sep 2018");
        MainCall.GENERIC_FUNCTIONS.selectRandomTime("0115\n");
        MainCall.GENERIC_FUNCTIONS.selectPassenger();

        MainCall.reqflightPage.selectNoOnSubmitButton();
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byRAFsubmitButton).isDisplayed(), "Plan a flight screen not displayed!");

        MainCall.GENERIC_FUNCTIONS.selectRequestFlightButton();

        Assert.assertTrue(MainCall.SimulateFlightPage.checkThankyouText().contains("Thank you"), "Thankyou message not displayed");

    }
}