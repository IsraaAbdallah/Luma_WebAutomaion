package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/review.feature"},
        glue = {"stepDefintions"},
//        dryRun = true,
        tags = "@Regression",
        plugin = {"html:cucumberReports/review_report.html","json:cucumberReports//review_report.json"},
        monochrome = true

)


public class Run_review extends AbstractTestNGCucumberTests {
}
