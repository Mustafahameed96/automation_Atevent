package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static Config.configProperties.Password;
import static Config.configProperties.UserName;

public class Switch_AddNewServiceTest extends baseTest {
    @Parameters({"username", "password"})
    @Test(description = "VWSHADOW-659901")

    public static void Login5() throws InterruptedException
    {

        MainCall.provider_service.openServicePage();
        MainCall.provider_service.fillForm();
        MainCall.provider_service.logoutPartner();


        MainCall.login_page2.enterUserDetails(UserName, Password);
        MainCall.login_page2.clickLogin();




    }
}
