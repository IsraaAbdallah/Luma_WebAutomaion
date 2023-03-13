package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/payment.feature"},
        glue = {"stepDefintions"},
//         dryRun = true,
        tags = "@Regression",
        plugin = {"html:cucumberReports/payment_report.html","json:cucumberReports//payment_report.json"},
        monochrome = true

)

public class Run_payment extends AbstractTestNGCucumberTests {
}
