package Objects;

import General.MainCall;
import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static General.GenericFunctions.by_timePicker;

//import static Objects.planAFlightForDayOverFlightPage.*;

public class ELOffersPage {

    public ELOffersPage(){}

    public static By byTitleName = By.cssSelector("#ReactApp > div > div.container-fluid.main-container > div > div > div > div:nth-child(1) > div:nth-child(1)");
    public static By ByPassengerbutton = By.className("passenger-n");
    public static By byIncrementPaxCount = By.className("text-right");
    public static By byPaxConfirmBtn =By.cssSelector("button[class='waves-effect waves-light btn background_color--gray right']");
    public static By byRequestQuoteBtn = By.id("submitItinerary");
    public static By byYourQuoteScreen = By.cssSelector("#ReactApp > div > div.container-fluid.main-container > div > div > div > div > div > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)");
    public static By byCreditCardMethod = By.className("selected-credit-card");
    public static By byScrollDown = By.className("action-container");
    public static By byCreditCardNumber = By.id("credit-card-number");
    public static By byCreditCardCVV =By.id("credit-card-cvv");
    public static By byCreditCardExpiryDate = By.id("credit-card-expiry-date");
    public static By bySelectCheckBox = By.className("input-field");
    public static By byAddCreditCardBtn = By.cssSelector(".save-btn.half-btn button");
    public static By byCreditCardOkBtn = By.xpath("//span[contains(text(), 'OK')]");
    public static By bySecuriryCode = By.id("security-code");
    public static By byRequestbtn = By.xpath("//span[contains(text(), 'Request')]"); // By.cssSelector("#ReactApp > div > div.container-fluid.main-container > div > div > div > div > div > div:nth-child(5) > div > div > div:nth-child(2) > button");
    public static By byConfirmationPopup = By.xpath("//span[contains(text(), 'Yes')]");
    public static By byLogoutBtn = By.xpath("//span[contains(text(), 'Logout')]");
    public static By byThankuText = By.cssSelector("#ReactApp > div > div.container-fluid.main-container > div > div > div:nth-child(4) > div.booked-message");
    public static By byCheckOffer = By.cssSelector("#ReactApp > div > div.container-fluid.main-container > div > div > div > div:nth-child(2) > div > div > div:nth-child(2) > button > div > svg > path");
    public static By byRecord = By.className("records-found-label");

    public String checkTitleName()
    {
        String titleName = WebDriverFactory.getDriver().findElement(byTitleName).getText();
        return titleName;
    }

    public void checkOffer() throws InterruptedException
    {
        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(byCheckOffer).click();
    }

    public void selectELOffer()
    {
        WebDriverFactory.getDriver().findElement(By.cssSelector(".children div:nth-child(2)")).click();
    }

    public void selectPassenger() throws InterruptedException
    {
        Thread.sleep(4000);
        WebDriverFactory.getDriver().findElement(ByPassengerbutton).click();
        WebDriverFactory.getDriver().findElement(byIncrementPaxCount).findElements(By.tagName("button")).get(1).click();
        WebDriverFactory.getDriver().findElement(byPaxConfirmBtn).click();
    }

    public void selectTime(String time) throws InterruptedException
    {
        //select time
        Thread.sleep(6000);
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.sendKeys(WebDriverFactory.getDriver().findElement(by_timePicker), (Keys.BACK_SPACE)).build().perform();
        action.sendKeys(WebDriverFactory.getDriver().findElement(by_timePicker), time).build().perform();
        WebDriverFactory.getDriver().findElement(By.className("leg--card")).click();
        Thread.sleep(2000);
    }

    public void clickRequestQuoteBtn() throws InterruptedException {
        WebDriverFactory.getDriver().findElement(byRequestQuoteBtn).click();
        Thread.sleep(10000);
    }

    public String checkTitleName2()
    {
        String titleName = WebDriverFactory.getDriver().findElement(byYourQuoteScreen).getText();
        return titleName;
    }

    public void selectCreditCardMethod() throws InterruptedException
    {
        Thread.sleep(3000);
        WebDriverFactory.getDriver().findElement(byCreditCardMethod).click();
        WebDriverFactory.getDriver().findElement(By.xpath("//*[contains(text(), 'Add Credit Card')]")).click();
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElement(By.xpath("//span[contains(text(), 'OK')]")).click();


        WebElement CT = WebDriverFactory.getDriver().findElement(byScrollDown);
        JavascriptExecutor jsx = (JavascriptExecutor)WebDriverFactory.getDriver();
        jsx.executeScript("arguments[0].scrollIntoView(true);",CT);

    }

    public void enterCreditCardDetails(String CCNumber, String CVV, String CCExpiryDate) throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byCreditCardNumber).sendKeys(CCNumber);
        Thread.sleep(1000);
        WebDriverFactory.getDriver().findElement(byCreditCardCVV).sendKeys(CVV);
        Thread.sleep(1000);
        WebDriverFactory.getDriver().findElement(byCreditCardExpiryDate).sendKeys(CCExpiryDate);
    }

    public void selectCheckbox() throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(bySelectCheckBox));
        element.click();

        Thread.sleep(4000);
    }

    public void clickAddCreditCardBtn(String SecurityCode) throws InterruptedException
    {
        Thread.sleep(4000);
        WebDriverFactory.getDriver().findElement(byAddCreditCardBtn).click();
        Thread.sleep(6000);

        //repeated credit card prompt
        try {
            if (WebDriverFactory.getDriver().findElement(byCreditCardOkBtn).isDisplayed()) {
                {
                    WebDriverFactory.getDriver().findElement(byCreditCardOkBtn).click();
                    Thread.sleep(10000);
                    //card created prompt
                    WebDriverFactory.getDriver().findElement(byCreditCardOkBtn).click();
                    Thread.sleep(5000);
                }
            }
        } catch (Exception e) {
            //card created prompt
            WebDriverFactory.getDriver().findElement(byCreditCardOkBtn).click();
            Thread.sleep(5000);
        }

        WebDriverFactory.getDriver().findElement(bySelectCheckBox).click();
        Thread.sleep(6000);
        WebDriverFactory.getDriver().findElement(bySecuriryCode).sendKeys(SecurityCode);
        Thread.sleep(6000);
    }

    public void clickRequestOffer()
    {
        WebDriverFactory.getDriver().findElement(byRequestbtn).click();
    }

    public void clickYesConfirmationPopup() throws InterruptedException {
        WebDriverFactory.getDriver().findElement(byConfirmationPopup).click();
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 80);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byThankuText));
    }

    public void clickLogoutBtn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byLogoutBtn));
        element.click();
//        WebDriverFactory.getDriver().findElement(byLogoutBtn).click();
        Thread.sleep(3000);
    }

}