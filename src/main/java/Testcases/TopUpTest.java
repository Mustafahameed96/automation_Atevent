package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Alvina Kamran on 08/05/2018.
 */
public class TopUpTest extends baseTest {

    @Test(description = "VWSHADOW-1002", priority = 1)
    //http://jira.vistajet.local/browse/VWSHADOW-1002
    public void TopUpAccount() throws InterruptedException
    {
        Thread.sleep(7000);
        MainCall.GENERIC_FUNCTIONS.clickOnSubMenuBar("Account balance" , "Top up account");
        Assert.assertEquals(MainCall.TopUpPage.checkTitleName(),"Top Up Account", "Incorrect title name");

        MainCall.TopUpPage.enterTopupAccount();
        MainCall.TopUpPage.clickCancelTopup();
        MainCall.TopUpPage.clickIMadeThisTransfer();
        Assert.assertEquals(MainCall.TopUpPage.checkTopupHistoryTitle(),"Top Up Account History", "Incorrect title name");
    }
}