package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Alvina Kamran on 08/05/2018.
 */
public class ELOffersTest extends baseTest {

    String CCNo = "4111111111111111";
    String CVV = "123";
    String CCExpirtDate ="11/25";
    String SecurityCode ="123";

    @Test(description = "VWSHADOW-2457", priority = 2)
    //http://jira.vistajet.local/browse/VWSHADOW-2457
    public void AvailELOffers() throws InterruptedException {

        Thread.sleep(4000);

        MainCall.GENERIC_FUNCTIONS.clickOnSubMenuBar("Offers" , "Empty leg");
        Assert.assertEquals(MainCall.ELOffersPage.checkTitleName(),"Empty Legs", "Incorrect title name");

        MainCall.ELOffersPage.checkOffer();
        Thread.sleep(5000);

        Assert.assertFalse(WebDriverFactory.getDriver().findElement(MainCall.ELOffersPage.byRecord).getText().contains("No offer found"), "No offers found");

        MainCall.ELOffersPage.selectELOffer();
        MainCall.ELOffersPage.selectTime("2335\n");
        MainCall.GENERIC_FUNCTIONS.selectPassenger();
        MainCall.ELOffersPage.clickRequestQuoteBtn();
        Assert.assertEquals(MainCall.ELOffersPage.checkTitleName2(),"Your Quote", "Incorrect title name");

        MainCall.ELOffersPage.selectCreditCardMethod();
        MainCall.ELOffersPage.enterCreditCardDetails(this.CCNo, this.CVV, this.CCExpirtDate);
        MainCall.ELOffersPage.selectCheckbox();
        MainCall.ELOffersPage.clickAddCreditCardBtn(this.SecurityCode);
        MainCall.ELOffersPage.clickRequestOffer();
        MainCall.ELOffersPage.clickYesConfirmationPopup();
        MainCall.ELOffersPage.clickLogoutBtn();

    }

}