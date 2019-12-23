package Testcases;

import General.MainCall;
import General.baseTest;
import org.testng.annotations.Test;

import java.util.Random;

public class PaymentMethodsTest extends baseTest {

    String CardNumber = "5500 0000 0000 0004" ;
    String CVV = "123";
    String CardExpiryDate = "11/22";

    @Test(description = "VWSHADOW-2798", priority = 6)
    //http://jira.vistajet.local/browse/VWSHADOW-2798
    public void test5PaymentMethods() throws InterruptedException
    {
        Thread.sleep(10000);
        MainCall.itineraryPage.clickMyAccountButton();
        MainCall.paymentPage.clickPaymentMethodButton();
        MainCall.paymentPage.clickAddNewCreditCard();
        MainCall.paymentPage.enterCreditCardDetails(CardNumber, CVV, CardExpiryDate);
        MainCall.paymentPage.clickCreateButton();
        Thread.sleep(6000);
        MainCall.paymentPage.acceptAlertOk();
        Thread.sleep(7000);
        MainCall.paymentPage.clickAddNewCreditCard();
        MainCall.paymentPage.enterCreditCardDetails("3400 0000 0000 009","1234", CardExpiryDate);
        MainCall.paymentPage.selectPersonalCheck();
        MainCall.paymentPage.selectByDefaultCheck();
        MainCall.paymentPage.clickCreateButton();
        MainCall.paymentPage.acceptAlertOk();
        MainCall.paymentPage.clickSetAsDefault();
        MainCall.paymentPage.acceptAlertOk();

        //Adding new credit card with the same 4 ending numbers the card added previously
        MainCall.paymentPage.clickAddNewCreditCard();
        MainCall.paymentPage.enterCreditCardDetails("3400 0000 0000 009","1234", CardExpiryDate);
        MainCall.paymentPage.selectPersonalCheck();
        MainCall.paymentPage.clickCreateButton();
        MainCall.paymentPage.acceptAlertOk();
        Thread.sleep(6000);
//        MainCall.paymentPage.acceptAlertOk();

        //Edit one of the credit cards
        MainCall.paymentPage.clickOnCreditCardDetails();
        MainCall.paymentPage.enterCVV("556");
        MainCall.paymentPage.enterCardExpiryDate("15/23");
        MainCall.paymentPage.clickSaveButton();
        MainCall.paymentPage.acceptAlertOk();

        //Choose some credit card again, make some changes and click on *Back* button
        MainCall.paymentPage.clickOnCreditCardDetails();
        MainCall.paymentPage.enterCVV("556");
        MainCall.paymentPage.enterCardExpiryDate("15/23");
        MainCall.paymentPage.clickBackButton();
        MainCall.paymentPage.clickleaveButton();

       //Delete Default Credit Card
        MainCall.paymentPage.clickOnDefaultCreditCardDetails();
        MainCall.paymentPage.clickDeleteButton();
        MainCall.paymentPage.clickCancelPrompt();
        Thread.sleep(3000);
        MainCall.paymentPage.clickBackButton();

        //Delete Credit Card
        MainCall.paymentPage.clickOnCreditCardDetails();
   //     MainCall.paymentPage.clickDeleteButton();
        MainCall.paymentPage.clickDeletePrompt();
        MainCall.paymentPage.acceptAlertOk();
        Thread.sleep(5000);

    }
}
