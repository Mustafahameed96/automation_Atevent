package Objects;

import General.CommonLocators;
import General.WebDriverFactory;
import General.WebDriverWaits;
import General.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccount_FSP_VJDirect extends baseTest
{

    public MyAccount_FSP_VJDirect()
    {}

    // VJ/FSP Direct MyAccount Locators

    public static By byMyAccountScreen = By.className("my-account-item-header");
    public static By byEditMyProfileButton = By.cssSelector(".rigth");
    public static By byFirstname = By.id("first-name");
    public static By byLastname = By.id("last-name");
    public static By byDateOfBirth = By.cssSelector(".form-control");
    public static By byBackIcon = By.cssSelector(".rdtPrev");
    public static By bySelectDate = By.cssSelector(".rdtDay");
    public static By byPhonenumber = By.cssSelector(".intl-tel-input > input");
    public static By byEmail = By.id("email");
    public static By bySavebutton = By.cssSelector(".col.s6.m6.l6.right button");
    public static By byContinue = By.cssSelector(".custom-dialog div:nth-child(2) button");
    public static By byAlertOk = By.cssSelector(".custom-dialog button");
    public static By byCheckLoginScreen = By.className("logo-anchor");
    public static WebElement editProfilebutton;


    // VJ/FSP Direct MyAccount Functions

    public void clickMyAccountButton()
    {

        WebElement myAccountbtn = WebDriverFactory.getDriver().findElement(CommonLocators.byMyAccountButton);
        myAccountbtn = WebDriverWaits.waitFor(ExpectedConditions.elementToBeClickable(myAccountbtn));
        myAccountbtn.click();

    }
    public boolean checkMyAccountScreen()
    {
       boolean homescreen = WebDriverFactory.getDriver().findElement(byMyAccountScreen).isDisplayed();
        return homescreen;
    }

    public void clickEditProfile()
    {
        editProfilebutton = WebDriverFactory.getDriver().findElement(byEditMyProfileButton);
        editProfilebutton.click();
    }


    public void Enter_details(String firstname, String lastname, String phonenum, String email)
    {
        WebDriverWaits.sleep(2000);
        WebElement Firstname =  WebDriverFactory.getDriver().findElement(byFirstname);
        WebDriverWaits.waitUntilElementNotDisplayed(Firstname);
        Firstname.clear();
        Firstname.sendKeys(firstname);


        WebElement Lastname = WebDriverFactory.getDriver().findElement(byLastname);
        WebDriverWaits.waitUntilElementNotDisplayed(Lastname);
        Lastname.clear();
        Lastname.sendKeys(lastname);


        WebElement phonenumber = WebDriverFactory.getDriver().findElement(byPhonenumber);
        WebDriverWaits.waitUntilElementNotDisplayed(phonenumber);
        phonenumber.clear();
        phonenumber.sendKeys(phonenum);


        WebElement Email = WebDriverFactory.getDriver().findElement(byEmail);
        WebDriverWaits.waitUntilElementNotDisplayed(Email);
        Email.clear();
        Email.sendKeys(email);

    }

    public void Click_DOBField()
    {
        WebDriverFactory.getDriver().findElement(byDateOfBirth).click();
    }

    public void ClickBackIcon()
    {
        WebDriverFactory.getDriver().findElement(byBackIcon).click();
    }

    public void Select_DOB()
    {
        WebDriverFactory.getDriver().findElement(bySelectDate).click();
    }

    public void dateOfBirth()
    {
        Click_DOBField();
        ClickBackIcon();
        Select_DOB();
    }

    public void Click_Savebutton()
    {
        WebElement savebutton = WebDriverFactory.getDriver().findElement(bySavebutton);
        savebutton.click();
    }

    public void Continue() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byContinue).click();

    }

    public void acceptAlertOk() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byAlertOk).click();

    }

    public boolean checkLoginScreen()
    {
        boolean loginscreen =  WebDriverFactory.getDriver().findElement(byCheckLoginScreen).isDisplayed();
        return loginscreen;
    }

}