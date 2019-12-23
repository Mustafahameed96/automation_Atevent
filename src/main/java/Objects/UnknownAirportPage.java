package Objects;

import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by VD-Shireen on 8/1/2018.
 */
public class UnknownAirportPage extends baseTest {

    public UnknownAirportPage() {}

    public static By byDepartureAirport         = By.className("heading--destination");
    public static By bySearchAirport            = By.className("input-field") ;
    public static By bySearchMoreAirportButton  = By.xpath("//span[contains(text(),'Search More Airports')]");

    public void unknownDeptAirport(String Departure) throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byDepartureAirport).click();
        WebDriverFactory.getDriver().findElement(bySearchAirport).findElement(By.tagName("input")).sendKeys(Departure);
        WebDriverFactory.getDriver().findElement(bySearchMoreAirportButton).click();
        Thread.sleep(4000);

        Actions action = new Actions(WebDriverFactory.getDriver());
        action.click(WebDriverFactory.getDriver().findElement(By.className("input-field")).findElement(By.tagName("input")));//, airport).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
    }
}
