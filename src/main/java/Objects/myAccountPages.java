package Objects;
import General.WebDriverFactory;
import General.WebDriverWaits;
import General.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Date;

public class myAccountPages extends baseTest {

    public myAccountPages() {}

    //My account Page Functions
    public static By byMyAccount = By.cssSelector("span.putTabIndex:nth-child(1)");
    public static By byEditMyProfile = By.xpath("//*[@id=\"ReactApp\"]/div/div[3]/div/div/div[2]/div[1]/div[4]/div[3]/div/button/div/div");
    public static By byfirstname = By.id("first-name");
    public static By lastname = By.id("last-name");
    public static By datepicker = By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div[2]/div/div[1]/div[2]/div[3]/div[1]/div/div[1]/input");
    public static By selectdate = By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div[2]/div/div[1]/div[2]/div[3]/div[1]/div/div[1]/div/div/table/tbody/tr[2]/td[3]");
    public static By phonenumber = By.xpath("/html/body/div[1]/div/div[3]/div/div/div/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/input");
    public static By byEmail = By.xpath("//*[@id=\"email\"]");
    public static By save = By.xpath("//span[contains(text(), 'Save')]"); //By.cssSelector("div.s6:nth-child(2) > div:nth-child(1) > button:nth-child(1)");


    //My Account Page Functions
    public void clickMyAccountButton() {

        WebDriverFactory.getDriver().findElement(byMyAccount).click();
    }

    public void EditProf(){

        String editProfile = WebDriverFactory.getDriver().findElement(byEditMyProfile).getText();
        Assert.assertEquals(editProfile, "Edit My Profile");
    }

    public void clickProf(){

        WebDriverFactory.getDriver().findElement(byEditMyProfile).click();
    }

    public void enterFirstname(String firstName, String lastName){
        WebDriverFactory.getDriver().findElement(byfirstname).clear();
        WebDriverFactory.getDriver().findElement(byfirstname).sendKeys(firstName);
        WebDriverWaits.sleep(1000);
        WebDriverWaits.sleep(1000);
        WebDriverFactory.getDriver().findElement(lastname).clear();
        WebDriverFactory.getDriver().findElement(lastname).sendKeys(lastName);
        WebDriverWaits.sleep(1000);
    }

    public void pickdate(){
        WebDriverFactory.getDriver().findElement(datepicker).click();
        WebDriverWaits.sleep(1000);
        WebDriverFactory.getDriver().findElement(selectdate).click();
        WebDriverWaits.sleep(1000);
    }

    public void save() throws InterruptedException {
        WebDriverWaits.sleep(5000);
        WebDriverFactory.getDriver().findElement(save).click();
        WebDriverWaits.sleep(10000);
        WebDriverFactory.getDriver().findElement(By.cssSelector(".custom-dialog > div > div > div")).click();
        Thread.sleep(5000);
    }

}
