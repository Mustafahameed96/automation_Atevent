package Objects;

import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;

/**
 * Created by Venturedive on 08/05/2018.
 */
public class AccountDetailsPage extends baseTest {

    public AccountDetailsPage(){}

    public static By byMyAccountButton = By.cssSelector(".user-menu-header span");
    public static By byEditProfileButton = By.cssSelector(".rigth > .link-button > button");
    public static By byFirstNameC = By.name("first-name");
    public static By byFirstNameW = By.name("first-name");
    public static By byLastNameC = By.name("last-name");
    public static By byLastNameW = By.name("last-name");
    public static By byDOB = By.className("form-control");
    public static By byrdtSwitch = By.className("rdtSwitch");
    public static By byrdtPrev = By.className("rdtPrev");
    public static By byrdtMonth = By.className("rdtMonth");
    public static By byrdtDay = By.className("rdtDay");
    public static By bySaveButton = By.xpath("//span[contains(text(), 'Save')]");
    public static By byContinue = By.xpath("//span[contains(text(), 'Continue')]");

    public void ClickMyAccountButton()
    {
        WebDriverFactory.getDriver().findElement(byMyAccountButton).click();
    }
    public void ClickEditProfileButton()
    {
        WebDriverFactory.getDriver().findElement(byEditProfileButton).click();
    }
    public void ClickbyFirstNameC()
    {
        WebDriverFactory.getDriver().findElement(byFirstNameC).clear();
    }
    public void ClickbyFirstNameW(String FirstName)
    {
        WebDriverFactory.getDriver().findElement(byFirstNameW).sendKeys(FirstName);
    }
    public void ClickbyLastNameC()
    {
        WebDriverFactory.getDriver().findElement(byLastNameC).clear();
    }

    public void ClickbyLastNameW(String LastName)
    {
        WebDriverFactory.getDriver().findElement(byLastNameW).sendKeys(LastName);
    }
    public void ClickbyDOB()
    {
        WebDriverFactory.getDriver().findElement(byDOB).click();
    }
    public void ClickbyrdtSwitch()
    {
        WebDriverFactory.getDriver().findElement(byrdtSwitch).click();
    }
    public void ClickbyrtdPrev()
    {
        WebDriverFactory.getDriver().findElement(byrdtPrev).click();
    }
    public void ClickrdtMonth()
    {
        WebDriverFactory.getDriver().findElement(byrdtMonth).click();
    }
    public void ClickrdtDay()
    {
        WebDriverFactory.getDriver().findElement(byrdtDay).click();
    }
    public void ClickbySaveButton()
    {
        WebDriverFactory.getDriver().findElement(bySaveButton).click();
    }
    public void ClickbyContinue()
    {
        //WebDriverFactory.getDriver().findElement(byContinue).click();
        WebDriverFactory.getDriver().findElement(By.cssSelector(".custom-dialog > div > div > div")).click();
    }

}
