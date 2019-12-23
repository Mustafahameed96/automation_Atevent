package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import Objects.loginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static Objects.loginPage.by_logout;

public class loginTests extends baseTest {

    @Parameters({"username", "password"})
    @Test(description = "VWSHADOW-6591")
    //http://jira.vistajet.local/browse/VWSHADOW-6591

    public static void loginIntoVistaJetApplication(String username, String password) throws InterruptedException
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
        Thread.sleep(4000);
        MainCall.loginPage.clickLoginTopButton();
        MainCall.loginPage.enterUserDetails(username, password);
        MainCall.loginPage.clickLogin();

        Assert.assertTrue(WebDriverFactory.getDriver().findElement(by_logout).isDisplayed(), "Login failed!");
    }

}