package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Switch_CheckPublishedProvidersTest extends baseTest {


    @Parameters({"username", "password"})
    @Test(description = "VWSHADOW-6594")

    public static void Login3() throws InterruptedException
    {

        MainCall.provider1.openProviderPanel();
        MainCall.provider1.publisher_panel_test();



    }
}
