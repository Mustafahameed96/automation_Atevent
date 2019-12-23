package Objects;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * Created by VD on 6/3/2018.
 */
public class editPastFlightPage extends baseTest {

    public editPastFlightPage () {}

    public static By byClickOnHome= By.cssSelector("ul > div:nth-child(1)");
    public static By byPastItineraryButton = By.xpath("//div[contains(text(), 'Past')]");
    public static By byPastFlight = By.id("past");
    public static By byFlightContainer = By.className("itinerary-order-container");


    public void pastIsEditable() throws InterruptedException {
        Thread.sleep(5000);

        WebDriverFactory.getDriver().findElement(byPastItineraryButton).click();
        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(byPastFlight).findElements(byFlightContainer).get(0).click();
        Thread.sleep(10000);

        String modifyButtonText = WebDriverFactory.getDriver().findElement(By.cssSelector("ul[class='itinerary_detail--buttons hide-header-buttons-small']")).findElement(By.cssSelector("button[class='btn font--caslon-sc background_color--gray padding_horizontal--none margin--zero display-ordinary-buttons']")).getText();
        String modifyText = "Modify";

        Assert.assertNotEquals(modifyButtonText, modifyText);
        if(modifyButtonText.equals(modifyText))
        {
            System.out.println("Test Case Failed");
        }
        else
        {
            System.out.println("Test Case Passed");
        }

    }
}
