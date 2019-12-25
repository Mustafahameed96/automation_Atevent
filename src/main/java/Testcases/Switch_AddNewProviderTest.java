package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Switch_AddNewProviderTest extends baseTest {


    @Parameters({"username", "password"})
    @Test(description = "VWSHADOW-6593")

    public static void Login3() throws InterruptedException
    {

        MainCall.provider.openProviderPanel();
        MainCall.provider.publisher_panel_test();



    }
}
