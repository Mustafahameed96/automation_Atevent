package Objects;

import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;

/**
 * Created by Venturedive on 25/05/2018.
 */
public class quotesPage extends baseTest {

    public quotesPage(){}
    public static By byQuotesButton = By.cssSelector("#ReactApp > div > div:nth-child(2) > div > div > ul > div:nth-child(7)");
    public static By byDetailsButton = By.cssSelector("#ReactApp > div > div.container-fluid.main-container > div > div > div.col.s12.m12.l12 > div > div > div:nth-child(3) > div:nth-child(1) > div.col.s12.m12.l12 > div > div:nth-child(2) > div > div.information.undefined > div.children > div > div > div:nth-child(2) > div > div > button > div > div > span");
    public static By byBuyQuoteButton = By.xpath("//span[contains(text(), 'Buy Quote')]");
    public static By byPaymentMethod = By.className("selected-credit-card");
    public static By byCCNumber = By.id("credit-card-number");
    public static By byCCCvv = By.id("credit-card-cvv");
    public static By byExpiryDate = By.id("credit-card-expiry-date");
    public static By byCCType = By.xpath("//span[contains(text(), 'Business')]");
    public static By bySetDefault = By.className("input-field");
    public static By byAddCCButton = By.xpath("//span[contains(text(), 'save-btn half-btn')]");
    public static By byOKButton = By.xpath("//span[contains(text(), 'OK')]");
    public static By bySecurityCode = By.id("security-code");
    public static By byTermsNCon = By.className("checkbox");
    public static By byRequestButton = By.xpath("//span[contains(text(), 'Request')]");
    public static By byOKPrompt = By.xpath("//span[contains(text(), 'Yes')]");

    public void ClickDetailsButton ()
    {
        WebDriverFactory.getDriver().findElement(byDetailsButton).click();
    }

    public void ClickBuyQuoteButton()
    {
        WebDriverFactory.getDriver().findElement(byBuyQuoteButton).click();
    }

    public void ClickPaymentMethod()
    {
        WebDriverFactory.getDriver().findElement(byPaymentMethod).click();
    }

    public void ClickCCNumber(String CCNumber)
    {
        WebDriverFactory.getDriver().findElement(byCCNumber).sendKeys(CCNumber);
    }
    public void ClickCCCvv(String CvvNumber)
    {
        WebDriverFactory.getDriver().findElement(byCCCvv).sendKeys(CvvNumber);
    }

    public void ClickExpiryDate(String ExpiryDate)
    {
        WebDriverFactory.getDriver().findElement(byExpiryDate).sendKeys(ExpiryDate);
    }

    public void ClickCCType()
    {
        WebDriverFactory.getDriver().findElement(byCCType).click();
    }

    public void ClickSetDefault()
    {
        WebDriverFactory.getDriver().findElement(bySetDefault).click();
    }

    public void ClickAddCCButton()
    {
        WebDriverFactory.getDriver().findElement(byAddCCButton).click();
    }

    public void ClickOKButton()
    {
        WebDriverFactory.getDriver().findElement(byOKButton).click();
    }

    public void ClickSecurityCode(String SCode)
    {
        WebDriverFactory.getDriver().findElement(bySecurityCode).sendKeys(SCode);
    }

    public void ClickTermsNCon()
    {
        WebDriverFactory.getDriver().findElement(byTermsNCon).click();
    }

    public void ClickRequestButton()
    {
        WebDriverFactory.getDriver().findElement(byRequestButton);
    }

    public void ClicksetByOKPrompt()
    {
        WebDriverFactory.getDriver().findElement(byOKPrompt).click();
    }


    }
