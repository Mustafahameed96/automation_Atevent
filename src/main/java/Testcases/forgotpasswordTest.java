package Testcases;

import General.*;
import Objects.loginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by VD on 5/9/2018.
 */
public class forgotpasswordTest extends baseTest
{
    registrationTest rr = new registrationTest();
    String username = GenericFunctions.generateRandomString(5);
    String email = GenericFunctions.generateEmail(username);

    @Test(description = "VWSHADOW-6610", priority = 1)
    //http://jira.vistajet.local/browse/VWSHADOW-6610

    public void ForgetPasswordPosScenario() throws InterruptedException
    {
        WebDriverWaits.waitForPageReadyByJquery();

        MainCall.forgotpasswordPage.clickLoginTopButton();
        MainCall.forgotpasswordPage.ClickForgotPasswordLink();

        WebDriverWaits.waitForPageReadyByJquery();

        MainCall.forgotpasswordPage.TypeEmail(MainCall.emailToLogin);
        MainCall.forgotpasswordPage.ClickSendLinkButton();
        Thread.sleep(2000);
        Assert.assertTrue(MainCall.forgotpasswordPage.EmailMessage().equals("Your password has been reset please check your inbox"),"The provided email");

        MainCall.forgotpasswordPage.ClickBackLogin();
        Thread.sleep(1000);

    }



    @Test(description = "Jira ID", priority = 4)

    public void ForgetPasswordNegScenario() throws InterruptedException {

        WebDriverWaits.waitForPageReadyByJquery();

        MainCall.forgotpasswordPage.clickLoginTopButton();
        MainCall.forgotpasswordPage.ClickForgotPasswordLink();

        WebDriverWaits.waitForPageReadyByJquery();

        MainCall.forgotpasswordPage.TypeEmail(email);
        MainCall.forgotpasswordPage.ClickSendLinkButton();
        WebDriverWaits.sleep(2000);
        Assert.assertTrue(MainCall.forgotpasswordPage.EmailMessage().equals("The provided email address does not exist"),"The provided email");

        MainCall.forgotpasswordPage.ClickBackLogin();
        Thread.sleep(1000);
    }
} 