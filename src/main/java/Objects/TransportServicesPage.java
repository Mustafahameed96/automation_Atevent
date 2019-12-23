package Objects;

import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Objects.addPassengerAndPassportPage.by_itineraries_button;

/**
 * Created by Alvina Kamran on 08/05/2018.
 */
public class TransportServicesPage extends baseTest {

    public TransportServicesPage(){}

    public static By byTitleName = By.cssSelector("#MyItinerariesContainer > div:nth-child(1) > div:nth-child(2) > div > div:nth-child(1)");
    public static By byScrolldown = By.className("icon-FBO");
    public static By byGroundTransportView = By.className("icon-GroundTransport");
    public static By byTransportOptions = By.className("indent-fix");
    public static By byDailogText = By.className("dialog-textarea");
    public static By byRequestGroundTransportBtn = By.cssSelector("button[class='btn btn-request-gt background_color--gray right']");
    public static By byScrollDown2 = By.className("icon-GroundTransport");
    public static By byOtherServicesView = By.className("icon-OtherServices");


    public void  clickMyItineraryTabPage() throws InterruptedException
    {
        WebDriverWait lwait = new WebDriverWait(WebDriverFactory.getDriver(), 100);
        lwait.until(ExpectedConditions.visibilityOfElementLocated(by_itineraries_button));

        WebDriverFactory.getDriver().findElement(by_itineraries_button).click();
        Thread.sleep(10000);
    }

    public String checkTitleName()
    {
        String titleName = WebDriverFactory.getDriver().findElement(byTitleName).getText();
        return titleName;
    }

    public void clickGTviewBtn() throws InterruptedException {

        WebElement CT = WebDriverFactory.getDriver().findElement(byScrolldown);
        JavascriptExecutor jsx = (JavascriptExecutor)WebDriverFactory.getDriver();
        jsx.executeScript("arguments[0].scrollIntoView(true);",CT);
        Thread.sleep(11000);

        WebDriverFactory.getDriver().findElement(byGroundTransportView).click();
    }

    public void selectTransportOptions()
    {
        Select oSelect = new Select(WebDriverFactory.getDriver().findElement(byTransportOptions));
       // oSelect.selectByVisibleText("Request Car Services");
        oSelect.selectByIndex(2);
    }

    public void enterDialogText(String Textarea) throws InterruptedException {
        WebDriverFactory.getDriver().findElement(byDailogText).sendKeys(Textarea);
        Thread.sleep(2000);
    }

    public void clickRequestGroundTransportBtn() throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byRequestGroundTransportBtn));
        element.click();
        Thread.sleep(9000);
    }
    public void clickOtherServiceViewBtn() throws InterruptedException
    {
        WebElement GT = WebDriverFactory.getDriver().findElement(byScrollDown2);
        JavascriptExecutor jsx1 = (JavascriptExecutor)WebDriverFactory.getDriver();
        jsx1.executeScript("arguments[0].scrollIntoView(true);",GT);
        Thread.sleep(4000);

        WebDriverFactory.getDriver().findElement(byOtherServicesView).click();
    }

    public void selectOtherServiceOptions()
    {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byTransportOptions));

        Select select1 = new Select(WebDriverFactory.getDriver().findElement(byTransportOptions));
        select1.selectByVisibleText("Conference Room");
    }

    public void clickRequestOtherServiceBtn() throws InterruptedException
    {
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElement(byRequestGroundTransportBtn).click();
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byOtherServicesView));
        Thread.sleep(9000);

    }

}