package Testcases;

import General.MainCall;
import General.WebDriverWaits;
import General.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by VD on 5/27/2018.
 */
public class membershipTest extends baseTest
{

    registrationTest rr = new registrationTest();
    String address  = "VD";
    String country  = "Pakistan";
    String cityname = "Karachi";
    String cc_num   = "4111111111111111";
    String cvv      = "123";
    String exp_date = "11/33";

    @Test(description = "Jira ID", priority = 0)

    public void joinMembershipflow() throws InterruptedException
    {
        MainCall.membership.login(MainCall.emailToLogin, rr.pwd);
        MainCall.LOGIN_PAGE.clickLogin();

        MainCall.membership.clickJoinMembership();
        Thread.sleep(3000);

        MainCall.membership.clickContinue();
        Thread.sleep(1000);

        MainCall.membership.enterBillingdetails(address,cityname);
        Thread.sleep(1000);

        MainCall.membership.selectPaymentmethod();
        MainCall.membership.enterCarddetails(cc_num,cvv,exp_date);
        MainCall.membership.clickAddcardButton();
        Thread.sleep(1000);

        MainCall.registerPage.acceptAlertOk();

        MainCall.membership.checkTerms();
        MainCall.membership.enterCVV(cvv);
        MainCall.membership.clickContinueMembership();
        Thread.sleep(10000);

        WebDriverWaits.waitForPageReadyByJquery();
        Assert.assertTrue(MainCall.membership.checkThankYouText().equals("a"),"assertion failed");
        Thread.sleep(5000);

        MainCall.membership.ClickHomeButton();


    }
} 