package utils.commonHelper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

import static utils.commonHelper.WaitHelper.waitForClickable;
import static utils.commonHelper.WaitHelper.waitForVisibility;

public class ElementHelper {

    private static final int waitingTime = 30;


    public static WebElement findElementByText(String text, WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='" + text + "']")));

    }
    public static WebElement findElementByValue(String value, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@value='" + value + "']")));
    }


    public static WebElement findElementByTextContains(String text, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'" + text + "')]")));
    }

    public static void click(WebDriver driver, By locator) {
        waitForVisibility(driver, locator);
        waitForClickable(driver, locator).click();
    }

    public static void click(WebElement webElement) {  //click on webElement
        webElement.click();
    }

    public static void sendText(String text, WebDriver driver, By locator) {
        WebElement element = waitForVisibility(driver, locator);
        element.clear();
        element.sendKeys(text);
    }

    public static void clearInput(WebDriver driver, By locator) {
        waitForVisibility(driver, locator).clear();
    }

    public static String getText(WebDriver driver, By locator) {
        return waitForVisibility(driver, locator).getText();
    }

    public static  String getCurrentUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public static WebElement findElementBy(WebDriver driver, By locator) {
        return waitForVisibility(driver,locator);
    }

    public static List<WebElement> getElements(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return driver.findElements(locator);
    }

    public static boolean isElementDisplayed(WebDriver driver, By locator) {
        try {
            return waitForVisibility(driver, locator).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementEnabled(WebDriver driver, By locator) {
        try {
            return waitForVisibility(driver, locator).isEnabled();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }




}
