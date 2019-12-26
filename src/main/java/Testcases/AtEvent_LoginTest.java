package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AtEvent_LoginTest  extends baseTest {

    @Parameters({"username", "password"})
    @Test(description = "VWSHADOW-6591")




    public static void Login(String username, String password) throws InterruptedException
    {
        MainCall.login_page1.enterUserDetails(username, password);
        MainCall.login_page1.clickLogin();

    }
}
