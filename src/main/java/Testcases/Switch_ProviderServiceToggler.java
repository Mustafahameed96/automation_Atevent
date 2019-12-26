package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static Config.configProperties.Password;
import static Config.configProperties.UserName;

public class Switch_ProviderServiceToggler extends baseTest {

    @Parameters({"username", "password"})
    @Test(description = "VWSHADOW-659901")

    public static void Login8() throws InterruptedException
    {
        MainCall.provider_service_toggler.toggleAllServices();
        MainCall.provider_service_toggler.logoutPartner();


        MainCall.login_page2.enterUserDetails(UserName, Password);
        MainCall.login_page2.clickLogin();




    }
}
