package Objects;

import General.GenericFunctions;
import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static Config.configProperties.VW_Url;
import static General.WebDriverFactory.getDriver;

public class Switch_ProviderServiceToggler  {


    public void Switch_ChangeToProviderProfile(){


    }

    public String Service_Name ;





    public static By byActivityBox = By.xpath("//*[@id=\"activity-list\"]");




    public static By byLogout_DropDown = By.xpath("/html/body/div/header/div/nav/div/ul[2]/li[2]/a");
    public static By byLogout_button = By.xpath("//ul[@class='dropdown-menu edit-profile']//li//a");

    public void toggleAllServices() throws InterruptedException {

        WebElement new_elem = WebDriverFactory.getDriver().findElement(byActivityBox);
        List<WebElement> toggler_btn = new_elem.findElements(By.className("switch-toggler"));

        for (int i = 0; i < toggler_btn.size(); i++) {


            if(toggler_btn.get(i).isSelected()){
                toggler_btn.get(i).click();
                Thread.sleep(500);
            }

            else{
                toggler_btn.get(i).click();
                Thread.sleep(5000);
            }



        }

    }





    public void logoutPartner() throws InterruptedException {



        getDriver().findElement(byLogout_DropDown).click();

        Thread.sleep(2000);

        getDriver().findElement(byLogout_button).click();
        getDriver().get(VW_Url);


    }
}
