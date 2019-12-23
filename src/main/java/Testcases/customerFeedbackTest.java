package Testcases;

import General.MainCall;
import org.testng.Assert;
import org.testng.annotations.Test;

public class customerFeedbackTest

{
    @Test(description = "VWSHADOW-6969", priority = 5)
    //http://jira.vistajet.local/browse/VWSHADOW-6969
    public void test6feedback() throws InterruptedException
    {
        Thread.sleep(5000);
        MainCall.GENERIC_FUNCTIONS.clickOnMenuBar("My itineraries");
        MainCall.feedbackPage.clickPastItineraryTab();
        MainCall.feedbackPage.clickPastFlight();
        Thread.sleep(5000);
        MainCall.feedbackPage.scrollDown();
        Assert.assertTrue(MainCall.feedbackPage.ratingText().contains("We are committed to improving your flight experience. How would you rate your flight?"), "Feedback disabled");
        MainCall.feedbackPage.clickRating();
        Assert.assertTrue(MainCall.feedbackPage.checkFeedbackButton().equals("true"), "Button is enable");
        MainCall.feedbackPage.enterRatingStars();
        MainCall.feedbackPage.enterRatingComments();
        MainCall.feedbackPage.selectOtherCategory();
        MainCall.feedbackPage.submitFeedBackButton();
        MainCall.paymentPage.acceptAlertOk();
        MainCall.feedbackPage.closeRatingBox();
        MainCall.feedbackPage.stayOnthisPage();
        MainCall.feedbackPage.enterOtherCategoryRatingStars();
        MainCall.feedbackPage.enterOtherCategoryRatingComments();
        MainCall.feedbackPage.submitFeedBackButton();
        MainCall.feedbackPage.clickOkPrompt();
        MainCall.feedbackPage.clickOkPrompt();
        Assert.assertEquals(MainCall.feedbackPage.ratingText(),"Thank you for submitting your feedback.","Feedback is not submitted");

    }

}
