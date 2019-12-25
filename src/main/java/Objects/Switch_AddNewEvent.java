package Objects;

import General.GenericFunctions;
import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Switch_AddNewEvent {

    public String checker;
    public String Email;

    public static By byProvider_Button = By.linkText("Provider");
    public static By byProviderPartner = By.cssSelector("#published > ul > li:nth-child(1) > a");
    public static By bySchedule_button = By.linkText("Schedule");
    public static By byAddNewEventButton = By.cssSelector("body > div > section > div > div > div:nth-child(2) > a");
    public static By byActivity_dropdown = By.id("providers_panel_slot_template_form_activity_id");
    public static By byDetail = By.id("providers_panel_slot_template_form_activity_detail");
    public static By byDate = By.xpath("//*[@id=\"providers_panel_slot_template_form_date\"]");
    public static By byDateNext = By.xpath(("//*[@id=\"ui-datepicker-div\"]/div/a[2]"));
    public static By byDateNextJan =  By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[6]/a");
    public static By bySaveButton = By.xpath("//*[@id=\"new_providers_panel_slot_template_form\"]/div/div[8]/input");







    public void openProviderPanel(){
        WebDriverFactory.getDriver().findElement(byProvider_Button).click();
    }

    public void publisher_Open(){

        WebDriverFactory.getDriver().findElement(byProviderPartner).click();



    }
    public void Schedule_open(){

        WebDriverFactory.getDriver().findElement(bySchedule_button).click();


    }

    public void AddNewEvent_open(){

        WebDriverFactory.getDriver().findElement(byAddNewEventButton).click();


    }

    public void createEvent(){

        Select drop_down = new Select(WebDriverFactory.getDriver().findElement(byActivity_dropdown));
        drop_down.selectByIndex(1);

        WebDriverFactory.getDriver().findElement(byDetail).sendKeys(GenericFunctions.generateRandomString(50));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverFactory.getDriver().findElement(byDate).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverFactory.getDriver().findElement(byDateNext).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverFactory.getDriver().findElement(byDateNextJan).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriverFactory.getDriver().findElement(bySaveButton).click();


    }

}
