package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Config.configProperties.VW_Url;
import static General.WebDriverFactory.getDriver;

public class Switch_ArchiveServices {

    public void Switch_ArchiveServices(){


    }






    public static By byActivityBox = By.xpath("//*[@id=\"activity-list\"]");

    public static By byArchiveServicesButton = By.partialLinkText("archived services");

    public static By byactivityName = By.className("activity-name");

    public static By byActivityArchive = By.id("archive-btn");


    public static By byLogout_DropDown = By.xpath("/html/body/div/header/div/nav/div/ul[2]/li[2]/a");
    public static By byLogout_button = By.xpath("//ul[@class='dropdown-menu edit-profile']//li//a");

    public void ArchiveAllServices() throws InterruptedException {

        WebElement new_elem = WebDriverFactory.getDriver().findElement(byActivityBox);
        List<WebElement> activity_name_btn = new_elem.findElements(byactivityName);

        for (int i = 0; i < activity_name_btn.size(); i++) {




            activity_name_btn.get(i).click();
            Thread.sleep(500);
            WebDriverFactory.getDriver().findElement(byActivityArchive).click();
            Thread.sleep(1500);
            new_elem = WebDriverFactory.getDriver().findElement(byActivityBox);
            activity_name_btn = new_elem.findElements(byactivityName);









        }

    }





    public void logoutPartner() throws InterruptedException {



        getDriver().findElement(byLogout_DropDown).click();

        Thread.sleep(2000);

        getDriver().findElement(byLogout_button).click();
        getDriver().get(VW_Url);


    }
}
