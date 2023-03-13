package stepDefintions;
import com.luma.utils.DriverConnector;
import com.luma.utils.TakeScreenShotClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class Hooks {
    @Before
    public  void setUp() {

        DriverConnector.setUpDriver();
        DriverConnector.openPage();
    }
    @BeforeTest
    public   void waiting(){

        DriverConnector.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public  void tearDown(Scenario scenario) {


        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverConnector.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            //save screenshot as file
            TakeScreenShotClass.screenShot(DriverConnector.driver,scenario.getName());

        }

        DriverConnector.tearDown();

    }


}
