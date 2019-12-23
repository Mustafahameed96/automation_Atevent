package Objects;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by VD on 6/2/2018.
 */
public class passportExpiryMyAccPage extends baseTest {

    public passportExpiryMyAccPage (){}

    public static By byMyAccButton = By.xpath("//span[contains(text(),'My Account')]");
    public static By byManagePassport = By.xpath("//span[contains(text(), 'Manage Passports')]");
    public static By byNewPassport = By.xpath("//span[contains(text(), 'New Passport')]");
    public static By byExpiryDate = By.className("form-control");
    public static By byPassportExpiryError = By.cssSelector("div:nth-child(2) > div > div:nth-child(3)");
    public static By byCreate = By.className("save-btn");

    public void clickOnMyAccButton ()
    {
        WebDriverFactory.getDriver().findElement(byMyAccButton).click();
    }

    public void clickOnManagePassport ()
    {
        WebDriverFactory.getDriver().findElement(byManagePassport).click();
    }

    public void clickOnNewPassport ()
    {
        WebDriverFactory.getDriver().findElement(byNewPassport).click();
    }

    public void fillPassportForm (String PassportNumber, String PassportName , String Nationality, String IssuingCountry, String expDate) throws InterruptedException
    {
        MainCall.itineraryPage.enterPassportDetails(PassportNumber, PassportName, Nationality, IssuingCountry);
        WebDriverFactory.getDriver().findElement(byExpiryDate).sendKeys(expDate);
        WebDriverFactory.getDriver().findElement(byCreate).click();

        String actualMsg =  WebDriverFactory.getDriver().findElement(byPassportExpiryError).getText();
        String errorMsg = "Passport expiry date should be in future. Please insert a valid date.";

        Assert.assertEquals("Something unexpected happened", errorMsg, actualMsg);
        if(actualMsg.equals(errorMsg))
        {
            System.out.println("Test Case Passed");
        }
        else
        {
            System.out.println("Test Case Failed");
        }
    }
}
