package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Venturedive on 25/05/2018.
 */
public class quotesTest extends baseTest {


    @Test(description = "VWSHADOW-2501", priority = 5)
    //http://jira.vistajet.local/browse/VWSHADOW-2501

    public void BuyQuoteForUser() throws InterruptedException {
        Thread.sleep(4000);

        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("My quotes");

        MainCall.quotesPage1.ClickDetailsButton();
        MainCall.quotesPage1.ClickBuyQuoteButton();
        MainCall.quotesPage1.ClickPaymentMethod();
        MainCall.quotesPage1.ClickCCNumber("4111111111111111");
        MainCall.quotesPage1.ClickCCCvv("123");
        MainCall.quotesPage1.ClickExpiryDate("12/31");
        MainCall.quotesPage1.ClickCCType();
        MainCall.quotesPage1.ClickSetDefault();
        MainCall.quotesPage1.ClickAddCCButton();
        MainCall.quotesPage1.ClickOKButton();
        MainCall.quotesPage1.ClickSecurityCode("123");
        MainCall.quotesPage1.ClickTermsNCon();
        MainCall.quotesPage1.ClickRequestButton();
        MainCall.quotesPage1.ClicksetByOKPrompt();
}
}