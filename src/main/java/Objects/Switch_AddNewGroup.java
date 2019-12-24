package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Switch_AddNewGroup {
    public Switch_AddNewGroup() {}


    public static By byGroup_Button = By.xpath("/html/body/div/nav/div/ul[2]/li[4]/a");
    public static By byAddGroup_Button = By.cssSelector("body > div > nav > div > ul.nav.navbar-nav.navbar-right > li.dropdown.dropdown-enlarge.has-tabs.group_dropdown.open > ul > div.form-inline.form-plain.mb-15 > div > div.form-group.col-md-5 > a");

    public void OpenGroupTabandAddNew(){
        WebDriverFactory.getDriver().findElement(byGroup_Button).click();
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);
        WebDriverFactory.getDriver().findElement(byAddGroup_Button).click();



    }



    public void AddNewGroup_PageOpened()
    {


        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("save_organization")));

        boolean status= element.isDisplayed();
        if(status)
        {
            System.out.println("User is on Add group Page");
        }

    }


}
