package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static Objects.editPastFlightPage.byClickOnHome;

/**
 * Created by VD on 6/2/2018.
 */
public class passportExpiry extends baseTest {

    @Test(description = "Jira ID", priority = 4)
    public void expirePassport () throws InterruptedException
    {
        Thread.sleep(6000);
        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("Home");

        MainCall.passportExpiry.clickOnMyAccButton();
        MainCall.passportExpiry.clickOnManagePassport();
        MainCall.passportExpiry.clickOnNewPassport();

        //Passport Details
        String PassportNumber       = MainCall.GENERIC_FUNCTIONS.generateAlphaNumeric("ABC", 5);
        String PassportName         = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
        String Nationality          = "Pakistan";
        String IssuingCountry       = "Pakistan";

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        MainCall.passportExpiry.fillPassportForm(PassportNumber,PassportName,Nationality, IssuingCountry, dateFormat.format(yesterday()));

    }

    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
}
