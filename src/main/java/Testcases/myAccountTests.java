package Testcases;

import General.GenericFunctions;
import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.util.Random;

import static org.testng.Assert.*;

public class myAccountTests extends baseTest{

    @Test(description = "Jira ID", priority = 1)
    public void MyAccountIntoVistaJeApplication() throws InterruptedException {
        Thread.sleep(4000);
        MainCall.myAccount.clickMyAccountButton();
        Thread.sleep(1000);
        MainCall.myAccount.EditProf();
        Thread.sleep(1000);
        MainCall.myAccount.clickProf();
        Thread.sleep(1000);

        String fName = GenericFunctions.generateRandomString(5);
        String lName = GenericFunctions.generateRandomString(5);

        MainCall.myAccount.enterFirstname(fName, lName);
        MainCall.myAccount.pickdate();
        MainCall.myAccount.save();

        Boolean isPresent = WebDriverFactory.getDriver().findElement(By.className("my-account-page")).isDisplayed();
        org.junit.Assert.assertTrue("Link not found", isPresent);

    }
}
