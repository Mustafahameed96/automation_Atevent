package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;

public class CanNotRequestFlightPage {

    public  CanNotRequestFlightPage(){}

  public static By byIssuePrompt = By.className("custom-dialog");
  public static By byAck = By.xpath("//span[contains(text(), 'OK')]");

  public void IssueMsg() throws InterruptedException
    {
        Thread.sleep(5000);
        WebDriverFactory.getDriver().findElement(byIssuePrompt).equals("Something unexpected happened. Please try again or contact our team directly.");
        WebDriverFactory.getDriver().findElement(byAck).click();
    }

}
