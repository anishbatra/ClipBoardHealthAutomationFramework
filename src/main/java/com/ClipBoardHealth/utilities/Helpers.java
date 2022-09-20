package com.ClipBoardHealth.utilities;

import com.ClipBoardHealth.Base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class Helpers extends BaseClass {
    public static long EXPLICIT_WAIT = 25;


    public static JavascriptExecutor executor;



    public static void highlightWebElement(WebDriver driver, WebElement element) {
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute('style', 'background: pink; border: 2px solid blue;');", element);
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, Long timeout) {
        WebDriverWait wait = new WebDriverWait(BaseClass.driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        highlightWebElement(driver, element);
    }

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element, Long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        highlightWebElement(driver, element);
    }

    public static void clickOn(WebDriver driver, WebElement element, long timeout) {
        waitForElementToBeVisible(driver, element, timeout);
        waitForElementToBeClickable(driver, element, timeout);
        element.click();

    }

    public static boolean isElementDisplayed(WebDriver driver, WebElement element, Long timeout) {
        waitForElementToBeVisible(driver, element, timeout);
        Assert.assertTrue(element.isDisplayed());
        return element.isDisplayed();

    }

    public static void selectTextFromDropDown(WebElement element, String text, Long timeout) {
        waitForElementToBeVisible(driver, element, timeout);
        Select sel = new Select(element);
        sel.selectByVisibleText(text);
        highlightWebElement(driver, element);
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
