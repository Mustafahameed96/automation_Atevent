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

    public void toggleAllServices() throws InterruptedException {

        WebElement new_elem = WebDriverFactory.getDriver().findElement(byActivityBox);
        List<WebElement> toggler_btn = new_elem.findElements(By.className("switch-toggler"));

        for (int i = 0; i < toggler_btn.size(); i++) {


            if(toggler_btn.get(i).isSelected()){
                toggler_btn.get(i).click();
                Thread.sleep(300);
            }

            else{
                toggler_btn.get(i).click();
                Thread.sleep(300);
            }



        }

    }






}
