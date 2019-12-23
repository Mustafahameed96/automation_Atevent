package Objects;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static Objects.addPassengerAndPassportPage.by_itineraries_button;
import static Objects.customerFeedbackPage.byFlightContainer;

public class MyItineraryPage extends baseTest {

    public MyItineraryPage(){}

    public static By byTitleName = By.cssSelector(".user-menu-header > div > div > div > div");
    public static By byMyAccountButton = By.xpath("//span[contains(text(),'My Account')]");
    public static By byManagePassportButton = By.className("my-account-container");
    public static By byTagButton = By.tagName("button");
    public static By byClickonNewPassport = By.xpath("//span[contains(text(), 'New Passport')]");
    public static By byEnterPassportNumber = By.id("passport-number");
    public static By byEnterDisplayName = By.id("display-name");
    public static By byClickonNationality = By.className("react-autosuggest__input");
    public static By byClickonIssuingCountry = By.className("react-autosuggest__input");
    public static By byClickOnExpiryDate = By.className("form-control");
    public static By byrdtSwitch = By.className("rdtSwitch");
    public static By byrdtNext = By.className("rdtNext");
    public static By byrdtMonth = By.className("rdtMonth");
    public static By byrdtDay = By.className("rdtDay");
    public static By byDefaultPassportCheck = By.className("default-passport-checkbox");
    public static By byCreatePassportButton = By.className("save-btn");
    public static By byPassportAddedPrompt = By.xpath("//span[contains(text(), 'OK')]");
    public static By byMyItineraryTopButton = By.cssSelector("ul.menu");
    public static By byMyItineraryTopButton2 = By.cssSelector("div.menu-item");
    public static By byPassengerViewIcon = By.className("icon-text-view");
    public static By byMyItinerary = By.xpath("//div[contains(text(), 'My Itineraries')]");
    public static By byClickUpcomingFlight = By.id("upcoming");
    public static By byAddPassenger = By.cssSelector("button[class='waves-effect waves-light btn background_color--gray left']");
    public static By bySearchPax = By.id("searchText");
    public static By bySearchButton = By.className("btn-search");
    public static By byAddButton = By.className("add-btn");
    public static By byClickonPaxDetails = By.className("list-name");
    public static By bybackbutton = By.className("btn--back");
    public static By byConfirmPaxButton = By.cssSelector("button[class='waves-effect waves-light btn background_color--gray right']");
    public static By byPaxDetailRow = By.className("Passenger--accordion");
    public static By byScrollDown = By.className("information-responsive");
    public static By byClickonPaxViewIcon = By.className("icon-Passengers");
    public static By byAddaNewPaxButton = By.cssSelector(".pax-add-passenger > span"); //By.className("pax-add-passenger-btn");
    public static By byPaxFirstName = By.id("firstname");
    public static By byPaxLastName = By.id("lastname");
    public static By byPaxDOB = By.id("dob");
    public static By byGender = By.cssSelector("select[class='dialog-textarea margin--zero putTabIndex']");
    public static By byEmail = By.id("email");
    public static By byPhoneNumber = By.id("phoneNumber");
    public static By byAddPassportButton = By.cssSelector("button[class='btn waves-effect waves-light background_color--gray putTabIndex']");
    public static By byPaxPassportNumber = By.id("passportNumber");
    public static By byPaxExpiryDate = By.id("dob");
    public static By byPassportDisplayName = By.id("displayName");
    public static By bySelectPaxNationality  = By.id("nationality");
    public static By bySelectPaxIssuingCountry  = By.id("issuingCountry");
    public static By byConfirmPassporButton = By.cssSelector("button[class='waves-effect waves-light btn background_color--gray right putTabIndex']");
    public static By byAddPax = By.cssSelector("button[class='btn waves-effect waves-light background_color--gray right putTabIndex']");
    public static By byRemovePax = By.className("remove-passenger");
    public static By byPassengerRow = By.className("list-item");



    public String checkUserName()
    {
        String titleName = WebDriverFactory.getDriver().findElement(byTitleName).getText();
        return titleName;
    }


    public void clickMyAccountButton() throws InterruptedException
    {
        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(byMyAccountButton).click();
        Thread.sleep(5000);
    }

