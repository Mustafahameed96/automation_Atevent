package Objects;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by VD on 5/27/2018.
 */
// Request quote from home page
public class requestQuoteDirectPage extends baseTest {

    public requestQuoteDirectPage(){}

    public static By byDepartureAirport = By.cssSelector("div:nth-child(1) > div.shared-autocomplete-container");
    public static By byArrivalAirport = By.cssSelector("div:nth-child(2) > div.shared-autocomplete-container");

    public void fillFlightFormDirect() throws InterruptedException
    {
        Thread.sleep(3000);

        WebDriverFactory.getDriver().findElement(byDepartureAirport).click();
        Thread.sleep(3000);
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(3000);
        WebDriverFactory.getDriver().findElement(byArrivalAirport).click();
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(4000);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        action.sendKeys(WebDriverFactory.getDriver().findElement(By.className("form-control")), dateFormat.format(futureFourDays())).build().perform();
        Thread.sleep(2000);

        WebDriverFactory.getDriver().findElement(By.xpath("//span[contains(text(),'Plan')]")).click();
        Thread.sleep(5000);
    }

    private Date futureFourDays()
    {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 4);
        return cal.getTime();
    }
}
