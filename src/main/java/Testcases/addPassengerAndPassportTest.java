package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by VD-Shireen on 5/18/2018.
 */
public class addPassengerAndPassportTest extends baseTest {
    //http://jira.vistajet.local/browse/VWSHADOW-6735

    @Test(description = "VWSHADOW-6735", priority = 3)
    public void addPassengerAndPassportDetails() throws InterruptedException {

        //Passenger Details
        String FirstName            = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
        String LastName             = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
        String DOB                  = "10-Apr-1994";
        String PhoneNumber          = "0333" + MainCall.GENERIC_FUNCTIONS.generateRandomNum(7);
        String Email                = MainCall.GENERIC_FUNCTIONS.generateEmail(FirstName);
        //Passport Details
        String PassportNumber       = MainCall.GENERIC_FUNCTIONS.generateAlphaNumeric("ABC", 5);
        String PassportName         = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
        String passportExpDate      = "30/11/2021\n";
        String Nationality          = "Pakistan";
        String IssuingCountry       = "Pakistan";

        Thread.sleep(15000);

        scrollDown();
        MainCall.addPaxPass.openPassengerView();
        MainCall.addPaxPass.addPax();
        MainCall.addPaxPass.paxDetails(FirstName, LastName, DOB, Email, PhoneNumber);
        MainCall.addPaxPass.addPassport();
        MainCall.addPaxPass.passportDetails(PassportNumber, passportExpDate, PassportName, Nationality, IssuingCountry);
        MainCall.addPaxPass.submit();

        Thread.sleep(10000);

        MainCall.itineraryPage.PaxDetailsOnItinerary();

        org.testng.Assert.assertTrue(MainCall.itineraryPage.checkPaxAdded().contains(Email), "Passenger not added successfully");
    }

    public void scrollDown() throws InterruptedException
    {
        WebElement element = WebDriverFactory.getDriver().findElement(By.className("icon-opnotes"));
        ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
    }

}
