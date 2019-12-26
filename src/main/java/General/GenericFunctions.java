package General;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

//import static Objects.planAFlightForDayOverFlightPage.by_timePicker;


/**
 * Created by VD on 5/8/2018.
 */
public class GenericFunctions {



    public static String generateRandomNum(int length)
    {
        String RawRandomNumber = RandomStringUtils.randomNumeric(length);
        return RawRandomNumber;
    }

    public static String generateAlphaNumeric(String s, int length)
    {
        String RawRandomNumber = RandomStringUtils.randomNumeric(length);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        stringBuilder.append(RawRandomNumber);
        return stringBuilder.toString();
    }

    public static String RandomPhoneNumber(String RawRandomNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+92300");
        stringBuilder.append(RawRandomNumber);
        return stringBuilder.toString();
    }

    public static String generateRandomString(int length) {
        String name = RandomStringUtils.randomAlphabetic(length);
        String first_letter = name.substring(0, 1).toUpperCase();
        String other_letters = name.substring(1).toLowerCase();
        String finalname = first_letter + other_letters;
        return finalname;
    }

    public static String generateEmail(String finalname)
    {
        return finalname + "@vd.com";
    }










} 