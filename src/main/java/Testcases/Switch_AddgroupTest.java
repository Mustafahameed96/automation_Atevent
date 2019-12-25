package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static Objects.loginPage.by_logout;

public class Switch_AddgroupTest extends baseTest {
    @Parameters({"username", "password"})
    @Test(description = "VWSHADOW-6592")

    public static void Login2() throws InterruptedException
    {

        MainCall.group.OpenGroupTabandAddNew();
        MainCall.group.AddNewGroup_PageOpened();
        MainCall.group.AddNameandSelectDropDown();
        MainCall.group.verify_GroupAdded();


    }
}
