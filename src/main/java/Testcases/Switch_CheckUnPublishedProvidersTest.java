package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Switch_CheckUnPublishedProvidersTest extends baseTest {

    @Parameters({"username", "password"})
    @Test(description = "VWSHADOW-6595")

    public static void Login3() throws InterruptedException
    {

        MainCall.provider2.openProviderPanel();
        MainCall.provider2.publisher_panel_test();
        MainCall.provider2.closeProviderPanel();




    }
}
