package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Switch_CheckPublishedProviders {

    public void Switch_CheckPublishedProviders(){


    }

    public String checker;
    public String Email;

    public static By byProvider_Button = By.linkText("Provider");
    public static By byCheckPublisher_Button = By.linkText("Published");
    public static By byTabContent =  By.xpath("//*[@id=\"published\"]");

    public static By byModalProvider  = By.id("add_new_provider");






    public void openProviderPanel(){
        WebDriverFactory.getDriver().findElement(byProvider_Button).click();
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);
//        WebDriverFactory.getDriver().findElement(byCheckPublisher_Button).click();
    }

    public void publisher_panel_test(){

        WebElement published_element = WebDriverFactory.getDriver().findElement(byTabContent);

        int   count =  published_element.findElements(By.tagName("a")).size();
        System.out.println(count);




    }
}
