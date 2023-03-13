package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/productDetails.feature"},
        glue = {"stepDefintions"},
       // dryRun = true,
        tags = "@Regression",
        plugin = {"html:cucumberReports/productDetails_report.html","json:cucumberReports//productDetails_report.json"},
        monochrome = true

)

public class Run_productDetails extends  AbstractTestNGCucumberTests {
}
