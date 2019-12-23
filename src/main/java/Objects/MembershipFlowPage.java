package Objects;

import General.WebDriverFactory;
import General.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Objects.loginPage.byEmail;
import static Objects.loginPage.byPassword;
import static Objects.myaccountpage.bybacklogin;

/**
 * Created by VD on 5/27/2018.
 */
public class MembershipFlowPage
{
    public MembershipFlowPage(){}

    public static WebElement address;
    public static WebElement cities;
    public static WebElement cardnum;
    public static WebElement Cvv;
    public static WebElement exp;

    public static By byJoinMembership = By.xpath("//span[contains(text(), 'Join Now')]");
    public static By byContinue = By.cssSelector(".footer-membership-plan div:nth-child(2) button");
    public static By byAddress = By.id("address");
    public static By byCity = By.id("city");
    public static By byContinueToPayment = (By.cssSelector(".footer-box > div > div:nth-child(2) > div"));
    public static By byToPaymentscreen = (By.cssSelector(".billing-address .col.m6.l6:nth-child(2) button"));
    public static By bySelectCard = (By.className("clear-after"));
    public static By byCreditcard = (By.cssSelector("input[id*='credit-card-number']"));
    public static By byCVV = (By.cssSelector("input[id*='credit-card-cvv']"));
    public static By byExpirydate = (By.cssSelector("input[id*='credit-card-expiry-date']"));
    public static By byAddcardbutton = By.className("save-btn");
    public static By bycheckTerms = By.cssSelector(".checkbox");
    public static By bysecurity = By.id("security-code");
    public static By byContinuemembership =  (By.cssSelector(".select-payment-container > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > button"));
    public static By byLoginButton = By.xpath("//span[contains(text(), 'Login')]");
    public static By byHome = By.xpath("//span[contains(text(), 'Home')]");
    public static By byOKButton = By.xpath("//span[contains(text(), 'OK')]");
    public static By byAndroidText = By.cssSelector("a[href*='vistajet.app.android']");

    public void login(String email, String pwd) {
        WebDriverFactory.getDriver().findElement(bybacklogin).click();
        WebDriverFactory.getDriver().findElement(byEmail).sendKeys(email);
        WebDriverFactory.getDriver().findElement(byPassword).sendKeys(pwd);

    }

    public void clickJoinMembership()
    {
        WebElement join_membership = WebDriverFactory.getDriver().findElement(byJoinMembership);
        WebDriverWaits.waitUntilElementNotDisplayed(join_membership);
        join_membership.click();
    }

    public void clickContinue()
    {
        WebElement next_page = WebDriverFactory.getDriver().findElement(byContinue);
        WebDriverWaits.waitUntilElementNotDisplayed(next_page);
        next_page.click();

    }

    public void enterBillingdetails(String add, String city)
    {
        address = WebDriverFactory.getDriver().findElement(byAddress);
        address.sendKeys(add);

        cities = WebDriverFactory.getDriver().findElement(byCity);
        cities.sendKeys(city);

        WebDriverFactory.getDriver().findElement(By.className("country-autosuggest__input")).sendKeys("Pakistan\n");
        WebDriverFactory.getDriver().findElement(byContinueToPayment).click();

    }

    public void selectPaymentmethod()
    {
       WebElement payment_method =  WebDriverFactory.getDriver().findElement(bySelectCard);
        WebDriverWaits.waitUntilElementNotDisplayed(payment_method);
        payment_method.click();
    }

    public void enterCarddetails(String num, String CVV, String expdate)
    {
        cardnum = WebDriverFactory.getDriver().findElement(byCreditcard);
        Actions actions = new Actions(WebDriverFactory.getDriver());
        actions.moveToElement(cardnum);
        actions.click();
        actions.sendKeys(num);
        actions.build().perform();

        Cvv = WebDriverFactory.getDriver().findElement(byCVV);
        Cvv.sendKeys(CVV);

        exp = WebDriverFactory.getDriver().findElement(byExpirydate);
        exp.sendKeys(expdate);
    }

    public void clickAddcardButton()
    {
        WebDriverFactory.getDriver().findElement(byAddcardbutton).click();
    }

    public void checkTerms()
    {
       WebElement terms_cond =  WebDriverFactory.getDriver().findElement(bycheckTerms);
        WebDriverWaits.waitUntilElementNotDisplayed(terms_cond);
        terms_cond.click();
    }

    public void enterCVV(String cc)
    {
        WebDriverFactory.getDriver().findElement(bysecurity).sendKeys(cc);
    }

    public void clickContinueMembership()
    {
        WebDriverFactory.getDriver().findElement(byContinuemembership).click();
    }

    public String checkThankYouText()
    {
        String ThankYouText = WebDriverFactory.getDriver().findElement(byAndroidText).getTagName();
        return ThankYouText;
    }

    public void ClickHomeButton() throws InterruptedException {
        WebDriverFactory.getDriver().findElement(byHome).click();
        Thread.sleep(5000);
    }

    public void ClickOKButton()
    {
        WebDriverFactory.getDriver().findElement(byOKButton).click();
    }


}