package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static Config.configProperties.Password;
import static Config.configProperties.UserName;

public class Switch_ChangeToProviderProfileTest extends baseTest {
    @Parameters({"username", "password"})
    @Test(description = "VWSHADOW-65990")

    public static void Login4() throws InterruptedException
    {

        MainCall.provider_profile.openProviderPanel();
        MainCall.provider_profile.publisher_Open();
        MainCall.provider_profile.changeToProviderProfile();
        MainCall.provider_profile.verifyThatAdminPanelIsAccessed();






    }



}
