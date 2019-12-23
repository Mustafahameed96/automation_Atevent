package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Test;

/**
 * Created by VD on 5/31/2018.
 */
public class fspSanityFlowTest extends baseTest
{
    String[] fsp_menu_bar =  {"Home", "Plan a flight", "Popular destination", "Your fleet", "My itineraries", "Account balance", "About us", "Contact us"};

    @Test(description = "Jira ID", priority = 2)
    public void fspSanityFlow() throws InterruptedException
    {

        Thread.sleep(5000);
        MainCall.GENERIC_FUNCTIONS.getElementOfMenubar();
        Thread.sleep(5000);
        MainCall.GENERIC_FUNCTIONS.assertionsForMenubar(fsp_menu_bar);
        Thread.sleep(2000);
        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("Plan a flight");
        Thread.sleep(3000);
        MainCall.REQUESTQUOTE_PAGE.selectDate();
        MainCall.REQUESTQUOTE_PAGE.selectTime();
        MainCall.REQUESTQUOTE_PAGE.clickDeptairport();
        MainCall.REQUESTQUOTE_PAGE.selectAirport("EKYT");
        Thread.sleep(1000);
        MainCall.REQUESTQUOTE_PAGE.clickArrivalairport();
        MainCall.REQUESTQUOTE_PAGE.selectAirport("LECO");
        Thread.sleep(1000);

        MainCall.PLAN_FLIGHT_PAGE.clickSelectPassengers();
        Thread.sleep(2000);
        MainCall.REQUESTQUOTE_PAGE.paxCount();
        Thread.sleep(2000);
        MainCall.PLAN_FLIGHT_PAGE.clickOnPassengerWidget();
        Thread.sleep(2000);
        MainCall.PLAN_FLIGHT_PAGE.clickConfirmPassengers();
        MainCall.REQUESTQUOTE_PAGE.clickAircraftwidget();
        MainCall.REQUESTQUOTE_PAGE.selectAircraft("Available in Contract");
        Thread.sleep(1000);
        MainCall.REQUESTQUOTE_PAGE.requestQuotebtn();
        MainCall.REQUESTQUOTE_PAGE.acceptPurchase();
    }
} 