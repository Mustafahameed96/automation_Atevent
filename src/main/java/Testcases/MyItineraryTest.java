package Testcases;

import General.MainCall;
import General.baseTest;
import org.omg.CORBA.MARSHAL;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyItineraryTest extends baseTest {

    String PassportNumber       = MainCall.GENERIC_FUNCTIONS.generateAlphaNumeric("ABC", 5);
    String PassportName         = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
    String Nationality          = "Pakistan";
    String IssuingCountry       = "Pakistan";


    //Passenger Details
    String FirstName            = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
    String LastName             = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
    String DOB                  = "10-Apr-1994";
    String PhoneNumber          = "0336" + MainCall.GENERIC_FUNCTIONS.generateRandomNum(7);
    String Email                = MainCall.GENERIC_FUNCTIONS.generateEmail(FirstName);
    String paxPassportNumber    = MainCall.GENERIC_FUNCTIONS.generateAlphaNumeric("ABC", 5);
    String paxPassportName      = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);

    @Test(description = "VWSHADOW-758", priority = 4)
    //http://jira.vistajet.local/browse/VWSHADOW-758
    public void test3MyItinerary() throws InterruptedException
    {
        Thread.sleep(20000);
        //Search Passenger - user name
        String SearchPax = MainCall.itineraryPage.checkUserName();

        MainCall.itineraryPage.clickMyAccountButton();
        MainCall.itineraryPage.clickonManagePassport();
        MainCall.itineraryPage.AddNewPassport();
        MainCall.itineraryPage.enterPassportDetails(PassportNumber, PassportName, Nationality, IssuingCountry);
        MainCall.itineraryPage.passportDatePicker();
        MainCall.itineraryPage.passportCheckbox();
        MainCall.itineraryPage.createPassport();

//        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("My itineraries");
//        MainCall.itineraryPage.clickonFlightDetails();

        RequestFlightTest.test2RequestFlightFlow();
        MainCall.itineraryPage.clickMyItineraryTabPage();

        MainCall.itineraryPage.clickonPassengerViewIcon();
        MainCall.itineraryPage.clickonAddPassengerButton();
        MainCall.itineraryPage.searchPassenger(SearchPax);
        MainCall.itineraryPage.searchButton();
        MainCall.itineraryPage.addsearchedPax();
        MainCall.itineraryPage.clickonAddedPaxDetails(SearchPax, PassportNumber);

        MainCall.itineraryPage.confirmPaxButton();

        MainCall.itineraryPage.PaxDetailsOnItinerary();
        MainCall.itineraryPage.scrollDown();

        MainCall.itineraryPage.clickonPassengerViewIcon();

        MainCall.itineraryPage.addNewPaxButton();
        MainCall.itineraryPage.enterPaxUserName(FirstName,LastName);
        MainCall.itineraryPage.enterPaxDetails(DOB,Email,PhoneNumber);
        MainCall.itineraryPage.enterGender();
        MainCall.itineraryPage.addPassportButton();
        MainCall.itineraryPage.enterPaxPassportDetails(paxPassportNumber, paxPassportName);
        MainCall.itineraryPage.passportPaxDatePicker();
        MainCall.itineraryPage.enterPaxNationality(Nationality);
        MainCall.itineraryPage.enterPaxIssuingCounrty(IssuingCountry);
        MainCall.itineraryPage.ConfirmPassporButton();
        MainCall.itineraryPage.addPax();

    }

}
