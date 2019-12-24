package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static Config.configProperties.*;

public class WebDriverFactory {
    static WebDriver driver;
    static String device = Device; // Change to windows or mac accordingly

    static String chromeDriverPath = device.equals("Windows") ? "driver/chromedriver.exe" : "driver/chromedriver";
    static String geckoDriverPath = device.equals("Windows") ? "driver/geckodriver.exe" : "driver/geckodriver";

    public static WebDriver getInstance(){

        ChromeOptions op = new ChromeOptions();
        switch (Browser)
        {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                op.addArguments("--start-maximized");
                driver = new ChromeDriver(op);
                break;

            case "IE":
                driver = new InternetExplorerDriver();
                break;

            case "Firefox":
                System.setProperty("webdriver.gecko.driver", geckoDriverPath);
                op.addArguments("--start-maximized");
                driver = new FirefoxDriver();
                break;

            case "Remote":
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                try {
                    driver = new RemoteWebDriver(new URL(Node), cap);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
        }

        if(Environment.equals("QA")) {
            VerificationCodeUrl = "http://ukdcapacheuat01.vistajet.local/VJET/1/customerApp/getUnverifiedCodeForUser/?email=";
            VerifyAccountUrl = "https://myqa.vistajet.com/#/verify-account/";
        }

        else if (Environment.equals("UAT")) {
            VerificationCodeUrl = "http://bpmtestpatch.vistajet.local:7003/VJET/1/customerApp/getUnverifiedCodeForUser/?email=";
            VerifyAccountUrl = "https://myuat.vistajet.com/#/verify-account/";
        }

        driver.get(VW_Url);
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        else
        {
            throw new IllegalStateException("Driver has not been initialized");
        }
    }


    public static void finishDriver()
    {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }

}
