package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;

/**
 * Created by VD on 5/9/2018.
 */
public class forgotpasswordPage
{
   // public forgotpasswordPage(){}

    // ForgotPassword Locators
    public static By byLoginTopButton = By.cssSelector(".user-menu-header div:nth-child(2) button");
    public static By byForgotPasswordLink = By.cssSelector(".forgot-password");
    public static By byEmailField = By.cssSelector("#email");
    public static By bySendlinkButton = By.cssSelector(".waves-effect");
    public static By byClickLoginBack = By.cssSelector("a[href*='login'] ");
    public static By bymessagedisplay = By.cssSelector(".center.msg");

    public void clickLoginTopButton()
    {
        WebDriverFactory.getDriver().findElement(byLoginTopButton).click();
    }

    public void ClickForgotPasswordLink()
    {
        WebDriverFactory.getDriver().findElement(byForgotPasswordLink).click();
    }

    public void TypeEmail(String email)
    {
        WebDriverFactory.getDriver().findElement(byEmailField).sendKeys(email);
    }

    public void ClickSendLinkButton()
    {
        WebDriverFactory.getDriver().findElement(bySendlinkButton).click();
    }

    public String EmailMessage()
    {
        String messagedisplayed = WebDriverFactory.getDriver().findElement(bymessagedisplay).getText();
        return messagedisplayed;
    }

    public void ClickBackLogin()
    {
        WebDriverFactory.getDriver().findElement(byClickLoginBack).click();
    }
} 