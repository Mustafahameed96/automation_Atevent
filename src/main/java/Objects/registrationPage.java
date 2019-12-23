package Objects;

import General.WebDriverFactory;
import General.WebDriverWaits;
import General.baseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class registrationPage  extends baseTest {

    public registrationPage(){}

    //Registration Page Locators

    public static By byRegisterButtonOnTop = By.cssSelector(".user-menu-header button");
    public static By byFirstName = By.id("firstName");
    public static By byLastName = By.cssSelector("input[id*='LastName']");
    public static By byGender = By.cssSelector(".s6 > div");
    public static By byCompany = By.cssSelector("input[id*='Company']");
    public static By byCountry = By.className("react-autosuggest__input");
    public static By byPhone = By.cssSelector(".intl-tel-input > input");
    public static By byEmail = By.cssSelector("input[id*='EmailAddressUsername']");
    public static By byRetypeEmail = By.cssSelector("input[id*='RetypeEmailAddress']");
    public static By byPassword = By.cssSelector("input[id*='Password']");
    public static By byRetypePassword = By.cssSelector("input[id*='RetypePassword']");
    public static By byRegister = By.cssSelector(".register-btn > button");
    public static By byConfirmationText = By.className("sub-title");
    public static By byVerifyAccountText = By.className("title");
    public static By byContinueBtn = By.className("save-button");
    public static By byAlertOk = By.cssSelector(".custom-dialog button");
    public static By byTermsConditions = By.cssSelector("label[for='terms-conditions']");

    //Registration Page Functions
    public void clickRegisterButtonTop()
    {
        WebDriverFactory.getDriver().findElement(byRegisterButtonOnTop).click();
    }

    public void enterUserName(String firstName, String lastName)
    {
        WebDriverFactory.getDriver().findElement(byFirstName).sendKeys(firstName);
        WebDriverFactory.getDriver().findElement(byLastName).sendKeys(lastName);
        WebDriverWaits.sleep(1000);
    }

    public void enterGender()
    {
        Actions action = new Actions(WebDriverFactory.getDriver());
        action.click(WebDriverFactory.getDriver().findElement(byGender)).build().perform();
        WebDriverWaits.sleep(1000);
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        WebDriverWaits.sleep(1000);
        action.sendKeys(Keys.ENTER).build().perform();
        WebDriverWaits.sleep(1000);
    }

    public void enterCompany(String companyName)
    {
        WebDriverFactory.getDriver().findElement(byCompany).sendKeys(companyName);
    }

    public void enterCountry(String countryName)
    {
        WebDriverFactory.getDriver().findElement(byCountry).sendKeys(countryName);
        WebDriverFactory.getDriver().findElement(byCountry).sendKeys(Keys.TAB);
    }

    public void enterPhone(String phone)
    {
        WebDriverFactory.getDriver().findElement(byPhone).sendKeys(phone);
    }

    public void enterDetails(String company, String country, String phone)
    {
        enterGender();
        enterCompany(company);
        enterCountry(country);
        enterPhone(phone);
    }

    public String enterMail(String email, String retypeEmail)
    {
        WebDriverFactory.getDriver().findElement(byEmail).sendKeys(email);
        WebDriverFactory.getDriver().findElement(byRetypeEmail).sendKeys(retypeEmail);

        return email;
    }

    public void enterPassword(String pwd, String retypePwd)
    {
        WebDriverFactory.getDriver().findElement(byPassword).sendKeys(pwd);
        WebDriverFactory.getDriver().findElement(byRetypePassword).sendKeys(retypePwd);
        WebDriverWaits.sleep(1000);
    }

    public void acceptPrivacyPolicy() {
        scrollDown();
        WebDriverFactory.getDriver().findElement(byTermsConditions).click();
    }

    public void scrollDown(){
        WebElement element = WebDriverFactory.getDriver().findElement(By.className("signup-card"));
        ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWaits.sleep(2000);
    }

    public void Register(){
        WebDriverFactory.getDriver().findElement(byRegister).click();
        WebDriverWaits.sleep(10000);
    }

    public String checkConfirmationText()
    {
        String confirmationText = WebDriverFactory.getDriver().findElement(byConfirmationText).getText();
        return confirmationText;
    }


    public String getToken()
    {
        String token = WebDriverFactory.getDriver().findElements(By.cssSelector("span[class='text']")).get(2).getText();
        return token;
    }

    public String checkVerifiedAccount()
    {
        String verifyAcc = WebDriverFactory.getDriver().findElement(byVerifyAccountText).getText();
        return verifyAcc;
    }

    public void clickContinue()throws InterruptedException
    {
        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(byContinueBtn).click();
        Thread.sleep(5000);
    }

    public void acceptAlertOk() throws InterruptedException
    {
        Thread.sleep(7000);
        WebDriverFactory.getDriver().findElement(byAlertOk).click();
        Thread.sleep(5000);
    }
}


