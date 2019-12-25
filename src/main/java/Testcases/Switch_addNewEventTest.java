package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Switch_addNewEventTest extends baseTest {


    @Parameters({"username", "password"})
    @Test(description = "VWSHADOW-6596")

    public static void Login5() throws InterruptedException
    {

        MainCall.provider_event.openProviderPanel();
        MainCall.provider_event.publisher_Open();
        MainCall.provider_event.Schedule_open();
        MainCall.provider_event.AddNewEvent_open();
        MainCall.provider_event.createEvent();



    }
}
