package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AtEvent_Login {
    public AtEvent_Login() {}


    public static By byEmail = By.xpath("//*[@id='email']");
    public static By byPassword = By.xpath("//*[@id='password']");
    public static By byLoginButton = By.xpath("/html/body/div/div/div/div/form/input[3]");


    public void enterUserDetails(String userMail, String pwd)
    {
        WebDriverFactory.getDriver().findElement(byEmail).sendKeys(userMail);
        WebDriverFactory.getDriver().findElement(byPassword).sendKeys(pwd);
    }

    public void clickLogin()
    {
        WebDriverFactory.getDriver().findElement(byLoginButton).click();

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/header/div/nav/div/ul[2]/li[1]/i")));

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

}
