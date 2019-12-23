package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import com.gargoylesoftware.htmlunit.WebAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by VD on 6/3/2018.
 */
public class editPastFlight extends baseTest {

    @Test(description = "Jira ID", priority = 3)
    public void checkPastFlightEdit () throws InterruptedException {

        Thread.sleep(10000);
        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("My itineraries");
        MainCall.editPastflightLeg.pastIsEditable();
        MainCall.LOGIN_PAGE.logout();
    }


}
