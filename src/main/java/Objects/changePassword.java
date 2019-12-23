package Objects;

import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;

/**
 * Created by Venturedive on 28/05/2018.
 */
public class changePassword extends baseTest {

    public changePassword(){}

    public static By byMyAccountButton = By.cssSelector(".user-menu-header span");
    public static By byChangePasswordButton = By.xpath("//span[contains(text(), 'Change Password')]");
    public static By byEnterOldPassword = By.id("old-password");
    public static By byNewPassword = By.id("new-password");
    public static By byRepeatPassword = By.id("repeat-password");
    public static By byConfirmButton = By.cssSelector("#ReactApp > div > div.container-fluid.main-container > div > div > div:nth-child(3) > div:nth-child(2)");

    public void ClickMyAccountButton()
    {
        WebDriverFactory.getDriver().findElement(byMyAccountButton).click();
    }

    public void ClickChangePasswordButton()
    {
        WebDriverFactory.getDriver().findElement(byChangePasswordButton).click();
    }

    public void ChangeEnterOldPassword(String OldPassword)
    {
        WebDriverFactory.getDriver().findElement(byEnterOldPassword).sendKeys(OldPassword);
    }

    public void ClickNewPassword(String NewPassword)
    {
        WebDriverFactory.getDriver().findElement(byNewPassword).sendKeys(NewPassword);
    }

    public void ClickRepeatPassword(String RepeatPassword)
    {
        WebDriverFactory.getDriver().findElement(byRepeatPassword).sendKeys(RepeatPassword);
    }

    public void ClickConfirmButton() throws InterruptedException {
        WebDriverFactory.getDriver().findElement(byConfirmButton).click();
        Thread.sleep(5000);
    }

}
