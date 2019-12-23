package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class RAF_add_passenger extends baseTest {

    String email= "Saddam@vd.com";
    String pwd="Vista786";
    String RAF="https://myqa.vistajet.com/#/request-flight";
    String confirm="https://myqa.vistajet.com/#/confirm-order";

    @Test(description = "Jira ID", priority = 3)
    public void test1() throws InterruptedException {

//        //logout
//        MainCall.RAF_passenger.logout();

        //login
        MainCall.loginPage.clickLoginTopButton();
        MainCall.loginPage.enterUserDetails(email,pwd);
        MainCall.loginPage.clickLogin();

        //homescreen wait
        MainCall.myaccountPage.lwait();

         //Go to plan a flight
        MainCall.RAF_passenger.planaflightscreen(RAF);

        //Plan a flight
        MainCall.RAF_passenger.RAF();

        //confirmation
        MainCall.RAF_passenger.confirm(confirm);


    }
}
