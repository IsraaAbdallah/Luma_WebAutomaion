package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/productDetails.feature"},
        glue = {"stepDefintions"},
        // dryRun = true,
        tags = "@Regression",
        plugin = {"html:cucumberReports/checkout_report.html","json:cucumberReports//checkout_report.json"},
        monochrome = true

)

public class Run_checkout extends AbstractTestNGCucumberTests {
}
