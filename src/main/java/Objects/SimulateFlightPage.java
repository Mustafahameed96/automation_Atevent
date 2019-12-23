package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alvina Kamran on 08/05/2018.
 */
public class SimulateFlightPage {

    public SimulateFlightPage(){}

    public static By ByTitleName = By.cssSelector("#ReactApp > div > div.container-fluid.main-container > div > div > div > div:nth-child(2) > div > div:nth-child(2) > header > div > div:nth-child(1)");
    public static By ByTagNameBtn = By.tagName("button");
    public static By ByDepartureAirport = By.className("heading--destination");
    public static By ByInputField = By.className("input-field");
    public static By ByTagNameInput = By.tagName("input");
    public static By ByPassengerbutton = By.className("passenger-n");
    public static By ByThankuText = By.cssSelector("#ReactApp > div > div.container-fluid.main-container > div > div > div.summary-card > div.booked-message > span > div");


    public String checkTitleName()
    {
        String titleName = WebDriverFactory.getDriver().findElement(ByTitleName).getText();
        return titleName;
    }

    public void selectDepartureAirport()
    {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(ByDepartureAirport));
        element2.click();
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.sendKeys(WebDriverFactory.getDriver().findElement(ByInputField).findElement(ByTagNameInput), "OPKC\n").build().perform();
    }

    public void selectPassenger()
    {
        WebDriverFactory.getDriver().findElement(ByPassengerbutton).findElements(ByTagNameBtn).get(1).click();
    }

    public String checkThankyouText(){
        String ThankyouText = WebDriverFactory.getDriver().findElement(ByThankuText).getText();
        return ThankyouText;
    }


}