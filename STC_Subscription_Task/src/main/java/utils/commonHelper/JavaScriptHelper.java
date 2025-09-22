package utils.commonHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.commonHelper.WaitHelper.waitForClickable;
import static utils.commonHelper.WaitHelper.waitForVisibility;

public class JavaScriptHelper {

    public static void scrollToElement(WebDriver driver, By locator) {
        WebElement element = waitForVisibility(driver, locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void jsClick(WebDriver driver, By locator) {
        WebElement element = waitForClickable(driver, locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
    }


    public static void hoverOver(WebDriver driver, By locator) {
        Actions actions = new Actions(driver);
        WebElement element = waitForVisibility(driver, locator);
        actions.moveToElement(element).perform();
    }
}
