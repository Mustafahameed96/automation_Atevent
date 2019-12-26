package Objects;

import General.GenericFunctions;
import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static Config.configProperties.VW_Url;
import static General.WebDriverFactory.getDriver;

public class Switch_AddNewService  {



    public void Switch_ChangeToProviderProfile(){


    }

    public String Service_Name ;

    public static By byService_button = By.linkText("Services");
    public static By byAddNewService = By.id("add-service");

    public static By byform_checkBoxEvent =  By.xpath("//*[@id=\"new_providers_panel_activity_form\"]/div[2]/div[3]/div/div[2]/div/span[2]");
    public static By byform_ActivityName =  By.id("providers_panel_activity_form_name");
    public static By byform_Headline =  By.id("providers_panel_activity_form_message_for_buyer");
    public static By byform_Description =  By.id("providers_panel_activity_form_description");
    public static By byform_Address =  By.id("providers_panel_activity_form_location_name");
    public static By byform_neighbourid =  By.id("providers_panel_activity_form_neighbourhood_id");
    public static By byform_capacity =  By.id("providers_panel_activity_form_participants_count");
    public static By byform_duration =  By.id("providers_panel_activity_form_duration_time");
    public static By byform_SubCategory =  By.id("providers_panel_activity_form_category_id");
    public static By byform_packages=  By.id("providers_panel_activity_form_activity_pricing_bundles_name");
    public static By byform_units =  By.id("providers_panel_activity_form_activity_pricing_bundles_number_of_sessions");
    public static By byform_prices =  By.id("providers_panel_activity_form_activity_pricing_bundles_total_price_cents");
    public static By byform_SaveButton =  By.id("save");


    public static By byActivityBox = By.xpath("//*[@id=\"activity-list\"]");




    public static By byLogout_DropDown = By.xpath("/html/body/div/header/div/nav/div/ul[2]/li[2]/a");
    public static By byLogout_button = By.xpath("//ul[@class='dropdown-menu edit-profile']//li//a");


    public void openServicePage(){

        getDriver().findElement(byService_button).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getDriver().findElement(byAddNewService).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void fillForm() throws InterruptedException {

        getDriver().findElement(byform_checkBoxEvent).click();

        Service_Name = GenericFunctions.generateRandomString(10);
        getDriver().findElement(byform_ActivityName).sendKeys(Service_Name);
        Thread.sleep(1000);
        getDriver().findElement(byform_Headline).sendKeys(Service_Name + Service_Name);
        Thread.sleep(1000);

        getDriver().findElement(byform_Description).sendKeys(Service_Name + " " + Service_Name + " " + Service_Name + " ");
        Thread.sleep(1000);

        getDriver().findElement(byform_Address).sendKeys(Service_Name + Service_Name);
        Thread.sleep(1000);

        Select drpDown = new Select( getDriver().findElement(byform_neighbourid));
        drpDown.selectByIndex(3);
        Thread.sleep(1000);

        getDriver().findElement(byform_capacity).sendKeys(GenericFunctions.generateRandomNum(2));
        Thread.sleep(1000);

        getDriver().findElement(byform_duration).sendKeys(GenericFunctions.generateRandomNum(2));
        Thread.sleep(1000);

        Select drpDown1 = new Select( getDriver().findElement(byform_SubCategory));
        drpDown1.selectByIndex(2);
        Thread.sleep(1000);

        getDriver().findElement(byform_packages).sendKeys(Service_Name);
        Thread.sleep(1000);

        getDriver().findElement(byform_units).sendKeys("1");
        Thread.sleep(1000);

        getDriver().findElement(byform_prices).sendKeys("10");
        Thread.sleep(1000);

        getDriver().findElement(byform_SaveButton).click();


        Thread.sleep(4000);
        WebElement new_elem = WebDriverFactory.getDriver().findElement(byActivityBox);
       List<WebElement> span_tag = new_elem.findElements(By.tagName("span"));


       for(int i = 0 ; i < span_tag.size() ; i++){

           if(span_tag.get(i).getText().equals(Service_Name)){
               System.out.println("Service Added");
               break;
           }
           else{
               System.out.println("Service Not Added");

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
