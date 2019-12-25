package Objects;

import General.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Switch_Provider_Schedule {

    public void Switch_Provider_Schedule(){


    }

    public String checker;
    public String Email;

    public static By byProvider_Button = By.linkText("Provider");
    public static By byCheckPublisher_Button = By.linkText("Published");
    public static By byTabContent =  By.xpath("//*[@id=\"published\"]");
    public static By byProviderPartner = By.cssSelector("#published > ul > li:nth-child(1) > a");
    public static By bySchedule_button = By.linkText("Schedule");

    public static By byMonth = By.xpath("/html[1]/body[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]");
    public static By byMonth_name = By.xpath("//*[@id=\"calendar\"]/div[1]/div[2]/h2");

    public static By byWeek = By.xpath("//*[@id=\"calendar\"]/div[1]/div[1]/div[1]/button[2]");

    public static By byDay = By.xpath("//*[@id=\"calendar\"]/div[1]/div[1]/div[1]/button[3]");


    public static By byPrevious_button = By.xpath("//*[@id=\"calendar\"]/div[1]/div[1]/div[2]/button[1]");
    public static By byNext_button = By.xpath("//*[@id=\"calendar\"]/div[1]/div[1]/div[2]/button[2]");

    public String month_name ;









    public void openProviderPanel(){
        WebDriverFactory.getDriver().findElement(byProvider_Button).click();
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);
    }

    public void publisher_Open(){

        WebDriverFactory.getDriver().findElement(byProviderPartner).click();

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 2);


    }
    public void Schedule_open(){

        WebDriverFactory.getDriver().findElement(bySchedule_button).click();


    }

    public void MonthTestCases(){



        WebElement Month_Element =  WebDriverFactory.getDriver().findElement(byMonth);
        Month_Element.click();

        if(hasClass(Month_Element,"fc-state-active")){

          month_name =   WebDriverFactory.getDriver().findElement(byMonth_name).getText();


        }

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 2);
        ;
        ClickOnNext();

        if(!month_name.equals(WebDriverFactory.getDriver().findElement(byMonth_name).getText())){

            System.out.println("Pass");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ClickOnPrevious();
        if(month_name.equals(WebDriverFactory.getDriver().findElement(byMonth_name).getText())){

            System.out.println("Pass");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void WeekTestCases(){



        WebElement Week_Element =  WebDriverFactory.getDriver().findElement(byWeek);
        Week_Element.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(hasClass(Week_Element,"fc-state-active")){

            month_name =   WebDriverFactory.getDriver().findElement(byMonth_name).getText();


        }


        ClickOnNext();

        if(!month_name.equals(WebDriverFactory.getDriver().findElement(byMonth_name).getText())){

            System.out.println("Pass");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ClickOnPrevious();
        if(month_name.equals(WebDriverFactory.getDriver().findElement(byMonth_name).getText())){

            System.out.println("Pass");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void DayTestCases(){



        WebElement Day_Element =  WebDriverFactory.getDriver().findElement(byDay);
        Day_Element.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(hasClass(Day_Element,"fc-state-active")){

            month_name =   WebDriverFactory.getDriver().findElement(byMonth_name).getText();


        }


        ClickOnNext();

        if(!month_name.equals(WebDriverFactory.getDriver().findElement(byMonth_name).getText())){

            System.out.println("Pass");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ClickOnPrevious();
        if(month_name.equals(WebDriverFactory.getDriver().findElement(byMonth_name).getText())){

            System.out.println("Pass");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public boolean hasClass(WebElement element , String active) {
        String classes = element.getAttribute("class");
        for (String c : classes.split(" ")) {
            if (c.equals(active)) {
                return true;
            }
        }

        return false;
    }

    public void ClickOnPrevious(){

        WebDriverFactory.getDriver().findElement(byPrevious_button).click();
    }
    public void ClickOnNext(){

    WebDriverFactory.getDriver().findElement(byNext_button).click();
    }

}


