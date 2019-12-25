package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Switch_Provider_ScheduleTest extends baseTest {

    @Parameters({"username", "password"})
    @Test(description = "VWSHADOW-6594")

    public static void Login4() throws InterruptedException
    {

        MainCall.provider_schedule.openProviderPanel();
        MainCall.provider_schedule.publisher_Open();
        MainCall.provider_schedule.Schedule_open();
        MainCall.provider_schedule.MonthTestCases();
        MainCall.provider_schedule.WeekTestCases();
        MainCall.provider_schedule.DayTestCases();




    }

}
