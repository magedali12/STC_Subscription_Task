package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import utils.commonHelper.AssertionHelper;
import utils.commonHelper.ElementHelper;
import utils.commonHelper.JavaScriptHelper;
import utils.driverManger.DriverManger;

public class SubscriptionPage {

    WebDriver driver;
    By countriesMenu = By.cssSelector("[data-test-id='header-country-switch']");  //css faster than xpath
    By basicPackageType = By.xpath("//h3[text()='Basic']");    // xpath is best for text base selection
    By watchOnlineForBasic = By.xpath("//div//dd[5]");
    By videoQualityForBasic = By.xpath("//dd[text()='Full HD']");
    By premiumPackageType = By.xpath("//h3[text()='Premium']");
    By videoQualityForPremium = By.xpath("//dd[text()='4K']");
    By deviceAccessForPremium = By.xpath("//dd[text()='Unlimited']");
    By premiumPrice = By.xpath("//div[@data-test-id='tier-price']//b");
    By premiumCurrency = By.xpath("//div[@data-test-id='tier-price']//i");
    By closeButton =By.cssSelector("[data-test-id='modal-close-btn']");


    public SubscriptionPage(){
        this.driver = DriverManger.getDriver();
    }

    public SubscriptionPage viewSpecificPackageFeatures(String packageName){     //combination btw relative and dynamic locator
        By discoverPackageFeatures = RelativeLocator.with(By.xpath("//div[@class='tier_features__BPje1']/p")).below(By.xpath("//*[text()='"+ packageName + "']"));
        JavaScriptHelper.scrollToElement(driver,discoverPackageFeatures);
        ElementHelper.click(driver,discoverPackageFeatures);
        return this;
    }

    public SubscriptionPage clickOnCloseButton(){
        ElementHelper.click(driver,closeButton);
        return this;
    }


    public SubscriptionPage chooseSpecificCountry(String countryName){
       ElementHelper.click(driver,countriesMenu);
       WebElement country = ElementHelper.findElementByText(countryName,driver);
       ElementHelper.click(country);
       return this;
    }


    public SubscriptionPage validateBasicPackageDetails(String ExpectedPackageType, String ExpectedVideoQuality, String WatchOnline){
        String actualPackageType = ElementHelper.getText(driver,basicPackageType);
        String actualVideoQuality = ElementHelper.getText(driver,videoQualityForBasic);
        String actualWatchOnline = ElementHelper.getText(driver,watchOnlineForBasic);

        AssertionHelper.assertEqual(actualPackageType,ExpectedPackageType);
        AssertionHelper.assertEqual(actualVideoQuality,ExpectedVideoQuality);
        AssertionHelper.assertEqual(actualWatchOnline,WatchOnline);
        return this;
    }

    public SubscriptionPage validatePremiumPackageDetails(String ExpectedPackageType,String ExpectedVideoQuality,String ExpectedDeviceAccess){
        String actualPackageType = ElementHelper.getText(driver,premiumPackageType);
        String actualVideoQuality = ElementHelper.getText(driver,videoQualityForPremium);
        String actualDeviceAccess = ElementHelper.getText(driver,deviceAccessForPremium);

        AssertionHelper.assertEqual(actualPackageType,ExpectedPackageType);
        AssertionHelper.assertEqual(actualVideoQuality,ExpectedVideoQuality);
        AssertionHelper.assertEqual(actualDeviceAccess,ExpectedDeviceAccess);
        return this;
    }

    public SubscriptionPage validatePackagePrice(String ExpectedPrice){
        String actualPremiumPrice = ElementHelper.getText(driver,premiumPrice);
        AssertionHelper.assertEqual(actualPremiumPrice,ExpectedPrice);
        return this;
    }

    public void validatePackageCurrency(String ExpectedCurrency){
        String actualCurrency = ElementHelper.getText(driver,premiumCurrency);
        AssertionHelper.assertEqual(actualCurrency,ExpectedCurrency);
    }

    public void validateSubscriptionModuleForKsa(String basicPackage, String basicExpectedVideoQuality, String basicWatchOnline,String premiumPackage,String premiumExpectedVideoQuality,String premiumDeviceAccess,String ExpectedPrice,String ExpectedCurrency){
        viewSpecificPackageFeatures(basicPackage)
                .validateBasicPackageDetails(basicPackage,basicExpectedVideoQuality,basicWatchOnline)
                .clickOnCloseButton()
                .viewSpecificPackageFeatures(premiumPackage)
                .validatePremiumPackageDetails(premiumPackage,premiumExpectedVideoQuality,premiumDeviceAccess)
                .clickOnCloseButton()
                .validatePackagePrice(ExpectedPrice)
                .validatePackageCurrency(ExpectedCurrency);
    }

    public void validateSubscriptionModuleForKuwait(String countryName, String basicPackage, String basicExpectedVideoQuality, String basicWatchOnline,String premiumPackage,String premiumExpectedVideoQuality,String premiumDeviceAccess,String ExpectedPrice,String ExpectedCurrency){
           chooseSpecificCountry(countryName)
                .viewSpecificPackageFeatures(basicPackage)
                .validateBasicPackageDetails(basicPackage,basicExpectedVideoQuality,basicWatchOnline)
                .clickOnCloseButton()
                .viewSpecificPackageFeatures(premiumPackage)
                .validatePremiumPackageDetails(premiumPackage,premiumExpectedVideoQuality,premiumDeviceAccess)
                .clickOnCloseButton()
                .validatePackagePrice(ExpectedPrice)
                .validatePackageCurrency(ExpectedCurrency);
    }

    public void validateSubscriptionModuleForBahrain(String countryName, String basicPackage, String basicExpectedVideoQuality, String basicWatchOnline,String premiumPackage,String premiumExpectedVideoQuality,String premiumDeviceAccess,String ExpectedPrice,String ExpectedCurrency){
           chooseSpecificCountry(countryName)
                .viewSpecificPackageFeatures(basicPackage)
                .validateBasicPackageDetails(basicPackage,basicExpectedVideoQuality,basicWatchOnline)
                .clickOnCloseButton()
                .viewSpecificPackageFeatures(premiumPackage)
                .validatePremiumPackageDetails(premiumPackage,premiumExpectedVideoQuality,premiumDeviceAccess)
                .clickOnCloseButton()
                .validatePackagePrice(ExpectedPrice)
                .validatePackageCurrency(ExpectedCurrency);
    }








//    public void changeToBahrain(){
//        ElementHelper.click(driver,countriesMenu);
//        ElementHelper.click(driver,bahrainCountry);
//    }


}
