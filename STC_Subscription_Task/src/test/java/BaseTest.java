import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.driverManger.DriverManger;

public class BaseTest {
    @BeforeTest
    public void init(){
        DriverManger.initiation();
    }


    @AfterTest
    public void tearDown(){
        DriverManger.closeDriver();

    }
}
