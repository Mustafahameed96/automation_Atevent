package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import Objects.loginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static Objects.loginPage.by_logout;

public class AtEvent_LoginTest  extends baseTest {

    @Parameters({"username", "password"})
    @Test(description = "VWSHADOW-6591")


    public static void loginIntoAtEvent(String username, String password) throws InterruptedException
    {
        //logout if some user is already logged in before executing Login scenario
        try {
            if (WebDriverFactory.getDriver().findElement(by_logout).isDisplayed()) {
                {
                    loginPage.clickLogoutButton();
                    Login(username, password);
                }
            }
        } catch (Exception e) {
            Login(username, password);
        }
    }

    public static void Login(String username, String password) throws InterruptedException
    {
        MainCall.login_page1.enterUserDetails(username, password);
        MainCall.login_page1.clickLogin();

    }
}
