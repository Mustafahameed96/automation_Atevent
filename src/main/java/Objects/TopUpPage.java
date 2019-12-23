package Objects;

import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alvina Kamran on 08/05/2018.
 */
public class TopUpPage extends baseTest {

    public TopUpPage(){}

    public static By byTitleName            = By.cssSelector("#ReactApp > div > div.container-fluid.main-container > div > div > div > div:nth-child(1) > div:nth-child(1)");
    public static By byTopupAccount         = By.name("topup-amount");
    public static By byTopupInput           = By.tagName("input");
    public static By byOkButton             = By.className("TopUpAmountInput--right-icon");
    public static By byBottomBtns           = By.className("TopUpAccountFooter--optional-buttons-container");
    public static By byCancelTopup          = By.cssSelector(".TopUpAccountFooter--optional-buttons-container > div:nth-child(2)");
    public static By byAttentionPopup       = By.xpath("//span[contains(text(), 'Continue In This Page')]");
    public static By byIMadeThisTransfer    = By.cssSelector(".TopUpAccountFooter--optional-buttons-container > div:nth-child(3)");
    public static By byOkTransferButn       = By.xpath("//span[contains(text(), 'OK')]");
    public static By byTopupHistoryTitle    = By.cssSelector("#ReactApp > div > div.container-fluid.main-container > div > div > div:nth-child(1) > div:nth-child(1)");


    public String checkTitleName()
    {
        String titleName = WebDriverFactory.getDriver().findElement(byTitleName).getText();
        return titleName;
    }

    public void enterTopupAccount() throws InterruptedException
    {
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.sendKeys(WebDriverFactory.getDriver().findElement(byTopupAccount).findElement(byTopupInput),"10").build().perform();

        WebDriverFactory.getDriver().findElement(byOkButton).click();

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byBottomBtns));
        JavascriptExecutor jsx = (JavascriptExecutor)WebDriverFactory.getDriver();
        jsx.executeScript("window.scrollBy(0,450)", "");
    }

    public void clickCancelTopup() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byCancelTopup).click();
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byAttentionPopup));
        WebDriverFactory.getDriver().findElement(byAttentionPopup).click();
    }

    public void clickIMadeThisTransfer() throws InterruptedException
    {
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElement(byIMadeThisTransfer).click();

        WebDriverWait wait1 = new WebDriverWait(WebDriverFactory.getDriver(), 40);
        WebElement element2 = wait1.until(ExpectedConditions.elementToBeClickable(byOkTransferButn));
        element2.click();

        boolean status= element2.isEnabled();
        if(status) System.out.println("Top Up Submitted");
        else System.out.println("Top Up not submitted");

        WebDriverWait wait2 = new WebDriverWait(WebDriverFactory.getDriver(), 40);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(byTopupHistoryTitle));
        Thread.sleep(5000);
    }

    public String checkTopupHistoryTitle()
    {
        String titleName = WebDriverFactory.getDriver().findElement(byTopupHistoryTitle).getText();
        return titleName;
    }
}