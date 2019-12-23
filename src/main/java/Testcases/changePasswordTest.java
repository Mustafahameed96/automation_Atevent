package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Test;

/**
 * Created by Venturedive on 28/05/2018.
 */
public class changePasswordTest extends baseTest {
    @Test(description = "VWSHADOW-4684", priority = 6)
    //http://jira.vistajet.local/browse/VWSHADOW-4684

    public void ChangeUserPassword() throws InterruptedException {
        Thread.sleep(4000);

        MainCall.changePassword.ClickMyAccountButton();
        MainCall.changePassword.ClickChangePasswordButton();
        MainCall.changePassword.ChangeEnterOldPassword("Abc12345");
        MainCall.changePassword.ClickNewPassword("Vista1234");
        MainCall.changePassword.ClickRepeatPassword("Vista1234");
        MainCall.changePassword.ClickConfirmButton();
        MainCall.membership.ClickOKButton();

    }
}
