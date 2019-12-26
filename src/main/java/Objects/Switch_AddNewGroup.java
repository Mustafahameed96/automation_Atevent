package Objects;

import General.GenericFunctions;
import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Switch_AddNewGroup {
    public Switch_AddNewGroup() {}

    public String checker;

    public static By byGroup_Button = By.xpath("/html/body/div/nav/div/ul[2]/li[4]/a");
    public static By byAddGroup_Button = By.cssSelector("body > div > nav > div > ul.nav.navbar-nav.navbar-right > li.dropdown.dropdown-enlarge.has-tabs.group_dropdown.open > ul > div.form-inline.form-plain.mb-15 > div > div.form-group.col-md-5 > a");
    public static By byName_Field = By.id("admin_organization_form_name");
    public static By byCity_dropDown = By.id("admin_organization_form_city_id");
    public static By bySave_button = By.id("save_organization");
    public static By byPublish_button = By.linkText("Publish");

    public void OpenGroupTabandAddNew(){
        WebDriverFactory.getDriver().findElement(byGroup_Button).click();
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

    public void AddNameandSelectDropDown() throws InterruptedException {
         checker = GenericFunctions.generateRandomString(10);
        WebDriverFactory.getDriver().findElement(byName_Field).sendKeys(checker);
        Select dropDown = new Select(WebDriverFactory.getDriver().findElement(byCity_dropDown));
        dropDown.selectByVisibleText("Dubai");
        WebDriverFactory.getDriver().findElement(bySave_button).click();
        Thread.sleep(3000);
        WebDriverFactory.getDriver().findElement(byPublish_button).click();
        Thread.sleep(3000);


    }

    public void verify_GroupAdded() throws InterruptedException {
        WebDriverFactory.getDriver().findElement(byGroup_Button).click();
        Thread.sleep(3000);
         By groupcreated_exist = By.linkText(checker);
        if(WebDriverFactory.getDriver().findElement(groupcreated_exist).isDisplayed() ){


            System.out.println("Group added");

        }



    }




}
