package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by VD on 5/28/2018.
 */
public class loginPage
{
    public loginPage() {}

    //Login Page Functions

    public static By byLoginTopButton = By.cssSelector(".user-menu-header div:nth-child(2) button");
    public static By byEmail = By.id("email");
    public static By byPassword = By.id("password");
    public static By byLoginButton = By.className("waves-effect");
    public static By by_logout = By.xpath("//span[contains(text(), 'Logout')]");
    private static By byNameverify = By.cssSelector(".my-account-page > div");


    public void clickLoginTopButton() throws InterruptedException {
        Thread.sleep(1000);
        WebDriverFactory.getDriver().findElement(byLoginTopButton).click();

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        boolean status = element1.isDisplayed();
        if (status) {
            System.out.println("Login page is displayed");
        } else {
            System.out.println("Login page is not displayed");
        }
    }

    public void enterUserDetails(String userMail, String pwd)
    {
        WebDriverFactory.getDriver().findElement(byEmail).sendKeys(userMail);
        WebDriverFactory.getDriver().findElement(byPassword).sendKeys(pwd);
    }


    public void clickLogin()
    {
        WebDriverFactory.getDriver().findElement(byLoginButton).click();

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ReactApp > div > div:nth-child(2) > div > section > div.user-menu-header > div > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")));

        boolean status= element.isDisplayed();
        if(status)
        {
            System.out.println("User is logged in successfully");
        }
        else
        {
            System.out.println("User is not logged in");
        }
    }

    public static void clickLogoutButton() throws InterruptedException {
        WebDriverFactory.getDriver().findElement(by_logout).click();
//        session has expired popup
        try {
            if (WebDriverFactory.getDriver().findElement(By.xpath("//span[contains(text(),'OK')]")).isDisplayed()) {
                {
                    WebDriverFactory.getDriver().findElement(By.xpath("//span[contains(text(),'OK')]")).click();
                }
            }
        }
        catch (Exception e) {
            Thread.sleep(10000);
        }
    }

    public void logout() throws InterruptedException{
        Thread.sleep(10000);
        clickLogoutButton();
    }

    public String getName()
    {
        return WebDriverFactory.getDriver().findElement(byNameverify).getText();
    }

}
