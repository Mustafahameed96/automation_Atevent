package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Test;

public class AddRemovePaxTest extends baseTest {

    //Passenger Details
    String FirstName    = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
    String LastName     = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
    String DOB          = "10-Apr-1995";
    String PhoneNumber  = "0336" + MainCall.GENERIC_FUNCTIONS.generateRandomNum(7);
    String Email        = MainCall.GENERIC_FUNCTIONS.generateEmail(FirstName);

    @Test(description = "VWSHADOW-302", priority = 3)
    //http://jira.vistajet.local/browse/VWSHADOW-302
    public void test4RemovePassengers() throws InterruptedException {
        Thread.sleep(20000);

        //Search Passenger - user name
        String SearchPax = MainCall.itineraryPage.checkUserName();
        Thread.sleep(10000);
        MainCall.itineraryPage.clickMyItineraryTabPage();
        MainCall.itineraryPage.clickonPassengerViewIcon();
        MainCall.itineraryPage.clickonAddPassengerButton();
        MainCall.itineraryPage.searchPassenger(SearchPax);
        MainCall.itineraryPage.searchButton();
        MainCall.itineraryPage.addsearchedPax();
        MainCall.itineraryPage.confirmPaxButton();
        MainCall.itineraryPage.scrollDown();
        MainCall.itineraryPage.clickonPaxSection();
        MainCall.itineraryPage.addNewPaxButton();
        MainCall.itineraryPage.enterPaxUserName(FirstName,LastName);
        MainCall.itineraryPage.enterPaxDetails(DOB,Email,PhoneNumber);
        MainCall.itineraryPage.enterGender();
        MainCall.itineraryPage.addPax();
        Thread.sleep(6000);
        MainCall.itineraryPage.clickonPaxSection();
        MainCall.itineraryPage.removePax();
        MainCall.itineraryPage.confirmPaxButton();
        Thread.sleep(8000);

    }
}
