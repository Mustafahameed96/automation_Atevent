package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HowToFly {

    public HowToFly(){}

    public static By byMenuBar  = By.id("top-menu-nav");
    public static By byTag      = By.tagName("ul");

    public void Comparasion(String actualMenuItems) throws InterruptedException
    {
        String winHandleBefore = WebDriverFactory.getDriver().getWindowHandle();
        for(String winHandle : WebDriverFactory.getDriver().getWindowHandles())
        {
            WebDriverFactory.getDriver().switchTo().window(winHandle);
        }

        Thread.sleep(3000);
        String expectedMenuItems = WebDriverFactory.getDriver().findElement(byMenuBar).findElements(byTag).get(0).getText();
        Assert.assertEquals(expectedMenuItems, actualMenuItems, "Menu items not exist");

        WebDriverFactory.getDriver().close();
        WebDriverFactory.getDriver().switchTo().window(winHandleBefore);
    }

}
