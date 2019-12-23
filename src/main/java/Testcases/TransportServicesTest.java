package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Alvina Kamran on 08/05/2018.
 */
public class TransportServicesTest extends baseTest {

    String DialogText = MainCall.GENERIC_FUNCTIONS.generateRandomString(6);

    @Test(description = "VWSHADOW-1165", priority =1)
    //http://jira.vistajet.local/browse/VWSHADOW-1165

    public void GTServices() throws InterruptedException
    {
        Thread.sleep(10000);
        //view this itinerary
        MainCall.TransportServicesPage.clickMyItineraryTabPage();
        MainCall.TransportServicesPage.clickGTviewBtn();
        MainCall.TransportServicesPage.selectTransportOptions();
        MainCall.TransportServicesPage.enterDialogText(this.DialogText);
        MainCall.TransportServicesPage.clickRequestGroundTransportBtn();
        MainCall.TransportServicesPage.clickOtherServiceViewBtn();
        MainCall.TransportServicesPage.selectOtherServiceOptions();
        MainCall.TransportServicesPage.enterDialogText(this.DialogText);
        MainCall.TransportServicesPage.clickRequestOtherServiceBtn();
    }

}