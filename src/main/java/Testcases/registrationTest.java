package Testcases;

import General.GenericFunctions;
import General.baseTest;
import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import Objects.loginPage;
import Objects.registrationPage;
import General.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Config.configProperties.VerificationCodeUrl;
import static Config.configProperties.VerifyAccountUrl;
import static General.GenericFunctions.generateRandomNum;

public class registrationTest extends baseTest {

    String username     = GenericFunctions.generateRandomString(4);
    String email        = GenericFunctions.generateEmail(username);
    String lastname     = GenericFunctions.generateRandomString(6);
    String pwd          = "Vista123";
    String phoneNumber  = GenericFunctions.RandomPhoneNumber(generateRandomNum(7));
    String tokenUrl     = "";
    String verifyUrl    = "";

    @Test(description = "VWSHADOW-6527", priority = 0)
    //http://jira.vistajet.local/browse/VWSHADOW-6527
    public void registerIntoVistaJetApplication() throws InterruptedException {

        try {
            if (WebDriverFactory.getDriver().findElement(By.xpath("//span[contains(text(), 'Logout')]")).isDisplayed()) {
                {
                    loginPage.clickLogoutButton();
                    Thread.sleep(3000);
                    register();
                }
            }
        } catch (Exception e) {
            Thread.sleep(3000);
            register();
        }
    }

    public void register() throws InterruptedException {
        tokenUrl = VerificationCodeUrl;
        verifyUrl = VerifyAccountUrl;

        Thread.sleep(10000);
        MainCall.registerPage.clickRegisterButtonTop();
        Thread.sleep(30000);
        MainCall.registerPage.enterUserName(username, lastname);
        MainCall.registerPage.enterDetails("VD", "Pakistan",phoneNumber);
        MainCall.registerPage.enterMail(email, email);
        Thread.sleep(1000);
        MainCall.registerPage.enterPassword(pwd, pwd);
        MainCall.registerPage.acceptPrivacyPolicy();

        MainCall.registerPage.Register();
        Assert.assertTrue(MainCall.registerPage.checkConfirmationText().contains("A verification link has been sent to " + email.toLowerCase()), "Confirmation email not sent");

        WebDriverFactory.getDriver().navigate().to(tokenUrl + email);
        String token = MainCall.registerPage.getToken();

        Thread.sleep(4000);
        WebDriverFactory.getDriver().navigate().to(verifyUrl + token);
        Thread.sleep(20000);

        MainCall.registerPage.clickContinue();
        MainCall.registerPage.acceptAlertOk();
        Assert.assertTrue(MainCall.registerPage.checkVerifiedAccount().equals("Your account is verified"),"Account is not verified");

        MainCall.emailToLogin = email;
    }
}