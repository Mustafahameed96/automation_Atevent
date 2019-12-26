package General;

import Objects.*;
import Testcases.Switch_Provider_ScheduleTest;
import com.relevantcodes.extentreports.ExtentReports;

import static Config.configProperties.Environment;

public class MainCall {

    static ExtentReports extent;
    public static String emailToLogin = "";

    public static ExtentReports startReport()
    {
        extent = new ExtentReports(System.getProperty("user.dir") + "/reports/ExtentReport.html", true);
        extent.addSystemInfo("Environment", Environment);
        return extent;
    }

    public static ExtentReports getExtentReport()
    {
        if (extent != null) {
            return extent;
        } else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }






    public final static GenericFunctions GENERIC_FUNCTIONS = new GenericFunctions();

    public final static String username = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
    public final static String emailid = MainCall.GENERIC_FUNCTIONS.generateEmail(username);
    public final static String lastname = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
    public final static String phonenum = MainCall.GENERIC_FUNCTIONS.generateRandomNum(7);



    public final static AtEvent_Login login_page1 = new AtEvent_Login();
    public final static Switch_AddNewGroup group = new Switch_AddNewGroup();
    public final static Switch_AddNewProvider provider = new Switch_AddNewProvider();
    public final static Switch_CheckPublishedProviders provider1 = new Switch_CheckPublishedProviders();
    public final static Switch_CheckUnPublishedProviders provider2 = new Switch_CheckUnPublishedProviders();
    public final static Switch_Provider_Schedule provider_schedule = new Switch_Provider_Schedule();
    public final static Switch_AddNewEvent provider_event = new Switch_AddNewEvent();
    public final static Switch_ChangeToProviderProfile provider_profile = new Switch_ChangeToProviderProfile();
    public final static AtEvent_Login login_page2 = new AtEvent_Login();
    public final static Switch_AddNewService provider_service = new Switch_AddNewService();







}
