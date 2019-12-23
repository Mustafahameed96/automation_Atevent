package Objects;

import General.WebDriverFactory;
import General.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static General.WebDriverFactory.getDriver;
import static Objects.TransportServicesPage.byScrolldown;

public class FlightEntertainment extends baseTest{

    public FlightEntertainment(){}

    public static By byEntertainmentView = By.className("icon-opnotes");
    public static By byMovConts =  By.cssSelector(".entertainment-movie-title p");
    public static By byShowConts = By.cssSelector(".entertainment-tvshow-title p");
    public static By byGamesConts = By.cssSelector(".entertainment-game-title p");

    public void selectEntertainmentDetails() throws InterruptedException
    {
        WebElement CT = WebDriverFactory.getDriver().findElement(byScrolldown);
        JavascriptExecutor jsx = (JavascriptExecutor)WebDriverFactory.getDriver();
        jsx.executeScript("arguments[0].scrollIntoView(true);",CT);
        Thread.sleep(11000);

        WebDriverFactory.getDriver().findElements(byEntertainmentView).get(1).click();
        Thread.sleep(10000);
    }

    public  String MoviesPresent() throws InterruptedException
    {
        Thread.sleep(8000);
        String MovieNames =  getDriver().findElement(byMovConts).getText();
        String ShowNames =   getDriver().findElement( byShowConts).getText();
        String GameNames =   getDriver().findElement(byGamesConts).getText();
        return MovieNames + "" + ShowNames + ""+ GameNames;
    }

}
