package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddPaxTests extends baseTest {

    @Test(description = "VWSHADOW-6982", priority = 3)
    //http://jira.vistajet.local/browse/VWSHADOW-6982

    public void AddPassengerFromDetails() throws InterruptedException
    {
        Thread.sleep(5000);

        String FirstName    = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
        String LastName     = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
        String DOB          = "20-Apr-1990";
        String PhoneNumber  = "0336" + MainCall.GENERIC_FUNCTIONS.generateRandomNum(7);
        String Email        = MainCall.GENERIC_FUNCTIONS.generateEmail(FirstName);

        MainCall.itineraryPage.clickMyItineraryTabPage();
        MainCall.itineraryPage.clickonPassengerViewIcon();
        MainCall.itineraryPage.addNewPaxButton();
        MainCall.itineraryPage.enterPaxUserName(FirstName,LastName);
        MainCall.itineraryPage.enterPaxDetails(DOB,Email,PhoneNumber);
        MainCall.itineraryPage.enterGender();
        MainCall.itineraryPage.addPax();
        MainCall.itineraryPage.scrollDown();
        MainCall.itineraryPage.PaxDetailsOnItinerary();

        Assert.assertTrue(MainCall.itineraryPage.checkPaxAdded().contains(Email), "Passenger not added successfully");

    }
}


