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

public class Guest_myaccount extends baseTest {

    String URL1 = "https://myqa.vistajet.com/#/my-account";
    String URL2 = "https://myqa.vistajet.com/#/my-account/edit-profile";
    String URL3 =  "https://myqa.vistajet.com/#/login";
    String firstname = "Shehzada";
    String lastname = "Fahad";
    String no = "+92 347 7393671";
    String id = "zubair7541@vd.com";
    String uid ="waris1234@vd.com";
    String pwd ="Vista123";
    String tokenUrl = "http://ukdcapacheuat01.vistajet.local/VJET/1/customerApp/getUnverifiedCodeForUser/?email="; //Change it & get through app config file
    String verifyUrl = "https://myqa.vistajet.com/#/verify-account/";


    @Test(description = "Jira ID", priority = 2)
    public void test1() throws InterruptedException
    {
        //homescreen
        MainCall.myaccountPage.lwait();

        //myaccount
        MainCall.myaccountPage.clickMyAccount();
        MainCall.myaccountPage.cWait();
        MainCall.myaccountPage.assertURL(URL1);

        //editprofile
        MainCall.myaccountPage.eprofile();
        MainCall.myaccountPage.assertURL1(URL2);

       //assertfields
        MainCall.myaccountPage.assertfields(firstname,lastname,id,no);

        //edit
        MainCall.myaccountPage.editfields(URL3);

        //login again with updated details
        MainCall.myaccountPage.login_with_confirmation(uid,pwd,tokenUrl,verifyUrl);


        //open myaccount again
        MainCall.myaccountPage.clickMyAccount();
        MainCall.myaccountPage.cWait();
        MainCall.myaccountPage.assertURL(URL1);

        //edit info again to previous one
        MainCall.myaccountPage.eprofile();
        MainCall.myaccountPage.assertURL1(URL2);

        MainCall.myaccountPage.edit_fields_to_previous(URL3);
        MainCall.myaccountPage.loginagain_with_confirmation(id,pwd,tokenUrl,verifyUrl);
}















}
