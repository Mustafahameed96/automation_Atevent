package Objects;

import General.MainCall;
import General.WebDriverFactory;
import General.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by VD on 5/31/2018.
 */

public class PlanFlightPage
{
    String username = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
    String lastname = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
    String phonenum = MainCall.GENERIC_FUNCTIONS.generateRandomNum(7);

    public static By bySelectPassengers = By.cssSelector(".input_pax");
    public static By byPassengerList = By.className("list");
    public static By byPassengerWidgets = By.className("list-item");
    public static By byAddnewPax = By.className("pax-add-passenger-btn");
    public static By bySearchtext = By.id("searchText");
    public static By bySearchbutton = By.cssSelector(".btn.btn-search.font--caslon-sc");
    public static By byBackbutton = By.cssSelector(".btn--back");
    public static By byAddpaxbutton = By.xpath("//button[contains(text(), 'Add Passenger')]");
    public static By byAddbtn = By.cssSelector(".add-btn");
    public static By byAddclass = By.xpath("//button[contains(text(), 'Confirm')]");
    public static By byFirstname = By.id("firstname");
    public static By byLastname = By.id("lastname");
    public static By byEmail = By.id("email");
    public static By byPhonenumber = By.id("phoneNumber");
    public static By byDOB = By.id("dob");
    public static By byPreviousMonth = By.className("rdtPrev");
    public static By bySelectDate = By.className("rdtDay");
    public static By bySelectImage = By.cssSelector(".picture-upload");

    public void enterPassengerDetails(String firstname, String lastname, String phonenum)
    {
        WebDriverWaits.sleep(2000);
        WebElement Firstname =  WebDriverFactory.getDriver().findElement(byFirstname);
        WebDriverWaits.waitUntilElementNotDisplayed(Firstname);
        Firstname.sendKeys(firstname);

        WebElement Lastname = WebDriverFactory.getDriver().findElement(byLastname);
        WebDriverWaits.waitUntilElementNotDisplayed(Lastname);
        Lastname.sendKeys(lastname);

        WebElement phonenumber = WebDriverFactory.getDriver().findElement(byPhonenumber);
        WebDriverWaits.waitUntilElementNotDisplayed(phonenumber);
        phonenumber.sendKeys(phonenum);
        WebDriverWaits.sleep(2000);
    }

    public void selectDOB() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byDOB).click();
        Thread.sleep(1000);
        WebDriverFactory.getDriver().findElement(byPreviousMonth).click();
        Thread.sleep(1000);
        WebDriverFactory.getDriver().findElement(bySelectDate).click();
    }

    public void addNewPassenger() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElements(byPassengerWidgets).get(1).click();
        Thread.sleep(1000);
        WebDriverFactory.getDriver().findElement(byAddnewPax).click();
        enterPassengerDetails(username,lastname,phonenum);
        Thread.sleep(1000);
         WebDriverFactory.getDriver().findElement(byAddpaxbutton ).click();

    }

    public void addPassengerViaSearch() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElements(byPassengerWidgets).get(2).click();
        Thread.sleep(1000);
        WebDriverFactory.getDriver().findElement(bySearchtext).sendKeys("John");
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElement(bySearchbutton).click();
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElement(byAddbtn).click();
        Thread.sleep(1000);
    }

    public void addRecentPassenger() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElements(byPassengerWidgets).get(3).click();
        Thread.sleep(1000);

        WebDriverFactory.getDriver().findElement(byAddbtn).click();

    }

    public List<WebElement> getPassengerWidgetCount()
    {
        WebElement list = WebDriverFactory.getDriver().findElement(byPassengerList);
        List<WebElement> list_count = list.findElements(byPassengerWidgets);
        return list_count;
    }
    public void clickOnPassengerWidget() throws InterruptedException {

        List<WebElement> passengersWidgetList = getPassengerWidgetCount();
        for (int j = 0; j < passengersWidgetList.size(); j++)
        {
            if (j == 0)
            {
                addNewPassenger();

            }
            else if (j == 1)
            {
                addPassengerViaSearch();
            }
            else if( j== 2)
            {
                addRecentPassenger();
            }

        }

    }

    public void clickSelectPassengers()
    {
        WebDriverFactory.getDriver().findElement(bySelectPassengers).click();

    }
    public void clickConfirmPassengers()
    {
        WebDriverFactory.getDriver().findElement(byAddclass).click();

    }
}
