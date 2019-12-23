package Testcases;

import General.MainCall;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightEntertainmentTests {

    @Test(description = "VWSHADOW-6982", priority = 4)
    //http://jira.vistajet.local/browse/VWSHADOW-6982

   public void FlightEntertainmentArea() throws  InterruptedException
    {
        Thread.sleep(10000);
        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("My itineraries");
        MainCall.itineraryPage.clickonFlightDetails();
        MainCall.entertainments.selectEntertainmentDetails();

        Assert.assertTrue(MainCall.entertainments.MoviesPresent().contains("The Big Short" + "" + "Arrested Development" + "" + "Active Soccer 2"), "No Details Found");

    }

}