    public void clickonManagePassport() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byManagePassportButton).findElements(byTagButton).get(4).click();
        Thread.sleep(5000);
    }

    public void AddNewPassport() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byClickonNewPassport).click();
        Thread.sleep(5000);
    }


    public void enterPasspordNumber(String passportNumber)
    {
        WebDriverFactory.getDriver().findElement(byEnterPassportNumber).sendKeys(passportNumber);

    }

    public void enterDisplayName(String PassportName)
    {
        WebDriverFactory.getDriver().findElement(byEnterDisplayName).sendKeys(PassportName);
    }

    public void enterNationality(String Nationality)
    {
        WebDriverFactory.getDriver().findElement(byClickonNationality).sendKeys(Nationality);
    }

    public void enterIssuingCountry(String IssuingCountry)
    {
        WebDriverFactory.getDriver().findElements(byClickonIssuingCountry).get(1).sendKeys(IssuingCountry);
    }


    public void enterPassportDetails(String passportNumber, String PassportName, String Nationality, String IssuingCountry)
    {
        enterPasspordNumber(passportNumber);
        enterDisplayName(PassportName);
        enterNationality(Nationality);
        enterIssuingCountry(IssuingCountry);
    }


    public void passportDatePicker()
    {
        WebDriverFactory.getDriver().findElement(byClickOnExpiryDate).click();
        passportDatePickerSwitch();
    }

    public void passportDatePickerSwitch()
    {
        WebDriverFactory.getDriver().findElement(byrdtSwitch).click();
        WebDriverFactory.getDriver().findElement(byrdtNext).click();
        WebDriverFactory.getDriver().findElements(byrdtMonth).get(3).click();
        WebDriverFactory.getDriver().findElements(byrdtDay).get(10).click();
    }


    public void passportCheckbox()
    {
        WebDriverFactory.getDriver().findElement(byDefaultPassportCheck).click();
    }

    public void createPassport() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byCreatePassportButton).click();
        Thread.sleep(7000);
        WebDriverFactory.getDriver().findElement(byPassportAddedPrompt).click();
        Thread.sleep(5000);
    }

    public void  clickMyItineraryTabPage() throws InterruptedException {
        Thread.sleep(15000);

        WebDriverFactory.getDriver().findElement(by_itineraries_button).click();
        Thread.sleep(10000);
    }

    public void clickonFlightDetails() throws InterruptedException
    {
        Thread.sleep(10000);
        WebDriverFactory.getDriver().findElement(byClickUpcomingFlight).findElements(byFlightContainer).get(0).click();
        Thread.sleep(20000);
    }

    public void clickonPassengerViewIcon() throws InterruptedException
    {
        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(byPassengerViewIcon).click();
        Thread.sleep(5000);
    }

    public void clickonAddPassengerButton()
    {
        WebDriverFactory.getDriver().findElement(byAddPassenger).click();
    }

    public void searchPassenger(String SearchPax)
    {
        WebDriverFactory.getDriver().findElement(bySearchPax).sendKeys(SearchPax);
    }

    public void searchButton() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(bySearchButton).click();
        Thread.sleep(5000);

    }

    public void addsearchedPax() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byAddButton).click();
        Thread.sleep(3000);
    }

    public void clickonAddedPaxDetails(String SearchPax, String passportNumber) throws InterruptedException
    {
        Thread.sleep(3000);
        Boolean findPax = false;
        Boolean findPassport = false;
        List<WebElement> paxList = WebDriverFactory.getDriver().findElements(byClickonPaxDetails);
        for (WebElement element : paxList)
        {
            if(element.getText().contains(SearchPax))
            {
                element.click();
                findPax = true;
            }
            if(findPax == true) break;
        }

        List<WebElement> passportDetails = WebDriverFactory.getDriver().findElements(By.className("DOB"));
        for(WebElement passport : passportDetails)
        {
            if(passport.getText().contains(passportNumber))
            {
                findPassport = true;
                WebDriverFactory.getDriver().findElement(bybackbutton).click();
            }
            if(findPassport == true) break;
        }

        if(findPassport == false)
        {
            WebDriverFactory.getDriver().findElement(bybackbutton).click();
            System.out.println("Passport not added successfully");
        }

    }

    public void confirmPaxButton() throws InterruptedException
    {
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElement(byConfirmPaxButton).click();
        Thread.sleep(8000);
    }

    public void PaxDetailsOnItinerary() throws InterruptedException
    {
        Thread.sleep(5000);
        WebElement CT = WebDriverFactory.getDriver().findElement(By.className("icon-crew"));
        JavascriptExecutor jsx = (JavascriptExecutor)WebDriverFactory.getDriver();
        jsx.executeScript("arguments[0].scrollIntoView(true);",CT);
        Thread.sleep(11000);

        WebDriverFactory.getDriver().findElement(byPaxDetailRow).click();

//        WebDriverFactory.getDriver().findElement(byPaxDetailRow).click();
    }

    public void scrollDown() throws InterruptedException
    {
        WebElement SD = WebDriverFactory.getDriver().findElement(byScrollDown);
        JavascriptExecutor jsx = (JavascriptExecutor)WebDriverFactory.getDriver();
        jsx.executeScript("scroll(0, 550);");

        Thread.sleep(4000);
    }

    public void clickonPaxSection() throws InterruptedException
    {
        Thread.sleep(2000);
        WebDriverFactory.getDriver().findElement(byClickonPaxViewIcon).click();
        confirmPaxButton();
    }

    public void removePax() throws InterruptedException
    {

        Thread.sleep(3000);
        WebDriverFactory.getDriver().findElement(byPassengerRow).click();
        Thread.sleep(4000);
        WebDriverFactory.getDriver().findElement(byRemovePax).click();
        Thread.sleep(5000);
    }

    public void addNewPaxButton()
    {
        WebDriverFactory.getDriver().findElement(byAddPassenger).click();
        WebDriverFactory.getDriver().findElement(byAddaNewPaxButton).click();
    }

    public void enterFirstName(String FirstName)
    {
        WebDriverFactory.getDriver().findElement(byPaxFirstName).sendKeys(FirstName);
    }

    public void enterLastName(String LastName)
    {
        WebDriverFactory.getDriver().findElement(byPaxLastName).sendKeys(LastName);
    }

    public void enterDOB (String DOB)
    {
        WebDriverFactory.getDriver().findElement(byPaxDOB).sendKeys(DOB);
    }

    public void enterGender()
    {
        WebElement mySelectElement = WebDriverFactory.getDriver().findElement(byGender);
        Select dropdown= new Select(mySelectElement);
        dropdown.selectByVisibleText("Female");
    }

    public void enterEmail(String Email)
    {
        WebDriverFactory.getDriver().findElement(byEmail).sendKeys(Email);
    }

    public void enterphoneNumber(String PhoneNumber)
    {
        WebDriverFactory.getDriver().findElement(byPhoneNumber).sendKeys(PhoneNumber);
    }


    public void enterPaxUserName(String FirstName, String LastName)
    {
        enterFirstName(FirstName);
        enterLastName(LastName);
    }

    public void enterPaxDetails(String DOB, String Email, String PhoneNumber)
    {
        enterDOB(DOB);
        enterEmail(Email);
        enterphoneNumber(PhoneNumber);
    }

    public void addPassportButton() throws InterruptedException
    {
        WebDriverFactory.getDriver().findElement(byAddPassportButton).click();
        Thread.sleep(3000);
    }

    public void enterPaxPassportNumber(String PaxPassportNumber)
    {
        WebDriverFactory.getDriver().findElement(byPaxPassportNumber).sendKeys(PaxPassportNumber);
    }

    public void enterPassportDisplayName(String PassportDisplayName)
    {
        WebDriverFactory.getDriver().findElement(byPassportDisplayName).sendKeys(PassportDisplayName);
    }

    public void enterPaxPassportDetails(String PaxPassportNumber, String PassportDisplayName)
    {
        enterPaxPassportNumber(PaxPassportNumber);
        enterPassportDisplayName(PassportDisplayName);
    }

    public void passportPaxDatePicker()
    {
        WebDriverFactory.getDriver().findElement(byPaxExpiryDate).click();
         passportDatePickerSwitch();
    }

    public void enterPaxNationality(String PaxNationality)
    {
        WebElement selectNationality = WebDriverFactory.getDriver().findElement(bySelectPaxNationality);
        Select dropdown1 = new Select(selectNationality);
        dropdown1.selectByVisibleText(PaxNationality);
    }


    public void enterPaxIssuingCounrty(String PaxIssuingCountry)
    {
        WebElement selectIssuingCountry = WebDriverFactory.getDriver().findElement(bySelectPaxIssuingCountry);
        Select dropdown2 = new Select(selectIssuingCountry);
        dropdown2.selectByVisibleText(PaxIssuingCountry);
    }

    public void ConfirmPassporButton()
    {
        WebDriverFactory.getDriver().findElement(byConfirmPassporButton).click();
    }

    public void addPax() throws InterruptedException {
        WebDriverFactory.getDriver().findElement(byAddPax).click();
        confirmPaxButton();
        Thread.sleep(4000);
    }

    public String checkPaxAdded()
    {
        return WebDriverFactory.getDriver().findElement(By.cssSelector(".truncate:nth-child(3)")).getText();
    }
}




