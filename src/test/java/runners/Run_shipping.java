package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/shipping.feature"},
        glue = {"stepDefintions"},
            dryRun = true,
        tags = "@Regression",
        plugin = {"html:cucumberReports/shipping_report.html","json:cucumberReports//shipping_report.json"},
        monochrome = true

)

public class Run_shipping extends AbstractTestNGCucumberTests {
}
