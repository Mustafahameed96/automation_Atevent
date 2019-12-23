package Objects;

import General.WebDriverFactory;
import General.WebDriverWaits;
import General.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Created by VD on 5/9/2018.
 */
public class requestquotePage extends baseTest {

  //  public requestquotePage() {}

    public static By byDeptAirport = By.cssSelector("li.left-align");
    public static By byArrivalAirport = By.cssSelector("li.right-align");
    public static By bySelectairport = By.cssSelector("ul.airport--listing");
    public static By bytagname = By.tagName("li");
    public static By byDateField = By.cssSelector(".date-input");
    public static By byNextMonth = By.cssSelector(".rdtNext");
    public static By ByGetDates = By.cssSelector(".rdtDays");
    public static By ByCalendarbody = By.tagName("tbody");
    public static By ByCalendarow = By.tagName("tr");
    public static By byTimeField = By.cssSelector(".TimePicker--text-field");
    public static By byHours = By.cssSelector("ul.TimeList--scrollbar");
    public static By byMinutes = By.cssSelector(".TimePicker--minutes-list");
    public static By byPassengercount = By.cssSelector(".btn.btn--pax-selector.putTabIndex");
    public static By byAircraftlist = By.cssSelector(".aircraft_selector--dropdown");
    public static By bySelectAircraft = By.cssSelector("li.aircraft_selector--action");
    public static By byQuoterequestbtn = By.cssSelector(".col.s6.l3.right-align.no-padding");
    public static By byPurchase = (By.xpath("//span[contains(text(), 'Yes')]"));
    public static By byThankyouscreenverify = By.cssSelector(".right div:nth-child(1) button");

    public void selectDate() throws InterruptedException
    {
        WebElement date_field = WebDriverFactory.getDriver().findElement(byDateField);
        WebDriverWaits.waitUntilElementNotDisplayed(date_field);
        date_field.click();

        WebElement next_month = WebDriverFactory.getDriver().findElement(byNextMonth);
        WebDriverWaits.waitUntilElementNotDisplayed(next_month);
        next_month.click();

        List<WebElement> date = WebDriverFactory.getDriver().findElement(ByGetDates).findElement(ByCalendarbody).findElements(ByCalendarow);
        date.get(3).click();
    }

    public void selectTime()
    {
        WebElement time_field = WebDriverFactory.getDriver().findElement(byTimeField);
        time_field.click();

        WebElement select_hour = WebDriverFactory.getDriver().findElement(byHours);
        WebDriverWaits.waitUntilElementNotDisplayed(select_hour);
        select_hour.click();

        WebElement select_minutes = WebDriverFactory.getDriver().findElement(byMinutes);
        WebDriverWaits.waitUntilElementNotDisplayed(select_minutes);
        select_minutes.click();
    }

    public void clickDeptairport() throws InterruptedException
    {
        WebElement dept_airport = WebDriverFactory.getDriver().findElement(byDeptAirport);
        WebDriverWaits.waitUntilElementNotDisplayed(dept_airport);
        dept_airport.click();
    }

    public void clickArrivalairport() throws InterruptedException
    {
        WebElement arrival_airport = WebDriverFactory.getDriver().findElement(byArrivalAirport);
        WebDriverWaits.waitUntilElementNotDisplayed(arrival_airport);
        arrival_airport.click();

    }

    public List<WebElement> getAirports()
    {
        WebElement airport = WebDriverFactory.getDriver().findElement(bySelectairport);
        return airport.findElements(bytagname);
    }

    public void selectAirport(String airport_name)
    {
        List<WebElement> airports = getAirports();
        for (WebElement airport_list : airports)
        {
            if (airport_list.getText().trim().contains(airport_name))
            {
                WebDriverWaits.waitUntilElementNotDisplayed(airport_list);
                airport_list.click();
                break;
            }
        }
    }

    public void paxCount()
    {
        WebElement pax_count = WebDriverFactory.getDriver().findElements(byPassengercount).get(1);
        WebDriverWaits.waitUntilElementNotDisplayed(pax_count);
        pax_count.click();
    }

    public void clickAircraftwidget()
    {
        WebElement aircraft_widget = WebDriverFactory.getDriver().findElement(byAircraftlist);
        WebDriverWaits.waitUntilElementNotDisplayed(aircraft_widget);
        aircraft_widget.click();
    }


    public List<WebElement> getAircraft()
    {
        List<WebElement> aircraft_list = WebDriverFactory.getDriver().findElements(bySelectAircraft);
        return aircraft_list;
    }

    public void selectAircraft(String aircraft_name) {
        List<WebElement> aircrafts = getAircraft();
        for (WebElement aircraft_list : aircrafts) {
            if (aircraft_list.getText().trim().contains(aircraft_name)) {
                aircraft_list.click();
                break;
            }
        }
    }

    public void requestQuotebtn()
    {
        WebElement request_button = WebDriverFactory.getDriver().findElement(byQuoterequestbtn);
        WebDriverWaits.waitUntilElementNotDisplayed(request_button);
        request_button.click();
    }

    public void acceptPurchase() {
        WebDriverFactory.getDriver().findElement(byPurchase).click();
    }

    public String checkThankyouscreen() {
        String thankyou = WebDriverFactory.getDriver().findElement(byThankyouscreenverify).getText();
        return thankyou;
    }


}
