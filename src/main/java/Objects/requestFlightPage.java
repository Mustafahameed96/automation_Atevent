package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import General.baseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class requestFlightPage extends baseTest {

    public requestFlightPage(){}

    public static By byRAFsubmitButton =    By.id("submitItinerary");
    public static By byConfirmationPopUp =  By.xpath("//span[contains(text(), 'No')]");
    public static By byThankyouMsg       =  By.className("booked-message");

    public void selectNoOnSubmitButton() throws InterruptedException
    {
        Thread.sleep(3000);
        WebDriverFactory.getDriver().findElement(byRAFsubmitButton).click();
        WebDriverFactory.getDriver().findElement(byConfirmationPopUp).click();
        Thread.sleep(4000);
    }

    public String thankyouMsg()
    {
        String thankyouMesssage =  WebDriverFactory.getDriver().findElement(byThankyouMsg).getText();
        return thankyouMesssage;
    }

    public String checkFlightInItinerary()
    {
        String fromToFlightName = WebDriverFactory.getDriver().findElement(By.className("flightConn")).getText();
        return fromToFlightName;
    }

}
