package Testcases;

import General.MainCall;
import General.WebDriverWaits;
import General.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by VD on 5/9/2018.
 */
public class MyAccount_FSP_VJDirectTest extends baseTest
{

    @Test(description = "Jira ID", priority = 3)
    public void Vj_Fsp_MyAccountUpdate() throws InterruptedException
    {
        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.clickMyAccountButton();
        WebDriverWaits.waitForPageReadyByJquery();
        Assert.assertTrue(MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.checkMyAccountScreen());
        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.clickEditProfile();
        WebDriverWaits.waitForPageReadyByJquery();
        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.dateOfBirth();
        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.Enter_details(MainCall.username, MainCall.lastname, MainCall.phonenum, MainCall.emailid);
        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.Click_Savebutton();
        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.Continue();
        WebDriverWaits.sleep(2000);
        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.acceptAlertOk();
        WebDriverWaits.sleep(2000);
        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.acceptAlertOk();
        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.checkLoginScreen();

    }

//    @Test(description = "Jira ID", priority = 2)
//
//    public void PaymentmethodFlow() throws InterruptedException
//    {
//        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.clickMyAccountButton();
//        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.clickPaymentmethod();
//        Thread.sleep(1500);
//        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.clickAddCredicardButton();
//        MainCall.membership.enterCarddetails("4111 1111 1111 1111","122","11/22");
//        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.clickCreate();
//        MainCall.registerPage.acceptAlertOk();
//        Thread.sleep(3500);
//        MainCall.MY_ACCOUNT_FSP_VJ_DIRECT.clickAcceptPopup();
//        Thread.sleep(1000);
//    }
} 