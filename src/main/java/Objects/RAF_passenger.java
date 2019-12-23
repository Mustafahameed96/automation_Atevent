package Objects;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RAF_passenger extends baseTest {

    public static By bylogout= By.cssSelector(".user-menu-header div:nth-of-type(2) .putTabIndex:nth-of-type(2)");
    public static By byPAFbtn = By.cssSelector(".hide-menu > .putTabIndex:nth-of-type(2)");
    public static By bymap = By.cssSelector("[tabindex=\"20\"]");

    public static By bydepart= By.xpath("//div[@id='ReactApp']//div[@class='container-fluid main-container']/div//div[@class='container-fluid']/div[2]/main[@class='container--medium']/section//article/ul/li[1]/div/div[1]/span[@class='airport--select']");
    public static By bydepartICAO = By.cssSelector("[aria-hidden=\"false\"] div li:nth-of-type(6)");

    public static By byarrival= By.xpath("//div[@id='ReactApp']//div[@class='container-fluid main-container']/div//div[@class='container-fluid']/div[2]/main[@class='container--medium']/section//article/ul/li[3]/div/div[1]/h4[@class='heading--destination']");

    public static By byarrivalICAO= By.cssSelector("[aria-hidden=\"false\"] div li:nth-of-type(42)");

    public static By bydd = By.cssSelector("[type=\"text\"]");
    //public static By bydd1= By.cssSelector("tbody tr:nth-of-type(5) [data-value=\"30\"]");

    public static By bydt = By.cssSelector("[placeholder=\"Departure Time\"]");
    public static By bypax = By.cssSelector(".input_pax");

    public static By byadd = By.cssSelector("div .btn--pax-selector.putTabIndex:nth-child(3)");
    public static By byconfirm = By.cssSelector(".background_color--gray.right");

    public static By byaircraft = By.cssSelector(".font_standard--color");
    public static By byaircraft1 = By.cssSelector("#aircraft-dropdown");


    public static By byplane= By.cssSelector(".aircraft_selector--control .putTabIndex:nth-of-type(1) strong span");
    public static By bynonplane= By.cssSelector(".aircraft_selector--control .putTabIndex:nth-of-type(2) span");

    public static By byNonContract = By.xpath("//span[contains(text(),'Confirm')]");


    public static By byrf = By.xpath("//a[@id='submitItinerary']/span[@class='text--modified']");
    public static By byrf1 = By.xpath("//a[@id='submitItinerary']/span[@class='text--modified']");
    public static By byYes =    By.xpath("//span[contains(text(),'Yes')]");
    public static By byNo =    By.xpath("//span[contains(text(),'No')]");
    public static By byviewitinerary = By.cssSelector(".summary-card > div:nth-of-type(3) span");





    public void logout(){
        WebElement MyAccount = WebDriverFactory.getDriver().findElement(bylogout);
        MyAccount.click();

        WebDriverWait lwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        lwait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.byLoginTopButton));
    }

    public  void planaflightscreen(String RAF) throws InterruptedException {

//        WebDriverWait PAFwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
//        PAFwait.until(ExpectedConditions.visibilityOfElementLocated(byPAFbtn));

        Thread.sleep(10000);
        WebElement Planaflight= new WebDriverFactory().getDriver().findElement(byPAFbtn);
        Planaflight.click();

        WebDriverWait mwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        mwait.until(ExpectedConditions.visibilityOfElementLocated(bymap));

        Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), RAF);
    }

   public void RAF() throws InterruptedException {

     //  Thread.sleep(10000);
       WebDriverWait departwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       departwait.until(ExpectedConditions.elementToBeClickable(bydepart));
      WebElement depart = new WebDriverFactory().getDriver().findElement(bydepart);
      depart.click();

       WebDriverWait departICAOwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       departICAOwait.until(ExpectedConditions.elementToBeClickable(bydepartICAO));
       WebElement departICAO = new WebDriverFactory().getDriver().findElement(bydepartICAO);
       departICAO.click();

       WebDriverWait arrivalwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       arrivalwait.until(ExpectedConditions.elementToBeClickable(byarrival));
       WebElement arrival = new WebDriverFactory().getDriver().findElement(byarrival);
              arrival.click();


       WebDriverWait arrivalICAOwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       arrivalICAOwait.until(ExpectedConditions.elementToBeClickable(byarrivalICAO));
       WebElement arrivalICAO = new WebDriverFactory().getDriver().findElement(byarrivalICAO);
             arrivalICAO.click();



       WebDriverWait Paxwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       Paxwait.until(ExpectedConditions.elementToBeClickable(bypax));
       WebElement Pax = new WebDriverFactory().getDriver().findElement(bypax);
              Pax.click();


       WebDriverWait addpaxwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       addpaxwait.until(ExpectedConditions.elementToBeClickable(byadd));
       WebElement addpax = new WebDriverFactory().getDriver().findElement(byadd);
           addpax.click();
           addpax.click();

       WebElement confirm= new WebDriverFactory().getDriver().findElement(byconfirm);
       confirm.click();

       WebElement aircraft = new WebDriverFactory().getDriver().findElement(byaircraft);
       aircraft.click();

       WebDriverWait saircraftwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       saircraftwait.until(ExpectedConditions.elementToBeClickable(byplane));
       WebElement saircraft= new WebDriverFactory().getDriver().findElement(byplane);
             saircraft.click();


       WebDriverWait aircraf1twait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       aircraf1twait.until(ExpectedConditions.elementToBeClickable(byaircraft1));
       WebElement aircraft1= new WebDriverFactory().getDriver().findElement(byaircraft1);
              aircraft1.click();

       WebDriverWait nonaircrafttwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       nonaircrafttwait.until(ExpectedConditions.elementToBeClickable(bynonplane));
       WebElement nonaircraft= new WebDriverFactory().getDriver().findElement(bynonplane);
              nonaircraft.click();


       WebDriverWait ncaircrafttwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       ncaircrafttwait.until(ExpectedConditions.elementToBeClickable(byNonContract));
       WebElement ncaircraft= new WebDriverFactory().getDriver().findElement(byNonContract);
              ncaircraft.click();

       Thread.sleep(2000);

       WebDriverWait Departdatetwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       Departdatetwait.until(ExpectedConditions.elementToBeClickable(bydd));
       WebElement Departdate = new WebDriverFactory().getDriver().findElement(bydd);
              Departdate.sendKeys("15 Oct 2018");

       Thread.sleep(2000);


       WebDriverWait departtimewait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       departtimewait.until(ExpectedConditions.elementToBeClickable(bydt));
       WebElement Departtime = new WebDriverFactory().getDriver().findElement(bydt);
       Departtime.sendKeys("04:25");


       WebDriverWait requestflightwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       requestflightwait.until(ExpectedConditions.elementToBeClickable(byrf));
       WebElement requestflight = new WebDriverFactory().getDriver().findElement(byrf);
       requestflight.click();

       WebDriverWait nwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       nwait.until(ExpectedConditions.visibilityOfElementLocated(byNo));

       WebElement Nconfirm = new WebDriverFactory().getDriver().findElement(byNo);
       Nconfirm.click();

       Thread.sleep(2000);
       WebDriverWait rf1wait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       rf1wait.until(ExpectedConditions.elementToBeClickable(byrf1));
       WebElement requestflight1 = new WebDriverFactory().getDriver().findElement(byrf1);
              requestflight1.click();

       WebDriverWait cwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
       cwait.until(ExpectedConditions.visibilityOfElementLocated(byYes));

       WebElement fconfirm = new WebDriverFactory().getDriver().findElement(byYes);
       fconfirm.click();

   }

    public  void confirm(String confirm) throws InterruptedException {


        WebDriverWait mwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        mwait.until(ExpectedConditions.visibilityOfElementLocated(byviewitinerary));

        Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), confirm);
    }


}


