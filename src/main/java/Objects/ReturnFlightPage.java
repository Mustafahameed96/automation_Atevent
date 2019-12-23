package Objects;

import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReturnFlightPage extends baseTest {

    public ReturnFlightPage(){}

    public static By byTitleName            = By.cssSelector("#ReactApp > div > div.container-fluid.main-container > div > div > div > div:nth-child(2) > div > div:nth-child(2) > header > div > div:nth-child(1)");
    public static By byClickReturnFlight    = By.id("returnFlight");
    public static By byScrollDown           = By.className("footer-label");
    public static By byClickDepartDate      = By.xpath("(//*[@id='dob'])[2]");
    public static By byClickDepartTime      = By.xpath("(//*[contains(@name, 'time-picker-input')])[2]");

    public String checkTitleName()
    {
        String titleName = WebDriverFactory.getDriver().findElement(byTitleName).getText();
        return titleName;
    }

    public void clickReturnFlightBtn() throws InterruptedException
    {
        Thread.sleep(4000);
        WebDriverFactory.getDriver().findElement(byClickReturnFlight).click();

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
        WebElement SD = wait.until(ExpectedConditions.visibilityOfElementLocated(byScrollDown));
        JavascriptExecutor jsx = (JavascriptExecutor)WebDriverFactory.getDriver();
        jsx.executeScript("arguments[0].scrollIntoView(true);",SD);
    }

    public void selectReturnDepartureDate(String date) throws InterruptedException
    {
        Thread.sleep(3000);
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.sendKeys(WebDriverFactory.getDriver().findElement(byClickDepartDate), date).build().perform();
        Thread.sleep(2000);
    }

    public void selectReturnDepartureTime(String time) throws InterruptedException
    {
        Thread.sleep(3000);
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.sendKeys(WebDriverFactory.getDriver().findElement(byClickDepartTime), time).build().perform();
        Thread.sleep(2000);
    }

}