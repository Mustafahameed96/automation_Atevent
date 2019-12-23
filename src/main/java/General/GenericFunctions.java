package General;

import Objects.loginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

//import static Objects.planAFlightForDayOverFlightPage.by_timePicker;


/**
 * Created by VD on 5/8/2018.
 */
public class GenericFunctions {
    public static By byMenubar      = By.cssSelector("ul.menu");
    public static By byMenuitems    = By.cssSelector(".menu-item");
    public static By byOpenContractList = By.className("contract-options");
    public static By byContractList = By.xpath("//div[contains(text(), 'ACCOUNT TOP FSP ')]");
    public static By byOpenAircraftList = By.className("aircraft_selector");
    public static By byAircraftSelector = By.cssSelector("ul[class='aircraft_selector']");
    public static By byAircraftList = By.cssSelector("li[class='aircraft_selector--action putTabIndex']");
    public static By byNonContractPrompt = By.xpath("//span[contains(text(), 'Confirm')]");
    public static By byPurchasePrompt = By.xpath("//span[contains(text(), 'Yes')]");
    public static By byDate = By.id("dob");
    public static By by_timePicker = By.name("time-picker-input");
    public static By byScreenAnywhere = By.className("back-size-contain");
    public static By byPassengerOption = By.className("passenger-n");
    public static By byIdentifyIncrementer = By.className("text-right");
    public static By byButton = By.tagName("button");
    public static By byConfirmPax = By.cssSelector("button[class='waves-effect waves-light btn background_color--gray right']");
    public static By bySelectDeparture = By.className("heading--destination");
    public static By byInputField = By.className("input-field");
    public static By byInput = By.tagName("input");
    public static By bySelectArrival= By.className("airport--select");
    public static By byOk = By.xpath("//span[contains(text(), 'OK')]");
    public static By bySubmitRequest = By.id("submitItinerary");

    public List<WebElement> getElementOfMenubar()
    {
        WebElement menu = WebDriverFactory.getDriver().findElement(byMenubar);
        return menu.findElements(byMenuitems);
    }

    public void assertionsForMenubar(String[] menubaritems)
    {
        List<WebElement> menuBarElements = MainCall.GENERIC_FUNCTIONS.getElementOfMenubar();
        for (WebElement element : menuBarElements)
        {
            String text = element.getText();
            if (!text.trim().isEmpty())
            {
                Assert.assertTrue(Arrays.asList(menubaritems).contains(text.trim()));
            }
        }
    }

    public void clickOnMenuBar(String itemName) throws InterruptedException {
        List<WebElement> menuBarItems = getElementOfMenubar();
        for (WebElement menuItem : menuBarItems)
        {
            if (menuItem.getText().trim().equals(itemName))
            {
                menuItem.click();
                break;
            }
        }
        Thread.sleep(4000);
    }


    public void clickOnSubMenuBar(String menuTag, String subMenuTag) throws InterruptedException {
        List<WebElement> menuBarItems = getElementOfMenubar();
        for (WebElement menuItem : menuBarItems)
        {
            if (menuItem.getText().trim().equals(menuTag))
            {
                menuItem.click();
                clickOnMenuBar(subMenuTag);
            }
        }
    }

//    public void clickOptionInMenubar(int a) {
//        WebElement menu = WebDriverFactory.getDriver().findElement(byMenubar);
//        WebElement request_btn = menu.findElements(byMenuitems).get(a);
//        WebDriverWaits.waitUntilElementNotDisplayed(request_btn);
//        request_btn.click();
//    }
//
    public static String generateRandomNum(int length)
    {
        String RawRandomNumber = RandomStringUtils.randomNumeric(length);
        return RawRandomNumber;
    }

    public static String generateAlphaNumeric(String s, int length)
    {
        String RawRandomNumber = RandomStringUtils.randomNumeric(length);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        stringBuilder.append(RawRandomNumber);
        return stringBuilder.toString();
    }

    public static String RandomPhoneNumber(String RawRandomNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+92300");
        stringBuilder.append(RawRandomNumber);
        return stringBuilder.toString();
    }

    public static String generateRandomString(int length) {
        String name = RandomStringUtils.randomAlphabetic(length);
        String first_letter = name.substring(0, 1).toUpperCase();
        String other_letters = name.substring(1).toLowerCase();
        String finalname = first_letter + other_letters;
        return finalname;
    }

    public static String generateEmail(String finalname)
    {
        return finalname + "@vd.com";
    }

    public void selectContract() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byOpenContractList).click();
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElements(byContractList).get(0).click();
        Thread.sleep(2000);
    }

    public void selectAircraft() throws InterruptedException
    {
        Thread.sleep(4000);
        WebDriverFactory.getDriver().findElement(byOpenAircraftList).click();
        WebDriverFactory.getDriver().findElement(byAircraftSelector).findElements(byAircraftList).get(1).click();
        //if non-contract aircraft prompt appears
        try {
            if (WebDriverFactory.getDriver().findElement(byNonContractPrompt).isDisplayed()) {
                {
                    WebDriverFactory.getDriver().findElement(byNonContractPrompt).click();
                    Thread.sleep(2000);
                }
            }
        } catch (Exception e) {
            Thread.sleep(1000);
        }
    }

    public void selectRandomDate(String date) throws InterruptedException
    {
        Thread.sleep(3000);
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.sendKeys(WebDriverFactory.getDriver().findElement(byDate), date).build().perform();
        Thread.sleep(2000);
    }

    public void selectRandomTime(String time) throws InterruptedException {
        //select time
        Thread.sleep(3000);
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.sendKeys(WebDriverFactory.getDriver().findElement(by_timePicker), (Keys.BACK_SPACE)).build().perform();
        action.sendKeys(WebDriverFactory.getDriver().findElement(by_timePicker), time).build().perform();
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElement(byScreenAnywhere).click();
    }

    public void selectPassenger() throws InterruptedException
    {
        //add 1 passenger
        WebDriverFactory.getDriver().findElement(byPassengerOption).click();
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElement(byIdentifyIncrementer).findElements(byButton).get(1).click();
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElement(byConfirmPax).click();
    }

    public void selectDirectPassenger ()
    {
        WebDriverFactory.getDriver().findElement(byPassengerOption).findElements(byButton).get(1).click();
    }

    public void selectDepartureAirport(String airport) throws InterruptedException
    {
        Thread.sleep(3000);
        WebDriverFactory.getDriver().findElement(bySelectDeparture).click();
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.sendKeys(WebDriverFactory.getDriver().findElement(byInputField).findElement(byInput), airport).build().perform();
        Thread.sleep(2000);
    }

    public void selectArrivalAirport(String airport) throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(bySelectArrival).click();
        Thread.sleep(2000);
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.sendKeys(WebDriverFactory.getDriver().findElement(byInputField).findElement(byInput), airport).build().perform();
        //fuel stop prompt
        try
        {
            if (WebDriverFactory.getDriver().findElement(byOk).isDisplayed())
            {
                WebDriverFactory.getDriver().findElement(byOk).click();
                    Thread.sleep(2000);
            }
        }
        catch (Exception e)
        {
            Thread.sleep(1000);
        }
    }

    public void selectRequestFlightButton() throws InterruptedException {
        WebDriverFactory.getDriver().findElement(bySubmitRequest).click();
        Thread.sleep(2000);
        //Are you happy to confirm your purchase?
        WebDriverFactory.getDriver().findElement(byPurchasePrompt).click();
        Thread.sleep(10000);
    }

} 