package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Switch_CheckUnPublishedProviders {


    public void Switch_CheckUnPublishedProviders(){


    }

    public String checker;
    public String Email;

    public static By byCheckUnPublisher_Button = By.cssSelector("#unpublished-tab > a");
    public static By byTabContent =  By.xpath("//*[@id=\"unpublished\"]");

    public static By byProvider_Button = By.linkText("Provider");

    // test comment






    public void openProviderPanel(){
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 10);
        WebDriverFactory.getDriver().findElement(byCheckUnPublisher_Button).click();
    }

    public void publisher_panel_test(){

        WebElement published_element = WebDriverFactory.getDriver().findElement(byTabContent);

        int   count =  published_element.findElements(By.tagName("a")).size();
        System.out.println(count);




    }

    public void closeProviderPanel(){
        WebDriverFactory.getDriver().findElement(byProvider_Button).click();
//        WebDriverFactory.getDriver().findElement(byCheckPublisher_Button).click();
    }
}
