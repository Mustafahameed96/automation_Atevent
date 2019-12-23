package Objects;

import General.WebDriverFactory;
import General.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by VD on 5/26/2018.
 */
public class PopularDestinationFlowPage
{
    public PopularDestinationFlowPage(){}

    public static By byMenu  = By.className("menu-item");
    public static By byFindoutmorebutton = By.cssSelector(".pd-cont div:nth-child(2) button");
    public static By byGlobal = By.cssSelector(".row div:nth-child(1) div.pd-image");
    public static By byCities = By.cssSelector(".col.l4.m6.s12.cities");
    public static By byAirports = By.cssSelector(".col.l6.m6.s12.airport");
    public static By byRequestbutton = By.className("LandingPage__join-now-button");
    public static By byAcceptalert = By.cssSelector(".custom-dialog div:nth-child(2) button");
    public static By byCheckscreen = By.cssSelector("h4.vistajet-text");
    public static By byDashboardverify = By.tagName("h2");
    public static By byheading = By.cssSelector("div.container > p:nth-child(2)");
    public static By byheading1 = By.cssSelector("div.container > p:nth-child(3)");

    public void clickHome(){
        WebDriverFactory.getDriver().findElements(byMenu).get(0).click();
    }

    public String Dashboardverify()
    {
        String verifyscreen = WebDriverFactory.getDriver().findElement(byDashboardverify).getText();
        return verifyscreen;
    }

    public void clickFindbutton() {
        WebElement findoutmore = WebDriverFactory.getDriver().findElement(byFindoutmorebutton);
        findoutmore.click();
    }

    public void clickGlobal() {
        WebElement global = WebDriverFactory.getDriver().findElement(byGlobal);
        WebDriverWaits.waitUntilElementNotDisplayed(global);
        global.click();
    }

    public void selectCities()
    {
        WebElement cities = WebDriverFactory.getDriver().findElement(byCities);
        WebDriverWaits.waitUntilElementNotDisplayed(cities);
        cities.click();

    }

    public void selectDestinationAiport()
    {
        WebElement airports = WebDriverFactory.getDriver().findElement(byAirports);
        WebDriverWaits.waitUntilElementNotDisplayed(airports);
        airports.click();

    }

    public void clickRequestbutton()
    {
        WebElement Request = WebDriverFactory.getDriver().findElement(byRequestbutton);
        WebDriverWaits.waitUntilElementNotDisplayed(Request);
        Request.click();
    }

    public void acceptAlert() throws InterruptedException
    {
        WebElement alert =  WebDriverFactory.getDriver().findElement(byAcceptalert);
        alert.click();
        Thread.sleep(3000);
    }

    public String checkScreen()
    {
        String checkScreen = WebDriverFactory.getDriver().findElement(byCheckscreen).getText();
        return checkScreen;
    }


    public String getheading()
    {
        String heading = WebDriverFactory.getDriver().findElement(byheading).getText();
        return heading;
    }

    public void getheading1()
    {
        String heading1 = WebDriverFactory.getDriver().findElement(byheading1).getText();
        Assert.assertEquals(heading1, "Your next far away travel opportunity is just waiting for you.");
    }


}
