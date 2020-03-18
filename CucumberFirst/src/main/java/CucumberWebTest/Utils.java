package CucumberWebTest;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils
{
    static protected WebDriver driver;


    public void waitForClickable(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public void waitForVisibility(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //wait for element present
    public void waitForElementsPresent(By by,int time)
    {  WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public void dropDrownVisibletext(By by,String text)
    { Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public String dropDownGetSelectedText(By by)
    {
        Select select = new Select(driver.findElement(by));
       return select.getFirstSelectedOption().getText();
    }
    public static void selectCountryByIndex(By by,int intNum)
    {
        Select dropdownCountry = new Select(driver.findElement(by));
        dropdownCountry.selectByIndex(intNum);
    }
    public static void selectStateByValue(By by,String Text)
    {
        Select dropdownState = new Select(driver.findElement(by));
        dropdownState.selectByValue(Text);
    }



    public void dropDownIndex(By by,int number)
    {Select select = new Select(driver.findElement(by));
        select.selectByIndex(number);
    }

    public void dropDownValue(By by,String text)
    { Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }


    public static String timeStamp()
    {
        DateFormat dateFormat = new SimpleDateFormat("ddmmyyhhmmss");
        Date date=new Date();
        return dateFormat.format(date);
    }
    public static void clickOnElement(By by)

    {
        driver.findElement(by).click();
    }

    public void clearAndEnterText(By by, String text)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public void EnterText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);

    }
    public static String getTextElement(By by)
    {
        return driver.findElement(by).getText();

    }
    public static void assertTextMessage(By by,String expected, String message)
    {
        Assert.assertEquals(getTextElement(by),expected,message);
    }
    public static void assertURL(String text)
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));

    }

    public static void sleep(int time){
        try {
            Thread.sleep(time *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void verifyElementIsDisplayed(By by)
    {
        Assert.assertTrue(driver.findElement(by).isDisplayed());
    }

    public static void scrollAndClick(By by){
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();


    }

    public static void takeScreenShot(String fileName) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with test method name
        try {
            FileUtils.copyFile(scrFile, new File("src\\test\\resources\\Screenshots\\"+fileName+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
