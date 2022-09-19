package com.ClipBoardHealth.utilities;

import com.ClipBoardHealth.Base.BaseClass;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static com.ClipBoardHealth.Base.BaseClass.driver;

public class Helpers {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;
    public static long EXPLICIT_WAIT = 25;


    public static JavascriptExecutor executor;



    public static void highlightElement(WebDriver driver, WebElement element) {
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    public static void waitToBeClicked(WebDriver driver, WebElement element, Long timeout) {
        WebDriverWait wait = new WebDriverWait(BaseClass.driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        highlightElement(driver, element);
    }

    public static void waitToBeSelected(WebDriver driver, WebElement element, Long timeout) {
        WebDriverWait wait = new WebDriverWait(BaseClass.driver, timeout);
        wait.until(ExpectedConditions.elementToBeSelected(element));
        highlightElement(driver, element);
    }

    public static void waitToBeVisble(WebDriver driver, WebElement element, Long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        highlightElement(driver, element);
    }

    public static void waitForText(WebElement element, String text, Long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        highlightElement(driver, element);
    }

    // Explicit Wait for Click on any Element.
    public static void clickOn(WebDriver driver, WebElement element, long timeout) {
        waitToBeClicked(driver, element, timeout);
        element.click();

    }

    public static void clickOnElementByJs(WebDriver driver, WebElement element, long timeout) {
        waitToBeClicked(driver, element, timeout);
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    // Explicit Wait for Sending Data to any Element.
    public static void sendKeys(WebDriver driver, WebElement element, long timeout, String value) {
        waitToBeVisble(driver, element, timeout);
        element.clear();
        element.sendKeys(value);
    }

    public static boolean isElementDisplayed(WebDriver driver, WebElement element, Long timeout) {
        waitToBeVisble(driver, element, timeout);
        Assert.assertTrue(element.isDisplayed());
        return element.isDisplayed();

    }

    // Method to switch to given frame
    public static void switchToGivenFrame(WebDriver driver, WebElement element, Long timeout) {
        waitToBeVisble(driver, element, timeout);

       // Log.info("Frame swithing...");
        driver.switchTo().frame(element);
        //Log.info("Frame switched...");
    }

    public static void scrollToElement(WebDriver driver, WebElement element, Long timeout) {
        waitToBeClicked(driver, element, timeout);
        //Log.info("Scrolling to..." + element.getText());
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Method to switch to default content
    public static void switchTodefaultContent(WebDriver driver) {

        driver.switchTo().defaultContent();
    }

    // Set Date For Log4J.
    public static void setDateForLog4j() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyy_hhmmss");
        System.setProperty("current_date", dateFormat.format(new Date()));
        PropertyConfigurator.configure("./log4j.properties");
    }

    public static String getSystemDate() {
        DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void selectTextFromDropDown(WebElement element, String text, Long timeout) {
        waitToBeVisble(driver, element, timeout);
        Select sel = new Select(element);
        sel.selectByVisibleText(text);
        highlightElement(driver, element);
        //waitToBeSelected(driver, element, timeout);
    }

    public static int switchWindow(int winNum) {
        Set<String> winIDs = driver.getWindowHandles();
        java.util.Iterator<String> iter = winIDs.iterator();
        int winCount = 1;
        while (winCount <= winNum) {
            String windowToBeSwitched = iter.next();
            if (winCount == winNum) {
                driver.switchTo().window(windowToBeSwitched);
                driver.manage().window().maximize();
                break;
            }
            winCount++;
        }
        return winCount;
    }



}
