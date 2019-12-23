package Objects;

import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class customerFeedbackPage extends baseTest
{

    public void customerFeedbackPage() {}

    public static By byPastItineraryButton = By.xpath("//div[contains(text(), 'Past')]");
    public static By byPastFlight = By.id("past");
    public static By byFlightContainer = By.className("itinerary-order-container");
    public static By byRatingText = By.className("rating-row");
    public static By byRating = By.className("rating-display-style");
    public static By byRatingStar = By.className("rating-popup-content");
    public static By byRatingStar1 = By.className("align-stars-center");
    public static By byRatingComments = By.className("rating-popup-content");
    public static By byRatingComments1 = By.className("dialog-textarea-cf");
    public static By byOtherCategory = By.className("cat-list");
    public static By bySubmitFeedback = By.cssSelector(".popup-footer button");
    public static By byCloseBox = By.className("close-error");
    public static By byselectstaybutton = By.xpath("//span[contains(text(),'Stay On This Page')]");
    public static By byOkButton = By.xpath("//span[contains(text(),'OK')]");
    public static By byScrollDownToBottom = By.className("rating-display-style");
    public static By byTagLi      =         By.tagName("li");


    public void clickPastItineraryTab() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(byPastItineraryButton).click();
    }

    public void clickPastFlight() throws InterruptedException
    {
        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(byPastFlight).findElements(byFlightContainer).get(0).click();
        Thread.sleep(15000);
    }


    public void scrollDown() throws InterruptedException
    {
        WebElement SD = WebDriverFactory.getDriver().findElement(byScrollDownToBottom);
        JavascriptExecutor jsx = (JavascriptExecutor)WebDriverFactory.getDriver();
        jsx.executeScript("scroll(0, document.body.scrollHeight);");

        Thread.sleep(3000);
    }


    public String ratingText()
    {
        String ratingTxt = WebDriverFactory.getDriver().findElement(byRatingText).getText();
        return ratingTxt;
    }

    public void clickRating()
    {
        WebDriverFactory.getDriver().findElement(byRating).click();

    }

    public String checkFeedbackButton()
    {
        String isDisabled = WebDriverFactory.getDriver().findElement(bySubmitFeedback).getAttribute("disabled");
        return isDisabled;
    }


    public void enterRatingStars()
    {
        WebDriverFactory.getDriver().findElement(byRatingStar).findElements(byRatingStar1).get(0).click();
    }

    public void enterRatingComments()
    {

        WebDriverFactory.getDriver().findElement(byRatingComments).findElements(byRatingComments1).get(0).sendKeys("Feedback");
    }


    public void  selectOtherCategory()
    {
        WebDriverFactory.getDriver().findElement(byOtherCategory).findElements(byTagLi).get(1).click();

    }

    public void submitFeedBackButton()
    {
        WebDriverFactory.getDriver().findElement(bySubmitFeedback).click();
    }


    public void closeRatingBox() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byCloseBox).click();
        Thread.sleep(2000);
    }

    public  void stayOnthisPage()
    {
        WebDriverFactory.getDriver().findElement(byselectstaybutton).click();
    }

    public void enterOtherCategoryRatingStars() throws InterruptedException
    {
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElement(byRatingStar).findElements(byRatingStar1).get(1).click();
    }


    public void enterOtherCategoryRatingComments()
    {
        WebDriverFactory.getDriver().findElement(byRatingComments).findElements(byRatingComments1).get(1).sendKeys("hellooooo");
    }

    public void clickOkPrompt() throws InterruptedException {
       WebDriverFactory.getDriver().findElement(byOkButton).click();
       Thread.sleep(8000);
    }

}
