package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static Config.configProperties.VW_Url;

public class Switch_ChangeToProviderProfile {

    public void Switch_ChangeToProviderProfile(){


    }

    public static String partner_Name = "Test Provider 92";

    public static By byProvider_Button = By.linkText("Provider");
    public static By byProviderPartner = By.linkText(partner_Name);
    public static By byProviderName_Test  = By.xpath("//span[@class='menu-item']");
    public static By byAdminToProvider_Button = By.xpath("//a[contains(text(),\"Provider's Panel\")]");
    public static By byArrow = By.cssSelector("body > div > header > div > nav > div > ul.nav.navbar-nav.navbar-left > li > a > span.icon-arrow-down.yellow");
    public static By byBookingButton = By.cssSelector("body > div > nav > div > ul > li:nth-child(4) > a");
    public static By byAlert = By.cssSelector("body > div > div.container.flash-message > div > div > div");
    public static By byLogout_DropDown = By.xpath("/html/body/div/header/div/nav/div/ul[2]/li[2]/a");
    public static By byLogout_button = By.xpath("//ul[@class='dropdown-menu edit-profile']//li//a");













    public void changeToProviderProfile(){

        WebDriverFactory.getDriver().findElement(byAdminToProvider_Button).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    public void verifyThatAdminPanelIsAccessed(){
        Assert.assertEquals(partner_Name, WebDriverFactory.getDriver().findElement(byProviderName_Test).getText());
        Assert.assertTrue(WebDriverFactory.getDriver().findElements(byArrow).isEmpty());
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byBookingButton).isDisplayed());
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(byAlert).isDisplayed());





            System.out.println("Super Admin is entered into providers admin panel");





    }


}
