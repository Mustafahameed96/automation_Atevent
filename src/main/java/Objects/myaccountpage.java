package Objects;

import General.MainCall;
import General.WebDriverFactory;
import General.WebDriverWaits;
import General.baseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class myaccountpage extends baseTest {


    public static By byMenuAccount = By.cssSelector(".user-menu-header div:nth-of-type(2) .putTabIndex:nth-of-type(1)");
    public static By byChangePwdBtn = By.cssSelector(".change-password-btn span");
    public static By bypnotification = By.cssSelector(".center span");
    public static By byeProfile = By.cssSelector(".rigth span");
    public static By bympassport = By.cssSelector(".right-corner span");
    public static By byFname = By.id("first-name");
    public static By bylname = By.cssSelector(".user-profile-form .l6:nth-of-type(2) [type=\"text\"]");
    public static By byUemail = By.cssSelector(".user-profile-form .row:nth-of-type(4) [type]");
    public static By bymNO = By.cssSelector("[type=\"tel\"]");
    public static By byDOB = By.cssSelector(".new-date-picker-style input");
    public static By bysavebtn = By.cssSelector("[tabindex=\"108\"] span");
    public static By bycontinuebtn = By.cssSelector(".custom-dialog div:nth-child(3) div:nth-of-type(2) div:nth-of-type(1) div");
    public static By byok = By.cssSelector(".custom-dialog span");

    public static By bybacklogin = By.cssSelector(".back-to-login-button div:nth-of-type(1) div");











    public void lwait(){
        WebDriverWait lwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        lwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[tabindex=\"32\"] span")));
    }

    public void clickMyAccount(){
        WebElement MyAccount = WebDriverFactory.getDriver().findElement(byMenuAccount);
        MyAccount.click();
    }

    public void cWait(){
        WebDriverWait cwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        cwait.until(ExpectedConditions.visibilityOfElementLocated(byChangePwdBtn));

    }

    public void assertURL(String URL1){
        Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), URL1);
    }

    public void eprofile(){
        WebElement eprofile = WebDriverFactory.getDriver().findElement(byeProfile);
        eprofile.click();
    }

    public void await(){
        WebDriverWait await = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        await.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".user-profile-form .row:nth-of-type(2) .l6:nth-of-type(1) [type]")));
    }

    public void assertURL1(String URL2){
        Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), URL2);
    }

    public void assertfields(String firstname, String lastname, String id, String no ){


        WebElement fname = WebDriverFactory.getDriver().findElement(byFname);
        Assert.assertEquals(firstname,fname.getAttribute("value"));

        WebElement lname = WebDriverFactory.getDriver().findElement(bylname);
        Assert.assertEquals(lastname,lname.getAttribute("value"));

        WebElement uemail = WebDriverFactory.getDriver().findElement(byUemail);
        Assert.assertEquals(id,uemail.getAttribute("value"));

        WebElement mno = WebDriverFactory.getDriver().findElement(bymNO);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();

            Assert.assertEquals(no, mno.getAttribute("Value"));
        }
    }


    public void editfields(String URL3) throws InterruptedException {

        WebDriverFactory.getDriver().findElement(byUemail).clear();
        WebDriverFactory.getDriver().findElement(byUemail).sendKeys("waris1234@vd.com");

        WebDriverFactory.getDriver().findElement(byFname).clear();
        WebDriverFactory.getDriver().findElement(byFname).sendKeys("Shehzadaa");

        WebDriverFactory.getDriver().findElement(bylname).clear();
        WebDriverFactory.getDriver().findElement(bylname).sendKeys("Fahada");

        WebDriverFactory.getDriver().findElement(bymNO).clear();
        WebDriverFactory.getDriver().findElement(bymNO).sendKeys("+923476308291");

        WebDriverFactory.getDriver().findElement(byDOB).clear();
        WebDriverFactory.getDriver().findElement(byDOB).sendKeys("02 Jan 1991");

        Thread.sleep(5000);

        WebDriverFactory.getDriver().findElement(bysavebtn).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        WebDriverFactory.getDriver().findElement(bycontinuebtn).click();


        WebDriverWait logout = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        logout.until(ExpectedConditions.visibilityOfElementLocated(loginPage.byLoginTopButton));

        WebDriverFactory.getDriver().findElement(byok).click();

        Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), URL3);



    }

    public void login_with_confirmation(String uid, String pwd, String tokenUrl, String verifyUrl) throws InterruptedException {


        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(loginPage.byEmail).sendKeys(uid);
        WebDriverFactory.getDriver().findElement(loginPage.byPassword).sendKeys(pwd);
        WebDriverFactory.getDriver().findElement(loginPage.byLoginButton).click();
        Thread.sleep(5000);
        WebDriverFactory.getDriver().navigate().to(tokenUrl + uid);
        String token = MainCall.registerPage.getToken();

        WebDriverFactory.getDriver().navigate().to(verifyUrl + token);
        Thread.sleep(20000);

        MainCall.registerPage.clickContinue();
        Thread.sleep(2000);

        MainCall.registerPage.acceptAlertOk();
        org.testng.Assert.assertTrue(MainCall.registerPage.checkVerifiedAccount().equals("Your account is verified"),"Account is not verified");


        WebDriverFactory.getDriver().findElement(bybacklogin).click();
        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(loginPage.byLoginTopButton).click();
        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(loginPage.byEmail).sendKeys(uid);
        WebDriverFactory.getDriver().findElement(loginPage.byPassword).sendKeys(pwd);
        WebDriverFactory.getDriver().findElement(loginPage.byLoginButton).click();


        WebDriverWait lwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        lwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[tabindex=\"32\"] span")));

    }

    public void edit_fields_to_previous(String URL3) throws InterruptedException {

        WebDriverFactory.getDriver().findElement(byFname).clear();
        WebDriverFactory.getDriver().findElement(byFname).sendKeys("Shehzada");

        WebDriverFactory.getDriver().findElement(bylname).clear();
        WebDriverFactory.getDriver().findElement(bylname).sendKeys("Fahad");

        WebDriverFactory.getDriver().findElement(bymNO).clear();
        WebDriverFactory.getDriver().findElement(bymNO).sendKeys("+923477393671");

        WebDriverFactory.getDriver().findElement(byDOB).clear();
        WebDriverFactory.getDriver().findElement(byDOB).sendKeys("02 Jan 1992");

        WebDriverFactory.getDriver().findElement(byUemail).clear();
        WebDriverFactory.getDriver().findElement(byUemail).sendKeys("zubair7541@vd.com");

        Thread.sleep(20000);

        WebDriverFactory.getDriver().findElement(bysavebtn).click();



        WebDriverFactory.getDriver().findElement(bycontinuebtn).click();
        Thread.sleep(20000);


        WebDriverWait logout = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        logout.until(ExpectedConditions.visibilityOfElementLocated(loginPage.byLoginTopButton));

        WebDriverFactory.getDriver().findElement(byok).click();

        Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), URL3);

    }

    public void loginagain_with_confirmation (String id, String pwd, String tokenUrl, String verifyUrl ) throws InterruptedException {

        WebDriverFactory.getDriver().findElement(loginPage.byEmail).sendKeys(id);
        WebDriverFactory.getDriver().findElement(loginPage.byPassword).sendKeys(pwd);
        WebDriverFactory.getDriver().findElement(loginPage.byLoginButton).click();

        Thread.sleep(5000);
        WebDriverFactory.getDriver().navigate().to(tokenUrl + id);
        String token = MainCall.registerPage.getToken();

        WebDriverFactory.getDriver().navigate().to(verifyUrl + token);
        Thread.sleep(20000);

        MainCall.registerPage.clickContinue();
        Thread.sleep(2000);

        MainCall.registerPage.acceptAlertOk();
        org.testng.Assert.assertTrue(MainCall.registerPage.checkVerifiedAccount().equals("Your account is verified"),"Account is not verified");


        WebDriverFactory.getDriver().findElement(bybacklogin).click();
        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(loginPage.byLoginTopButton).click();
        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(loginPage.byEmail).sendKeys(id);
        WebDriverFactory.getDriver().findElement(loginPage.byPassword).sendKeys(pwd);
        WebDriverFactory.getDriver().findElement(loginPage.byLoginButton).click();


        WebDriverWait lwait = new WebDriverWait(WebDriverFactory.getDriver(), 20);
        lwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[tabindex=\"32\"] span")));

    }
}
