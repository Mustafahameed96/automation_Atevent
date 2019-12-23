package Testcases;

import General.GenericFunctions;
import General.MainCall;
import General.baseTest;
import org.testng.annotations.Test;
import java.util.Random;

/**
 * Created by Venturedive on 09/05/2018.
 */
public class AccountDetails extends baseTest {

    @Test(description = "VWSHADOW-6674", priority = 4)
    //http://jira.vistajet.local/browse/VWSHADOW-6674
    public void AccountDetailsForUser() throws InterruptedException {
        Thread.sleep(3000);

        MainCall.accountDetailsPage.ClickMyAccountButton();
        Thread.sleep(3000);
        MainCall.accountDetailsPage.ClickEditProfileButton();
        Thread.sleep(1000);
        MainCall.accountDetailsPage.ClickbyFirstNameC();

        String changedFName = GenericFunctions.generateRandomString(4);
        String changedLName = GenericFunctions.generateRandomString(4);

        MainCall.accountDetailsPage.ClickbyFirstNameW(changedFName);
        MainCall.accountDetailsPage.ClickbyLastNameC();
        MainCall.accountDetailsPage.ClickbyLastNameW(changedLName);
        MainCall.accountDetailsPage.ClickbyDOB();
        MainCall.accountDetailsPage.ClickbyrdtSwitch();
        MainCall.accountDetailsPage.ClickbyrtdPrev();
        MainCall.accountDetailsPage.ClickrdtMonth();
        MainCall.accountDetailsPage.ClickrdtDay();
        Thread.sleep(3000);

        MainCall.accountDetailsPage.ClickbySaveButton();
        Thread.sleep(4000);
        MainCall.accountDetailsPage.ClickbyContinue();

    }
}
