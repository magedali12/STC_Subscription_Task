import Pages.SubscriptionPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.datareaders.DataProviderUtils;
import utils.extentReport.ExtentReportListener;



@Listeners(ExtentReportListener.class)
public class SubscriptionTest extends BaseTest{


    @Test(dataProvider = "ksaData",dataProviderClass = DataProviderUtils.class)
    public void validateSubscriptionPackagesForKsa(String basicPackage, String basicExpectedVideoQuality, String basicWatchOnline, String premiumPackage, String premiumExpectedVideoQuality,String premiumDeviceAccess,String ExpectedPrice,String ExpectedCurrency){
        new SubscriptionPage()
                .validateSubscriptionModuleForKsa(basicPackage,basicExpectedVideoQuality
                ,basicWatchOnline,premiumPackage,premiumExpectedVideoQuality,premiumDeviceAccess
                ,ExpectedPrice,ExpectedCurrency);

    }


    @Test(dependsOnMethods = {"validateSubscriptionPackagesForKsa"},dataProvider = "kuwaitData",dataProviderClass = DataProviderUtils.class)
    public void validateSubscriptionPackagesForKuwait(String countryName, String basicPackage, String basicExpectedVideoQuality, String basicWatchOnline,String premiumPackage,String premiumExpectedVideoQuality,String premiumDeviceAccess,String ExpectedPrice,String ExpectedCurrency){
        new SubscriptionPage()
                .validateSubscriptionModuleForKuwait(countryName,basicPackage,basicExpectedVideoQuality
                        ,basicWatchOnline,premiumPackage,premiumExpectedVideoQuality
                        ,premiumDeviceAccess,ExpectedPrice,ExpectedCurrency);

    }

    @Test(dependsOnMethods = {"validateSubscriptionPackagesForKuwait"},dataProvider = "bahrainData",dataProviderClass = DataProviderUtils.class)
    public void validateSubscriptionPackagesForBahrain(String countryName, String basicPackage, String basicExpectedVideoQuality, String basicWatchOnline,String premiumPackage,String premiumExpectedVideoQuality,String premiumDeviceAccess,String ExpectedPrice,String ExpectedCurrency){
        new SubscriptionPage()
                .validateSubscriptionModuleForBahrain(countryName,basicPackage,basicExpectedVideoQuality
                        ,basicWatchOnline,premiumPackage,premiumExpectedVideoQuality
                        ,premiumDeviceAccess,ExpectedPrice,ExpectedCurrency);

    }


}
