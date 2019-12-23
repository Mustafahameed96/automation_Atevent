package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Test;

public class HowToFlyTests extends  baseTest {

    @Test(description = "VWSHADOW-6980", priority = 0)
    //http://jira.vistajet.local/browse/VWSHADOW-6980

    public void HowToFLyVerifications() throws InterruptedException {

        Thread.sleep(10000);
        String actualMenu = "Home\n" + "About\n" + "Fleet\n" + "How to fly\n" + "News\n" + "Contact us\n" + "Login";

        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("How to fly");
        MainCall.htfv.Comparasion(actualMenu);
    }
}
