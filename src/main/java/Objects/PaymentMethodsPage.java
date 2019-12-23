package Objects;

import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Objects.MyItineraryPage.byTagButton;

public class PaymentMethodsPage extends baseTest
{
   public PaymentMethodsPage(){}

    public static By byPaymentButton            = By.className("my-account-container");
    public static By byAddNewCreditCard         = By.xpath("//span[contains(text(),'Add New Credit Card')]");
    public static By byCreditNumber             = By.id("credit-card-number");
    public static By byCVV                      = By.id("credit-card-cvv");
    public static By byCardExpiryDate           = By.id("credit-card-expiry-date");
    public static By byPersonalCheck            = By.id("1");
    public static By byCreate                   = By.xpath("//span[contains(text(),'Create')]");
    public static By byAlertOkay                = By.cssSelector(".custom-dialog button");
    public static By bydefaultcheck             = By.className("input-field");
    public static By bytapOnCreditCard          = By.cssSelector("div[class='credit-card-list-item ']");
    public static By bySetAsDefault             = By.className("credit-card-set-default-btn");
    public static By byDeleteButton             = By.cssSelector("div[class='delete-btn']");// By.className("delete-btn");
    public static By byDeletePrompt             = By.xpath("/html/body/div[8]/div/div[1]/div/div/div[2]/div[1]/button/div/div"); // By.xpath("//span[contains(text(), 'Delete')]"); // By.cssSelector("body > div:nth-child(14) > div > div:nth-child(1) > div > div > div:nth-child(3) > div:nth-child(1) > button > div > div > span");
    public static By byCancelPrompt             = By.xpath("//span[contains(text(), 'Cancel')]");
    public static By bySaveButton               = By.className("save-btn ");
    public static By byBackButton               = By.className("back-btn");
    public static By byleavePrompt              = By.xpath("//span[contains(text(),'Leave Anyway')]");
    public static By byclickdefaultCreditCard   = By.className("credit-card-default");

    public void clickPaymentMethodButton() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byPaymentButton).findElements(byTagButton).get(5).click();
        Thread.sleep(5000);
    }

    public void clickAddNewCreditCard() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byAddNewCreditCard).click();
        Thread.sleep(4000);
    }

    public void enterCardNumber(String CardNumber)
    {
     WebDriverFactory.getDriver().findElement(byCreditNumber).sendKeys(CardNumber);
    }

    public void enterCVV (String CVV)
    {
        WebDriverFactory.getDriver().findElement(byCVV).sendKeys(CVV);
    }

    public void enterCardExpiryDate(String CardExpiryDate)
    {
        WebDriverFactory.getDriver().findElement(byCardExpiryDate).sendKeys(CardExpiryDate);
    }

    public void enterCreditCardDetails(String CardNumber, String CVV, String CardExpiryDate)
    {
        enterCardNumber(CardNumber);
        enterCVV(CVV);
        enterCardExpiryDate(CardExpiryDate);
    }

    public void  selectPersonalCheck()
    {
        WebDriverFactory.getDriver().findElement(byPersonalCheck).click();
    }

    public void clickCreateButton() throws InterruptedException
    {
        Thread.sleep(4000);
        WebDriverFactory.getDriver().findElement(byCreate).click();

        try {
            if (WebDriverFactory.getDriver().findElement(By.xpath("//span[contains(text(),'OK')]")).isDisplayed()) {
                {
                    WebDriverFactory.getDriver().findElement(By.xpath("//span[contains(text(),'OK')]")).click();
                    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(byAlertOkay));
                     Thread.sleep(10000);
                }
            }
        }
        catch (Exception e) {
            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(byAlertOkay));
             Thread.sleep(10000);
        }
    }

    public void acceptAlertOk() throws InterruptedException {
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.click(WebDriverFactory.getDriver().findElement(byAlertOkay)).build().perform();
        Thread.sleep(7000);
    }

    public void selectByDefaultCheck()
    {
        WebDriverFactory.getDriver().findElement(bydefaultcheck).click();
    }

    public void clickOnCreditCardDetails() throws InterruptedException
    {
        Thread.sleep(3000);
        WebDriverFactory.getDriver().findElement(bytapOnCreditCard).click();
    }

    public void clickOnDefaultCreditCardDetails()
    {
       WebDriverFactory.getDriver().findElement(byclickdefaultCreditCard).click();
    }

    public void clickSetAsDefault() throws InterruptedException
    {
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElement(bySetAsDefault).click();
        Thread.sleep(5000);
    }

    public void clickDeleteButton() throws InterruptedException {
        Thread.sleep(4000);
        WebDriverFactory.getDriver().findElement(byDeleteButton).click();
        Thread.sleep(4000);
    }

    public void clickDeletePrompt() throws InterruptedException
    {
        Thread.sleep(4000);
        WebDriverFactory.getDriver().findElement(byDeleteButton).click();
        WebDriverFactory.getDriver().findElement(byDeletePrompt).click();
        Thread.sleep(4000);
    }

    public void clickCancelPrompt()
    {
        WebDriverFactory.getDriver().findElement(byCancelPrompt).click();
    }

    public void clickSaveButton()
    {
        WebDriverFactory.getDriver().findElement(bySaveButton).click();
    }

    public void clickBackButton()
    {
        WebDriverFactory.getDriver().findElement(byBackButton).click();
    }

    public void clickleaveButton() throws InterruptedException
    {
        Thread.sleep(3000);
        WebDriverFactory.getDriver().findElement(byleavePrompt).click();
    }


}
