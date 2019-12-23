package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;

/**
 * Created by VD-Shireen on 5/18/2018.
 */
public class addPassengerAndPassportPage {

    public addPassengerAndPassportPage(){}

    public static By by_view                    = By.className("iview-title");
    public static By by_gender                  = By.className("selected-disabled");

    public static By by_addPax                  = By.cssSelector("button[class='waves-effect waves-light btn background_color--gray left']");
    public static By by_addPassport             = By.cssSelector("button[class='btn waves-effect waves-light background_color--gray putTabIndex']");
    public static By by_confirm_passport        = By.cssSelector("button[class='waves-effect waves-light btn background_color--gray right putTabIndex']");
    public static By by_confirm_pax             = By.cssSelector("button[class='btn waves-effect waves-light background_color--gray right putTabIndex']");
    public static By by_submit                  = By.cssSelector("button[class='waves-effect waves-light btn background_color--gray right']");
    public static By by_new_pax                 = By.cssSelector(".pax-add-passenger > span");

    public static By by_itineraries_button      = By.xpath("//span[contains(text(), 'View this Itinerary')]");

    public static By by_fname                   = By.id("firstname");
    public static By by_lname                   = By.id("lastname");
    public static By by_dob                     = By.id("dob");
    public static By by_email                   = By.id("email");
    public static By by_phoneNum                = By.id("phoneNumber");
    public static By by_passportNum             = By.id("passportNumber");
    public static By by_displayName             = By.id("displayName");
    public static By by_nationality             = By.id("nationality");
    public static By by_issuing_country         = By.id("issuingCountry");


    public void openPassengerView() throws InterruptedException {
        Thread.sleep(10000);
        WebDriverFactory.getDriver().findElements(by_view).get(2).click();
        Thread.sleep(5000);
    }

    public void addPax() throws InterruptedException {
        WebDriverFactory.getDriver().findElement(by_addPax).click();
        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(by_new_pax).click();
        Thread.sleep(2000);
    }

    public void paxDetails(String fName, String lName, String DOB, String email, String phoneNum) throws InterruptedException {
        WebDriverFactory.getDriver().findElement(by_fname).sendKeys(fName);
        WebDriverFactory.getDriver().findElement(by_lname).sendKeys(lName);
        WebDriverFactory.getDriver().findElement(by_dob).sendKeys(DOB);
        WebDriverFactory.getDriver().findElements(by_gender).get(1).click();  //gender
        WebDriverFactory.getDriver().findElement(by_email).sendKeys(email);
        WebDriverFactory.getDriver().findElement(by_phoneNum).sendKeys(phoneNum);
        Thread.sleep(3000);
    }

    public void addPassport() throws InterruptedException {
        WebDriverFactory.getDriver().findElement(by_addPassport).click();
        Thread.sleep(2000);
    }

    public void passportDetails(String passportNum, String expDate, String passportName, String Nationality, String issueCountry) throws InterruptedException {
        WebDriverFactory.getDriver().findElement(by_passportNum).sendKeys(passportNum);
        WebDriverFactory.getDriver().findElement(by_dob).sendKeys(expDate);
        WebDriverFactory.getDriver().findElement(by_displayName).sendKeys(passportName);
        WebDriverFactory.getDriver().findElement(by_nationality).sendKeys(Nationality);
        WebDriverFactory.getDriver().findElement(by_issuing_country).sendKeys(issueCountry);
        WebDriverFactory.getDriver().findElement(by_confirm_passport).click();
        WebDriverFactory.getDriver().findElement(by_confirm_pax).click();
        Thread.sleep(2000);
    }

    public void submit() throws InterruptedException {
        WebDriverFactory.getDriver().findElement(by_submit).click();
        Thread.sleep(2000);
    }
}
