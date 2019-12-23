package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

public class popularTest extends baseTest {

    @Parameters({"username", "password"})
    @Test(description = "Jira ID", priority = 1)
    public void PopularIntoVistaJeApplication(String username, String password) throws InterruptedException{

        Thread.sleep(4000);

        MainCall.GENERIC_FUNCTIONS.clickOnSubMenuBar("Popular destination" , "Global");

        String heading = MainCall.POPULAR_DESTINATION_FLOW_PAGE.getheading();
        Assert.assertEquals(heading, "Should you need an excuse to try more of the pleasures of a VistaJet flight, we’d like to help.");

        MainCall.POPULAR_DESTINATION_FLOW_PAGE.getheading1();

        MainCall.POPULAR_DESTINATION_FLOW_PAGE.selectCities();
        MainCall.POPULAR_DESTINATION_FLOW_PAGE.selectDestinationAiport();
        MainCall.POPULAR_DESTINATION_FLOW_PAGE.clickRequestbutton();

        MainCall.GENERIC_FUNCTIONS.selectRandomDate("30 Oct 2018");
        MainCall.GENERIC_FUNCTIONS.selectRandomTime("0135\n");
        MainCall.GENERIC_FUNCTIONS.selectDepartureAirport("LIRQ\n");
        MainCall.GENERIC_FUNCTIONS.selectPassenger();
        MainCall.GENERIC_FUNCTIONS.selectContract();
        MainCall.GENERIC_FUNCTIONS.selectAircraft();
        MainCall.GENERIC_FUNCTIONS.selectRequestFlightButton();

        Assert.assertTrue(MainCall.requestPage.thankyouMsg().contains("Thank you."), "Flight not requested");

        Thread.sleep(8000);
        PopularDestinationTest.popularDestinationFlow(username,  password);
        Thread.sleep(8000);

        MainCall.GENERIC_FUNCTIONS.clickOnSubMenuBar("Popular destination" , "In your region");

        heading = MainCall.POPULAR_DESTINATION_FLOW_PAGE.getheading();
        Assert.assertTrue(heading.contains("Amazing does not mean far. Discover destinations close to you"), "No regional destinations found");


        MainCall.POPULAR_DESTINATION_FLOW_PAGE.selectCities();
        MainCall.POPULAR_DESTINATION_FLOW_PAGE.selectDestinationAiport();
        MainCall.POPULAR_DESTINATION_FLOW_PAGE.clickRequestbutton();

        MainCall.GENERIC_FUNCTIONS.selectRandomDate("31 Oct 2018");
        MainCall.GENERIC_FUNCTIONS.selectRandomTime("0235\n");
        MainCall.GENERIC_FUNCTIONS.selectDepartureAirport("OPKC\n");
        MainCall.GENERIC_FUNCTIONS.selectAircraft();
        MainCall.GENERIC_FUNCTIONS.selectDirectPassenger();
        MainCall.GENERIC_FUNCTIONS.selectRequestFlightButton();
        Thread.sleep(5000);
        Assert.assertTrue(MainCall.requestPage.thankyouMsg().contains("Thank you."), "Flight not requested");

    }
}
