package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.WebDriverWaits;
import General.baseTest;
import Objects.loginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by VD on 5/26/2018.
 */
public class PopularDestinationTest extends baseTest
{

    @Parameters({"username", "password"})
    @Test(description = "Jira ID", priority = 0)
    public static void popularDestinationFlow(String username, String password) throws InterruptedException {
        try {
            if (WebDriverFactory.getDriver().findElement(By.xpath("//span[contains(text(), 'Logout')]")).isDisplayed()) {
                {
                    loginPage.clickLogoutButton();
                    popularDestination(username , password);
                }
            }
        } catch (Exception e) {
            popularDestination(username, password);
        }
    }

    public static void popularDestination(String username, String password) throws InterruptedException {

        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("Home");
        WebDriverWaits.waitForPageReadyByJquery();
        Assert.assertTrue(MainCall.POPULAR_DESTINATION_FLOW_PAGE.Dashboardverify().equals("Popular Destinations"),"Application not launched. Time-out.");
        MainCall.POPULAR_DESTINATION_FLOW_PAGE.clickFindbutton();
        MainCall.POPULAR_DESTINATION_FLOW_PAGE.clickGlobal();

        MainCall.POPULAR_DESTINATION_FLOW_PAGE.selectCities();
        MainCall.POPULAR_DESTINATION_FLOW_PAGE.selectDestinationAiport();
        MainCall.POPULAR_DESTINATION_FLOW_PAGE.clickRequestbutton();

        MainCall.GENERIC_FUNCTIONS.selectRandomDate("30 Oct 2018");
        MainCall.GENERIC_FUNCTIONS.selectRandomTime("0120\n");
        MainCall.GENERIC_FUNCTIONS.selectDepartureAirport("LECO\n");
        MainCall.GENERIC_FUNCTIONS.selectDirectPassenger();
        MainCall.GENERIC_FUNCTIONS.selectAircraft();

        MainCall.REQUESTQUOTE_PAGE.requestQuotebtn();
        MainCall.POPULAR_DESTINATION_FLOW_PAGE.acceptAlert();
        Thread.sleep(1000);

        Assert.assertTrue(MainCall.POPULAR_DESTINATION_FLOW_PAGE.checkScreen().equals("Login"),"wrong screen");

        MainCall.LOGIN_PAGE.enterUserDetails(username, password);
        MainCall.LOGIN_PAGE.clickLogin();
        Thread.sleep(1000);

        MainCall.REQUESTQUOTE_PAGE.requestQuotebtn();
        MainCall.REQUESTQUOTE_PAGE.acceptPurchase();
        Thread.sleep(1000);

        Assert.assertTrue(MainCall.REQUESTQUOTE_PAGE.checkThankyouscreen().equals("New Request"),"Assertion failed on thankyouscreen");

    }
} 